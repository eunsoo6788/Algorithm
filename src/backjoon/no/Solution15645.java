package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution15645 {

    /**
     * 백준 : 상자넣기
     * 알고리즘 : LIS , DP
     * 실버2
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][3];
        int[][] dp = new int[num][3];
        int[][] dpMin = new int[num][3];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        dpMin[0][0] = arr[0][0];
        dpMin[0][1] = arr[0][1];
        dpMin[0][2] = arr[0][2];

        for (int i = 1; i < num; i++) {

            dp[i][0] =Math.max(dp[i-1][0] + arr[i][0], dp[i-1][1] + arr[i][0]);
            dp[i][1] =Math.max(dp[i-1][0] + arr[i][1], Math.max(dp[i-1][1] + arr[i][1], dp[i-1][2] + arr[i][1]));
            dp[i][2] =Math.max(dp[i-1][1] + arr[i][2], dp[i-1][2] + arr[i][2]);


            dpMin[i][0] =Math.min(dpMin[i-1][0] + arr[i][0], dpMin[i-1][1] + arr[i][0]);
            dpMin[i][1] =Math.min(dpMin[i-1][0] + arr[i][1], Math.min(dpMin[i-1][1] + arr[i][1], dpMin[i-1][2] + arr[i][1]));
            dpMin[i][2] =Math.min(dpMin[i-1][1] + arr[i][2], dpMin[i-1][2] + arr[i][2]);

        }

        StringBuilder st = new StringBuilder();

        st.append(Math.max(dp[num-1][0], Math.max(dp[num-1][1], dp[num-1][2])));
        st.append(" ");
        st.append(Math.min(dpMin[num-1][0], Math.min(dpMin[num-1][1], dpMin[num-1][2])));
        st.append("\n");

        System.out.println(st);

    }


}
