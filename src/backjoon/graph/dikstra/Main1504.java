package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1504 {

    /**
     * 특정한 최단 경로 1504
     * 골드 4
     * 그래프, 다익스트라
     */

    private static class Node {
        private int end;
        private int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

    }


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] dx = {-1, 1, 0, 0 };
        int[] dy = {0, 0, -1, 1 };

        int[] result = new int[num];

        Arrays.fill(result, Integer.MAX_VALUE);


        List<Node>[] graph = new List[num];

        for (int i = 0; i < num; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < num; i++) {
            for (int j = 0 ; j < num ; j++) {


                for (int k = 0; k < 5; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];

                    if (nx >= 0 && nx < num && ny >= 0 && ny < num) {
                    }


                }

            }

        }




    }
}
