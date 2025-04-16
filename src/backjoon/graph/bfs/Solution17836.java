package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution17836 {

    /**
     * 공주님을 구해라!
     * 골드5
     * 너비우선탐색 / bfs
     * Sol
     */

    private static int[][] arr;
    private static int[][][] visited;

    private static int ySize;
    private static int xSize;
    private static int limit;
    private static int time;
    private static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());

        time = 0 ;
        flag = false;

        arr = new int[ySize][xSize];
        visited = new int[ySize][xSize][2];

        for (int i = 0; i < ySize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < xSize; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        if (!flag) {
            System.out.println("Fail");

        } else {
            System.out.println(time);
        }

    }


    private static void bfs() {

        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{0, 0, 0, 0});  // x, y,
        visited[0][0][0] = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};


        while (!pq.isEmpty()) {

            int[] now = pq.poll();

            if (now[0] == xSize - 1 && now[1] == ySize - 1 && now[3] <= limit) {
                flag = true;
                time = now[3];
                break;
            }

            if (now[3] > limit) {
                break;
            }

            if (arr[now[1]][now[0]] == 2) {
                now[2] = 1;
                mujuck = true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < xSize && ny < ySize) {


                    if (visited[ny][nx][0] == 0 && now[2] == 0 && arr[ny][nx] != 1) {
                        visited[ny][nx][0] = 1;
                        pq.add(new int[]{nx, ny, now[2], now[3] + 1});
                    } else if (visited[ny][nx][1] == 0 && now[2] == 1 ) {
                        visited[ny][nx][1] = 1;
                        pq.add(new int[]{nx, ny, now[2], now[3] + 1});
                    }


                }


            }


        }


    }


}
