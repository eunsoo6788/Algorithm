package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5558 {

    /**
     * 치즈 (Chese)
     * 골드5
     * 알고리즘 : bfs
     */

    private static char[][] arr;
    private static boolean[][] visited;
    private static int num;
    private static int xSize;
    private static int ySize;
    private static int nowX;
    private static int nowY;
    private static int size;
    private static int lenth;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        size = 1;
        lenth = 0;


        arr = new char[ySize][xSize];

        for (int i = 0; i < ySize; i++) {
            String str = br.readLine();
            for (int j = 0; j < xSize; j++) {
                arr[i][j] = str.charAt(j);
            }
        }



        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (arr[i][j] == 'S') {
                    visited = new boolean[ySize][xSize];
                    nowX = j;
                    nowY = i;
                    bfs();
                }
            }
        }


        for (int i = 1; i <= num; i++) {
            visited = new boolean[ySize][xSize];
            bfs();
        }


        System.out.println(lenth);


    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{nowX, nowY, 0});
        visited[nowY][nowX] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (arr[now[1]][now[0]] - '0' ==  size) {
                lenth += now[2];
                size++;
                nowX = now[0];
                nowY = now[1];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= xSize || ny >= ySize) {
                    continue;
                }

                if (!visited[ny][nx] && arr[ny][nx] != 'X' ) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{nx, ny, now[2]+1});
                }


            }




        }


    }


}
