package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution11000 {

    /**
     * 강의실 배정
     * 우선순위 큐
     * 골드5
     * not sol
     */

    private static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        PriorityQueue<Node> room = new PriorityQueue<>((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end));
        }


        int max = 0;

        while (!pq.isEmpty()) {

            Node node = pq.poll();

            while (!room.isEmpty() && room.peek().end <= node.start) {
                room.poll();
            }

            room.add(node);


            max = Math.max(max, room.size());

        }


        System.out.println(max);





    }


}
