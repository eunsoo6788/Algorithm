package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution20922 {

    /**
     * 백준 : 겹치는 건 싫어 20922
     * 알고리즘 : 투 포인터
     * not sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st1.nextToken());
        int size = Integer.parseInt(st1.nextToken());

        int[] arr = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] score = new int[100_001];

        int low = 0;
        int high = 0;

        int max = 0;
        while(high <= num-1) {


            score[arr[high]]++;

            if (score[arr[high]] > size) {
                score[arr[high]]--;
                low++;
            }

            max = Math.max(max,high - low+1);

            high++;

        }


        System.out.println(max);

    }
}
