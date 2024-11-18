package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6603 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[n];

            backtracking(visited, arr, 0, new int[n], 0);
            System.out.println();



        }


    }

    private static void backtracking(boolean[] visited, int[] arr, int depth, int[] result, int before) {

        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(result[i]+" ");

            }
            System.out.println();
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && arr[i] > before) {
                visited[i] = true;
                result[depth] = arr[i];
                backtracking(visited, arr, depth + 1, result, arr[i]);
                visited[i] = false;
            }
        }

    }



}
