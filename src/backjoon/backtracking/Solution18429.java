package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution18429 {

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int num = Integer.parseInt(st.nextToken());
        int calory = Integer.parseInt(st.nextToken());


        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }


        boolean[] visited = new boolean[num];


        backtracking(visited,arr,0,500,calory);

        System.out.println(answer);

    }

    private static void backtracking(boolean[] visited, int[] arr, int depth, int calory, int minus) {


        if (depth == arr.length) {
            answer++;
            return;
        }


        for (int i = 0; i < arr.length; i++) {

            if (!visited[i] && calory >= 500) {

                visited[i] = true;
                backtracking(visited, arr, depth + 1, calory - minus + arr[i], minus);
                visited[i] = false;
            }
        }




    }


}
