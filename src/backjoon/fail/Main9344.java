package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main9344 {

    /**
     * 정복자
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


        int n = Integer.parseInt(br.readLine());
        for (int k = 0; k < n; k++) {


            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());


            parents = new int[num+1];
            for (int i = 1; i <= num; i++) {
                parents[i] = i;
            }

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

            for (int i = 0; i < edge; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                pq.add(new Node(start, end, weight));

            }

            boolean visited = false;

            while (!pq.isEmpty()) {
                Node node = pq.poll();

                int start = find(node.start);
                int end = find(node.end);

                if (start != end) {

                    if ((node.start == s || node.start == e) && (node.end == e ||  node.end == s)) {
                        visited = true;
                    }

                    union(node.start, node.end);
                }

            }

            System.out.println(visited?"YES":"NO");


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
