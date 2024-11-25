package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2961 {

    /**
     * https://www.acmicpc.net/problem/2961
     * 실버2
     * 알고리즘 : 백트래킹
     * Not Sol
     */

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        int[][] arr= new int[num][2];
        boolean[] visited = new boolean[num];
        for (int i = 0 ; i < num ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        for (int targetDepth = 1 ; targetDepth <= num ; targetDepth++) {
            dfs(targetDepth,0,arr,visited, new int[targetDepth][2]);
        }

        System.out.println(answer);
    }

    private static void dfs(int targetDepth, int depth, int[][] arr, boolean[] visited, int[][] list){

        if (targetDepth == depth) {

            int shin = 1;
            int ssun = 0;

            for (int[] i : list) {
                shin *= i[0];
                ssun += i[1];
            }

            answer = Math.min(answer, Math.abs(shin - ssun));

            return;
        }

        for (int i = 0 ; i < arr.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list[depth][0] = arr[i][0];
                list[depth][1] = arr[i][1];
                dfs(targetDepth, depth + 1 ,arr, visited,list);

                list[depth][0] = 0;
                list[depth][1] = 0;
                visited[i] = false;
            }
        }

    }

}
