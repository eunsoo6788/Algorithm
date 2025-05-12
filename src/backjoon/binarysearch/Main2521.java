package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2521 {

    /**
     * 예산
     * 실버2
     * 이분탐색
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[num];
        long max = 0;
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long total = Integer.parseInt(br.readLine());


        long low = 0;
        long high = max;

        while (low <= high) {

            long mid = (low + high) / 2;

            long sum = 0;

            for (int i = 0; i < num; i++) {

                if (arr[i] >= mid) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }

            }


            if (sum <= total ) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }


        }


        System.out.println(high);







    }

}
