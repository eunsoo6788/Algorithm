package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution15989 {

    /**
     * 1, 2, 3 더하기 4
     * 골드5
     * 알고리즘 : dp
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < num ; i++) {

            int value = Integer.parseInt(br.readLine());

            int[] dp = new int[num+1];


            for (int j = 1 ; j < value ; j++) {
                if (j % 3 == 0 ) {

                }
            }



        }


    }


}
