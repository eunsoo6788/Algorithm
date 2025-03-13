package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution2467 {

    /**
     * 용액 2467
     * 투 포인터
     * not sol
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long minAbs = Long.MAX_VALUE;
        int left = 0;
        int right = num - 1;

        long firstValue = 0;
        long secondValue = 0;


        while (left < right) {

            long sum = arr[left] + arr[right];

            if (Math.abs(sum) < minAbs) {
                minAbs = Math.abs(sum);
                firstValue = arr[left];
                secondValue = arr[right];
            }


            if (sum == 0) {
                break;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }


        System.out.println(firstValue +
                " " + secondValue);

    }
}
