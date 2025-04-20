package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution15558 {

    /**
     * 점프 게임
     * 골드5
     * 알고리즘 : bfs
     * Not Sol
     */

    private static int[][] arr;
    private static boolean[][] visited;
    private static int num;
    private static int jump;
    private static boolean flag = false;
    private static int answer = 0;




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        num = Integer.parseInt(st.nextToken());
        jump = Integer.parseInt(st.nextToken());

        arr = new int[2][num];
        visited = new boolean[2][num];

        for (int i = 0; i < 2; i++) {
            String str = br.readLine();
            for (int j = 0; j < num; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }





    private static void bfs() {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {

            int[] now = q.poll();

            int y = now[0];
            int x = now[1];
            int depth = now[2];


            if (x + 1 >= num || x+jump >= num) {

                flag = true;
                answer = depth;
                break;
            }


            int nx = 0;
            int ny = 0;


            // 1단계
            nx = x + 1;
            ny = y;

            if (nx >= 0 && ny >= 0 && nx < num && ny < num && !visited[ny][nx]) {

                if (arr[ny][nx] == 1 && nx > depth) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, depth + 1});
                }
            }

            // 2단계
            nx = x - 1;
            ny = y;
            if (nx >= 0 && ny >= 0 && nx < num && ny < num && !visited[ny][nx]) {
                if (arr[ny][nx] == 1 && nx > depth ) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, depth + 1});
                }
            }

            // 3단계
            nx = x + jump;
            ny = y == 0? 1 : 0;
            if (nx >= 0 && ny >= 0 && nx < num && ny < num && !visited[ny][nx]) {
                if (arr[ny][nx] == 1 && nx > depth) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, depth + 1});
                }
            }


        }



    }



}
