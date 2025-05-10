package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main16938 {

    /**
     * 캠프 준비
     * 골드5
     */

    private static int num;
    private static int minSum;
    private static int maxSum;
    private static int abs;
    private static int count = 0;

    private static int[] arr;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        num = Integer.parseInt(st.nextToken());
        minSum = Integer.parseInt(st.nextToken());
        maxSum = Integer.parseInt(st.nextToken());
        abs = Integer.parseInt(st.nextToken()); // 같거나 커야 한다.

        arr = new int[num];
        visited = new boolean[num];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        solve(0,0,0,Integer.MAX_VALUE,0);

        System.out.println(count);



    }

    private static void solve(int index, int depth, int sum, int min, int max) {

        if (index >= 2) {
            if (sum >= minSum && sum <= maxSum && Math.abs(min-max) >= abs) {
                count++;
            }
        }


        if (index == num) {
            return;
        }

        for (int i = index; i < num; i++) {

            if (!visited[i]) {
                visited[i] = true;
                solve(i+1, depth + 1, sum+arr[i], Math.min(min, arr[i]), Math.max(max, arr[i]));
                visited[i] = false;
            }

        }





    }


}
