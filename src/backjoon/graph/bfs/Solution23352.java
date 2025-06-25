package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution23352 {

    /**
     * 방탈출
     * bfs / 겨자
     * 골드5
     */


    private static int ySize;
    private static int xSize;
    private static int[][] map;
    private static boolean[][] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());


        map = new int[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xSize; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }


        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (map[y][x] != 0) {
                    visited = new boolean[ySize][xSize];
                    bfs(x, y);
                }
            }
        }


        System.out.println(maxPassword);

    }

    private static int maxLen = 0;
    private static int maxPassword = 0;

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[y][x] = true;

        int password = map[y][x];

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            if (now[2] == maxLen) {
                maxPassword = Math.max(maxPassword, password + map[now[1]][now[0]]);
            } else if (now[2] > maxLen) {
                maxPassword = password + map[now[1]][now[0]];
                maxLen = now[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx >= 0 && ny >= 0 && nx < xSize && ny < ySize) {
                    if (!visited[ny][nx] && map[ny][nx] != 0) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{nx, ny, now[2] + 1});
                    }

                }

            }


        }

    }

}
