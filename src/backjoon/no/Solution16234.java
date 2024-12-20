package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution16234 {

    /**
     * 백준 : 숫자고르기
     * 알고리즘 : 구현 bfs
     * not sol
     * 골드 5
     */

    private static int[][] arr;
    private static boolean[][] visited;
    private static int minDiff;
    private static int maxDiff;
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        size = Integer.parseInt(st.nextToken());
        minDiff = Integer.parseInt(st.nextToken());
        maxDiff = Integer.parseInt(st.nextToken());

        arr = new int[size][size];
        for (int y = 0; y < size; y++) {
            StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < size; x++) {
                arr[y][x] = Integer.parseInt(stArr.nextToken());
            }
        }

        int totalCount = 0;
        while (true) {

            visited = new boolean[size][size];

            int count = 0;

            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {

                    int[] dx = {1, 0};
                    int[] dy = {0, 1};

                    for (int i = 0; i < 2; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx < size-1 && ny < size-1) {
                            int diff = Math.abs(arr[y][x] - arr[ny][nx]);
                            if (diff >= minDiff && diff <= maxDiff) {
                                visited[y][x] = true;
                                visited[ny][nx] = true;
                                count ++;
                            }
                        }
                    }
                }
            }


            if (count != 0) {
                break;
            }

            totalCount++;


            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    if (visited[y][x]) {
                        visited[y][x] = false;
                        List<int[]> list = new ArrayList<>();
                        list.add(new int[]{x,y});


                        dfs(x,y,list);

                        int sum = 0;
                        for (int[] ar : list){
                            sum += arr[ar[1]][ar[0]];
                        }

                        int avg =sum/list.size();

                        for (int[] ar : list){
                            arr[ar[1]][ar[0]] = avg;
                        }
                    }

                }
            }

        }
        System.out.println(totalCount);





    }

    private static void dfs(int x, int y, List<int[]> list) {


        int[] dx = {1, 0};
        int[] dy = {0, 1};

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < size-1 && ny < size-1) {
                if (visited[ny][nx]) {
                    visited[ny][nx] = false;

                    list.add(new int[] {nx,ny});
                    dfs(nx,ny,list);

                }
            }
        }


    }


}
