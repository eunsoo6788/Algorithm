package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2206Re {

    /**
     * 벽 부수고 이동하기 2206
     * 골드3
     * 알고리즘 : bfs
     * Not Sol
     */

    private static int min = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[][] visited;
    private static int ySize;
    private static int xSize;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        map = new int[ySize][xSize];
        visited = new boolean[ySize][xSize];


        for (int y = 0; y < ySize; y++) {
            String str = br.readLine();
            for (int x = 0; x < xSize; x++) {
                map[y][x] = str.charAt(x) - '0';
            }
        }

        bfs();


    }

    private static void bfs() {

        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{0, 0, 1, 0}); // x, y, depth, 벽 부순 여부
        visited[0][0] = true;


        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};


        while (!pq.isEmpty()) {

            int[] now = pq.poll();

            if (now[0] == xSize - 1 && now[1] == ySize - 1) {

                System.out.println(now[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || ny >= ySize || nx >= xSize) {
                    continue;
                }

                if (!visited[ny][nx]) {
                    if (now[3] == 0) {

                        if (map[ny][nx] == 0) {
                            pq.offer(new int[]{nx, ny, now[2] + 1, now[3]});
                            visited[ny][nx] = true;

                        } else {
                            pq.offer(new int[]{nx, ny, now[2] + 1, 1});
                            visited[ny][nx] = true;
                        }


                    } else {
                        if (map[ny][nx] == 0) {
                            visited[ny][nx] = true;
                            pq.offer(new int[]{nx, ny, now[2] + 1, now[3]});
                        }
                    }

                }


            }


        }

        System.out.println(-1);


    }

}
