package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution14940 {

    /**
     * 백준 : 쉬운 최단거리 14940
     * 알고리즘 : bfs
     * sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());

        int[][] map = new int[ySize][xSize];
        int[][] arr = new int[ySize][xSize];
        boolean[][] visited = new boolean[ySize][xSize];
        for (int i = 0 ; i < ySize ; i++ ) {
            StringTokenizer mapSt = new StringTokenizer(br.readLine(), " ");

            for (int  x = 0 ; x< xSize ; x++) {
                map[i][x] = Integer.parseInt(mapSt.nextToken());
            }
        }

        for (int y = 0 ; y < ySize ; y++) {
            for (int x = 0 ; x < xSize ; x++) {

                if (map[y][x] == 2) {
                    bfs(y,x,visited,arr,map);
                }
            }
        }


        for (int y = 0 ; y < ySize ; y++) {
            for (int x = 0 ; x < xSize ; x++) {

                if (!visited[y][x] && map[y][x] == 1) {
                    arr[y][x] = -1;
                }

                System.out.print(arr[y][x] + " ");
            }
            System.out.println();
        }


    }

    private static void bfs(int y, int x, boolean[][] visited, int[][] arr, int[][] map) {

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        Queue<int[]> queue = new LinkedList<>();


        queue.add(new int[]{y, x, 0});
        arr[y][x] = 0;

        visited[y][x] = true;

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            for ( int i = 0 ; i < 4 ; i++) {
                int nx = poll[1] + dx[i];
                int ny = poll[0] + dy[i];


                if (nx >= 0 && ny>=0 && nx < map[0].length && ny < map.length){
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        arr[ny][nx] = poll[2] +1;
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny,nx,poll[2]+1});
                    }
                }
            }
        }
    }


}
