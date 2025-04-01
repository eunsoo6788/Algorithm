package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution12915 {

    /**
     * 대회개최
     * 골드5
     * 알고리즘 : 이분탐색 / 그리드
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int low = Integer.parseInt(st.nextToken());
        int lowAndMid = Integer.parseInt(st.nextToken());
        int mid = Integer.parseInt(st.nextToken());
        int midAndHigh = Integer.parseInt(st.nextToken());
        int high = Integer.parseInt(st.nextToken());


        int lowDiff = Math.abs(low-mid);
        int highDiff = Math.abs(high-mid);

        if (lowDiff > highDiff) {

        }


    }

}
