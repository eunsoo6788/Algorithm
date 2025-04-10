package backjoon.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14502 {

    /**
     * 아기상어
     * bfs
     * 골드3
     */

    private static int ySize;
    private static int xSize;
    private static boolean[][] visited;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        arr = new int[ySize][xSize];

        visited = new boolean[ySize][xSize];

        for (int i = 0; i < ySize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < xSize; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }






    }

    private static void backChannel(int depth) {

        if (depth == 3) {



            return;
        }


        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    backChannel(depth+1);
                    arr[i][j] = 0;
                }
            }
        }



    }

    private static void bfs() {




    }

}
