package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution14921 {

    /**
     * 용액 합성하기 14921
     * 알고리즘 : 투 포인터
     * sol > 쏘 이지
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int low = 0;
        int high = num - 1;
        long min = Integer.MAX_VALUE;

        while (low < high) {

            long sum = arr[low] + arr[high];

            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
            }

            if (sum > 0) {
                high--;
            } else if(sum <0) {
                low++;
            } else {
                min = sum;

                break;
            }


        }


        System.out.println(min);


    }
}
