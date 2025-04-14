package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2230 {

    /**
     * 수 고르기
     * 투 포인터
     * not sol
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int low = 0;
        int high = 0;
        int absMin = Integer.MAX_VALUE;

        while (low < num) {

            if (low == high) {

                if (high == num -1) {
                    break;
                }

                high++;
                continue;
            }

            int abs = Math.abs(arr[low] - arr[high]);

            if (abs < limit) {

                if (high == num -1) {
                    break;
                }

                high++;
            } else if (abs > limit) {
                absMin = Math.min(abs, absMin);
                low++;
            } else if (abs == absMin) {
                absMin = abs;
            }

        }



        System.out.println(absMin);
    }
}
