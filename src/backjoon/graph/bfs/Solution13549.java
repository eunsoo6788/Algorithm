package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution13549 {

    /**
     * 숨바꼭질3 13549
     * 골드5
     * 알고리즘 : 백트래킹
     * Not Sol
     */

    private static int answer = 0;
    private static boolean[] visited = new boolean[100001];


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        bfs(start, target);


        System.out.println(answer);

    }

    private static void bfs(int start, int target) {


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            if (target == now[0]) {
                answer = now[1];
                return;
            }

            if (now[0]*2 < 100001 && !visited[now[0] * 2]) {
                visited[now[0] * 2] = true;
                queue.add(new int[]{now[0] * 2, now[1]});
            }

            if (now[0] -1 >= 0 && !visited[now[0] - 1]) {
                visited[now[0] - 1] = true;
                queue.add(new int[]{now[0] - 1, now[1] + 1});
            }
            if (now[0] + 1 < 100001 && !visited[now[0] + 1]) {
                visited[now[0] + 1] = true;
                queue.add(new int[]{now[0] + 1, now[1] + 1});
            }




        }

    }


}
