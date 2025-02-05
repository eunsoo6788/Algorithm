package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1932 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][num];
        int[][] dp = new int[num][num];


        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dp[0][0] = arr[0][0];

        for (int i = 1; i < num ; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = arr[i][j] + dp[i-1][j];
                } else if (j == i) {
                    dp[i][j] = arr[i][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }

            }
        }

        int[] answer = new int[num];
        for (int i = 0 ; i < num ; i++) {
            answer[i] = dp[num-1][i];
        }

        Arrays.sort(answer);

        System.out.println(answer[num-1]);


    }


}
