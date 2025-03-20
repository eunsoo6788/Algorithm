package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution13023Re {

    /**
     * ABCDE
     * 백트래킹
     * not sol
     * 골드 5
     */

    private static boolean isFriends;
    private static int nodeNum;
    private static int edgeNum;
    private static List<Integer>[] list;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        nodeNum = Integer.parseInt(st.nextToken());
        edgeNum = Integer.parseInt(st.nextToken());

        list = new List[nodeNum];

        for (int i = 0 ; i < nodeNum ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        visited = new boolean[nodeNum];


        for (int i = 0 ; i < nodeNum ; i++) {

            if(isFriends) {
                break;
            }

            backtracking(i,1);
        }


        if (isFriends) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }


    private static void backtracking(int start, int depth) {

        if (depth == nodeNum) {
            isFriends = true;
            return;
        }

        visited[start] = true;

        for (int i : list[start]) {
            if (isFriends) {
                return;
            }

            if (!visited[i]) {
                backtracking(i, depth+1);
            }
        }

        visited[start] = false;


    }


}
