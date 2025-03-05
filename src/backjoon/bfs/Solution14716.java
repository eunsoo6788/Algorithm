package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution14716 {

    /**
     * 현수막 14716
     * 알고리즘 : bfs
     * 실버 1
     * Sol
     */


    private static int[][] map;
    private static boolean[][] visited;

    private static int ySize;
    private static int xSize;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        visited = new boolean[ySize][xSize];
        map = new int[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < xSize; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (!visited[y][x] && map[y][x] == 1) {
                    visited[y][x] = true;

                    bfs(x, y);
                    count++;

                }
            }
        }

        System.out.println(count);


    }

    private static void bfs(int x, int y) {

        int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
        int[] dy = {-1, 1, 0, 0, 1, -1, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < xSize && ny < ySize) {
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }


        }


    }


}
