package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2667 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[][] map = new int[size][size];
        boolean[][] visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String str = br.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<int[][]> queue = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    queue.add(new int[][]{{i, j}});
                    bfs(map, visited, i, j, size, queue, 0);
                }
            }
        }


    }

    private static void bfs(int[][] map, boolean[][] visited, int x, int y, int size, Queue<int[][]> queue, int depth) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        visited[x][y] = true;


        while (!queue.isEmpty()) {


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= size || ny >= size) {
                    continue;
                }

                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[][]{{nx, ny}});
                    visited[nx][ny] = true;
                }
            }
        }
    }

}
