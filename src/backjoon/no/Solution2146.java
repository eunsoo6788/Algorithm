package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2146 {

    /**
     * 다리 만들기
     * 골드 3
     */

    private static int num;
    private static int[][] map;
    private static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        num = Integer.parseInt(st.nextToken());
        map = new int[num][num];
        visited = new boolean[num][num];

        for (int y = 0; y < num; y++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < num; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int number = 0;
        for (int y = 0; y < num; y++) {
            for (int x = 0; x < num; x++) {
                if (!visited[y][x] && map[y][x] == 1) {
                    number++;
                    numbering(x,y,number);
                }
            }
        }


        int min = Integer.MAX_VALUE;
        for (int y = 0; y < num; y++) {
            for (int x = 0; x < num; x++) {
                if (map[y][x] >= 1) {
                    visited = new boolean[num][num];
                    int count = count(x,y,map[y][x]);
                    min = Math.min(min, count);
                }
            }
        }

        System.out.println(min);

    }


    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static void numbering(int x, int y, int number) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0, 0));
        map[y][x] = number;
        visited[y][x] = true;

        int depth = 0;
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= num || ny < 0 || ny >= num) {
                    continue;
                }

                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    map[ny][nx] = number;
                    queue.add(new Point(nx, ny, depth + 1, number));
                }
            }

        }
    }




    private static int count(int x, int y, int number) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0, number));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (map[now.y][now.x] != number && map[now.y][now.x] != 0) {
                return now.depth - 1; // 바다 칸 수만 계산해야 하므로 -1
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= num || ny < 0 || ny >= num) continue;

                if (map[ny][nx] == number) continue;

                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new Point(nx, ny, now.depth + 1, number));
                }
            }
        }
        return Integer.MAX_VALUE; // 도달 실패시 큰 값
    }


    private static class Point {
        int x;
        int y;
        int depth;
        int num;

        public Point(int x, int y, int depth, int num) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.num = num;
        }
    }

}
