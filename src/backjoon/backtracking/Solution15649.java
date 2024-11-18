package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution15649 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int num = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());


        boolean[] visited = new boolean[num];
        int[] arr = new int[count];

        backtracking(visited, arr, count, 0, 4);
    }

    private static void backtracking(boolean[] visited, int[] arr, int count, int index, int num) {

        if (index == count) {
            for (int i = 0; i < count; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }


        for (int i = 0; i < num; i++) {

            if (!visited[i]) {
                visited[i] = true;
                arr[index] = i+1;
                backtracking(visited, arr, count, index + 1, 4);
                visited[i] = false;
            }

        }
    }


}
