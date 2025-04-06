package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4485 {

    /**
     * 특정한 최단 경로 1504
     * 골드 4
     * 그래프, 다익스트라
     */




    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        while (true) {

            int num = Integer.parseInt(br.readLine());

            // 종료조건
            if (num == 0) {
                break;
            }

            int[][] arr = new int[num][num];
            boolean[][] visited = new boolean[num][num];

            for (int i = 0; i < num; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < num; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }



            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            pq.add(new int[]{0, 0, arr[0][0]});
            visited[0][0] = true;

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            int min = Integer.MAX_VALUE;

            while (!pq.isEmpty()) {
                int[] now = pq.poll();

                if (now[0] == num-1 && now[1] == num-1) {
                    min = Math.min(min, now[2]);
                }



                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];


                    if (nx < 0 || ny < 0 || nx >= num || ny >= num) {
                        continue;
                    }

                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        pq.add(new int[]{nx, ny, now[2] + arr[nx][ny]});
                    }


                }

            }

            count++;
            System.out.println("Problem "+count+": " + min);



        }




    }







}
