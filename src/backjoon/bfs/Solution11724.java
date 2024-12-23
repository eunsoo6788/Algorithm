package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution11724 {

    /**
     * 연결 요소의 개수 11724
     * 알고리즘 : dfs
     * 실버2
     * Not Sol
     */


    private static ArrayList<Integer>[] map;
    private static boolean[] visited;

    private static int nodeNum;
    private static int edgeNum;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nodeNum = Integer.parseInt(st.nextToken());
        edgeNum = Integer.parseInt(st.nextToken());

        map = new ArrayList[nodeNum+1];
        for (int i = 1 ; i <= nodeNum ; i++){
            map[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < edgeNum ; i++) {
            StringTokenizer mapSt = new StringTokenizer(br.readLine(), " ");

            int first = Integer.parseInt(mapSt.nextToken());
            int second = Integer.parseInt(mapSt.nextToken());

            map[first].add(second);
            map[second].add(first);
        }

        visited = new boolean[nodeNum+1];
        int count = 0;

        for (int i = 1 ; i <= nodeNum ; i++) {

            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
                count++;
            }

        }

        System.out.println(count);

    }

    private static void dfs(int node) {


        for (int i : map[node]) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }

    }


}
