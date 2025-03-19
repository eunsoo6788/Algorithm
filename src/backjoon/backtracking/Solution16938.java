package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution16938 {

    /**
     * 캠프준비
     * 백트래킹
     * not sol
     * 골드5
     */

    private static int[] arr;
    private static boolean[] visited;
    private static int num;
    private static int difficulty;
    private static int minSum;
    private static int maxSum;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        num = Integer.parseInt(st.nextToken());
        minSum = Integer.parseInt(st.nextToken());
        maxSum = Integer.parseInt(st.nextToken());
        difficulty = Integer.parseInt(st.nextToken());


        arr = new int[num];
        visited = new boolean[num];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        solve(0, 0);

        System.out.println(answer);

    }


    private static void solve(int depth, int sum) {

        if (sum >= minSum && sum <= maxSum) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            int count = 0;

            for (int i = 0; i < num; i++) {
                if (!visited[i]) {
                    continue;
                }

                count++;

                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }

            if (count > 1 && max - min >= difficulty) {
                answer++;
                return;
            }


        }


        if (depth == num) {
            return;
        }


        for (int i = depth; i < num; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solve(i + 1, sum + arr[i]);
                visited[i] = false;
            }
        }

    }

}
