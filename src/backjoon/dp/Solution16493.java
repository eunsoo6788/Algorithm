package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution16493 {

    /**
     * 최대 페이지 수
     * 실버2
     * 알고리즘 : dp, 배낭문제
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int bag = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int[][] arr = new int[num][2];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[bag+1];


        for (int i = 0 ; i < num ; i++) {

            for (int j = bag ; j >= arr[i][0] ; j--) {
                dp[j] = Math.max(dp[j], dp[j-arr[i][0]] + arr[i][1]);
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[bag]);


    }


}
