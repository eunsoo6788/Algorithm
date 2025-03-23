package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5014 {

    /**
     * 스타트와링크
     * 실버1
     * 알고리즘 : bfs
     * Sol
     */


    private static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int high = Integer.parseInt(st.nextToken()); // 총 층수
        int now = Integer.parseInt(st.nextToken()); // 현재
        int target = Integer.parseInt(st.nextToken()); // 목표
        int up = Integer.parseInt(st.nextToken()); // 상승
        int down = Integer.parseInt(st.nextToken()); // 하강

        boolean[] visited = new boolean[high+1];


        Queue<int[]> queue = new LinkedList<>();
        visited[now] = true;
        queue.offer(new int[]{now, 0});

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            if (current[0] == target) {
                System.out.println(current[1]);
                return;
            }

            if (current[0] + up <= high && !visited[current[0] + up]) {
                visited[current[0] + up] = true;
                queue.offer(new int[]{current[0] + up, current[1] + 1});
            }

            if (current[0] - down >= 1 && !visited[current[0] - down]) {
                visited[current[0] - down] = true;
                queue.offer(new int[]{current[0] - down, current[1] + 1});
            }


        }


        System.out.println("use the stairs");




    }

}
