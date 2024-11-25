package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1920 {

    /**
     * https://www.acmicpc.net/problem/1920
     * 실버4
     * 알고리즘 : 이분탐색
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[num2];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num2; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);


        int[] answer = new int[num2];
        for (int i = 0; i < num2; i++) {


            int targetNum = arr2[i];

            long high = num - 1;
            long low = 0;

            while (high >= low) {

                long mid = (high + low) / 2;


                if (arr[(int) mid] > targetNum) {
                    high = mid - 1;
                } else if (arr[(int) mid] < targetNum) {
                    low = mid + 1;
                } else {
                    answer[i] = 1;
                    break;
                }
            }

        }


        for (int i : answer) {
            System.out.println(i);
        }


    }

}
