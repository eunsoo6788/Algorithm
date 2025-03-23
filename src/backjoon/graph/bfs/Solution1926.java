package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1926 {

    private static int maxSize;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());

        map = new int[ySize][xSize];
        visited = new boolean[ySize][xSize];
        for (int y = 0; y < ySize; y++) {
            StringTokenizer mapSt = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < xSize; x++) {
                map[y][x] = Integer.parseInt(mapSt.nextToken());
            }
        }

        int count = 0;
        maxSize = 0;

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (!visited[y][x] && map[y][x] == 1) {
                    int currentSize = dfs(y, x);
                    maxSize = Math.max(maxSize, currentSize);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    private static int dfs(int y, int x) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        visited[y][x] = true;
        int size = 1; // 현재 노드 포함

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < map[0].length && ny < map.length) {
                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    size += dfs(ny, nx);
                }
            }
        }

        return size;
    }
}
