package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2798 {

    private static int n;
    private static int limit;
    private static int max = 0;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(0,0);

        System.out.println(max);
    }


    private static void solve(int depth, int sum) {

        if (depth == 3) {

            if (sum <= limit) {
                max = Math.max(max, sum);
            }

            return;

        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solve(depth+1, sum + arr[i]);
                visited[i] = false;

            }
        }

    }


}
