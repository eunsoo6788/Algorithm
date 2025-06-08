package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution22115 {

    /**
     * 창영이와 커피
     * 골드5
     * 알고리즘 : dp, 배낭문제
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int num = Integer.parseInt(st.nextToken());
        int bag = Integer.parseInt(st.nextToken());


        int[] arr = new int[num];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[bag+1];


        for (int i = 0 ; i < num ; i++) {

            for (int j = bag ; j >= 0 ; j--) {
                int value = arr[i] + j;

                if (value < bag) {
                    dp[value] = Math.min(dp[value], dp[j] + 1);
                }

            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < bag; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                min = Math.min(min, dp[i]);
            }
        }

        System.out.println(min);


    }


}
