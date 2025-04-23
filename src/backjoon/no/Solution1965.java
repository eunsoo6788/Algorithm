package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1965 {

    /**
     * 백준 : 상자넣기
     * 알고리즘 : LIS , DP
     * 실버2
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        int[] dp = new int[num];
        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int max = 0;

        for (int i = 0; i < num; i++) {

            for (int j = i-1; j >= 0; j--) {

                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }

            max = Math.max(max, dp[i]);
        }


        System.out.println(max);


    }


}
