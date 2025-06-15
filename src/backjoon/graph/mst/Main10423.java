package backjoon.graph.mst;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main10423 {

    /**
     * 전기가 부족해
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
    private static List<Integer> city;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        result = new int[nodes + 1];
        city = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            city.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= nodes; i++) {
            result[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        PriorityQueue<Node> tmp = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end, weight));
        }

        int sum = 0;
        int count = num;

        while (!pq.isEmpty()) {

            Node now = pq.peek();

            int start = find(now.start);
            int end = find(now.end);

            if (start != end) {

                for (int i = 0; i < num; i++) {
                    if ((city.get(i) == start || city.get(i) == end) && !(city.contains(start) && city.contains(end))) {
                        union(start, end);
                        city.remove(i);
                        city.add(find(now.start));
                        sum += now.weight;
                        pq.poll();
                        count++;

                        while (!tmp.isEmpty()) {
                            pq.offer(tmp.poll());
                        }

                        break;
                    }

                    if (i == num - 1) {
                        tmp.offer(pq.poll());
                    }
                }


            }

            if (count == nodes) {
                break;
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
