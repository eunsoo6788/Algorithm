package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1245 {

    /**
     * 농장 관리
     * 골드5
     * 너비우선탐색 / bfs
     * Not Sol
     */

    private static int[][] arr;
    private static boolean[][] visited;

    private static int ySize;
    private static int xSize;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        arr = new int[ySize][xSize];
        visited = new boolean[ySize][xSize];

        for (int i = 0; i < ySize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < xSize; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }








    }


    private static void bfs() {

    }


}
