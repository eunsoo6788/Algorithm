package backjoon.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16236 {

    /**
     * 아기상어
     * bfs
     * 골드3
     */

    private static int num;
    private static int sharkSize;
    private static int sharkLevel;
    private static boolean feed;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int time;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        arr = new int[num][num];


        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        sharkSize = 2;
        sharkLevel = 2;
        time = 0;

        while (true) {


            feed = false;
            visited = new boolean[num][num];

            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if (arr[i][j] == 9) {
                        bfs(j, i);
                    }
                }
            }


            if (!feed) {
                break;
            }


        }


        System.out.println(time);

    }

    private static void bfs(int x, int y) {

        int min = Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1[2] == o2[2]) {
                        if (o1[1] == o2[1]) {
                            return o1[0] - o2[0];
                        }
                        return o1[1] - o2[1];
                    }
                    return o1[2] - o2[2];
                }
        );
        q.add(new int[]{x, y, 0}); // x, y, dist
        visited[y][x] = true;

        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};


        while (!q.isEmpty()) {
            int[] now = q.poll();


            if (arr[now[1]][now[0]] < sharkSize && arr[now[1]][now[0]] > 0 && arr[now[1]][now[0]] <= 6) {
                pq.add(new int[]{now[1], now[0], now[2]});
                min = Math.min(min, now[2]);
            }

            if (now[2] > min) {
                now = pq.poll();
                time += now[2];
                feed = true;
                sharkLevel--;
                arr[now[1]][now[0]] = 9;
                arr[y][x] = 0;


                if (sharkLevel == 0) {
                    sharkSize++;
                    sharkLevel = sharkSize;
                }
                break;
            }


            for (int i = 0; i < 4; i++) {

                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < num && ny < num) {
                    if (!visited[ny][nx] && arr[ny][nx] <= sharkSize) {
                        visited[ny][nx] = true;
                        q.add(new int[]{nx, ny, now[2] + 1});
                    }
                }


            }

        }


    }

}
