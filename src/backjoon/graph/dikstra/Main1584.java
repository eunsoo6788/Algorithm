package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1584 {

    /**
     * 게임
     * 골드5
     * 다익스트라
     */


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int warningNum = Integer.parseInt(br.readLine());
        int[][] warningZone = new int[warningNum][4];
        for (int i = 0; i < warningNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            warningZone[i][0] = Integer.parseInt(st.nextToken());
            warningZone[i][1] = Integer.parseInt(st.nextToken());
            warningZone[i][2] = Integer.parseInt(st.nextToken());
            warningZone[i][3] = Integer.parseInt(st.nextToken());
        }

        int dieNum = Integer.parseInt(br.readLine());
        int[][] dieZone = new int[dieNum][4];
        for (int i = 0; i < dieNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            dieZone[i][0] = Integer.parseInt(st.nextToken());
            dieZone[i][1] = Integer.parseInt(st.nextToken());
            dieZone[i][2] = Integer.parseInt(st.nextToken());
            dieZone[i][3] = Integer.parseInt(st.nextToken());
        }

        boolean[][] visited = new boolean[501][501];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!pq.isEmpty()) {

            int[] now = pq.poll();

            if (now[0] == 500 && now[1] == 500) {
                System.out.println(now[2]);
                return;
            }


            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 501 && ny < 501) {

                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;

                        // 금지
                        boolean die = false;
                        for (int[] zone : dieZone) {

                            if (nx >= Math.min(zone[0], zone[2]) && nx <= Math.max(zone[0], zone[2]) && ny >= Math.min(zone[1], zone[3]) && ny <= Math.max(zone[1], zone[3])) {
                                die = true;
                                break;
                            }

                        }

                        if (die) {
                            continue;
                        }


                        // 위험
                        boolean warning = false;
                        for (int[] zone : warningZone) {

                            if (nx >= Math.min(zone[0], zone[2]) && nx <= Math.max(zone[0], zone[2]) && ny >= Math.min(zone[1], zone[3]) && ny <= Math.max(zone[1], zone[3])) {
                                warning = true;
                                break;
                            }


                        }
                        if (warning) {
                            pq.add(new int[]{nx, ny, now[2] + 1});
                            continue;
                        }


                        // 안전

                        pq.add(new int[]{nx, ny, now[2]});

                    }


                }


            }


        }


        System.out.println(-1);


    }


}
