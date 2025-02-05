package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution15565Re {

    /**
     * 백준 : 귀여운 라이언
     * 알고리즘 : 투 포인터
     * not sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
        }


        int low = 0;
        int high = 0;

        int count = 0;
        int length = 0;
        while (low <= high && low <= num) {

            if (count < target && high < num) {
                if (arr[high] == 1 ) {
                    count++;
                }

                high++;

                length = Math.max(length, high -low +1);

            } else if (count == target && high < num && arr[high] ==2 ) {
                if (arr[high] == 1 ) {
                    count++;
                }

                high++;

                length = Math.max(length, high -low +1);
            }
            else {

                if (arr[low] == 1) {
                    count--;
                }

                low++;

                length = Math.max(length, high -low +1);
            }



        }

        System.out.println(length);




    }
}
