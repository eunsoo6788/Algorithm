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

        for (int i = 0; i < yNum; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < xNum; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < yNum; i++) {
            for (int j = 0; j < xNum; j++) {
                if (arr[i][j] != 0) {
                    visited = new boolean[yNum][xNum];

                    int depth = dfs(i, j, arr[i][j]);
                    max = Math.max(max, depth);
                }
            }
        }


        System.out.println(max);


    }


    private static int dfs(int y, int x, int coin) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited[y][x] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};


        int max = 0;
        int value = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int nowX = cur[0];
            int nowY = cur[1];
            int depth = cur[2];

            if (max < depth) {
                max = depth;
                value = coin + arr[nowY][nowX];
            } else if (max == depth) {
                value = Math.max(coin + arr[nowY][nowX], value);
            }

            for (int k = 0; k < 4; k++) {

                int nx = nowX + dx[k];
                int ny = nowY + dy[k];

                if (nx < 0 || ny < 0 || nx >= xNum || ny >= yNum) {
                    continue;
                }

                if (!visited[ny][nx] && arr[ny][nx] != 0) {
                    visited[ny][nx] = true;
                    q.add(new int[]{nx, ny, depth + 1});
                }


            }


        }

        return value;

    }


}
