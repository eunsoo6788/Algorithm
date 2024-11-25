package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11048 {

    /**
     * https://www.acmicpc.net/problem/11048
     * 실버2
     * 알고리즘 : dp
     * Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer numStringTokenizer = new StringTokenizer(br.readLine(), " ");

        int ySize = Integer.parseInt(numStringTokenizer.nextToken());
        int xSize = Integer.parseInt(numStringTokenizer.nextToken());

        int[][] arr = new int[ySize][xSize];
        int[][] dp = new int[ySize][xSize];


        for (int yIndex = 0; yIndex < arr.length; yIndex++) {
            StringTokenizer arrTokenizer = new StringTokenizer(br.readLine(), " ");
            for (int xIndex = 0; xIndex < arr[0].length; xIndex++) {
                arr[yIndex][xIndex] = Integer.parseInt(arrTokenizer.nextToken());
            }
        }

        dp[0][0] = arr[0][0];


        for (int yIndex = 0; yIndex < arr.length; yIndex++) {
            for (int xIndex = 0; xIndex < arr[0].length; xIndex++) {

                if (xIndex + 1 < arr[0].length) {
                    dp[yIndex][xIndex + 1] = Math.max(dp[yIndex][xIndex + 1], dp[yIndex][xIndex] + arr[yIndex][xIndex + 1]);
                }

                if (yIndex + 1 < arr.length) {
                    dp[yIndex + 1][xIndex] = Math.max(dp[yIndex + 1][xIndex], dp[yIndex][xIndex] + arr[yIndex + 1][xIndex]);
                }


                if (xIndex + 1 < arr[0].length && yIndex + 1 < arr.length) {
                    dp[yIndex + 1][xIndex + 1] = Math.max(dp[yIndex + 1][xIndex + 1], dp[yIndex][xIndex] + arr[yIndex + 1][xIndex + 1]);
                }

            }
        }

        System.out.println(dp[arr.length - 1][arr[0].length - 1]);


    }


}
