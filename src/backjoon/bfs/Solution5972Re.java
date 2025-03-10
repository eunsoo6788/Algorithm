package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution5972Re {

    /**
     * 택배 배송 5972
     * 골드5
     * 알고리즘 : 다익스트라
     * Not Sol
     */

    private static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        List<Node>[] nodeList = new List[nodeNum+1];
        boolean[] visited = new boolean[nodeNum+1];
        int[] result = new int[nodeNum+1];

        for (int i = 0 ; i <= nodeNum ; i++) {
            nodeList[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }


        for (int i = 0 ; i < edgeNum ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int strat = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList[strat].add(new Node(end, weight));
            nodeList[end].add(new Node(strat,weight));
        }


        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        result[1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();


            if (!visited[now.end]) {
                visited[now.end] = true;

                for (int i = 0 ; i < nodeList[now.end].size() ; i++) {
                    Node next  = nodeList[now.end].get(i);

                    if (!visited[next.end] && now.weight + next.weight < result[next.weight]) {
                        visited[next.end] = true;
                        result[next.weight] = 


                    }



                }

            }





        }




    }



}
