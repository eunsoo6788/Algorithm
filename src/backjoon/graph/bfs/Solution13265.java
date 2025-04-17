package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution13265 {

    /**
     * 공주님을 구해라!
     * 골드5
     * 너비우선탐색 / bfs
     * Sol
     */


    private static int node;
    private static int edge;


    private static List<Integer>[] lists;
    private static int[] arr;
    private static boolean[] visited;
    private static int time;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        for (int t = 0; t < n; t++) {


            StringTokenizer st = new StringTokenizer(br.readLine());

            node = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());

            arr = new int[node+1];
            visited = new boolean[node+1];

            lists = new List[node+1];
            for (int i = 0; i < node; i++) {
                lists[i] = new ArrayList<>();
            }

            for (int i = 0; i < edge; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                lists[x].add(y);
                lists[y].add(x);
            }




        }


    }


    private static void dfs(int node , int beforeColor) {



        for (int i = 0; i < lists[node].size(); i++) {

            int next = lists[node].get(i);

            if (!visited[next]) {
                visited[next] = true;

                if (beforeColor == 1) {
                    arr[next] = 2;
                    dfs(next, 2);
                } else if (beforeColor == 2) {
                    arr[next] = 1;
                    dfs(next, 1);
                }


            }



        }



    }


}
