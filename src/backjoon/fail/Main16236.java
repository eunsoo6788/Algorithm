package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main16236 {

    /**
     * 아기상어
     * 골드3
     */


    private static int sharkSize;
    private static int nowSharkCount;
    private static int sum;
    private static boolean flag;


    private static int num;
    private static int nowX;
    private static int nowY;
    private static int[][] arr;
    private static boolean[][] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        sharkSize = 2;
        nowSharkCount = 0;
        sum = 0;

        arr = new int[num][num];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        nowX = -1;
        nowY = -1;

        int time = 0;
        while (true) {

            if (time == 0) {
                for (int i = 0; i < num; i++) {
                    for (int j = 0; j < num; j++) {
                        if (arr[i][j] == 9) {
                            nowY = i;
                            nowX = j;
                            break;
                        }
                    }

                    if (nowX != -1 && nowY != -1) {
                        break;
                    }
                }
            }


            visited = new boolean[num][num];
            flag = false;
            bfs(nowX, nowY);

            if (!flag) {
                break;
            }

        }

        System.out.println(sum);



    }

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] == o2[2]) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
            return o1[2] - o2[2];
        });

        queue.add(new int[]{x, y, 0});
        visited[y][x] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (arr[now[1]][now[0]] < sharkSize && arr[now[1]][now[0]] > 0) {
                nowSharkCount++;
                sum += now[2];
                arr[now[1]][now[0]] = 0;

                if (nowSharkCount == sharkSize) {
                    nowSharkCount = 0;
                    sharkSize++;
                }

                nowX = now[0];
                nowY = now[1];

                flag = true;

                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < num && ny < num) {

                    if (!visited[ny][nx] && arr[ny][nx] <= sharkSize) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny, now[2] + 1});
                    }

                }


            }


        }


    }


}
