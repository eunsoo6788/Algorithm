package backjoon.graph.dikstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1753Re {

    private static class Node {
        int end;
        int wight;

        public Node(int end, int wight) {
            this.end = end;
            this.wight = wight;
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

        result = new int[nodeNum + 1];
        visited = new boolean[nodeNum + 1];
        nodeList = new List[nodeNum + 1];

        for (int i = 1; i <= nodeNum; i++) {
            nodeList[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }


        for (int i = 0; i < edgeNum; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList[start].add(new Node(end, weight));

        }


        PriorityQueue<Node> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.wight)));
        result[startNode] = 0;
        pq.add(new Node(startNode, 0));


        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visited[now.end]) {
                visited[now.end] = true;

                for (int i = 0; i < nodeList[now.end].size(); i++) {

                    Node next = nodeList[now.end].get(i);

                    if (!visited[next.end] && now.wight + next.wight < result[next.end]) {

                        result[next.end] = now.wight + next.wight;
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
