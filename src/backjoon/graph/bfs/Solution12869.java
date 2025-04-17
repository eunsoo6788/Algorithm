package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution12869 {

    /**
     * 뮤탈리스크
     * 골드4
     * bfs , 백트래킹
     */


    private static int[] arr;
    private static boolean[][] visited;
    private static int num;
    private static int size;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;


    }

    private static int min;

    private static void bfs() {

        Queue<int[]> q = new LinkedList<>();
        int[] tmp = new int[num+1];
        for (int i = 0; i < num; i++) {
            tmp[i] = arr[i];
        }
        q.add(tmp);


        while (!q.isEmpty()) {

            int[] now = q.poll();

            boolean notFinished = false;
            for (int i = 0; i < num; i++) {
                if (now[i] > 0 ) {
                    notFinished = true;
                    break;
                }
            }

            if (!notFinished) {
                min = now[num-1];
                break;
            }

            for (int i = 0; i < num; i++) {





            }


        }





    }


}
