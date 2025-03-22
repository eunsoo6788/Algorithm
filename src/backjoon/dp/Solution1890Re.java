package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1890Re {

    /**
     * 점프 1890
     * 실버1
     * 알고리즘 : dp
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][num];
        long[][] dp = new long[num][num];

        for (int y = 0; y< num ; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0;  x  < num ; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0]= 1;


        for (int y = 0; y< num ; y++) {
            for (int x = 0;  x  < num ; x++) {
                int jump = arr[y][x];

                if (y+jump < num && dp[y][x] == 1) {
                    dp[y+jump][x] += dp[y][x];
                }

                if (x+jump < num && dp[y][x] == 1) {
                    dp[y][x+jump] += dp[y][x];
                }

            }
        }




        System.out.println(dp[num-1][num-1]);



    }


}
