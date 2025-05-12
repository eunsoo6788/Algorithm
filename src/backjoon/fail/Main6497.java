package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main6497 {

    /**
     * 전력난
     * 골드4
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

    private static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            if (num == 0 && edge == 0) {
                break;
            }

            parents = new int[num];
            for (int i = 0; i < num; i++) {
                parents[i] = i;
            }

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

            long sumAll = 0;
            for (int i = 0; i < edge; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                pq.add(new Node(start, end, weight));

                sumAll += weight;
            }

            long sum = 0;
            while (!pq.isEmpty()) {
                Node node = pq.poll();

                int start = find(node.start);
                int end = find(node.end);

                if (start != end) {
                    sum += node.weight;
                    union(node.start, node.end);
                }

            }


            System.out.println(sumAll-sum);

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
