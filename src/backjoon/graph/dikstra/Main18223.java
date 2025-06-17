package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main18223 {

    /**
     * 민준이와 마산 그리고 건우
     * 다익스트라
     * 골드4
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

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int middleNum = Integer.parseInt(st.nextToken());


        List<Node>[] lists = new List[nodeNum + 1];

        for (int i = 1; i <= nodeNum; i++) {
            lists[i] = new ArrayList<>();
        }


        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[start].add(new Node(end, weight));
            lists[end].add(new Node(start, weight));
        }




        boolean[] visited = new boolean[nodeNum + 1];
        boolean[] visited2 = new boolean[nodeNum + 1];
        int[] result = new int[nodeNum + 1];
        int[] result2 = new int[nodeNum + 1];

        for (int j = 1; j <= nodeNum; j++) {
            result[j] = Integer.MAX_VALUE;
            result2[j] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.weight));
        result[1] = 0;
        pq.add(new Node(1, 0));


        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (visited[now.end]) {
                continue;
            }

            visited[now.end] = true;


            for (Node next : lists[now.end]) {

                if (now.weight + next.weight < result[next.end]) {
                    result[next.end] = now.weight + next.weight;
                    pq.add(new Node(next.end, result[next.end]));
                }
            }
        }



        PriorityQueue<Node> pq2 = new PriorityQueue<>(Comparator.comparing(o -> o.weight));
        result2[middleNum] = 0;
        pq2.add(new Node(middleNum, 0));


        while (!pq2.isEmpty()) {

            Node now = pq2.poll();

            if (visited2[now.end]) {
                continue;
            }

            visited2[now.end] = true;


            for (Node next : lists[now.end]) {

                if (now.weight + next.weight < result2[next.end]) {
                    result2[next.end] = now.weight + next.weight;
                    pq2.add(new Node(next.end, result2[next.end]));
                }
            }
        }


        if (result[nodeNum] == result[middleNum] + result2[nodeNum]) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }



    }


}
