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


        int target = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int[][] arr = new int[num][2];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[1001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i < 1001; i++) {

            for (int j = 0; j < num; j++) {
                int money = arr[j][0];
                int person = arr[j][1];

                if (i % person == 0) {

                    if (i-person > 0) {
                        dp[i] = Math.min(dp[i], dp[i-person] + money);
                    } else {
                        dp[i] = money;
                    }

                }
            }

        }


        int min = Integer.MAX_VALUE;

        for (int i = target; i < 1001; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                min = Math.min(dp[i], min);
            }
        }

        System.out.println(min);

    }


}
