package backjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution20922 {

    /**
     * 백준 : 겹치는 거 싫어 20922
     * 알고리즘 : 투 포인터
     * sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        StringTokenizer arrSt = new StringTokenizer(br.readLine(), " ");

        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(arrSt.nextToken());
        }



        int left = 0;
        int right = num - 1;
        int answer = 0;

        while (left <= right) {

            Map<Integer,Integer> map = new HashMap<>();
            int count = 0;
            for (int i = right ; i > left ; i-- ) {

                if (map.getOrDefault(arr[i], 0) >= size) {
                    break;
                }

                map.put(arr[i], map.getOrDefault(arr[i],0) +1);
                count++;
            }

            if (count == num - left) {
                answer = Math.max(answer,count);
            }

            left++;
        }


        System.out.println(answer);


    }
}
