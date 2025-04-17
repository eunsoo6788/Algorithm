package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution16509 {

    /**
     * 공주님을 구해라!
     * 골드5
     * 너비우선탐색 / bfs
     * Sol
     */

    private static boolean[][] visited;

    private static int attackY;
    private static int attackX;
    private static int kingX;
    private static int kingY;
    private static int time;
    private static boolean find;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        attackY = Integer.parseInt(st.nextToken());
        attackX = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        kingY = Integer.parseInt(st.nextToken());
        kingX = Integer.parseInt(st.nextToken());


        visited = new boolean[10][9];
        find = false;

        bfs();
        System.out.println(find ? time : -1);


    }


    private static void bfs() {

        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{attackX, attackY, 0});
        visited[attackY][attackX] = true;

        int[][] dx = {{-1, -2, -3}, {0, -1, -2}, {0, 1, 2}, {1, 2, 3}, {1, 2, 3}, {0, 1, 2}, {0, -1, -2}, {-1, -2, -3}};
        int[][] dy = {{0, -1, -2}, {-1, -2, -3}, {-1, -2, -3}, {0, -1, -2}, {0, 1, 2}, {1, 2, 3}, {1, 2, 3}, {0, 1, 2}};


        while (!pq.isEmpty()) {

            int[] now = pq.poll();

            if (now[0] == kingX && now[1] == kingY) {
                time = now[2];
                find = true;
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i][2];
                int ny = now[1] + dy[i][2];

                if (nx < 0 || nx >= 9 || ny < 0 || ny >= 9) {
                    continue;
                }

                boolean flag = false;
                for (int j = 0 ; j < 2 ; j++) {
                    int kx = now[0] + dx[i][j];
                    int ky = now[1] + dy[i][j];

                    if (j == 0) {
                        if (!check(now[0], now[1], kx, ky)) {
                            flag = true;
                            break;
                        }
                    } else if (j == 1) {
                        if (!check(now[0] + dx[i][0], now[1] + dy[i][0], kx, ky)){
                            flag = true;
                            break;
                        }
                    }

                    if (kx == kingX && ky == kingY) {
                        flag = true;
                        break;
                    }

                }

                if (flag) {
                    continue;
                }

                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    pq.offer(new int[]{nx, ny, now[2] + 1});
                }

            }


        }


    }


    private static boolean check(int x, int y, int nx , int ny) {
       if (x == 3 && y == 1 && nx == 4 && ny == 0  ) {
           return false;
       }

       if (x == 5 && y == 1 && nx == 4 && ny == 0  ) {
           return false;
       }

       if (x == 3 && y == 1 && nx == 4 && ny == 2  ) {
           return false;
       }

        if (x == 4 && y == 2 && nx == 3 && ny == 1  ) {
            return false;
        }

        if (x == 5 && y == 1 && nx == 4 && ny == 2  ) {
            return false;
        }

        if (x == 4 && y == 2 && nx == 5 && ny == 1  ) {
            return false;
        }

        //


        if (x == 3 && y == 8 && nx == 4 && ny == 9  ) {
            return false;
        }

        if (x == 5 && y == 8 && nx == 4 && ny == 9  ) {
            return false;
        }

        if (x == 3 && y == 8 && nx == 4 && ny == 7  ) {
            return false;
        }

        if (x == 4 && y == 7 && nx == 3 && ny == 8  ) {
            return false;
        }

        if (x == 5 && y == 8 && nx == 4 && ny == 7  ) {
            return false;
        }

        if (x == 4 && y == 7 && nx == 5 && ny == 8  ) {
            return false;
        }


        return true;
    }


}
