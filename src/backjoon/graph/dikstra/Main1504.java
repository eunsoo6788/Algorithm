package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1504 {

    /**
     * 특정한 최단 경로 1504
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        List<Node>[] nodes = new List[nodeNum+1];
        int[] result = new int[nodeNum+1];
        boolean[] visited = new boolean[nodeNum+1];

        for (int i = 0; i <= nodeNum; i++) {
            nodes[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[start].add(new Node(end, weight));
            nodes[end].add(new Node(start, weight));
        }


        int[] route = new int[4];
        route[0] = 1;
        route[3] = nodeNum;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            route[i+1] = Integer.parseInt(st.nextToken());
        }

        int distanceOne = 0;
        int distanceTwo = 0;

        boolean foundOne = false;
        boolean foundTwo = false;


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= nodeNum; j++) {
                result[j] = Integer.MAX_VALUE;
            }
            visited = new boolean[nodeNum+1];

            int start = route[i];
            int end = route[i + 1];


            PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
            queue.add(new Node(start, 0));
            result[start] = 0;

            while (!queue.isEmpty()) {
                Node now = queue.poll();

                if (visited[now.end]) {
                    continue;
                }
                visited[now.end] = true;

                for (Node next : nodes[now.end]) {
                    if (now.weight + next.weight < result[next.end]) {
                        result[next.end] = now.weight + next.weight;
                        queue.add(new Node(next.end, result[next.end]));
                    }
                }


            }


            distanceOne += result[end];
            if (result[end] == Integer.MAX_VALUE) {
                foundOne = true;
                break;
            }
        }



        int tmp = route[1];
        route[1] = route[2];
        route[2] = tmp;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= nodeNum; j++) {
                result[j] = Integer.MAX_VALUE;
            }
            visited = new boolean[nodeNum+1];

            int start = route[i];
            int end = route[i + 1];


            PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
            queue.add(new Node(start, 0));
            result[start] = 0;

            while (!queue.isEmpty()) {
                Node now = queue.poll();

                if (visited[now.end]) {
                    continue;
                }
                visited[now.end] = true;

                for (Node next : nodes[now.end]) {
                    if (now.weight + next.weight < result[next.end]) {
                        result[next.end] = now.weight + next.weight;
                        queue.add(new Node(next.end, result[next.end]));
                    }
                }


            }


            distanceTwo += result[end];
            if (result[end] == Integer.MAX_VALUE) {
                foundTwo = true;
                break;
            }
        }

        if (foundOne && foundTwo) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(distanceOne, distanceTwo));

    }







}
