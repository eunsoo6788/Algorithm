package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution14501 {

    /**
     * https://www.acmicpc.net/problem/14501
     * 실버3
     * 알고리즘 : dp
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][2];
        for (int i = 0 ; i < num ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[num];


        for (int i = 0 ; i < arr.length ; i++) {

            if (arr[i][0] + i <= num) {



                if ( i == 0) {
                    dp[i + arr[i][0] -1] = Math.max(dp[i + arr[i][0] -1], dp[i] + arr[i][1]);
                }

                else {
                    dp[i + arr[i][0] -1] = Math.max(dp[i + arr[i][0] -1], dp[i - 1] + arr[i][1]);
                }


                if (i != arr.length-1){
                    dp[i+1] = Math.max(dp[i+1], dp[i]);
                }
            }


        }


        Arrays.sort(dp);

        System.out.println(dp[dp.length-1]);




    }


}
