package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2096 {

    /**
     * 내려가기
     * 골드5
     * dp
     * 솔
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][3];
        int[][] dp = new int[num][3];
        int[][] dpMin = new int[num][3];


        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = arr[0][i];
            dpMin[0][i] = arr[0][i];
        }


        for (int i = 1; i < num; i++) {

            dp[i][0] = Math.max(dp[i-1][0]+arr[i][0], dp[i-1][1]+arr[i][0]);
            dp[i][1] = Math.max(dp[i-1][0]+arr[i][1], Math.max(dp[i-1][1]+arr[i][1], dp[i-1][2]+arr[i][1]));
            dp[i][2] = Math.max(dp[i-1][1]+arr[i][2], dp[i-1][2]+arr[i][2]);


            dpMin[i][0] = Math.min(dpMin[i-1][0]+arr[i][0], dpMin[i-1][1]+arr[i][0]);
            dpMin[i][1] = Math.min(dpMin[i-1][0]+arr[i][1], Math.min(dpMin[i-1][1]+arr[i][1], dpMin[i-1][2]+arr[i][1]));
            dpMin[i][2] = Math.min(dpMin[i-1][1]+arr[i][2], dpMin[i-1][2]+arr[i][2]);

        }

        StringBuilder sb = new StringBuilder();

        sb.append(Math.max(dp[num-1][0], Math.max(dp[num-1][1], dp[num-1][2])))
                .append(" ")
                .append(Math.min(dpMin[num-1][0], Math.min(dpMin[num-1][1], dpMin[num-1][2])));


        System.out.println(sb);








    }


}
