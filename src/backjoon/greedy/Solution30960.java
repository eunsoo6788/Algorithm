package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution30960 {

    /**
     * 선물 고르기
     * 알고리즘 : 그리디
     * 골드4
     */

    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        boolean triple = n % 2 == 1 ? true : false;


        if (triple) {
            System.out.println(triple());
        } else {
            System.out.println(second());
        }


    }

    private static long triple() {

        long min = Long.MAX_VALUE;
        for (int i = 0; i < n-1; i+=2) {
            min = Math.min(min,tripleSolve(i));
        }


        return min;
    }

    private static long tripleSolve(int index) {

        long sum = 0;
        for (int i = 0; i < n; i+=2) {

            if (index == i) {
                sum += Math.abs(arr[i] - arr[i+2]);
                i++;
                continue;
            }

            sum += Math.abs(arr[i] - arr[i+1]);
        }


        return sum;
    }


    private static long second() {
        long sum = 0;

        for (int i = 0; i < n; i += 2) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }

        return sum;
    }

}
