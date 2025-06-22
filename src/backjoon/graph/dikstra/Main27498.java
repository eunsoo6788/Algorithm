package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main27498 {

    /**
     * 연애 혁명
     * 골드 3
     * 그래프, 다익스트라
     */


    private static class Node {

        private int start;
        private int end;
        private int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private static int[] parents;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        parents = new int[nodeNum + 1];
        for (int i = 1; i <= nodeNum; i++) {
            parents[i] = i;
        }


        Queue<Node> queue = new PriorityQueue<>(
                ((o1, o2) -> o2.weight - o1.weight)
        );
        int total = 0;
        int sum = 0;

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            int love = Integer.parseInt(st.nextToken());

            if (love == 1) {
                union(start, end);
                sum += weight;
            } else {
                queue.add(new Node(start, end, weight));
            }

            total += weight;
        }



        int size = queue.size();

        for (int i = 0; i < size; i++) {

            Node node = queue.poll();

            int start = find(node.start);
            int end = find(node.end);

            if (start != end) {
                sum += node.weight;
                union(start, end);
            }
        }


        System.out.println(total-sum);





    }


    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }


    private static void union(int x, int y) {
        x = find(x);
        y = find(y);


        if (x != y) {
            if (x < y) {
                parents[y] = x;
            } else {
                parents[x] = y;
            }
        }
    }
}
