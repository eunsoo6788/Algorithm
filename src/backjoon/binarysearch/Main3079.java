 package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 public class Main3079 {

     /**
      * 입국심사
      * 골드5
      * 이분탐색
      */

     public static void main(String[] args) throws IOException {

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());

         int queue = Integer.parseInt(st.nextToken());
         long person = Long.parseLong(st.nextToken());

         long[] arr = new long[queue];
         long max = 0;
         long min = Long.MAX_VALUE;
         for (int i = 0; i < queue; i++) {
             arr[i] = Long.parseLong(br.readLine());
             max = Math.max(max, arr[i]);
             min = Math.min(min, arr[i]);
         }




         long low = min;
         long high = max * person;

         while (low <= high) {

             long mid = (low + high) / 2;

             long count = 0;
             for (int i = 0; i < queue; i++) {
                count += (mid/arr[i]);
             }

             if (count < person ) {
                 low = mid + 1;
             } else {
                 high = mid - 1;
             }


         }


         System.out.println(low);







     }

 }
