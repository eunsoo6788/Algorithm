package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution11286 {

    /**
     * 절대값 힙 11286
     * 자료구조
     * 실버 1
     * not sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );

        for (int i = 0 ; i< num ; i++) {
            int value = Integer.parseInt(br.readLine());
            heap.add(new int[]{Math.abs(value), value});

//            queue.add(Math.abs(value));
//
//            int poll = queue.poll();
//
//            System.out.println(poll);
//            while (queue.peek() == poll) {
//                queue.poll();
//            }


        }

    }


}
