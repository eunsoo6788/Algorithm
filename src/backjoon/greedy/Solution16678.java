package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution16678 {

    /**
     * 모독
     * 알고리즘 : 그리디
     * 골드5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());



        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < num; i++) {
            int value = Integer.parseInt(br.readLine());
            pq.add(value);
        }


        int time = 0;
        long sum = 0;
        while (!pq.isEmpty()) {
            time++;


            int poll = pq.poll();

            if (time == poll) {

                while (!pq.isEmpty() && pq.peek() == time) {
                    pq.poll();
                }

                continue;
            }

            sum += Math.abs(poll - time);
        }


        System.out.println(sum);








    }


}
