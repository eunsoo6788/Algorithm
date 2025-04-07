package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main2665 {

    /**
     * 미로만들기
     * 골드 4
     * 다익스트라
     */


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][num];


        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            for (int j = 0; j < num; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[num][num];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.add(new int[]{0, 0, 0}); //x,y,벽
        visited[0][0] = true;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};



        while (!pq.isEmpty()) {

            int[] now = pq.poll();

            if (now[0] == num -1 && now[1] == num -1) {
                System.out.println(now[2]);
                break;
            }


            for (int i = 0; i < 4; i++) {

                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < num && ny < num) {

                    if (!visited[ny][nx] && arr[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        pq.add(new int[] {nx,ny,now[2] + 1});

                    } else if (!visited[ny][nx] && arr[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        pq.add(new int[] {nx,ny,now[2]});
                    }
                }
            }
        }


    }


}
