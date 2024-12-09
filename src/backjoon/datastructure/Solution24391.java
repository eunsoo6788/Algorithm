package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution24391 {

    /**
     * 귀찮은 해강이 24391
     * 자료구조
     * 골드 5
     * not sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int arrSize = Integer.parseInt(st.nextToken());
        int graphSize = Integer.parseInt(st.nextToken());

        int[][] graph = new int[graphSize][2];
        for (int i = 0 ; i < graphSize ; i++) {
            StringTokenizer graphArr = new StringTokenizer(br.readLine(), " ");
            graph[i][0] = Integer.parseInt(graphArr.nextToken());
            graph[i][1] = Integer.parseInt(graphArr.nextToken());
        }

        int[] arr = new int[arrSize];
        StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < arrSize ; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
        }

        int count =0;
        for (int i = 0 ; i < arr.length-1 ; i++) {
            int now = arr[i];
            int next = arr[i+1];

            boolean result = bfs(now,next,graph,new boolean[graphSize]);

            if (!result) {
                count++;
            }

        }

        System.out.println(count);

    }

    private static boolean bfs(int now, int next, int[][] graph, boolean[] visited) {
        boolean result = false;
        for (int i = 0 ; i < graph.length ; i++) {

            if (!visited[i]) {

                if (graph[i][0] == now || graph[i][1] == now) {
                    Queue<int[]> queue = new LinkedList<>();

                    queue.add(new  int[]{graph[i][0], graph[i][1]});
                    visited[i] = true;


                    while (!queue.isEmpty()) {

                        int[] poll = queue.poll();

                        if (poll[0] == next || poll[1] == next) {
                            result = true;
                            break;
                        }


                        for (int j = 0 ; j < graph.length ; j++) {

                            if (!visited[i]) {
                                if (poll[0] == graph[i][0] || poll[0] == graph[i][1] || poll[1] == graph[i][0] || poll[1] == graph[i][1]) {
                                    visited[j] = true;
                                    queue.add(new int[]{graph[i][0], graph[i][1]});
                                }
                            }
                        }



                    }

                }

            }

            if (result){
                break;
            }
        }


        return result;
    }


}
