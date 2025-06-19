package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main13424 {

    /**
     * 비밀모임
     * 골드 4
     * 그래프, 다익스트라
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

        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int nodes = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());


            List<Node>[] graph = new List[nodes+1];

            for (int i = 1; i <= nodes; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0 ; i < edges ; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph[a].add(new Node(b,c));
                graph[b].add(new Node(a,c));
            }

            int friend = Integer.parseInt(br.readLine());
            int[] friends = new int[friend];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < friend; i++) {
                friends[i] = Integer.parseInt(st.nextToken());
            }


            int[][] result = new int[nodes+1][friend];

            for (int f = 0; f < friend; f++) {


                for (int i = 0; i <= nodes; i++) {
                    result[i][f] = Integer.MAX_VALUE;
                }

                PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
                result[friends[f]][f] = 0;
                pq.add(new Node(friends[f],0));

                boolean[] visited = new boolean[nodes+1];

                while (!pq.isEmpty()) {
                    Node now = pq.poll();

                    if (visited[now.end]) {
                        continue;
                    }

                    visited[now.end] = true;

                    for (Node next : graph[now.end]) {

                        if (now.weight + next.weight < result[next.end][f]) {
                            result[next.end][f] = now.weight + next.weight;
                            pq.add(new Node(next.end, result[next.end][f]));
                        }
                    }

                }
            }


            int[] res = new int[nodes+1];
            for (int f = 0; f < friend; f++) {
                for (int n = 1; n <= nodes; n++) {
                    if (result[n][f] != Integer.MAX_VALUE) {
                        res[n] += result[n][f];
                    }
                }
            }





            int min = Integer.MAX_VALUE;
            int answer = 0;
            for (int f = 1; f <= nodes; f++) {
                if (res[f] < min) {
                    min = res[f];
                    answer = f;
                }
            }

            System.out.println(answer);



        }




    }
}
