package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution10026 {

    /**
     * 적록색약 10026
     * 골드5
     * 알고리즘 : dfs
     * Not Sol
     */


    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    private static char[][] map;
    private static boolean[][] visited;

    private static int size;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        size = Integer.parseInt(br.readLine());
        map = new char[size][size];

        for (int y = 0; y < size; y++) {
            String str = br.readLine();
            for (int x = 0; x < size; x++) {
                map[y][x] = str.charAt(x);
            }
        }

        int count = 0;
        visited = new boolean[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {

                if (!visited[y][x]) {
                    visited[y][x] = true;
                    distinctColor(x,y,map[y][x], map[y][x]);
                    count++;
                }

            }
        }

        int count1 = 0;
        visited = new boolean[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {

                if (!visited[y][x]) {
                    visited[y][x] = true;

                    if (map[y][x] == 'B') {
                        distinctColor(x,y,'B', 'B');
                    } else {
                        distinctColor(x,y,'G', 'R');
                    }

                    count1++;
                }

            }
        }

        System.out.println(count + " " + count1);


    }

    private static void distinctColor(int x, int y, char color, char color1) {

        for (int i = 0 ; i < 4 ; i++) {
            int nx = x +dx[i];
            int ny = y +dy[i];

            if (nx >= 0 && ny >= 0 && nx < size && ny <size) {
                if (!visited[ny][nx] && (map[ny][nx] == color || map[ny][nx] == color1)) {
                    visited[ny][nx] = true;
                    distinctColor(nx,ny, color, color1);
                }
            }

        }



    }


}
