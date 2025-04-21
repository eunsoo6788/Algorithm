package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution17141Re {

    /**
     * 연구소2
     * 골드4
     * bfs , 백트래킹
     */


    private static int[][] arr;
    private static boolean[][] visited;
    private static int num;
    private static int size;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        arr = new int[num][num];


        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        backtrack(0);


        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }


    }


    private static List<int[]> list = new ArrayList<>();

    private static void backtrack(int depth) {

        if (depth == size) {
            visited = new boolean[num][num];
            bfs();
            return;
        }


        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (arr[i][j] == 2) {
                    arr[i][j] = 3;
                    list.add(new int[]{i, j});
                    backtrack(depth + 1);
                    list.remove(depth);
                    arr[i][j] = 2;
                }
            }

        }


    }


    private static int min = Integer.MAX_VALUE;

    private static void bfs() {


        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            int[] byrus = list.get(i);
            queue.offer(new int[]{byrus[0], byrus[1], 0}); // y ,x ,depth
            visited[byrus[0]][byrus[1]] = true;
        }


        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int max = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            max = Math.max(max, now[2]);

            for (int i = 0; i < 4; i++) {
                int nowX = now[1] + dx[i];
                int nowY = now[0] + dy[i];


                if (nowX < 0 || nowX >= num || nowY < 0 || nowY >= num) {
                    continue;
                }

                if (!visited[nowY][nowX] && arr[nowY][nowX] != 1) {

                    visited[nowY][nowX] = true;
                    queue.offer(new int[]{nowY, nowX, now[2]+1});
                }

            }

        }

        boolean clean = true;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (!visited[i][j] && arr[i][j] !=1 ) {
                    clean = false;
                    break;
                }
            }

            if (!clean) {
                break;
            }
        }

        if (clean) {
            min = Math.min(min, max);
        }



    }


}
