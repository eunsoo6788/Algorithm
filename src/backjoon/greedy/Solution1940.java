package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1940 {


    /**
     * https://www.acmicpc.net/problem/1940
     * 실버 4
     * 알고리즘 : 투 포인트
     * Not Sol
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int targetNum = Integer.parseInt(br.readLine());

        StringTokenizer arrTokenizer = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(arrTokenizer.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;

        int low = 0;
        int high = size -1;

        while (low < high) {

            if (arr[low] + arr[high] < targetNum) {
                low++;
            } else if (arr[low] + arr[high] > targetNum) {
                high--;
            } else {
                low++;
                high--;
                count++;
            }

        }

        System.out.println(count);

    }
}
