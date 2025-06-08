package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1535 {

    /**
     * 안녕
     * 실버2
     * 알고리즘 : dp, 배낭문제
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st1.nextToken());
        }

        int[] dp = new int[100];

        for (int i = 0; i < num; i++) {
            int weight = arr[i][0];
            int value = arr[i][1];

            for (int j = 99 ; j >= weight ; j--) {
                dp[j] = dp[j] + dp[j - weight] + value;
            }

        }
    }


}
