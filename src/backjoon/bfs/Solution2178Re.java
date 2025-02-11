package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2178Re {

    /**
     * 미로탐색 2178
     * 알고리즘 : bfs
     * 실버1
     * Not Sol
     */

    private static int[][] map;
    private static boolean[][] visited;
    private static int count = 0;
    private static int ySize;
    private static int xSize;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());
        map = new int[ySize][xSize];
        visited = new boolean[ySize][xSize];

        for (int y = 0 ; y < ySize ; y++) {
            String str = br.readLine();
            for (int x = 0 ; x< xSize ; x++) {
                map[y][x] = str.charAt(x) - '0';
            }
        }

        bfs();

        System.out.println(count);


    }

    private static void bfs() {
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;


        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            if (now[0] == xSize-1 && now[1] == ySize-1) {
                count = now[2];
                return;
            }

            for (int i = 0 ; i < 4 ; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >=0 && ny>= 0 && nx < xSize && ny < ySize) {
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx,ny,now[2]+1});
                    }
                }


            }



        }






    }



}
