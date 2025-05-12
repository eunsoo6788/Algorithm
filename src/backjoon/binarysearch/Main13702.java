package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13702 {

    /**
     * 이상한 술집
     * 실버2
     * 이분탐색
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int person = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        long max = 0;
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }



        long low = 0;
        long high = max;

        while (low <= high) {

            long mid = (low + high) / 2;
            long count = 0;

            if (mid == 0) {
                break;
            }

            for (int i = 0; i < num; i++) {
                count += arr[i]/mid;
            }


            if (count >= person ) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }


        }


        System.out.println(high);







    }

}
