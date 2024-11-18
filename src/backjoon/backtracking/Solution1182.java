package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1182 {

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int size = Integer.parseInt(st.nextToken());
        int targetNum = Integer.parseInt(st.nextToken());


        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[size];
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        backtracking(visited, arr, 0, 0, targetNum, -1);

        System.out.println(answer);
    }

    private static void backtracking(boolean[] visited, int[] arr, int depth, int sum, int target, int beforeIndex) {


        if (sum == target || depth == arr.length) {
            if (sum == target) {

                if (depth == 0) {
                    if (arr[0] == target ) {
                        answer++;
                    }
                } else {
                    answer++;
                    return;
                }
            }
        }


        for (int i = 0 ; i < arr.length ; i++) {
            if (!visited[i] && i > beforeIndex) {

                visited[i] = true;
                backtracking(visited, arr, depth + 1, sum + arr[i], target, i);
                visited[i] = false;


            }
        }

    }



}
