package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution22862 {

    /**
     * 가장 긴 짝수 연속한 부분 수열
     * 투 포인터
     * not sol
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int remove = Integer.parseInt(st.nextToken());
        int total = remove;

        int[] arr = new int[num];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }



        int low = 0;
        int high = 0;
        int max = 0;

        for (int i = 0; i < num; i++) {
            if (arr[i] % 2 == 0) {
                low = i;
                high = i;
                break;
            }
        }


        while (high < num) {


            while (high < num) {

                if (arr[high] % 2 == 0) {
                    max = Math.max(max, high - low + 1 - (total - remove) );
                    high++;
                } else if (arr[high] % 2 == 1 && remove > 0) {
                    max = Math.max(max, high - low + 1 - (total - remove));
                    high++;
                    remove--;
                } else if (arr[high] % 2 == 1 && remove == 0) {
                    high--;
                    break;
                }

            }



            while (low < num) {

                if (arr[low+1] % 2 == 0) {
                    low++;
                    break;
                } else if (arr[low+1] % 2 == 1) {
                    low++;
                    remove++;
                }
            }




        }


        System.out.println(max);

    }
}
