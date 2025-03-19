package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution1446 {

    /**
     * 지름길 1446
     * 실버1
     * 알고리즘 : dp
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());

        int[][] arr = new int[num][3];
        int[] dp = new int[distance + 1];


        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }




        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));

        for (int i = 1; i <= distance; i++) {

            dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            for (int j = 0; j < num; j++) {
                if (arr[j][1] == i) {
                    dp[i] = Math.min(dp[i], dp[arr[j][0]] + arr[j][2]);

                } else if (arr[j][1] > i) {
                    break;
                }
            }
        }

        System.out.println(dp[distance]);

    }


}
