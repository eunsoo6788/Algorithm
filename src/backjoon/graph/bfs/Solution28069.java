package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution28069 {

    /**
     * 골드5
     * 알고리즘 : bfs
     * Not Sol
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int step = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());


        int[] dp = new int[step + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < step; i++) {
            dp[i+1] = Math.min(dp[i+1], dp[i]+1);

            if (i+(i/2) <= step) {
                dp[i+(i/2)] = Math.min(dp[i+(i/2)], dp[i]+1);
            }
        }


        System.out.println(dp[step] <= num ? "minigimbob" : "water");




    }



}
