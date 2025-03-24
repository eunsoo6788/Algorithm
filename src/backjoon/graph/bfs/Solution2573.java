package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2573 {

    /**
     * 로봇 청소기
     * 골드5
     * 알고리즘 : bfs
     * Not Sol
     */

    private static int[][] map;
    private static boolean[][] visited;
    private static int ySize, xSize;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        map = new int[ySize][xSize];

        for (int i = 0; i < ySize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < xSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {

            year++;

            visited = new boolean[ySize][xSize];

            int count = 0;
            for (int i = 0; i < ySize; i++) {
                for (int j = 0; j < xSize; j++) {
                    if (map[i][j] > 0) {

                        for (int k = 0;k < 4; k++) {
                            int nx = j + dx[k];
                            int ny = i + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < xSize && ny < ySize) {
                                if (!visited[ny][nx] && map[ny][nx] == 0) {

                                    if (map[i][j] > 0) {
                                        map[i][j]--;
                                    }
                                }
                            }

                        }


                        count++;
                        visited[i][j] = true;
                        melt(j,i);
                    }
                }
            }


            if (count > 1) {
                System.out.println(year);
                break;
            }



        }

    }


    private static void melt(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {

            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < xSize && ny < ySize) {
                    if (!visited[ny][nx] && map[ny][nx] == 0) {

                        if (map[y][x] > 0) {
                            map[y][x]--;
                        }
                    }
                }

            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];


                if (nx >= 0 && ny >= 0 && nx < xSize && ny < ySize) {
                    if (map[ny][nx] > 0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.add(new int[]{nx, ny});
                    }
                }

            }


        }

    }

}
