package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5972 {

    /**
     * 택배 배송 5972
     * 골드5
     * 알고리즘 : dfs
     * Not Sol
     */

    private static int[][] arr;
    private static boolean[] visited;
    private static int target;
    private static int caseSize;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        target = Integer.parseInt(st.nextToken());
        caseSize = Integer.parseInt(st.nextToken());


        arr= new int[caseSize][3];
        visited = new boolean[50_001];

        for (int i = 0 ; i < caseSize ; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st1.nextToken());
            arr[i][1] = Integer.parseInt(st1.nextToken());
            arr[i][2] = Integer.parseInt(st1.nextToken());
        }

        bfs();

    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0 ; i < caseSize ; i++) {

            if (arr[i][0] == 1) {
                if (arr[i][2] < min) {
                    min = arr[i][2];
                    start = 1;
                    end = arr[i][1];
                }
            }

            if (arr[i][1] == 1) {
                if (arr[i][2] < min) {
                    min = arr[i][2];
                    start = 1;
                    end = arr[i][0];
                }
            }
        }

        visited[start] = true;
        queue.add(new int[]{start,end,min});


        while(!queue.isEmpty()) {

            min = Integer.MAX_VALUE;
            start = 0;
            end = 0;

            int[] poll = queue.poll();



            // 종료 조건
            if (poll[1] == target) {
                System.out.println(poll[2]);
                return;
            }




            for (int i = 0 ; i < caseSize ; i++) {

                if (arr[i][0] == poll[1]) {
                    if (!visited[arr[i][1]]) {
                        if (arr[i][2] < min) {
                            min = arr[i][2];
                            start = arr[i][0];
                            end = arr[i][1];
                        }
                    }
                }

                if (arr[i][1] == poll[1]) {
                    if (!visited[arr[i][0]]) {
                        if (arr[i][2] < min) {
                            min = arr[i][2];
                            start = arr[i][1];
                            end = arr[i][0];
                        }
                    }
                }
            }



            visited[start] = true;
            queue.add(new int[]{start,end,poll[2] + min});




        }




    }

}
