package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol2667 {

    private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
    private static List<Integer> houseCount = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int apartCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, map, visited);
                    apartCount++;
                }
            }
        }




    }

    private static void dfs(int x, int y, int[][] map, boolean[][] visited) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map.length) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny, map, visited);
                }
            }
        }

    }


}
