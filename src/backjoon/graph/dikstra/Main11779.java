package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11779 {

    /**
     * 최소비용 구하기2
     * 골드3
     * 다익스트라
     */

    private static class Node {
        private int end;
        private int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

    }


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeNum = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());

        List<Node>[] nodes = new List[nodeNum + 1];

        for (int i = 0; i <= nodeNum; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[start].add(new Node(end, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());



        int[] result = new int[nodeNum + 1];
        int[] route = new int[nodeNum + 1];
        boolean[] visited = new boolean[nodeNum + 1];

        for (int j = 0; j <= nodeNum; j++) {
            result[j] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.add(new Node(startNode, 0));
        result[startNode] = 0;


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
                    route[next.end] = now.end;
                }
            }

        }


        List<Integer> list = new ArrayList<>();
        list.add(endNode);

        int now = endNode;
        while (now != startNode) {


            list.add(route[now]);
            now = route[now];
        }

        int size = list.size();

        System.out.println(result[endNode]);
        System.out.println(size);

        for (int i = 0; i < size; i++) {
            System.out.print(list.get(size - i - 1) + " ");
        }



    }


}
