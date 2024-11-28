package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1522 {

    /**
     * 백준 : 숨바꼭질 1697
     * 알고리즘 : bfs
     * not sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[1000001];

        bfs(start, end, visited);


    }

    private static void bfs(int start, int end, boolean[] visited) {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            if (poll[0] == end) {
                System.out.println(poll[1]);
                break;
            }

            if (poll[0] - 1 < (end*2)  && !visited[poll[0]-1]){
                visited[poll[0] - 1] = true;
                queue.add(new int[]{poll[0] - 1, poll[1] + 1});

            }
            if (poll[0] + 1 < (end*2) && !visited[poll[0]+1]){
                visited[poll[0] + 1] = true;
                queue.add(new int[]{poll[0] + 1, poll[1] + 1});

            }

            if (poll[0] * 2 < (end*2) && !visited[poll[0]*2]){
                visited[poll[0]* 2] = true;
                queue.add(new int[]{poll[0] * 2, poll[1] + 1});
            }



        }


    }


}
