package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2206 {

    /**
     * 벽 부수고 이동하기 2206
     * 골드3
     * 알고리즘 : bfs
     * Not Sol
     */

    private static int min = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[][] visited;
    private static int ySize;
    private static int xSize;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        map = new int[ySize][xSize];
        visited = new boolean[ySize][xSize];


        for (int y = 0; y < ySize; y++) {
            String str = br.readLine();
            for (int x = 0; x < xSize; x++) {
                map[y][x] = str.charAt(x) - '0';
            }
        }

        bfs();

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

    }

    private static void bfs() {

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1, 0});  // x, y, depth, boolean destroy
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == xSize - 1 && now[1] == ySize - 1) {
                min = Math.min(min, now[2]);
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && ny < ySize && nx < xSize) {
                    if (!visited[ny][nx] && map[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{nx, ny, now[2] + 1, now[3]});
                    } else if (map[ny][nx] == 1 && now[3] == 0) {
                        queue.offer(new int[]{nx, ny, now[2] + 1, 1});
                    }
                }
            }
        }
    }

}
