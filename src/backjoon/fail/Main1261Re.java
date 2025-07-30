package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1261Re {

    /**
     * 알고스팟
     * 골드4
     */

    private static boolean[][] visited;
    private static int[][] map;
    private static int xSize;
    private static int ySize;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        xSize = Integer.parseInt(st.nextToken());
        ySize = Integer.parseInt(st.nextToken());

        visited = new boolean[ySize][xSize];
        map = new int[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            String str = br.readLine();
            for (int x = 0; x < xSize; x++) {
                map[y][x] = str.charAt(x) - '0';
            }
        }

        bfs();

    }


    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static void bfs() {

        Queue<Point> queue = new PriorityQueue<Point>(Comparator.comparingInt(p -> p.count));
        queue.add(new Point(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == xSize - 1 && now.y == ySize - 1) {
                System.out.println(now.count);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];


                if (nx >= 0 && nx < xSize && ny >= 0 && ny < ySize) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        if (map[ny][nx] == 1) {
                            queue.add(new Point(nx, ny, now.count + 1));
                        } else {
                            queue.add(new Point(nx, ny, now.count));
                        }
                    }
                }
            }

        }


    }

    private static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }


}
