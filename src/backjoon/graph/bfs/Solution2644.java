package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2644 {

    /**
     * 촌수계산
     * 실버2
     * 알고리즘 : bfs
     * Not Sol
     */

    private static int[][] edges;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeNum = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int edgeNum = Integer.parseInt(br.readLine());

        List<Integer>[] list = new List[nodeNum+1];
        boolean[] visited = new boolean[nodeNum+1];

        for (int i = 0; i <= nodeNum; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }


        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == end) {
                System.out.println(now[1]);
                return;
            }

            for (int next : list[now[0]]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, now[1]+1});
                }
            }
        }


        System.out.println(-1);


    }


}
