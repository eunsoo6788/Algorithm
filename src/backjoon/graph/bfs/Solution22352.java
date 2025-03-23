package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution22352 {

    /**
     * 항체인식 22352
     * 골드5
     * 알고리즘 : dfs
     * Not Sol
     */


    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    private static int[][] originMap;
    private static int[][] answerMap;
    private static boolean[][] visited;
    private static boolean[][] visitedMap;

    private static int ysize;
    private static int xsize;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        ysize = Integer.parseInt(st.nextToken());
        xsize = Integer.parseInt(st.nextToken());

        originMap = new int[ysize][xsize];
        answerMap = new int[ysize][xsize];

        for (int y = 0 ; y < ysize ; y++) {
            StringTokenizer originSt = new StringTokenizer(br.readLine(), " ");

            for (int x = 0 ; x < xsize ; x++) {
                originMap[y][x] = Integer.parseInt(originSt.nextToken());
            }
        }
        for (int y = 0 ; y < ysize ; y++) {
            StringTokenizer originSt = new StringTokenizer(br.readLine(), " ");

            for (int x = 0 ; x < xsize ; x++) {
                answerMap[y][x] = Integer.parseInt(originSt.nextToken());
            }
        }


        visited = new boolean[ysize][xsize];

        for (int y = 0 ; y < ysize ; y++) {
            for (int x = 0 ; x < xsize ; x++) {

                if (!visited[y][x]) {
                    visited[y][x] = true;
                    visitedMap = new boolean[ysize][xsize];
                    visitedMap[y][x] = true;

                    dfs(x,y,originMap[y][x]);

                    if (check()) {
                        System.out.println("YES");
                        return;
                    }

                }
            }
        }

        System.out.println("NO");
    }

    private static boolean check() {

        for (int y = 0 ; y < ysize ; y++) {
            for (int x = 0 ; x < xsize ; x++) {

                if (originMap[y][x] != answerMap[y][x]) {

                    if (!visitedMap[y][x]) {
                        return false;
                    }

                }
            }
        }

        return true;
    }


    private static void dfs(int x, int y, int value) {

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];


            if (nx >= 0 && ny >= 0 && ny < ysize && nx < xsize) {

                if (!visited[ny][nx] && originMap[ny][nx] == value) {
                    visited[ny][nx] = true;
                    visitedMap[ny][nx] = true;

                    dfs(nx, ny, value);
                }

            }


        }

    }
}
