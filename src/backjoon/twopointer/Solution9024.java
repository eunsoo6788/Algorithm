package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution9024 {

    /**
     * 두 수의 합 9024
     * 알고리즘 : 투 포인터
     * sol > 쏘 이지
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum = Integer.parseInt(br.readLine());

        for (int testCase= 0 ; testCase < testNum ; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int num = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");

            int[] arr = new int[num];
            for (int i = 0 ; i < num ; i++) {
                arr[i] = Integer.parseInt(stArr.nextToken());
            }

            Arrays.sort(arr);


            long minAbs = Integer.MAX_VALUE;
            long minCount = 0;


            int low = 0 ;
            int high = num-1;

            while(low < high) {

                long sum = arr[low] + arr[high];


                if (minAbs > Math.abs(sum- target)) {
                    minAbs = Math.abs(sum- target);
                    minCount = 1;
                } else if (minAbs == Math.abs(sum- target)) {
                    minCount ++;
                }

                if (sum > target) {
                    high--;
                } else if (sum <= target) {
                    low++;
                }

            }

            System.out.println(minCount);




        }



    }
}
