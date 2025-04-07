package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main10282 {

    /**
     * 해킹
     * 골드 4
     * 다익스트라
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

        int testNum = Integer.parseInt(br.readLine());

        for (int testCase = 0 ; testCase < testNum ; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int nodeNum = Integer.parseInt(st.nextToken());
            int edgeNum = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());


            int[] result = new int[nodeNum+1];
            boolean[] visited = new  boolean[nodeNum+1];
            List<Node>[] lists = new List[nodeNum+1];

            for (int i = 0 ; i <= nodeNum ; i++) {
                result[i] = Integer.MAX_VALUE;
                lists[i] = new ArrayList<>();
            }


            for (int i = 0 ; i < edgeNum ; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

//                lists[s].add(new Node(e,w));
                lists[e].add(new Node(s,w));
            }



            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

            pq.add(new Node(startNode,0));
            result[startNode] = 0;

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

            int count = 0;
            int time = 0;

            for (int i = 1 ; i <= nodeNum ; i++) {
                if (result[i] != Integer.MAX_VALUE) {
                    count++;
                    time = Math.max(time, result[i]);
                }
            }

            System.out.println(count + " " + time);




        }


    }


}
