package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution23843Re {

    /**
     * 최소 회의실 개수 19598
     * 자료구조
     * 골드 5
     * not sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());


        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {return o2-o1;});
        StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < num ; i++) {
            pq.add(Integer.parseInt(stArr.nextToken()));
        }


        int count = 0;
        while (!pq.isEmpty()) {
            count++;
            int[] arr = new int[size];
            for (int i = 0 ; i < size ; i++) {
                if (!pq.isEmpty()) {
                    arr[i] = pq.poll();
                }
            }

            for (int i = 0 ; i < size ; i++) {
                arr[i]--;
                if (arr[i] > 0) {
                    pq.add(arr[i]);
                }
            }

        }

        System.out.println(count);








    }


}
