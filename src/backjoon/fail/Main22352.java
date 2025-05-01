package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main22352 {

    /**
     * 항체인식
     * 골드5
     */

    private static int xSize;
    private static int ySize;
    private static int[][] arr;
    private static int[][] arr2;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());


        arr = new int[ySize][xSize];

        for (int i = 0; i < ySize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < xSize; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        arr2 = new int[ySize][xSize];

        for (int i = 0; i < ySize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < xSize; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        boolean stop = false;
        visited = new boolean[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (arr[i][j] != arr2[i][j]) {
                    stop = true;
                    visited[i][j] = true;
                    bfs(arr[i][j], arr2[i][j], j, i);
                    break;
                }
            }
            if (stop) {
                break;
            }
        }

        boolean flag = true;
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (arr[i][j] != arr2[i][j] && !visited[i][j]) {
                    flag = false;
                }
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


    private static void bfs(int value, int value2, int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[] {x,y});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] now = q.poll();


            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < xSize && ny >= 0 && ny < ySize) {
                    if (!visited[ny][nx] && arr2[ny][nx] != arr[ny][nx] && arr[ny][nx] == value && arr2[ny][nx] == value2) {
                        visited[ny][nx] = true;
                        q.add(new int[] {nx, ny});
                    }
                }


            }


        }

    }



}
