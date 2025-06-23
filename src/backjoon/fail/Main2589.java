package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2589 {

    /**
     * 보물섬
     * 골드5
     */


    private static List<Integer>[] list;
    private static boolean[][] visited;
    private static char[][] arr;
    private static int max = 0;
    private static int xSize;
    private static int ySize;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        arr = new char[ySize][xSize];

        for (int i = 0; i < ySize; i++) {
            String str = br.readLine();
            for (int j = 0; j < xSize; j++) {
                arr[i][j] = str.charAt(j);
            }
        }


        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (arr[i][j] == 'L') {
                    visited = new boolean[ySize][xSize];
                    bfs(i, j);
                }
            }
        }


        System.out.println(max);


    }


    private static void bfs(int y, int x) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x,0});
        visited[y][x] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            max = Math.max(max, now[2]);

            for (int i = 0; i < 4; i++) {
                int nx = now[1] + dx[i];
                int ny = now[0] + dy[i];

                if (nx >= 0 && ny >=0 && nx < xSize && ny < ySize) {
                    if (!visited[ny][nx] && arr[ny][nx] == 'L') {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx, now[2]+1});
                    }

                }

            }

        }





    }




}
