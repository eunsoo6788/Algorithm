package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1715 {

    /**
     * 카드 정렬하기 1715
     * 알고리즘 : 그리디
     * not sol
     * 골드4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < num; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }


        int sum = 0;


        while (pq.size() > 1) {

            int first = pq.poll();
            int second = pq.poll();

            sum += first;
            sum += second;

            pq.add(first + second);
        }


        System.out.println(sum);


    }
}
