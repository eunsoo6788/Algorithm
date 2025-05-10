package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11404 {

    /**
     * 플로이드
     * 골드5
     */

    private static class Node {
        int end;
        int weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }


    private static int node;
    private static int edge;
    private static List<Node>[] list;
    private static int[] result;
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        list = new List[node+1];


        for (int i = 1; i <= node; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0 ; i < edge ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        for (int i = 1; i <= node; i++) {

            result = new int[node+1];
            visited = new boolean[node+1];
            Arrays.fill(result, Integer.MAX_VALUE);
            bfs(i);

            for (int j =1 ; j <= node ; j++) {
                System.out.print(result[j] == Integer.MAX_VALUE ? 0 + " " : result[j] + " ");
            }
            System.out.println();


        }





    }


    private static void bfs(int startNode) {

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.add(new Node(startNode, 0));
        result[startNode] = 0;

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (visited[now.end]) {
                continue;
            }

            visited[now.end] = true;

            for (Node next : list[now.end]) {

                if (now.weight + next.weight < result[next.end]) {
                    result[next.end] = now.weight + next.weight;
                    pq.add(new Node(next.end, result[next.end]));
                }

            }



        }


    }


}
