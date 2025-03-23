package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution14503 {

    /**
     * 로봇 청소기
     * 골드5
     * 알고리즘 : bfs
     * Not Sol
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine(), " ");
        int nowY = Integer.parseInt(st.nextToken());
        int nowX = Integer.parseInt(st.nextToken());
        int round = Integer.parseInt(st.nextToken());

        int[][] map = new int[ySize][xSize];
        boolean[][] visited = new boolean[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < xSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{nowX, nowY, round, 1});
        visited[nowY][nowX] = true;


        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int count = 0;
        boolean flag = false;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            boolean notClean = false;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= ySize || ny >= xSize) {
                    continue;
                }

                if (!visited[ny][nx] && map[ny][nx] == 0) {
                    notClean = true;
                }
            }


            if (notClean) {

                int nowRound = now[2] + 3;
                int nx = 0;
                int ny = 0;

                for (int i = 0; i < 4; i++) {
                    nowRound = (nowRound + 3 + i) % 4;

                    if (nowRound == 0) {
                        nx = now[0];
                        ny = now[1] - 1;
                    } else if (nowRound == 1) {
                        nx = now[0] - 1;
                        ny = now[1];
                    } else if (nowRound == 2) {
                        nx = now[0];
                        ny = now[1] + 1;
                    } else if (nowRound == 3) {
                        nx = now[0] + 1;
                        ny = now[1];
                    }

                    if (nx < 0 || ny < 0 || nx >= ySize || ny >= xSize) {
                        continue;
                    }

                    if (!visited[ny][nx] && map[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny, nowRound, now[3] + 1});
                        break;
                    }

                    count = now[3];
                }




            } else {

                int nx = 0;
                int ny = 0;

                if (now[2] == 0) {
                    nx = now[0];
                    ny = now[1] + 1;
                } else if (now[2] == 1) {
                    nx = now[0] + 1;
                    ny = now[1];
                } else if (now[2] == 2) {
                    nx = now[0];
                    ny = now[1] - 1;
                } else if (now[2] == 3) {
                    nx = now[0] - 1;
                    ny = now[1];
                }

                if (nx < 0 || ny < 0 || nx >= ySize || ny >= xSize) {
                    System.out.println(now[3]);
                    flag = true;
                    break;
                } else if (map[ny][nx] == 1) {
                    System.out.println(now[3]);
                    flag = true;
                    break;
                }

                queue.add(new int[]{nx, ny, now[2], now[3]});
            }


        }


        if (!flag) {
            System.out.println(count);
        }


    }

}
