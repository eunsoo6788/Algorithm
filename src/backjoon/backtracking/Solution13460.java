package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution13460 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());


        List<int[][]> red = new ArrayList<>();
        List<int[][]> blue = new ArrayList<>();

        String[][] map = new String[y][x];
        boolean[][] visited = new boolean[y][x];


        for (int i = 0 ; i < y; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), "");
            for (int j = 0; j < x; j++) {
                map[i][j] = st1.nextToken();
            }
        }


        Queue<int[][]> queue = new LinkedList<>();



    }


    private void bfs (int[][] red, int[][] blue, String[][] map, Queue<int[][]> queue) {


        queue.add(red);



    }

}
