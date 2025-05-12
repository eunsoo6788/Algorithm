package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16401 {

    /**
     * 과자 나눠주기
     * 실버2
     * 이분탐색
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int person = Integer.parseInt(st.nextToken());
        int snack = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[snack];
        long max = 0;
        for (int i = 0; i < snack; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }



        long low = 1;
        long high = max;

        while (low <= high) {

            long mid = (low + high) / 2;
            long count = 0;

            for (int i = 0; i < snack; i++) {
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
