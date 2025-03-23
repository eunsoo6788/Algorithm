package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1260 {

    /**
     * DFS와 BFS
     * 실버2
     * 알고리즘 : 백트래킹
     * Not Sol
     */

    private static int[][] edges;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        edges = new int[edgeNum][2];

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        visited = new boolean[nodeNum+1];

        System.out.print(start+" ");
        visited[start] = true;
        dfs(start);


        System.out.println();

        visited = new boolean[nodeNum+1];
        bfs(start);


    }


    private static void dfs(int start) {


        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == start && !visited[edges[i][1]]) {
                System.out.print(edges[i][1] + " ");
                visited[edges[i][1]] = true;
                dfs(edges[i][1]);
            } else if (edges[i][1] == start && !visited[edges[i][0]]) {
                System.out.print(edges[i][0] + " ");
                visited[edges[i][0]] = true;
                dfs(edges[i][0]);
            }
        }


    }


    private static void bfs(int start) {


        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        System.out.print(start +" ");

        while (!queue.isEmpty()) {
            int now = queue.poll();


            for (int i = 0; i < edges.length; i++) {

                if (now == edges[i][0] && !visited[edges[i][1]]) {
                    visited[edges[i][1]] = true;
                    System.out.print(edges[i][1] + " ");
                    queue.add(edges[i][1]);
                } else if (now == edges[i][1] && !visited[edges[i][0]]) {
                    visited[edges[i][0]] = true;
                    System.out.print(edges[i][0] + " ");
                    queue.add(edges[i][0]);
                }

            }

        }





    }


}
