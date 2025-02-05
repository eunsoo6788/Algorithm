package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sol2468Re {

    private static int num;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        num = Integer.parseInt(br.readLine());
        map = new int[num][num];

        int low = Integer.MAX_VALUE;
        int high = 0;


        for (int y = 0; y < num; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < num; x++) {
                int value = Integer.parseInt(st.nextToken());
                map[y][x] = value;

                low = Math.min(low, value);
                high = Math.max(high, value);
            }
        }


        int answer = 0;
        for (int i = low; i <= high; i++) {
            visited = new boolean[num][num];
            int count = 0;
            for (int y = 0; y < num; y++) {
                for (int x = 0; x < num; x++) {
                    if (!visited[y][x] && map[y][x] > i) {
                        visited[y][x] = true;
                        dfs(x,y, i);
                        count++;
                    }
                }
            }
            answer = Math.max(count,answer);
        }


        System.out.println(answer != 0 ? answer : 1);

    }

    private static void dfs(int x, int y, int height) {
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        for (int i =0 ; i< 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < num && ny <num) {
                if (!visited[ny][nx] && map[ny][nx] > height) {
                    visited[ny][nx] = true;
                    dfs(nx,ny,height);
                }
            }

        }

    }


}
