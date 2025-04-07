package backjoon.graph.floyd;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main22865 {

    /**
     * 가장 먼 곳
     * 골드4
     * 플로이드 워셜
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

        int nodeNum = Integer.parseInt(br.readLine());

        boolean[] house = new boolean[nodeNum+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            house[Integer.parseInt(st.nextToken())] = true;
        }

        List<Node>[] lists = new List[nodeNum+1];

        for (int i = 0; i <= nodeNum; i++) {
            lists[i] = new ArrayList<>();
        }

        int edgeNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < edgeNum; i++) {

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[start].add(new Node(end, weight));
            lists[end].add(new Node(start, weight));
        }


        int max = 0;
        int houseAnswer = 0;


        for (int i = 1; i <= nodeNum; i++) {

            if (house[i]) {
                continue;
            }

            int[] result = new int[nodeNum+1];
            for (int j = 0; j <= nodeNum; j++) {
                result[j] = Integer.MAX_VALUE;
            }



            boolean[] visited = new boolean[nodeNum+1];
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
            pq.add(new Node(i, 0));
            result[i] = 0;


            while (!pq.isEmpty()) {

                Node node = pq.poll();

                if (visited[node.end]) {
                    continue;
                }

                visited[node.end] = true;

                for (Node next : lists[node.end]) {
                    if (node.weight + next.weight < result[next.end]) {
                        result[next.end] = node.weight + next.weight;
                        pq.add(new Node(next.end, result[next.end]));
                    }
                }

            }

            int distance = Integer.MAX_VALUE;

            for (int j = 1; j <= nodeNum; j++) {
                if (result[j] != Integer.MAX_VALUE && j != i && house[j]) {

                    if (result[j] < distance) {
                        distance = result[j];
                    }
                }
            }



            if (distance > max) {
                max = distance;
                houseAnswer = i;
            } else if (distance == max) {
                houseAnswer = Math.min(houseAnswer, i);
            }

        }


        System.out.println(houseAnswer);






    }


}
