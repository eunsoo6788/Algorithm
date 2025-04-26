
package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution28471Re {

    /**
     * W키가 빠진 성원이
     * 골드5
     * 알고리즘 : bfs
     * Not Sol
     */

    private static int max = 0;
    private static int num;
    private static boolean[][] visited;
    private static char[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        arr = new char[num][num];

        for (int i = 0; i < num; i++) {
            String s = br.readLine();
            for (int j = 0; j < num; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        visited = new boolean[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (arr[i][j] == 'F') {
                    bfs(j, i);
                }
            }
        }

        System.out.println(max);

    }


    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        visited[y][x] = true;

        int[] dx = {-1, 1, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, -1, 1, 1, -1};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();



            for (int i = 0; i < 7; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= num || ny >= num) {
                    continue;
                }

                if (!visited[ny][nx] && arr[ny][nx] == '.') {
                    visited[ny][nx] = true;
                    max++;
                    queue.offer(new int[]{nx, ny, now[2] + 1});
                }

            }

        }

    }

}
