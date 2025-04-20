
package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution19940 {

    /**
     * 피자 오븐
     * 골드5
     * 알고리즘 : bfs
     * Not Sol
     */

    private static int num;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int t = 0; t < test; t++) {

            num = Integer.parseInt(br.readLine());

            int count = 0;

            while (num >= 60 ) {
                num -= 60;
                count++;
            }


            visited = new boolean[num + 61];

            bfs(count);


        }


    }

    private static void bfs(int count) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, count, 0, 0, 0, 0}); // now, 60, 10, -10, 1, -1
        visited[0] = true;

        while (!q.isEmpty()) {

            int[] now = q.poll();

            if (now[0] == num) {
                System.out.println(now[1] + " " + now[2] + " " + now[3] + " " + now[4] + " " + now[5]);
                break;
            }


            if (now[0] - 1 <= num + 60 && now[0] - 1 >= 0) {
                if (!visited[now[0] - 1]) {
                    q.add(new int[]{now[0] - 1, now[1], now[2], now[3], now[4], now[5] + 1});
                    visited[now[0]- 1] = true;
                }

            }


            if (now[0] + 1 <= num + 60 && now[0] +1 >= 0) {
                if (!visited[now[0] + 1]) {
                    q.add(new int[]{now[0] + 1, now[1], now[2], now[3], now[4] + 1, now[5]});
                    visited[now[0]+ 1] = true;
                }

            }

            //

            if (now[0] - 10 <= num + 60 && now[0]- 10 >= 0) {
                if (!visited[now[0] - 10]) {
                    q.add(new int[]{now[0] - 10, now[1], now[2], now[3] + 1, now[4], now[5]});
                    visited[now[0]- 10] = true;
                }

            }

            if (now[0] + 10 <= num + 60 && now[0] + 10 >= 0) {
                if (!visited[now[0] + 10]) {
                    q.add(new int[]{now[0] + 10, now[1], now[2] + 1, now[3], now[4], now[5]});
                    visited[now[0]+ 10] = true;
                }

            }

            if (now[0] + 60 <= num + 60 && now[0] + 60 >= 0) {
                if (!visited[now[0] + 60]) {
                    q.add(new int[]{now[0] + 60, now[1] + 1, now[2], now[3], now[4], now[5]});
                    visited[now[0]+ 60] = true;
                }
            }

        }

    }

}
