package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main22116 {

    /**
     * 창영이와 퇴근
     * 골드4
     */

    private static boolean[][] visited;
    private static int[][] map;
    private static int num;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        visited = new boolean[num][num];
        map = new int[num][num];

        for (int y = 0; y < num; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < num; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

    }


    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static void bfs() {

        Queue<Point> queue = new PriorityQueue<Point>(Comparator.comparingInt(p -> p.cost));
        queue.add(new Point(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {

            Point now = queue.poll();

            if (now.x == num-1 && now.y == num-1) {
                System.out.println(now.cost);
                break;
            }


            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= num || ny < 0 || ny >= num) {
                    continue;
                }

                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    int abs = map[ny][nx] - map[now.y][now.x];

                    if (abs > 0 && now.cost < abs) {
                        queue.add(new Point(nx, ny, abs));
                    } else {
                        queue.add(new Point(nx, ny, now.cost));
                    }
                }
            }

        }


    }

    private static class Point {
        int x;
        int y;
        int cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }


}
