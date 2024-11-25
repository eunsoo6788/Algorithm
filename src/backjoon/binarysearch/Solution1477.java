package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1477 {

    /**
     * https://www.acmicpc.net/problem/1477
     * 골드4
     * 알고리즘 : 이분탐색
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int targetNum = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[num];
        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(arr);


        long low = len / (num + targetNum); // 이상 적으로 가능한 가장 짧은 거리
        long high = 0;

        for (int i = 0 ; i < num -1 ; i++) {
            high = Math.max(high,arr[i+1] - arr[i]);
        }

        while (low <= high) {

            long mid = (low + high) /2 ;




        }


    }

}
