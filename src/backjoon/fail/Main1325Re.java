package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1325Re {

    /**
     * 효율적인 해킹
     * 실버1
     */


    private static List<Integer>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());


        list = new List[nodeNum+1];
        int[] result = new int[nodeNum+1];

        for (int i = 0; i <= nodeNum; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[end].add(start);
        }


        for (int i = 1; i <= nodeNum; i++) {

            boolean[] visited = new boolean[nodeNum+1];
            int value = bfs(i, visited);
            result[i] = value;
        }

        int max = 0;
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= nodeNum; i++) {

            if (result[i] > max) {
                answer.clear();
                max = result[i];
                answer.add(i);
            } else if (result[i] == max) {
                answer.add(i);
            }

        }

        answer.sort(Comparator.naturalOrder());
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }

    }


    private static int bfs(int start, boolean[] visited) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        int max = 0;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            max = Math.max(max, node[1]);

            for (int s : list[node[0]]) {
                if (!visited[s]) {
                    visited[s] = true;
                    queue.add(new int[]{s, node[1]+1});
                }
            }

        }

        return max;
    }

}
