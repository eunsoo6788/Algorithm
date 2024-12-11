package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3020 {

    /**
     * 개똥벌레 3020
     * 골드 5
     * 알고리즘 : 이분탐색
     * Not Sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());



        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[num];
        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }




        long min = Math.abs(arr[0] + arr[num-1]);
        long lowValueOne = arr[0];
        long lowValueTwo = arr[num-1];


        for (int i = 0 ; i < num -1  ; i++) {

            int high = num -1;
            int low = i;

            long minIndex = Math.abs(arr[i] + arr[num-1]);

            if (minIndex < min) {
                lowValueOne = arr[i];
                lowValueTwo = arr[num-1];
            }

            if (minIndex == 0 ){
                lowValueOne = arr[i];
                lowValueTwo = arr[num-1];
                break;
            }

            while(low < high) {

                int mid = (high+low) /2;

                long sum = Math.abs(arr[i] + arr[high]);

                if (sum < min) {
                    lowValueOne = arr[i];
                    lowValueTwo = arr[high];
                }

                if (sum == 0) {
                    break;
                }


                if (Math.abs(sum) >= minIndex) {
                    low = mid +1;
                } else {
                    high = mid -1;
                }

            }

        }

        System.out.println(lowValueOne);
        System.out.println(lowValueTwo);



    }

}
