package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4963 {

    /**
     * https://www.acmicpc.net/problem/4963
     * 실버
     * 알고리즘 : dfs bfs
     * Sol
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int xSize = Integer.parseInt(st.nextToken());
            int ySize = Integer.parseInt(st.nextToken());

            if (xSize == 0 && ySize ==0) {
                break;
            }


            int[][] map = new int[ySize][xSize];
            boolean[][] visited = new boolean[ySize][xSize];

            for (int y = 0; y < ySize; y++) {
                StringTokenizer arrSt = new StringTokenizer(br.readLine(), " ");
                for (int x = 0; x < xSize; x++) {
                    map[y][x] = Integer.parseInt(arrSt.nextToken());
                }
            }


            int count = 0;
            for (int y = 0; y < ySize; y++) {
                for (int x = 0; x < xSize; x++) {

                    if (!visited[y][x] && map[y][x] == 1) {
                        //dfs
                        dfs(map,visited, x,y);
                        count++;
                    }

                }
            }

            System.out.println(count);

        }

    }


    private static void dfs(int[][] arr, boolean[][] visited, int x, int y) {

        for (int i = 0; i < 8; i++) {

            int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
            int[] dy = {-1, 1, 0, 0, 1, -1, -1, 1};

            int nx = x + dx[i];
            int ny = y + dy[i];


            if (nx >= 0 && ny >= 0 && nx < arr[0].length && ny < arr.length) {

                if (!visited[ny][nx] && arr[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    dfs(arr,visited, nx, ny);
                }

            }


        }

    }


}
