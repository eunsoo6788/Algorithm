package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main28449Re {

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


        int[] arrA = new int[aNum];
        int[] arrB = new int[bNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aNum; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bNum; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrB);

        int win = 0;
        int draw = 0;
        int lose = 0;

        for (int a = 0 ; a < aNum ; a++) {

            int aValue = arrA[a];
            int low = 0;
            int high = bNum-1;

            boolean isDraw = false;

            int mid = 0;

            while (low <= high) {

                mid = (low+high) / 2;

                if (aValue > arrB[mid]) {
                    low = mid+1;
                } else if (aValue == arrB[mid]) {
                    isDraw = true;
                    break;
                } else {
                    high = mid-1;
                }

            }

            if (isDraw) {
                draw++;
                win += mid;
                lose += (bNum - mid -1);
            } else {
                win += mid;
                lose += (bNum - mid);
            }

        }


        System.out.println(win + " " + lose + " " + draw) ;



    }

}

