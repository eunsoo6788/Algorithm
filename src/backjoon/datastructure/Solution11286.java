package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution11286 {

    /**
     * 절대값 힙 11286
     * 자료구조 - 큐
     * 실버1
     * sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        });

        for (int i = 0; i < num; i++) {

            int value = Integer.parseInt(br.readLine());

            if (value == 0) {
                if (!queue.isEmpty()) {

                    int poll = queue.poll();
                    System.out.println(poll);

                } else {
                    System.out.println(0);
                }


            } else {
                queue.add(value);
            }
        }


    }


}
