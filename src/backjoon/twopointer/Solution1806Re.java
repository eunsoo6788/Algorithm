package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1806Re {

    /**
     * 부분합 1806
     * 알고리즘 : 투 포인터, 누적합
     * not sol
     * 골드 4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int minTarget = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        int[] sum = new int[num];

        StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());

            if (i == 0) {
                sum[i] = arr[i];
            } else {
                sum[i] = sum[i - 1] + arr[i];
            }
        }


        int left = 0;
        int right = 1;
        int minLength = Integer.MAX_VALUE;
        int minSum = 0;

        while (left < right) {

            if (left == 0) {
                minSum = sum[right];
            } else {
                minSum = sum[right] - sum[left - 1];
            }

            if (minSum >= minTarget) {
                minLength = Math.min(minLength, right - left + 1);
                left++;

            } else {
                right++;

                if (right == num ) {
                    break;
                }

                if (right == left) {
                    break;
                }
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLength);
        }





    }
}
