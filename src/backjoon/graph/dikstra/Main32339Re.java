package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main32339Re {

    /**
     * 비밀모임
     * 골드 3
     * 그래프, 다익스트라
     */


    private static class Node {

        private int start;
        private int end;
        private int weight;
        private int vehicle;
        private int prior;

        public Node(int start, int end, int weight, int vehicle, int prior) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.vehicle = vehicle;
            this.prior = prior;
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

        int[] priority = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            priority[Integer.parseInt(st.nextToken())] = i;
        }

        Queue<Node> queue = new PriorityQueue<>((o1, o2) ->
        {
            if (o1.weight == o2.weight) {
                return Integer.compare(o1.prior, o2.prior);
            }
            return Integer.compare(o1.weight, o2.weight);
        });

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            int vehicle = Integer.parseInt(st.nextToken());

            queue.add(new Node(start, end, weight, vehicle, priority[vehicle]));
        }


        int sum = 0;
        int[][] answer = new int[3][2];

        for (int i = 0; i < edgeNum; i++) {

            Node node = queue.poll();

            int start = find(node.start);
            int end = find(node.end);

            if (start != end) {
                sum += node.weight;
                answer[node.vehicle][0]++;
                answer[node.vehicle][1] += node.weight;

                union(start, end);
            }
        }


        System.out.println(sum);
        for (int i = 0; i < 3; i++) {
            System.out.println(answer[i][0] + " " + answer[i][1]);
        }



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
