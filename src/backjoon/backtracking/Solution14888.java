package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14888 {

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int[] operator = new int[4];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st1.nextToken());
        }

        dfs(arr, operator, arr[0], 1);

        System.out.println(max);
        System.out.println(min);



    }


    private static void dfs(int[] arr, int[] operator, int num, int depth) {

        if (depth == arr.length) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }


        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(arr, operator, num + arr[depth], depth + 1);
                        break;
                    case 1:
                        dfs(arr, operator, num - arr[depth], depth + 1);
                        break;
                    case 2:
                        dfs(arr, operator, num * arr[depth], depth + 1);
                        break;
                    case 3:
                        dfs(arr, operator, num / arr[depth], depth + 1);
                        break;
                }



                operator[i]++;
            }
        }



    }



}
