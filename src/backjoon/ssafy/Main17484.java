package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main17484 {

    private static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] map = new int[y][x];

        for (int i = 0; i < y; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }


        for (int i = 0 ; i < x ; i++) {
            dfs(map, 0, i, 0, 3);
        }

        System.out.println(max);

    }

    private static void dfs(int[][] map, int y, int x, int num, int point) {

        if (y == map.length) {
            max = Math.min(max, num);
            return;
        }


        if (x < 0 || x >= map[0].length) {
            return;
        }

        if (point == -1 ) {

            for (int i =0 ; i < 2 ; i++) {
                if (i == 0) {
                    dfs(map, y+1, x, num + map[y][x], 0);
                } else {
                    dfs(map, y+1, x+1, num + map[y][x], 1);
                }

            }
        }

        if (point == 0 ) {

            for (int i =0 ; i < 2 ; i++) {
                if (i == 0) {
                    dfs(map, y+1, x-1, num + map[y][x], -1);
                } else {
                    dfs(map, y+1, x+1, num + map[y][x], 1);
                }

            }
        }


        if (point == 1) {

            for (int i =0 ; i < 2 ; i++) {
                if (i == 0) {
                    dfs(map, y+1, x-1, num + map[y][x], -1);
                } else {
                    dfs(map, y+1, x, num + map[y][x], 0);
                }

            }
        }

        if (point == 3) {
            for (int i =0 ; i < 3 ; i++) {
                if (i == 0) {
                    dfs(map, y+1, x-1, num + map[y][x], -1);
                } else if (i == 1) {
                    dfs(map, y+1, x, num + map[y][x], 0);
                } else {
                    dfs(map, y+1, x+1, num + map[y][x], 1);
                }

            }
        }


    }

}
