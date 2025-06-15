package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1106 {

    /**
     * 벼락치기
     * 골드5
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


        int[] dp = new int[1001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < num; i++) {
            int weight = arr[i][1];
            int value = arr[i][0];

            for (int j = 1000; j >= weight; j--) {
                dp[j] = Math.min(dp[j], dp[j - weight] + value);
            }
        }

        int min = 0 ;
        for (int i = bag; i < 1001; i++) {
            min = Math.min(min, dp[i]);
        }

        System.out.println(min);

    }


}
