package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution9024 {

    /**
     * https://www.acmicpc.net/problem/9024
     * 골드 5
     * 알고리즘 : 투 포인트
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int problemSize = Integer.parseInt(br.readLine());


        for (int problemNum = 0 ; problemNum < problemSize ; problemNum++) {

            StringTokenizer numTokenizer = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(numTokenizer.nextToken());
            int targetNumber = Integer.parseInt(numTokenizer.nextToken());


            int[] arr = new int[num];
            StringTokenizer arrTokenizer = new StringTokenizer(br.readLine(), " ");
            for (int i = 0 ; i < num ; i++) {
                arr[i] = Integer.parseInt(arrTokenizer.nextToken());
            }

            Arrays.sort(arr);

            for (int i = 0 ; i < arr.length ; i++) {

            }


        }





    }
}
