package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main20010Re {

    /**
     * 악덕 영주 혜유
     * 골드2
     * 그래프, 다익스트라
     */


    private static class Node {

        private int start;
        private int end;
        private int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }


    private static class Villege {

        private int end;
        private int weight;

        public Villege(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    private static int[] parents;
    private static List<Villege>[] list;


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        parents = new int[nodeNum + 1];
        for (int i = 1; i <= nodeNum; i++) {
            parents[i] = i;
        }


        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            queue.add(new Node(start, end, weight));
        }

        list = new List[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            list[i] = new ArrayList<>();
        }


        int sum = 0;

        for (int i = 0; i < edgeNum; i++) {

            Node node = queue.poll();

            int start = find(node.start);
            int end = find(node.end);

            if (start != end) {
                sum += node.weight;
                union(start, end);
                list[node.start].add(new Villege(node.end, node.weight));
                list[node.end].add(new Villege(node.start, node.weight));
            }
        }


        int max = 0;

        longDistance();

        System.out.println(sum);
        System.out.println(max);





    }


    // bfs
    private static void longDistance() {


        Queue<Villege> queue = new LinkedList<>();




    }


    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }


    private static void union(int x, int y) {
        x = find(x);
        y = find(y);


        if (x != y) {
            if (x < y) {
                parents[y] = x;
            } else {
                parents[x] = y;
            }
        }
    }
}
