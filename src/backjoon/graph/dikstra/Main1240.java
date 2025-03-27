package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1240 {



    private static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }



    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = nodeNum - 1;
        int caseNum = Integer.parseInt(st.nextToken());

        List<Node>[] nodes = new List[nodeNum + 1];


        for (int i = 1; i <= nodeNum; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[start].add(new Node(end, weight));
            nodes[end].add(new Node(start, weight));
        }

        for (int i = 0; i < caseNum; i++) {
            int[] result = new int[nodeNum + 1];
            boolean[] visited = new boolean[nodeNum + 1];

            for (int j = 1; j <= nodeNum; j++) {
                result[j] = Integer.MAX_VALUE;
            }

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
            pq.add(new Node(start, 0));
            result[start] = 0;

            while (!pq.isEmpty()) {

                Node now = pq.poll();

                if (visited[now.end]) {
                    continue;
                }

                visited[now.end] = true;

                for (Node next : nodes[now.end]) {

                    if (now.weight + next.weight < result[next.end]) {
                        result[next.end] = now.weight + next.weight;
                        pq.add(new Node(next.end, result[next.end]));
                    }
                }


            }

            System.out.println(result[end]);


        }






    }







}
