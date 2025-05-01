package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1260 {

    /**
     * DFS와 BFS
     * 실버2
     */

    private static int node;
    private static int edge;
    private static int start;
    private static List<Integer>[] list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        list = new List[node+1];
        visited = new boolean[node+1];


        for (int i = 1; i <= node; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        for (int i = 1; i <= node; i++) {
            list[i].sort(Comparator.naturalOrder());
        }

        visited[start] = true;
        dfs(start);


        visited = new boolean[node+1];

        System.out.println();
        bfs();




    }


    private static void dfs(int now) {

        System.out.print(now + " ");


        for (int i : list[now]) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }


    }



    private static void bfs() {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        System.out.print(start + " ");

        while (!q.isEmpty()) {

            int now = q.poll();


            for (int i : list[now]) {
                if (!visited[i]) {
                    System.out.print(i + " ");
                    visited[i] = true;
                    q.add(i);
                }
            }



        }


    }




}
