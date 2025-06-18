package backjoon.graph.mst;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1414 {

    /**
     * 불우이웃돕기
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

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int nodes = Integer.parseInt(br.readLine());

        result = new int[nodes + 1];

        for (int i = 1; i <= nodes; i++) {
            result[i] = i;
        }


        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt((Node n) -> n.weight));


        int total = 0;
        for (int i = 0; i < nodes; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < nodes; j++) {
                char c = str.charAt(j);

                if (c == '0') {
                    continue;
                } else if (c >= 'a' && c <= 'z') {
                    total += c - 'a' +1;
                    pq.offer(new Node(i+1, j+1, c-'a'+1));
                } else if (c >= 'A' && c <= 'Z') {
                    total += c - 'A' +27;
                    pq.offer(new Node(i+1, j+1, c-'A'+27));
                }
            }
        }


        int count = 1;
        int sum = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int start = find(now.start);
            int end = find(now.end);

            if (start != end) {
                sum += now.weight;
                union(start, end);
                count++;
            }


            if (count == nodes) {
                break;
            }
        }


        if (count != nodes) {
            System.out.println(-1);
        } else {
            System.out.println(total - sum);
        }

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
