package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1260Re {

    /**
     * DFS와 BFS
     * 실버2
     * 알고리즘 : 백트래킹
     * Not Sol
     */

    private static int[][] edges;
    private static boolean[] visited;
    private static List<Integer>[] lists;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        lists = new List[nodeNum+1];

        for (int i = 0; i <= nodeNum; i++) {
            lists[i] = new LinkedList<>();
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lists[s].add(e);
            lists[e].add(s);
        }

        for (int i = 1; i <= nodeNum; i++) {
            Collections.sort(lists[i]);
        }




        visited = new boolean[nodeNum+1];
        visited[start] = true;
        System.out.print(start+" ");
        dfs(start);


        visited = new boolean[nodeNum+1];
        bfs(start);




    }


    private static void dfs(int start) {


        for (int i : lists[start]) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.print(i+" ");
                dfs(i);
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

            for (int i : lists[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    System.out.print(i+" ");
                    queue.add(i);
                }

            }

        }





    }


}
