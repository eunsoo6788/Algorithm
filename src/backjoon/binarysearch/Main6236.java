 package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 public class Main6236 {

     /**
      * 용돈관리
      * 실버1
      * 이분탐색
      */

     public static void main(String[] args) throws IOException {

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());

         int num = Integer.parseInt(st.nextToken());
         int target = Integer.parseInt(st.nextToken());

         int[] arr = new int[num];
         long sum = 0;
         long max = 0;
         for (int i = 0; i < num; i++) {
             arr[i] = Integer.parseInt(br.readLine());
             sum += arr[i];
             max = Math.max(max, arr[i]);
         }



         long low = max;
         long high = sum;

         while (low <= high) {

             long mid = (low + high) / 2;

             int count = 1;
             int nowSum = 0;
             for (int i = 0; i < num; i++) {
                 nowSum += arr[i];

                 if (nowSum > mid) {
                     count++;
                     nowSum = arr[i];
                 }
             }

             if (count > target ) {
                 low = mid + 1;
             } else {
                 high = mid - 1;
             }


         }


         System.out.println(low);







     }

 }
