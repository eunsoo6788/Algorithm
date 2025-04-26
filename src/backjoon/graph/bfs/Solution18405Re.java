package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution18405Re {

    /**
     * 경쟁적 전염
     * 골드5
     * 너비우선탐색 (bfs)
     * Not Sol
     */

    private static int[][] arr;
    private static boolean[][] visited;
    private static int size;
    private static int num;
    private static int time;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());

        arr = new int[size][size];

        for (int i = 0 ; i < size ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < size ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        time = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken())-1;
        int x = Integer.parseInt(st.nextToken())-1;

        visited = new boolean[size][size];
        bfs();

        System.out.println(arr[y][x]);

    }


    private static void bfs() {

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->{

            if (o1[3] == o2[3]) {
                return o1[2] - o2[2];
            }

            return o1[3] - o2[3];
        }
        );

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] != 0) {
                    visited[i][j] = true;
                    pq.offer(new int[]{i, j, arr[i][j], 0}); // y x
                }
            }
        }

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        while (!pq.isEmpty()) {

            int[] now = pq.poll();

            for (int i = 0 ; i < 4 ; i++) {

                int nx = now[1] + dx[i];
                int ny = now[0] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
                    if (arr[ny][nx] == 0 && !visited[ny][nx] && now[3] < time) {

                        visited[ny][nx] = true;
                        arr[ny][nx] = now[2];
                        pq.offer(new int[]{ny, nx, now[2], now[3]+1});
                    }
                }
            }
        }

    }


}
