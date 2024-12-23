package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2178 {

    /**
     * 미로탐색 2178
     * 알고리즘 : bfs
     * 실버1
     * Not Sol
     */


    private static int[][] map;
    private static int count;
    private static boolean[][] visited;

    private static int ySize;
    private static int xSize;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());
        count = 0;

        map = new int[ySize][xSize];
        visited = new boolean[ySize][xSize];


        for (int y = 0 ; y< ySize ; y++) {
            String str = br.readLine();
            for (int x = 0 ; x < xSize ; x++) {
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

            int[] poll = queue.poll();

            if (poll[0] == xSize -1 && poll[1] == ySize -1) {
                count = poll[2];
                return;
            }

            for (int i = 0 ; i < 4 ; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < xSize && ny < ySize ){
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.add(new int[] {nx,ny,poll[2]+1});
                    }
                }


            }


        }



    }


}
