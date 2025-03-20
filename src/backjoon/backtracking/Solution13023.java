package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution13023 {

    /**
     * ABCDE
     * 백트래킹
     * not sol
     * 골드 5
     */

    private static boolean isFriends;
    private static int nodeNum;
    private static int edgeNum;
    private static int[][] arr;
    private static boolean[] visited;
    private static boolean[] friends;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        nodeNum = Integer.parseInt(st.nextToken());
        edgeNum = Integer.parseInt(st.nextToken());

        arr = new int[edgeNum][2];
        visited = new boolean[edgeNum];
        friends = new boolean[nodeNum];


        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        backtracking(0, 0);


        if (isFriends) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }


    private static void backtracking(int depth, int before) {

        if (depth == 5) {

            int count = 0;
            for (boolean friend : friends) {
                if (friend) {
                    count++;
                }
            }

            if (count == nodeNum) {
                isFriends = true;
                return;
            }
        }


        for (int i = 0; i < edgeNum; i++) {

            if (depth == 0) {
                visited[0] = true;
                friends[arr[0][0]] = true;
                friends[arr[0][1]] = true;

                backtracking(depth + 1, arr[0][0]);
                backtracking(depth + 1, arr[0][1]);

                visited[i] = false;
                friends[arr[0][0]] = false;
                friends[arr[0][1]] = false;

            } else if (!visited[i] && ( before == arr[i][0] || before == arr[i][1] )) {
                visited[i] = true;
                friends[arr[i][0]] = true;
                friends[arr[i][1]] = true;

                backtracking(depth + 1, before == arr[i][0] ? arr[i][1] : arr[i][0]);

                visited[i] = false;
                friends[arr[i][0]] = false;
                friends[arr[i][1]] = false;

            }
        }

    }


}
