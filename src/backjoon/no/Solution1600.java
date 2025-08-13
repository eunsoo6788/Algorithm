package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1600 {

    /**
     * 말이 되고픈 원숭이
     * 골드 3
     */

    private static int num;
    private static int xSize;
    private static int ySize;
    private static int[][] map;
    private static boolean[][][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        xSize = Integer.parseInt(st.nextToken());
        ySize = Integer.parseInt(st.nextToken());

        map = new int[ySize][xSize];
        visited = new boolean[ySize][xSize][num+1];

        for (int y = 0; y < ySize; y++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < xSize; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(bfs());


    }


    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int[] kx = {2, 2, 1, -1, -2, -2, -1, 1};
    private static int[] ky = {1, -1, -2, -2, 1, -1, 2, 2};

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;

        int depth = -1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == xSize - 1 && now.y == ySize - 1) {
                depth = now.depth;
                break;
            }


            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= xSize || ny < 0 || ny >= ySize) {
                    continue;
                }

                if (!visited[ny][nx][now.count] && map[ny][nx] != 1) {
                    visited[ny][nx][now.count] = true;
                    queue.add(new Point(nx, ny, now.depth + 1, now.count));
                }
            }

            if (now.count < num) {

                for (int j = 0; j < 8; j++) {
                    int nx = now.x + kx[j];
                    int ny = now.y + ky[j];

                    if (nx < 0 || nx >= xSize || ny < 0 || ny >= ySize) {
                        continue;
                    }

                    if (!visited[ny][nx][now.count+1] && map[ny][nx] != 1) {
                        visited[ny][nx][now.count+1] = true;
                        queue.add(new Point(nx, ny, now.depth + 1, now.count + 1));
                    }
                }


            }


        }

        return depth;
    }


    private static class Point {
        int x;
        int y;
        int depth;
        int count;

        public Point(int x, int y, int depth, int count) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.count = count;
        }
    }

}
