package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2792 {

    /**
     * 대회개최
     * 골드5
     * 알고리즘 : 이분탐색
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int child = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int max = 0;

        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }


        int low = 1;
        int high = max;


        while (low <= high) {

            int mid = (low + high) / 2;
            int count = cal(mid, arr);

            if (count < child) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int answer = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] % high > 0) {
                answer = Math.max(answer, arr[i]/high + 1);
            } else {
                answer = Math.max(answer, arr[i]/high);
            }
        }


        System.out.println(answer);



    }

    private static int cal(int value, int[] arr) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            count += arr[i] / value;
        }

        return count;
    }


}
