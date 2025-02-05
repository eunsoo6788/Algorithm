package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2805Re {

    /**
     * https://www.acmicpc.net/problem/2805
     * 실버2
     * 알고리즘 : 이분탐색
     * Not Sol
     */

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());


        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[num];


        long high = 0;
        long low = 0;

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
            high = Math.max(high, arr[i]);
        }

        while (low <= high) {

            long mid = (high +low) /2;
            long sum = 0;
            for (int i = 0 ; i < num ; i++) {
                if (arr[i] > mid ){
                    sum += (arr[i]-mid );
                }
            }

            if (sum >= target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }


        }

        System.out.println(high);

    }


}
