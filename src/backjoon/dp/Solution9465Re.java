package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9465Re {

    /**
     * 점프 1890
     * 실버1
     * 알고리즘 : dp
     * Not Sol -> chatgpt 도움 받음
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < testNum; testCase++) {

            int num = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int[][] arr = new int[num][2];
            int[][] dp = new int[num][2];

            for (int i = 0; i < num; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st1.nextToken());
            }


            if (num == 1) {
                System.out.println(Math.max(arr[0][0], arr[0][1]));
                continue;
            }


            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];
            dp[1][0] = arr[0][1] + arr[1][0];
            dp[1][1] = arr[0][0] + arr[1][1];


            if (num == 2) {
                System.out.println(Math.max(dp[1][0], dp[1][1]));
                continue;
            }



            int max = 0;

            for (int i = 2; i < num; i++) {
                dp[i][0] = Math.max(dp[i-1][1] + arr[i][0] , Math.max(dp[i-2][0] + arr[i][0], dp[i-2][1] + arr[i][0]));
                dp[i][1] = Math.max(dp[i-1][0] + arr[i][1] , Math.max(dp[i-2][1] + arr[i][1], dp[i-2][0] + arr[i][1]));

                max = Math.max(max, dp[i][0]);
                max = Math.max(max, dp[i][1]);

            }


            System.out.println(max);



        }









    }


}
