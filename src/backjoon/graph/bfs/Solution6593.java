package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution6593 {

    /**
     * 상범 빌딩
     * 골드5
     * 너비우선탐색 (bfs)
     * Not Sol
     */

    private static char[][][] arr;
    private static boolean[][][] visited;
    private static int floor;
    private static int ySize;
    private static int xSize;
    private static boolean find;
    private static int time;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            floor = Integer.parseInt(st.nextToken());
            ySize = Integer.parseInt(st.nextToken());
            xSize = Integer.parseInt(st.nextToken());

            if (floor == 0 && ySize == 0 && xSize == 0) {
                break;
            }

            arr = new char[floor][ySize][xSize];
            visited = new boolean[floor][ySize][xSize];
            find = false;
            time = 0;

            for (int i = 0; i < floor; i++) {
                for (int j = 0; j < ySize; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < xSize; k++) {
                        arr[i][j][k] = str.charAt(k);
                    }
                }
                br.readLine();
            }


            boolean stop = false;

            for (int i = 0; i < floor; i++) {
                for (int j = 0; j < ySize; j++) {
                    for (int k = 0; k < xSize; k++) {
                        if (arr[i][j][k] == 'S' && !visited[i][j][k]) {
                            visited[i][j][k] = true;
                            bfs(i, j, k);
                            stop = true;
                            break;
                        }
                    }

                    if (stop) {
                        break;
                    }
                }
                if (stop) {
                    break;
                }
            }


            if (find) {
                System.out.println("Escaped in " + time + " minute(s).");
            } else {
                System.out.println("Trapped!");

            }


        }

    }


    private static void bfs(int f, int y, int x) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{f, y, x, 0});

        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] df = {0, 0, 0, 0, 1, -1};

        while (!q.isEmpty()) {

            int[] now = q.poll();

            if (arr[now[0]][now[1]][now[2]] == 'E') {
                find = true;
                time = now[3];
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nx = now[2] + dx[i];
                int ny = now[1] + dy[i];
                int nf = now[0] + df[i];

                if (nx >= 0 && nx < xSize && ny >= 0 && ny < ySize && nf >= 0 && nf < floor) {

                    if (!visited[nf][ny][nx] && arr[nf][ny][nx] != '#') {
                        visited[nf][ny][nx] = true;
                        q.add(new int[]{nf, ny, nx, now[3] + 1});
                    }

                }

            }


        }


    }


}
