package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1303 {

    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());

        map = new char[ySize][xSize];
        visited = new boolean[ySize][xSize];
        for (int y = 0; y < ySize; y++) {
            String str = br.readLine();
            for (int x = 0; x < xSize; x++) {
                map[y][x] = str.charAt(x);
            }
        }



        int myScore = 0;
        int enemyScore = 0;

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (!visited[y][x] && map[y][x] == 'W') {
                    int size = dfs(y,x,map[y][x]);
                    myScore += (size * size);
                }

                if (!visited[y][x] && map[y][x] == 'B') {
                    int size = dfs(y,x,map[y][x]);
                    enemyScore += (size * size);
                }
            }
        }


        System.out.println(myScore);
        System.out.println(enemyScore);

    }


    private static  int bfs(int y, int x, char flag) {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x,y});
        visited[y][x] = true;

        int size = 1;


        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            for (int i = 0 ; i < 4; i++) {

                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < map[0].length && ny < map.length) {
                    if (!visited[ny][nx] && map[ny][nx] == flag) {
                        size++;
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx,ny});
                    }
                }

            }

        }

        return size;
    }



    private static int dfs(int y, int x, char flag) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        visited[y][x] = true;
        int size = 1; // 현재 노드 포함

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < map[0].length && ny < map.length) {
                if (!visited[ny][nx] && map[ny][nx] == flag) {
                    size += dfs(ny, nx, flag);
                }
            }
        }

        return size;
    }
}
