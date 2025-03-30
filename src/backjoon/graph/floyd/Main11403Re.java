package backjoon.graph.floyd;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11403Re {

    /**
     * 경로찾기
     * 실버1
     * 알고리즘 : floyd warshall
     */


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        List<Integer>[] nodes = new List[num];
        for (int i = 0; i < num; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                int a = Integer.parseInt(st.nextToken());

                if (a == 1) {
                    nodes[i].add(j);
                }
            }
        }

        int[][] map = new int[num][num];

        for (int y = 0; y < num; y++) {

            boolean[] visited = new boolean[num];

            Queue<Integer> q = new LinkedList<>();
            q.add(y);

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int next : nodes[now]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }

            }



            for (int i = 0; i < num; i++) {
                if (visited[i]) {
                    map[y][i] = 1;
                }
            }


        }


        for (int y = 0; y < num; y++) {
            for (int x = 0 ; x < num; x++) {
                System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }






    }


}
