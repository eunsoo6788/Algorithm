package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1654 {

    /**
     * 랜선 자르기
     * 실버2
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());


        long[] arr = new long[num];
        long max = 0;
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }


        long low = 1;
        long high = max;

        long len = 0;

        while (low <= high) {

            long mid = (low + high) / 2;

            long sum = 0;
            for (long i : arr) {
                sum += i / mid;
            }


            if (sum >= target) {
                low = mid + 1;
                len = Math.max(len, mid);
            } else if (sum < target) {
                high = mid - 1;
            }

        }

        System.out.println(len);

    }


}
