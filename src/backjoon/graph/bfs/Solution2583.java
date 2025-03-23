package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2583 {

    /**
     * https://www.acmicpc.net/problem/2583
     * 실버1
     * 알고리즘 : dfs bfs
     * Sol
     */

    private static int[][] map;
    private static boolean[][] visited;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer startTokenizer = new StringTokenizer(br.readLine(), " ");

        int ySize = Integer.parseInt(startTokenizer.nextToken());
        int xSize = Integer.parseInt(startTokenizer.nextToken());
        int num = Integer.parseInt(startTokenizer.nextToken());

        map = new int[ySize][xSize];
        visited = new boolean[ySize][xSize];

        for (int i = 0; i < num ; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());


            for (int y = startY; y < endY; y++) {
                for (int x = startX; x < endX; x++) {
                    map[y][x] = 1;
                }
            }
        }

        int count  = 0;
        List<Integer> list = new ArrayList<>();
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {

                if (!visited[y][x] && map[y][x] == 0) {
                    visited[y][x] = true;
                    answer = 0;
                    dfs(x,y,0);
                    list.add(answer);
                    count++;
                }

            }
        }

        System.out.println(count);

        Collections.sort(list);

        for (int i : list){
            System.out.print(i + " ");
        }

    }


    private static void dfs(int x, int y, int depth) {

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        answer++;

        for (int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < map[0].length && ny < map.length) {
                if (!visited[ny][nx] && map[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    dfs(nx, ny, depth+1);
                }
            }
        }

    }


}
