package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution25947 {


    /**
     * 선물할인
     * 실버1
     * 알고리즘 : 그리디
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        int discount = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int max = 0;

        dp[0] = arr[0] / 2;
        if (dp[0] <= cost) {
            max = Math.max(max, 1);
        }

        for (int i = 1; i < discount; i++) {
            dp[i] = arr[i] / 2;
            dp[i] += dp[i - 1];

            if (dp[i] <= cost) {
                max = Math.max(max, i+1);
            }
        }

        for (int i = discount; i < n; i++) {
            if (i == 0) {
                dp[i] = arr[i] / 2;
                dp[i] += arr[i - discount] / 2;
            } else {
                dp[i] = arr[i] / 2;
                dp[i] += dp[i - 1];
                dp[i] += arr[i - discount] / 2;
            }


            if (dp[i] <= cost) {
                max = Math.max(max, i+1);
            }
        }

        System.out.println(max);


    }


}
