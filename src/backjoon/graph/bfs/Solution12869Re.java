package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution12869Re {

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

        int max = 0;
        arr = new int[num + 1];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        arr[num] = 0;

        visited = new boolean[3][max + 1];

        bfs();





    }


    private static void bfs() {

        Queue<int[]> q = new LinkedList<>();
        q.add(arr);
        for (int i = 0; i < 3; i++) {
            visited[i][arr[i]] = true;
        }

        int[] d1 = {-9, -9, -1, -1, -3, -3};
        int[] d2 = {-3, -1, -9, -3, -1, -9};
        int[] d3 = {-1, -3, -3, -9, -9, -1};


        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == 0 && now[1] == 0 && now[2] == 0 ) {
                System.out.println(now[3]);
                break;
            }


            for (int i = 0; i < 6; i++) {
                int n1 = now[0] + d1[i];
                int n2 = now[1] + d2[i];
                int n3 = now[2] + d3[i];

                if (n1 <= 0 ) {
                    n1 = 0;
                }

                if (n2 <= 0 ) {
                    n2 = 0;
                }

                if (n3 <= 0 ) {
                    n3 = 0;
                }


                q.add(new int[]{n1, n2, n3, now[3]+1});

            }





        }


    }


}
