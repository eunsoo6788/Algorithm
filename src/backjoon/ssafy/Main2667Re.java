package backjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main2667Re {

    private static int num;
    private static int[][] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        arr = new int[num][num];
        visited = new boolean[num][num];

        for (int i = 0 ; i < num ; i++) {
            String str = br.readLine();
            for (int j = 0 ; j < num ; j++) {
                arr[i][j] = str.charAt(j) -'0';
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int y = 0 ; y < num ; y++) {
            for (int x = 0 ; x < num ; x++) {
                if (!visited[y][x]) {
                    dfs(x,y,0);
                }
            }
        }


    }

    public static void dfs(int x, int y, int depth) {
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        for (int i = 0 ; i < 4; i++) {

            int nx = x+ dx[i];
            int ny = y+ dy[i];

            if (nx >=0 && ny >= 0 && nx < num && ny < num) {
                if (!visited[ny][nx] && arr[ny][nx] == 1) {
                    dfs(nx, ny, depth + 1);
                }
            }

        }


    }

}
