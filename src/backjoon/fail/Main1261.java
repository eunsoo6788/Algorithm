package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1261 {

    /**
     * 알고스팟
     * 골드4
     */


    private static int xSize;
    private static int ySize;
    private static int[][] arr;
    private static boolean[][] visited;


    private static int count = 0;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        xSize = Integer.parseInt(st.nextToken());
        ySize = Integer.parseInt(st.nextToken());

        arr = new int[ySize][xSize];
        visited = new boolean[ySize][xSize];

        for (int i = 0; i < ySize; i++) {
            String str = br.readLine();
            for (int j = 0; j < xSize; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0,0);

    }

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        queue.add(new int[]{x, y, 0, 0});
        visited[y][x] = true;

        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();


            if (now[0] == xSize-1 && now[1] == ySize-1) {
                System.out.println(now[2]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < xSize && ny < ySize) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;

                        if (arr[ny][nx] == 1) {
                            queue.add(new int[]{nx, ny, now[2] + 1, 1});
                        } else {
                            queue.add(new int[]{nx, ny, now[2], 1});
                        }

                    }
                }
            }
        }


    }


}
