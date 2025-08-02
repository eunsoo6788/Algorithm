package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2230 {

    /**
     * 수 고르기
     * 투 포인터
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        long limit = Integer.parseInt(st.nextToken());

        long[] arr = new long[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);


        int low = 0 ;
        int high = 0;

        long min = Long.MAX_VALUE;

        while (high < num) {

            long abs = Math.abs(arr[low] - arr[high]);

            if (abs < limit) {
                high++;
            } else if (abs == limit) {
                min = limit;
                break;
            } else {
                low++;
                min = Math.min(abs, min);
            }

        }

        System.out.println(min);


    }
}
