package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution11053 {

    /**
     * https://www.acmicpc.net/problem/11060
     * 실버2
     * 알고리즘 : dp
     * Not Sol -> 엣지 케이스 (처음 arr[0] =0 일때 케이스 같은 경우 처리 못함)
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        int[] dp = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }



        for (int i = 0; i < num; i++) {


            int minValue = arr[i];
            int count = 1;
            for (int j = i +1; j < num; j++) {
                if (minValue < arr[j]){
                    minValue = arr[j];
                    count++;
                }
            }

            dp[i] = count;
        }

        Arrays.sort(dp);

        System.out.println(dp[num-1]);





    }


}
