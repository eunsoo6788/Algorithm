package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution9084 {

    /**
     * 동전
     * 골드5
     * 알고리즘 : dp, 배낭문제
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test  = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            int num = Integer.parseInt(br.readLine());

            int[] arr = new int[num];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int bag = Integer.parseInt(br.readLine());
            int[] dp = new int[bag+1];

            dp[0] = 1;

            for (int j = 0 ; j < num ; j++) {

                int value = arr[j];

                for (int k = value ; k <= bag ; k++ ) {
                    dp[k] = dp[k] + dp[k - value];
                }
            }


            System.out.println(dp[bag]);


        }

    }


}
