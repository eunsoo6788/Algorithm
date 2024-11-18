package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution15654 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int num = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());


        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }


        Arrays.sort(arr);

        boolean[] visited = new boolean[num];
        int[] result = new int[count];

        backtracking(visited, arr, count, 0, num, result);
    }

    private static void backtracking(boolean[] visited, int[] arr, int count, int index, int num, int[] result) {

        if (index == count) {
            for (int i = 0; i < count; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }


        for (int i = 0; i < num; i++) {

            if (!visited[i]) {
                visited[i] = true;
                result[index] = arr[i];
                backtracking(visited, arr, count, index + 1, 4, result);
                visited[i] = false;
            }

        }
    }


}
