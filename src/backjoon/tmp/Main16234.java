package backjoon.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16234 {

    /**
     * 인구이동
     * 구현 , bfs
     * 골드4
     * not sol
     */

    private static boolean[][] visited;
    private static boolean[][] check;
    private static int[][] arr;
    private static int num;
    private static int low;
    private static int high;
    private static int value;
    private static int count;
    private static boolean flag;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        num = Integer.parseInt(st.nextToken());
        low = Integer.parseInt(st.nextToken());
        high = Integer.parseInt(st.nextToken());


        arr = new int[num][num];


        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;

        while (true) {

            visited = new boolean[num][num];
            check = new boolean[num][num];

            flag = false;

            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if (!visited[i][j]) {
                        value = 0;
                        count = 0;

                        solve(j,i);

                        if (count > 0) {
                            value /= count;
                            mark(j,i);
                        }


                    }
                }
            }

            if (!flag) {
                break;
            }

            time++;

        }


        System.out.println(time);

    }

    private static void mark(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        check[y][x] = true;
        arr[y][x] = value;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < num && ny < num) {

                    if (!check[ny][nx] && visited[ny][nx]) {
                        check[ny][nx] = true;
                        arr[ny][nx] = value;
                        q.add(new int[]{nx, ny});
                    }
                }


            }
        }
    }


    private static void solve(int x , int y) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[y][x] = true;


        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] now = q.poll();

            value += arr[now[1]][now[0]];
            count++;


            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];


                if (nx >= 0 && ny >= 0 && nx < num && ny < num) {

                    int abs = Math.abs(arr[ny][nx] - arr[now[1]][now[0]]);

                    if (!visited[ny][nx] && abs >= low && abs <= high) {
                        visited[ny][nx] = true;
                        flag = true;
                        q.add(new int[]{nx, ny});
                    }
                }


            }
        }


    }

}
