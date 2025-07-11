package backjoon.graph.mst;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main14621 {

    /**
     * 나만 안되는 연애
     * 골드3
     * MST
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
    private static char[] city;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        result = new int[nodes + 1];
        city = new char[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            result[i] = i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= nodes; i++) {
            city[i] = st.nextToken().charAt(0);
        }


        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end, weight));
        }

        int sum = 0;
        int count = 1;

        Node before = pq.poll();


        while (!pq.isEmpty() && count != nodes) {
            Node now = pq.peek();

            if (city[now.start] != city[now.end]) {

                int start = find(now.start);
                int end = find(now.end);

                if (start != end) {
                    sum += now.weight;
                    union(start, end);
                    pq.poll();
                    count++;
                }

            }


        }


        System.out.println(sum);


    }


    private static int find(int x) {
        if (x == result[x]) {
            return x;
        }
        return result[x] = find(result[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (y > x) {
                result[y] = x;
            } else {
                result[x] = y;
            }
        }
    }
}
