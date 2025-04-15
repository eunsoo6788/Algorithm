package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2118 {

    /**
     * 가장 긴 짝수 연속한 부분 수열
     * 투 포인터
     * not sol
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int sum = 0;

        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        int middle = sum / 2;

        int low = 0;
        int high = 0;


        int max = 0;
        int distance = 0;
        while (high < num) {

             while (high < num && distance <= middle) {
                 distance += arr[high];
                 high++;
             }

             while (low < num && distance > middle) {
                 distance -= arr[low];
                 low++;
             }

             if (distance >= middle) {
                 max = Math.max(distance, max);
             }


        }

        System.out.println(max);






    }
}
