package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution11053ReRe {

    /**
     * 가장 긴 증가하는 부분 수열
     * 실버2
     * dp, LIS
     * not sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[num];
        int[] dp = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }


        for (int i = 1; i < num; i++) {

            for (int j = i - 1; j >= 0; j--) {

                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Arrays.sort(dp);

        System.out.println(dp[num - 1]);

    }

}
