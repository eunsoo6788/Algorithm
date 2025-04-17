package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution23352 {

    /**
     * 방탈출
     * 골드5
     * 너비우선탐색 / bfs
     */




    private static int[][] arr;
    private static boolean[][] visited;
    private static int yNum;
    private static int xNum;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        yNum = Integer.parseInt(st.nextToken());
        xNum = Integer.parseInt(st.nextToken());

        arr = new int[yNum][xNum];
        visited = new boolean[yNum][xNum];

        for (int i = 0; i < yNum; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < xNum; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < yNum; i++) {
            for (int j = 0; j < xNum; j++) {
                if (!visited[i][j] && arr[i][j] == 0) {
                     dfs(i, j);
                     count++;
                }
            }
        }


        System.out.println(count);


    }



    private static void dfs (int y, int x) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[y][x] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};



        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int nowX = cur[0];
            int nowY = cur[1];

            for (int k = 0; k < 4; k++) {

                int nx = nowX + dx[k];
                int ny = nowY + dy[k];

                if (nx == xNum) {
                    nx = 0;
                } else if (ny == yNum) {
                    ny = 0;
                }

                if (nx == -1 ) {
                    nx = xNum -1;
                } else if (ny == -1) {
                    ny = yNum -1;
                }

                if (!visited[ny][nx] && arr[ny][nx] == 0) {
                    q.add(new int[]{nx, ny});
                    visited[ny][nx] = true;
                }




            }


        }






    }




}
