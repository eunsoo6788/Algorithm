package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main18352 {

    /**
     * 다익스트라
     * 실버2
     * 특정 거리의 도시 찾기
     * Sol
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());


        List<Node>[] lists = new List[nodeNum+1];
        boolean[] visited = new boolean[nodeNum+1];
        int[] result = new int[nodeNum+1];


        for (int i = 0; i <= nodeNum ; i++) {
            lists[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0 ; i < edgeNum ; i++) {
            st = new StringTokenizer(br.readLine()," ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lists[start].add(new Node(end,1));
        }


        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.weight));
        result[startNode] = 0;
        pq.add(new Node(startNode,0));


        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (visited[now.end]) {
                continue;
            }

            visited[now.end] = true;


            for (Node next : lists[now.end]) {

                if (!visited[next.end] && now.weight + next.weight < result[next.end]) {
                    result[next.end]  = now.weight + next.weight;
                    pq.add(new Node(next.end, result[next.end]));
                }
            }
        }


        int count = 0;
        for (int i = 0 ; i <= nodeNum ; i++ ){
            if (result[i] == distance) {
                System.out.println(i);
                count++;
            }
        }


        if (count == 0) {
            System.out.println(-1);
        }
    }







}
