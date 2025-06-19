package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main32339 {

    /**
     * 비밀모임
     * 골드 4
     * 그래프, 다익스트라
     */


    private static class Node {

        private int start;
        private int end;
        private int weight;
        private int prior;

        public Node(int end, int weight, int prior) {
            this.end = end;
            this.weight = weight;
            this.prior = prior;
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        int[] result = new int[nodeNum+1];
        boolean[] visited = new boolean[nodeNum+1];
        List<Node>[] nodes = new List[nodeNum+1];

        for (int i = 1; i <= nodeNum; i++) {
            nodes[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        int[] priority = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            priority[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            int prior = Integer.parseInt(st.nextToken());

            nodes[start].add(new Node(end, weight, prior));
        }



        PriorityQueue<Node> pq = new PriorityQueue<>(
                (o1, o2) ->
                {
                    if (o1.weight == o2.weight) {
                        return Integer.compare(o1.prior, o2.prior);
                    }
                    return Integer.compare(o1.weight, o2.weight);
                }
        );
        result[1] = 0;
        pq.add(new Node(1,0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;


            for (Node n : nodes[now.end]) {

                if (now.weight + n.weight < result[n.end]) {
                    result[n.end] = now.weight + n.weight;
                    pq.add(new Node(n.end, result[n.end], n.prior));
                }

            }
        }


        System.out.println();







    }
}
