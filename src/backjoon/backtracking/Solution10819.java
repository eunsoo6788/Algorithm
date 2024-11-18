package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution10819 {

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        int[] arr =new int[size];
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        backtracking(visited, arr, 0, new int[size]);

        System.out.println(answer);

    }

    private static void backtracking(boolean[] visited, int[] arr, int depth, int[] result) {

        if (depth == arr.length) {


            int sum = 0;

            for (int i = 0; i < arr.length-1; i++) {
                sum += Math.abs(result[i] - result[i+1]);
            }

            answer = Math.max(answer, sum);
            return;
        }



        for (int i = 0; i < arr.length; i++) {

            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                backtracking(visited, arr, depth + 1, result);
                visited[i] = false;
            }


        }

    }



}
