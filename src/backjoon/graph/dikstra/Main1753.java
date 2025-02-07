package backjoon.graph.dikstra;


import java.io.*;
import java.util.*;

public class Main1753 {

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
        int edgeNum = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[nodeNum+1];
        int[] result = new int[nodeNum+1];
        List<Node>[] nodeList = new List[nodeNum+1];


        for (int i = 1 ; i <= nodeNum ; i++) {
            result[i]= Integer.MAX_VALUE;
            nodeList[i] = new ArrayList<>();
        }


        for (int i = 0 ; i < edgeNum ; i++) {
            st = new StringTokenizer(st.nextToken(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList[start].add(new Node(end,weight));
        }


        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        result[startNode] = 0;
        pq.add(new Node(startNode,0));

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (!visited[now.end]) {
                visited[now.end] = true;
            }

            for (int i = 0 ; i < nodeList[now.end].size() ; i++) {

                Node next = nodeList[now.end].get(i);

                if (!visited[next.end] && now.weight + next.weight < result[next.end]) {
                    result[next.end] = now.weight + next.weight;
                    pq.add(new Node(next.end,result[next.end]));
                }


            }



        }




    }







}
