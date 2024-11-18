package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888 {

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }


        int[] operator = new int[4];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st1.nextToken());
            operator[i] = num;
        }

        dfs(operator, arr, arr[0], 1);

        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int[] operator, int[] arr, int num, int depth) {


        if (depth == arr.length) {

            max = Math.max(max, num);
            min = Math.min(min, num);

            return;
        }


        for (int i = 0; i < 4; i++) {

            if (operator[i] != 0) {
                operator[i]--;


                if (i == 0) {
                    dfs(operator, arr, num + arr[depth], depth + 1);
                } else if (i == 1) {
                    dfs(operator, arr, num - arr[depth], depth + 1);
                } else if (i == 2) {
                    dfs(operator, arr, num * arr[depth], depth + 1);
                } else if (i == 3) {
                    dfs(operator, arr, num / arr[depth], depth + 1);
                }

                operator[i]++;

            }

        }


    }

}
