package backjoon.graph.dikstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1753ReRe {

    private static class Node {
        private int end;
        private int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

    }

    private static int[] result;
    private static boolean[] visited;
    private static List<Node>[] nodeList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());

        visited = new boolean[nodeNum + 1];
        nodeList = new List[nodeNum + 1];
        result = new int[nodeNum + 1];

        for (int i = 1; i <= nodeNum; i++) {
            nodeList[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0 ; i < edgeNum ; i++) {
            StringTokenizer mapSt = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(mapSt.nextToken());
            int end = Integer.parseInt(mapSt.nextToken());
            int weight = Integer.parseInt(mapSt.nextToken());

            nodeList[start].add(new Node(end,weight));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        result[startNode] = 0;
        pq.offer(new Node(startNode,0));

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (!visited[now.end]) {
                visited[now.end] = true;

                for (int i = 0; i < nodeList[now.end].size(); i++) {

                    Node next = nodeList[now.end].get(i);

                    if (!visited[next.end] && next.weight + now.weight < result[next.weight]) {
                        result[next.weight] = next.weight +now.weight;
                        pq.add(new Node(next.end, result[next.end]));
                    }


                }



            }


        }


        for (int i = 1 ; i <= nodeNum ; i++){
            if (result[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }





    }


}
