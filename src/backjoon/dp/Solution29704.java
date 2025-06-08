package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution29704 {

    /**
     * 창영이와 커피
     * 골드5
     * 알고리즘 : dp, 배낭문제
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int num = Integer.parseInt(st.nextToken());
        int bag = Integer.parseInt(st.nextToken());
        int total = 0 ;

        int[][] arr = new int[num][2];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            total += arr[i][1];
        }

        int[] dp = new int[bag+1];


        for (int i = 0 ; i < num ; i++) {

            int weight = arr[i][0];
            int value = arr[i][1];

            for (int j = bag ; j >= 0 ; j--) {

                int index = weight + j;

                if (index <= bag) {
                    dp[index] = Math.max(dp[index], dp[j] + value);
                }

            }
        }

        Arrays.sort(dp);
        System.out.println(total-dp[bag]);



    }


}
