package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1245 {

    /**
     * https://www.acmicpc.net/problem/1245
     * 골드5
     * 알고리즘 : dfs
     * Not Sol
     */


    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    private static int[][] map;
    private static boolean[][] visited;

    private static int xSize;
    private static int ySize;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        map = new int[ySize][xSize];
        visited = new boolean[ySize][xSize];

        for (int y = 0 ; y < ySize ; y++) {
            StringTokenizer arrSt = new StringTokenizer(br.readLine(), " ");
            for (int x = 0 ; x < xSize ; x++) {
                map[y][x] = Integer.parseInt(arrSt.nextToken());
            }
        }

        int count = 0;

        for (int y = 0 ; y < ySize ; y++) {
            for (int x = 0 ; x < xSize ; x++) {

                if (!visited[y][x] && map[y][x] != 0) {

                    visited[y][x] = true;

                    dfs(y,x);
                    count++;

                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int y, int x) {

        for (int i = 0 ; i < 4 ; i++) {

            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx>=0 && ny>=0 && nx < xSize && ny < ySize) {

                if (map[ny][nx] != 0 && !visited[ny][nx]){

                    visited[ny][nx] = true;
                    dfs(ny,nx);
                }

            }


        }


    }


}
