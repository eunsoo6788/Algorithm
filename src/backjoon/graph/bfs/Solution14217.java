
package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution14217 {

    /**
     * 치즈 (Chese)
     * 골드5
     * 알고리즘 : bfs
     */

    private static class Node {
        int end;
        boolean possible;
        public Node(int end, boolean possible) {
            this.end = end;
            this.possible = possible;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Node>[] lists = new List[n + 1];
        int[] result = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lists[start].add(new Node(end, true));
            lists[end].add(new Node(start, true));
        }


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int problem = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            if (problem == 1 ) {
                lists[a].add(new Node(b, true));
            }

            if (problem == 2 ) {
            }

        }






    }

    private static void bfs() {



    }


}
