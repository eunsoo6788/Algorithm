package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution11060 {

    /**
     * https://www.acmicpc.net/problem/11060
     * 실버2
     * 알고리즘 : dp
     * Not Sol -> 테스트 케이스는 맞는데 어디가 틀린지 모르겠음.
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        int[] dp = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 0; i < num; i++) {


            for (int j = 0; j < arr[i]; j++) {

                if (i + j < num - 1) {
                    dp[i + j + 1] = Math.min(dp[i + j + 1], dp[i] + 1);
                }

            }
        }


        System.out.println(dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1]);

    }


}
