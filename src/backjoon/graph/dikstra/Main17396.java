package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main17396 {

    /**
     * 백도어
     * 다익스트라
     * 골드5
     * not Sol
     */

    private static class Node {
        int end;
        long weight;

        public Node(int end, long weight) {
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


        List<Node>[] lists = new List[nodeNum];
        boolean[] visited = new boolean[nodeNum];
        long[] result = new long[nodeNum];
        int[] visible = new int[nodeNum];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < nodeNum ; i++) {
            visible[i] = Integer.parseInt(st.nextToken());
            lists[i] = new ArrayList<>();
            result[i] = Long.MAX_VALUE;
        }

        visible[0] = 0;
        visible[nodeNum-1] = 0;

        for (int i = 0 ; i < edgeNum ; i++) {
            st = new StringTokenizer(br.readLine()," ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[start].add(new Node(end,weight));
            lists[end].add(new Node(start,weight));
        }



        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.weight));
        result[0] = 0;
        pq.add(new Node(0,0));


        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (visited[now.end]) {
                continue;
            }

            visited[now.end] = true;


            for (Node next : lists[now.end]) {

                if (visible[next.end] == 0 && !visited[next.end] && now.weight + next.weight < result[next.end]) {
                    result[next.end]  = now.weight + next.weight;
                    pq.add(new Node(next.end, result[next.end]));
                }
            }
        }

        if (result[nodeNum-1] == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(result[nodeNum-1]);
    }







}
