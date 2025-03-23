package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1697 {

    /**
     * 숨바꼭질
     * 실버1
     * 알고리즘 : bfs
     * Not Sol > 메모리 초과
     */


    private static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end);

    }

    private static void bfs(int start, int end) {


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            if (now[0] == end) {
                System.out.println(now[1]);
                return;
            }

            if (now[0]+1 < 100001 && !visited[now[0]+1]) {
                queue.add(new int[]{now[0]+1, now[1] + 1});
            }

            if (now[0]-1 < 100001 &&!visited[now[0]-1]) {
                queue.add(new int[]{now[0]-1, now[1] + 1});
            }

            if (now[0]*2 < 100001 &&!visited[now[0]*2]) {
                queue.add(new int[]{now[0]*2, now[1] + 1});
            }



        }



    }


}
