package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2606 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeNum = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[edgeNum];
        boolean[] answer = new boolean[nodeNum + 1];
        int[][] edge = new int[edgeNum][2];

        for (int i = 0; i < edgeNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            edge[i][0] = Integer.parseInt(st.nextToken());
            edge[i][1] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < edgeNum; i++) {

            if (edge[i][0] == 1 || edge[i][1] == 1) {
                visited[i] = true;
                answer[edge[i][0]] = true;
                answer[edge[i][1]] = true;

                if (edge[i][0] == 1) {
                    dfs(edge, visited, answer,1, edge[i][1]);
                } else if (edge[i][1] == 1) {
                    dfs(edge, visited, answer, 1, edge[i][0]);
                }

            }
        }

        int count = 0;
        for (boolean ba : answer) {
            if (ba) {
                count++;
            }
        }

        System.out.println(count-1);


    }

    private static void dfs(int[][] edge, boolean[] visited, boolean[] answer, int now, int next) {


        for (int i = 0; i < edge.length; i++) {
            if (!visited[i]) {
                if (edge[i][0] == next) {
                    visited[i] = true;
                    answer[edge[i][0]] = true;
                    answer[edge[i][1]] = true;
                    dfs(edge, visited, answer, now, edge[i][1]);
                } else if (edge[i][1] == next) {
                    visited[i] = true;
                    answer[edge[i][0]] = true;
                    answer[edge[i][1]] = true;
                    dfs(edge, visited, answer, now, edge[i][0]);
                }


            }


        }


    }


}
