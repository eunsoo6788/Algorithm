package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1697 {

    /**
     * 숨바꼭질
     * 실버1
     * 알고리즘 : dp
     * BFS > Not Sol > 메모리 초과
     * DP > Not Sol >
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dp = new int[end + 1];
        int mid = ((start+start*2)+1)/2;
        for (int i = 1; i <= mid - start ; i++) {
            dp[start+i] = i;
        }

        int value = 2;
        for (int i = start*2-1; i >= mid +1 ; i--) {
            dp[i] = value;
            value++;
        }

        dp[start*2] = 1;


        for (int i = start*2+1; i <= end; i++) {
            if (i %2 == 0) {
                dp[i] = dp[i/2]+1;
            } else {
                dp[i] = Math.min(dp[i-1]+1,dp[(i+1)/2]+2);
            }
        }


        System.out.println(dp[end]);

    }




}
