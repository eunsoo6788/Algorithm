
package backjoon.problemset.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution14502 {

    /**
     * 연구소
     * 백트래킹, bfs
     * 골드4
     * 문제집 : 삼성 소프트웨어 기출
     */

    private static int max;
    private static int ySize;
    private static int xSize;
    private static int[][] arr;
    private static int[][] tmp;
    private static boolean[][] visited;
    private static List<int[]> birusList = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());
        max = 0;

        arr = new int[ySize][xSize];

        for (int i = 0; i < ySize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < xSize; j++) {

                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 2) {
                    birusList.add(new int[]{j, i});
                }
            }
        }

        backtracking(0);

        System.out.println(max);


    }


    private static void backtracking(int depth) {

        if (depth == 3) {
            visited = new boolean[ySize][xSize];
            tmp = new int[ySize][xSize];

            for (int i = 0; i < ySize; i++) {
                for (int j = 0; j < xSize; j++) {
                    tmp[i][j] = arr[i][j];
                }
            }

            bfs();

            int num = 0;

            for (int i = 0; i < ySize; i++) {
                for (int j = 0; j < xSize; j++) {
                    if (tmp[i][j] == 0) {
                        num++;
                    }
                }
            }


            max = Math.max(num, max);

            return;
        }

        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {

                if (arr[i][j] == 0) {

                    arr[i][j] = 1;
                    backtracking(depth + 1);
                    arr[i][j] = 0;

                }
            }
        }


    }


    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < birusList.size(); i++) {
            int[] birus = birusList.get(i);
            queue.add(birus);
            visited[birus[1]][birus[0]] = true;
        }


        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < xSize && ny < ySize) {
                    if (!visited[ny][nx] && tmp[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        tmp[ny][nx] = 2;
                        queue.add(new int[]{nx, ny});
                    }
                }


            }


        }


    }

}
