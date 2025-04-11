package backjoon.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main17144 {

    /**
     * 미세먼지 안녕!
     * 구현
     * 골드4
     * not sol
     */

//    private static boolean[][] visited;
//    private static boolean[][] check;
//    private static int[][] arr;
    private static int xSize;
    private static int ySize;
    private static int target;
//    private static int value;
//    private static int count;
//    private static boolean flag;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());


        int[][] arr = new int[ySize][xSize];

        int[] machine1 = new int[2];
        int[] machine2 = new int[2];

        for (int i = 0; i < ySize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < xSize; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    machine1[0] = j;
                    machine1[1] = i;
                }
            }
        }


        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();

        // 확산 계산하기
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (arr[i][j] > 0) {
                    int count = 0;

                    for (int k = 0; k < 4; k++) {

                        int nx = j + dx[k];
                        int ny = i + dy[k];

                        if (nx >= 0 && ny >= 0 && ny < ySize && nx < xSize) {
                            if (arr[ny][nx] != -1) {
                                count++;
                                q.add(new int[]{nx, ny, arr[i][j] / 5});
                            }
                        }

                        arr[i][j] -= (arr[i][j] / 5) * count;


                    }


                }
            }
        }

        // 확산 완료
        while (!q.isEmpty()) {
            int[] now = q.poll();

            arr[now[1]][now[0]] += now[2];
        }


        // 공기 순환











    }

}
