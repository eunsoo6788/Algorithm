package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2206 {

    /**
     * 벽 부수고 이동하기
     * 골드3
     */

    private static int ySize;
    private static int xSize;
    private static int answer = -1;
    private static int[][] arr;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        arr = new int[ySize][xSize];
        visited = new boolean[ySize][xSize][2];

        for (int i = 0; i < ySize; i++) {
            String str = br.readLine();
            for (int j = 0; j < xSize; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(answer);
    }


    private static void bfs() {


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0}); // x,y,depth,break
        visited[0][0][0] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            if (now[0] == xSize - 1 && now[1] == ySize - 1) {
                answer = now[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];


                if (nx >= 0 && nx < xSize && ny >= 0 && ny < ySize ) {

                    if (!visited[ny][nx][0] && now[3] == 0) {
                        visited[ny][nx][0] = true;

                        if (arr[ny][nx] == 1) {
                            queue.add(new int[]{nx, ny, now[2]+1, 1});
                        } else if (arr[ny][nx] == 0) {
                            queue.add(new int[]{nx, ny, now[2]+1, 0});
                        }

                    } else if (!visited[ny][nx][1] && now[3] == 1) {

                        if (arr[ny][nx] == 0) {
                            visited[ny][nx][1] = true;
                            queue.add(new int[]{nx, ny, now[2]+1, 1});
                        }
                    }

                }



            }



        }


    }


}
