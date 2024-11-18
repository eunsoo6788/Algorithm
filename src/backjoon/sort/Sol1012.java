package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol1012 {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            int[][] arr = new int[y][x];

            for (int j = 0; j < count; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                arr[b][a] = 1;
            }

            boolean[][] visited = new boolean[y][x];
            int result = 0;

            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (arr[j][k] == 1 && !visited[j][k]) {
                        dfs(k, j, visited, arr);
                        result++;
                    }
                }
            }

            System.out.println(result);

        }

    }

    private static void dfs(int x, int y, boolean[][] visited, int[][] arr) {

        visited[y][x] = true;


        for (int i = 0 ; i < 4 ; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < arr[0].length && nextY < arr.length) {
                if (arr[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    dfs(nextX, nextY, visited, arr);
                }
            }
        }




    }




}
