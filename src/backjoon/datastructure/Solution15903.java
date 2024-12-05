package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution15903 {

    public static void main(String[] args) throws IOException {

        /**
         * 카드 합체 놀이 15903
         * 자료구조
         * 실버 1
         * sol
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());


        long[] arr = new long[num];
        for (int i = 0 ; i < num ; i++) {
            arr[i] = Long.parseLong(stArr.nextToken());
        }



        for (int i = 0 ; i < count ; i++) {
            Arrays.sort(arr);
            long value = arr[0] + arr[1];
            arr[0] = value;
            arr[1] = value;

        }


        long sum = 0;
        for (long i : arr){
            sum += i;
        }

        System.out.print(sum);

    }


}
