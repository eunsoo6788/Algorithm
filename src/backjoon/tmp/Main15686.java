package backjoon.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main15686 {

    /**
     * 치킨배달
     * bfs, 백트래킹
     * 골드5
     * not sol
     */

    private static int min;
    private static int num;
    private static int size;
    private static boolean[][] visited;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        num = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());
        arr = new int[num][num];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        backChannel(0);


        System.out.println(min);




    }

    private static void backChannel(int depth) {

        if (depth == size) {

            visited = new boolean[num][num];

            int distance = bfs();

            min = Math.min(min, distance);

            return;
        }


        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (arr[i][j] == 2) {
                    arr[i][j] = 3;
                    backChannel(depth+1);
                    arr[i][j] = 2;
                }
            }
        }



    }

    private static int bfs() {


        Queue<int[]> queue = new LinkedList<>();


        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (arr[i][j] == 3) {
                    queue.add(new int[]{i, j,0});
                    visited[i][j] = true;
                }
            }
        }


        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int distance = 0;


        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (arr[now[0]][now[1]] == 1) {
                distance += now[2];
            }


            for (int i = 0; i < 4; i++) {
                int nx = now[1] + dx[i];
                int ny = now[0] + dy[i];

                if (nx < 0 || ny < 0 || nx >= num || ny >= num) {
                    continue;
                }

                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx, now[2]+1});
                }

            }


        }

        return distance;

    }

}
