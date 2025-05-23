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
     * Not Sol -> 엣지 케이스 (처음 arr[0] =0 일때 케이스 같은 경우 처리 못함)
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
            for (int j = 1 ; j <= arr[i] ; j++) {
                if (i+j < num) {
                    dp[i+j] = Math.min(dp[i]+1, dp[i+j]);
                }
            }
        }


        if (arr[0] == 0) {
            System.out.println(0);
        } else {
            System.out.println(dp[num-1] == Integer.MAX_VALUE ? -1 : dp[num-1]);
        }


    }


}
