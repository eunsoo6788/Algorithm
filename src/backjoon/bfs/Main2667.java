package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2667 {

    private static int[][] map;
    private static boolean[][] visited;
    private static int size;
    private static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        map = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String str = br.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> answer = new ArrayList<>();
        int mapCount = 0;
        for (int y= 0 ; y < size ; y++) {
            for (int x = 0 ; x < size ; x++) {
                if ( !visited[y][x] && map[y][x] == 1) {
                    visited[y][x] = true;
                    count = 0;
                    dfs(x,y);
                    answer.add(count);
                    mapCount++;
                }
            }
        }

        Collections.sort(answer);

        System.out.println(mapCount);
        for (int value : answer) {
            System.out.println(value);
        }

    }

    private static int[] dx ={0,0,-1,1};
    private static int[] dy ={-1,1,0,0};

    private static void dfs(int x, int y) {

        for (int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx>=0 && ny>=0 && nx < size && ny < size) {
                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    count++;
                    dfs(nx,ny);
                }
            }

        }



    }


}
