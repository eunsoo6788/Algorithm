package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution17086 {

    /**
     * https://www.acmicpc.net/problem/17086
     * 실버1
     * 알고리즘 : dfs bfs
     * Not Sol
     */

    private static int distant = Integer.MAX_VALUE ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());

        int[][] map = new int[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < xSize; x++) {
                map[y][x] = Integer.parseInt(st1.nextToken());
            }
        }



        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (map[y][x] == 1) {
                    boolean[][] visited = new boolean[ySize][xSize];
                    bfs(map,visited,y,x);
                }

            }
        }


        System.out.println(distant);


    }


    private static void bfs(int[][] map, boolean[][] visited, int y, int x) {

        int[] dx = {0,0,-1,1,-1,1,-1,1};
        int[] dy = {-1,1,0,0,-1,1,1,-1};


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x,1,0});
        visited[y][x] = true;

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            if (poll[3] == 1) {
                distant = Math.min(distant,poll[2]);
                break;
            }


            for (int i = 0 ; i < 8 ; i++) {

                int nx = poll[1] + dx[i];
                int ny = poll[0] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < map[0].length && ny < map.length) {

                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny,nx,poll[2] + 1, map[ny][nx]});
                    }

                }


            }




        }






    }



}
