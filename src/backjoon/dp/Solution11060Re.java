package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution11060Re {

    /**
     * 점프 점프
     * 실버2
     * dp
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        int[] dp = new int[num];

        Arrays.fill(dp, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;

        for (int i = 0; i < num; i++) {

            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int j = i + 1; j <= i + arr[i]; j++) {

                if ( j >= num) {
                    break;
                }

                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        System.out.println(dp[num - 1] == Integer.MAX_VALUE ? -1 : dp[num - 1]);


    }


}
