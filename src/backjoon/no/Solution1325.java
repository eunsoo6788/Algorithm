package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1325 {

    /**
     * 백준 : 효율적인 해킹
     * 알고리즘 : BFS
     * 실버1
     */

    private static List<Integer>[] list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        list = new ArrayList[num+1];

        for (int i = 1; i <= num; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
        }

        int[] result = new int[num+1];
        for (int i = 1; i <= num; i++) {
            visited = new boolean[num+1];
            int value = dfs(i);
            result[i] = value;
        }

        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 1; i <= num; i++) {
            if (max < result[i]) {
                max = result[i];
                list.clear();
                list.add(i);
            } else if (max == result[i]) {
                list.add(i);
            }
        }

        list.sort(Comparator.naturalOrder());
        for ( int i : list ) {
            System.out.print(i + " ");
        }
    }


    private static int dfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        int max = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            max = Math.max(max, now[1]);

            for (int next : list[now[0]]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, now[1] + 1});
                }
            }
        }

        return max;
    }

}
