package backjoon.graph.floyd;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11404 {

    /**
     * 플로이드
     * 골드4
     * 알고리즘 : 플로이드 워셜, 다익스트라
     */

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
        int nodeNum = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());


        List<Node>[] nodes = new List[nodeNum+1];

       for (int i = 1; i <= nodeNum; i++) {
           nodes[i] = new ArrayList<>();
       }

       for (int i = 0; i < edgeNum; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());
           int weight = Integer.parseInt(st.nextToken());

           nodes[start].add(new Node(end, weight));
       }


       for (int i = 1; i <= nodeNum; i++) {


           int[] result = new int[nodeNum+1];
           boolean[] visited = new boolean[nodeNum+1];

           for (int j = 0; j < nodeNum+1; j++) {
               result[j] = Integer.MAX_VALUE;
           }


           PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

           pq.add(new Node(i, 0));
           result[i] = 0;


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

           for (int j = 1; j <= nodeNum; j++) {
               System.out.print(result[j] + " ");
           }

           System.out.println();

       }


    }


}
