package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[num][2];
        for (int i = 0 ; i < num ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[num + 1];

         for (int i = 0 ; i < num ; i++) {

            if (i + arr[i][0] < num){
                dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], dp[i + arr[i][0]] + arr[i][1]);
            }

             dp[i+1] = Math.max(dp[i+1], dp[i]);


        }


        System.out.println();


    }


}
