package backjoon.graph.mst;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1197Re {

    /**
     * 최소 스패닝 트리
     * 골드4
     * MST (
     */

    private static class Node {
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private static int[] result;


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());

        result = new int[nodes + 1];

        for (int i = 1; i <= nodes; i++) {
            result[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        for (int i = 1; i <= edges; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.add(new Node(start, end, weight));
        }


        int sum = 0;
        for (int i = 0; i < edges; i++) {

            Node now = pq.poll();

            int start = find(now.start);
            int end = find(now.end);

            if (start != end) {
                sum += now.weight;
                union(start, end);
            }

        }


        System.out.println(sum);




    }

    private static int find(int x) {
        if (result[x] == x) {
            return x;
        }
        return result[x] = find(result[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                result[y] = x;
            } else {
                result[x] = y;
            }
        }
    }

}
