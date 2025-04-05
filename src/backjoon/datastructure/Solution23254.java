package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution23254 {

    /**
     * 나는 기말고사형 인간이야
     * 우선순위 큐
     * 골드 5
     * not sol
     */

    public static class Node {
        int score; // 시작점수
        int plus; // 플러스 점수
        int total; // 총점
        double percent;  // 효율

        public Node(int score, int plus, int total, double percent) {
            this.score = score;
            this.plus = plus;
            this.total = total;
            this.percent = percent;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int timeNum = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int time = timeNum * 24;
        int total = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o.percent));

        st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            int score = Integer.parseInt(st.nextToken());
            int plus = Integer.parseInt(st1.nextToken());

            total += score;
            pq.add(new Node(score, plus, score, (double) (100 - score) /plus));
        }



        while (time > 0 && !pq.isEmpty()) {

            Node node = pq.poll();

            if (node.total + node.plus > 100) {
                continue;
            }


            Node newNode = new Node(node.score, node.plus, node.total + node.plus, (double) (100-node.total-node.plus)/node.plus);
            pq.offer(newNode);

            total += newNode.plus;

            time--;

        }


        System.out.println(total);


    }


}
