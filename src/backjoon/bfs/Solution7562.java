package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7562 {

    /**
     * https://www.acmicpc.net/problem/7562
     * 실버1
     * 알고리즘 : dfs bfs
     * Sol
     */

    private static int startX;
    private static int startY;
    private static int endX;
    private static int endY;
    private static int[][] map;
    private static boolean[][] visited;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < testSize; i++) {


            int size = Integer.parseInt(br.readLine());


            StringTokenizer startTokenizer = new StringTokenizer(br.readLine(), " ");
            startY = Integer.parseInt(startTokenizer.nextToken());
            startX = Integer.parseInt(startTokenizer.nextToken());


            StringTokenizer endTokenizer = new StringTokenizer(br.readLine(), " ");
            endY = Integer.parseInt(endTokenizer.nextToken());
            endX = Integer.parseInt(endTokenizer.nextToken());


            map = new int[size][size];
            visited = new boolean[size][size];


            bfs();
            System.out.println(answer);


        }


    }


    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY, 0});
        visited[startY][startX] = true;

        int[] dx = {1, 2, -1, -2, 1, 2, -1, -2};
        int[] dy = {2, 1, 2, 1, -2, -1, -2, -1};

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            if (poll[0] == endX && poll[1] == endY) {
                answer = poll[2];
                break;
            }


            for (int i = 0; i < 8; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < map[0].length && ny < map.length) {

                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny, poll[2] + 1});
                    }

                }

            }


        }


    }


}
