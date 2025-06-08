package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution29792 {

    /**
     * 창영이와 커피
     * 골드5
     * 알고리즘 : dp, 배낭문제
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        int member = Integer.parseInt(st.nextToken());
        int boss = Integer.parseInt(st.nextToken());


        int[][] attackPoint = new int[total][2];
        for (int i = 0; i < total; i++) {
            attackPoint[i][0] = Integer.parseInt(br.readLine());
            attackPoint[i][1] = attackPoint[i][0] * 15 * 60;
        }

        int[][] bossInfo = new int[boss][2];
        for (int i = 0; i < boss; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            bossInfo[i][0] = Integer.parseInt(st1.nextToken());
            bossInfo[i][1] = Integer.parseInt(st1.nextToken());
        }

        int[] maxDp = new int[total];

        for (int i = 0; i < total; i++) {

            int[] dp = new int[attackPoint[i][1]+1];

            for (int j = 0; j < boss; j++) {

                int bossValue = bossInfo[j][0];

                if (bossValue % attackPoint[i][0] != 0) {
                    bossValue += attackPoint[i][0] - (bossValue % attackPoint[i][0]);
                }

                for (int k = attackPoint[i][1] ; k >= bossValue; k--) {
                    dp[k] = Math.max(dp[k], dp[k-bossValue] + bossInfo[j][1]);
                }
            }

            Arrays.sort(dp);

            maxDp[i] = dp[attackPoint[i][1]];
        }

        Arrays.sort(maxDp);

        int answer = 0;
        for (int i = 0; i < member; i++) {
            answer += maxDp[total-1-i];
        }

        System.out.println(answer);



    }


}
