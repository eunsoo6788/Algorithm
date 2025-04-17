package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution17141 {

    /**
     * 연구소2
     * 골드4
     * bfs , 백트래킹
     */


    private static int[][] arr;
    private static boolean[][] visited;
    private static int num;
    private static int size;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        arr = new int[num][num];


        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        backtrack(0);

        System.out.println(min);



    }

    private static int min = Integer.MAX_VALUE;
    private static int max;

    private static void backtrack(int depth) {


        if (depth == size) {
            visited = new boolean[num][num];
            max = 0;
            bfs();
            min = Math.min(min, max);

            return;
        }


        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {

                if (arr[i][j] == 2) {
                    arr[i][j] = 0;
                    backtrack(depth + 1);
                    arr[i][j] = 2;
                }

            }
        }
    }


    private static void bfs() {

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (arr[i][j] == 2) {
                    q.add(new int[]{j, i, 0});
                    visited[i][j] = true;
                }
            }
        }


        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};


        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int nowX = cur[0];
            int nowY = cur[1];
            int depth = cur[2];

            max = Math.max(max, depth);


            for (int k = 0; k < 4; k++) {

                int nx = nowX + dx[k];
                int ny = nowY + dy[k];

                if (nx < 0 || ny < 0 || nx >= num || ny >= num) {
                    continue;
                }

                if (!visited[ny][nx] && arr[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    q.add(new int[]{nx, ny, depth + 1});
                }


            }


        }


    }


}
