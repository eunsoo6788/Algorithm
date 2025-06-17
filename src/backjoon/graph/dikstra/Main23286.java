package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main23286 {

    /**
     * 허들넘기
     * 다익스트라
     * 골드3
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
        int tryNum = Integer.parseInt(st.nextToken());


        List<Node>[] lists = new List[nodeNum+1];

        for (int i = 1; i <= nodeNum ; i++) {
            lists[i] = new ArrayList<>();
        }


        for (int i = 0 ; i < edgeNum ; i++) {
            st = new StringTokenizer(br.readLine()," ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[start].add(new Node(end,weight));
        }


        for (int i = 0; i < tryNum ; i++) {

            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[nodeNum+1];
            int[] result = new int[nodeNum+1];

            for (int j = 1; j <= nodeNum ; j++) {
                result[j] = Integer.MAX_VALUE;
            }

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.weight));
            result[start] = 0;
            pq.add(new Node(start,0));


            while (!pq.isEmpty()) {

                Node now = pq.poll();

                if (visited[now.end]) {
                    continue;
                }

                visited[now.end] = true;


                for (Node next : lists[now.end]) {

                    if (next.weight < result[next.end]) {
                        result[next.end]  = Math.max(now.weight , next.weight);
                        pq.add(new Node(next.end, result[next.end]));
                    }
                }
            }


            if (result[end] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(result[end]);
            }

        }




    }







}
