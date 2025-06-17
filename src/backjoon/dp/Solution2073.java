package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2073 {

    /**
     * 수도배관공사
     * 골드4
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
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < num; i++) {

            int len = arr[i][0];
            int size = arr[i][1];

            for (int j = bag ; j >= 0 ; j-- ) {

                if(j+len == bag) {
                    dp[j+len] = Math.max(dp[j+len], size);
                    break;
                }
                else if (j == 0 && j+len <= bag) {
                    dp[j+len] = Math.min(dp[j+len], size);
                } else if (dp[j] != Integer.MAX_VALUE && j+len <= bag) {
                    dp[j+len] = Math.min(dp[j+len], size);
                }

            }

        }


        System.out.println(dp[bag]);
    }



}
