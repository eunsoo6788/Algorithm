package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main17141 {

    /**
     * 연구소2
     * 골드5
     */

    private static int n;
    private static int m;
    private static int min;
    private static int[][] arr;
    private static int[][] nowByrus;
    private static boolean[] allByrusVisited;
    private static boolean[][] visited;
    private static List<int[]> allByrus;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        arr = new int[n][n];
        nowByrus = new int[m][2]; //x,y
        allByrus = new ArrayList<int[]>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 2) {
                    allByrus.add(new int[]{j, i});
                }

            }
        }

        min = Integer.MAX_VALUE;
        allByrusVisited = new boolean[allByrus.size()];

        backTracking(0,-1);



        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    private static int bfs() {

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            queue.add(new int[]{nowByrus[i][0], nowByrus[i][1], 0});
            visited[nowByrus[i][1]][nowByrus[i][0]] = true;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int max = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            max = Math.max(max, now[2]);

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {

                    if (!visited[ny][nx] && arr[ny][nx] != 1) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny, now[2] + 1});
                    }

                }

            }


        }

        return max;


    }


    private static boolean isAllVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void backTracking(int depth, int index) {

        if (depth == m) {

            // 바이러스 탐색
            visited = new boolean[n][n];
            int value = bfs();

            if (isAllVisited()) {
                min = Math.min(min, value);
            }

            return;
        }


        for (int i = index + 1; i < allByrus.size(); i++) {

            if (!allByrusVisited[i]) {
                allByrusVisited[i] = true;
                nowByrus[depth][0] = allByrus.get(i)[0];
                nowByrus[depth][1] = allByrus.get(i)[1];
                backTracking(depth+1, i);
                allByrusVisited[i] = false;
            }

        }


    }


}
