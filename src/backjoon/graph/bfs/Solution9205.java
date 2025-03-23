package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution9205 {

    /**
     * 맥주 마시면서 걸어가기
     * 골드5
     * 알고리즘 : bfs
     * Sol
     */



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < test; test_case++) {

            int num = Integer.parseInt(br.readLine()) + 2;

            int[][] arr = new int[num][2];
            boolean[] visited = new boolean[num];

            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][0] = Integer.parseInt(st.nextToken());
            arr[0][1] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < num-2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[i+1][0] = x;
                arr[i+1][1] = y;
            }
            st = new StringTokenizer(br.readLine());
            arr[num-1][0] = Integer.parseInt(st.nextToken());
            arr[num-1][1] = Integer.parseInt(st.nextToken());


            visited[0] = true;
            visited[num-1] = true;

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{arr[0][0], arr[0][1]});

            boolean success = false;

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                int diff2 = Math.abs(now[0] - arr[num-1][0]) + Math.abs(now[1] - arr[num-1][1]);
                if (diff2 <= 1000) {
                    success = true;
                    break;
                }

                for (int i = 0; i < num-2; i++) {
                    int diff = Math.abs(now[0] - arr[i+1][0]) + Math.abs(now[1] - arr[i+1][1]);
                    if (!visited[i+1] && diff <= 1000) {
                        visited[i+1] = true;
                        queue.offer(new int[]{arr[i+1][0], arr[i+1][1]});
                    }
                }
            }


            if (success) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }


        }


    }

}
