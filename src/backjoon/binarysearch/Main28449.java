package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main28449 {

    /**
     * 누가 이길까
     * 골드5
     * 이분탐색
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aNum = Integer.parseInt(st.nextToken());
        int bNum = Integer.parseInt(st.nextToken());


        int[] a = new int[aNum];
        int[] b = new int[bNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aNum; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bNum; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(b);

        int win = 0;
        int lose = 0;
        int draw = 0;

        for (int i = 0; i < aNum; i++) {

            int low = 0;
            int high = bNum - 1;
            boolean isDraw = false;

            while (low <= high) {

                int mid = (low + high) / 2;

                if (a[i] < b[mid]) {
                    high = mid - 1;
                } else if (a[i] > b[mid]) {
                    low = mid + 1;
                } else {
                    isDraw = true;
                    low = mid;
                    break;
                }
            }

            if (isDraw) {
                draw++;
                win += low - 1;
                lose += bNum - low;
            } else {
                win += low;
                lose += bNum - low;
            }

        }

        System.out.println(win);
        System.out.println(lose);
        System.out.println(draw);

    }

}
