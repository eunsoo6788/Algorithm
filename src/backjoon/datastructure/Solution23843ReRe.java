package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution23843ReRe {

    /**
     * 콘센트
     * 우선순위 큐
     * 골드 5
     * not sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> room = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
           pq.add(Integer.parseInt(st.nextToken()));
        }


        for (int i = 0; i < size && !pq.isEmpty(); i++) {
            room.add(pq.poll());
        }

        int time = 0;
        while (!room.isEmpty() || !pq.isEmpty()) {

            while (!pq.isEmpty() && room.size() < size) {
                room.add(pq.poll());
            }

            int[] tmp = new int[room.size()];
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = room.poll();
            }

            for (int i = 0; i < tmp.length; i++) {
                tmp[i]--;
            }

            for (int i = 0; i < tmp.length; i++) {
                room.add(tmp[i]);
            }


            while (!room.isEmpty() && room.peek() == 0) {
                room.poll();
            }

            time++;

        }


        System.out.println(time);



    }


}
