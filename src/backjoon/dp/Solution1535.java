package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1535 {

    /**
     * 안녕 1535
     * 실버2
     * 알고리즘 : dp
     * Not Sol -> 테스트 케이스는 맞는데 어디가 틀린지 모르겠음.
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        int[][] arr = new int[num][2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < num ; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < num ; i++) {
            arr[i][1] = Integer.parseInt(st1.nextToken());
        }

        int[][] dp = new int[num][2];
        dp[0][0] = arr[0][1];
        int heart = arr[0][0];
        dp[0][1] = heart;



        if (dp[0][1] + arr[1][0] < 100) {
            dp[1][0] = dp[0][0] + arr[1][1];
            dp[1][1] = dp[0][1] + arr[1][0];
        } else {
            dp[1][0] = arr[1][1];
            dp[1][1] = arr[1][0];
        }


        for (int i = 2 ; i < num ; i++) {

            int a = 0;
            int b = 0;

            if (dp[i-1][1] + arr[i][0] < 100) {
                a = dp[i-1][0] + arr[i][1];
            } else if (dp[i-2][1] + arr[i][0] < 100) {
                b = dp[i-2][0] + arr[i][1];
            } else {
                dp[i][0] = arr[i][1];
                dp[i][1] = arr[i][0];
                continue;
            }


            if (a>= b) {
                dp[i][0] = a;
                dp[i][1] = dp[i-1][1] + arr[i][0];
            } else {
                dp[i][0] = b;
                dp[i][1] = dp[i-2][1] + arr[i][0];
            }

        }


        System.out.println();

    }


}
