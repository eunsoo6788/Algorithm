package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1325 {

    /**
     * 효율적인 해킹
     * 실버1
     */

    private static List<Integer>[] list;
    private static int node;
    private static int edge;
    private static boolean[] visited;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        list = new List[node+1];

        for (int i = 1; i <= node; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
        }

        int max = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= node; i++) {

            visited = new boolean[node+1];

            int value = solve(i);

            if (max < value) {
                list.clear();
                max = value;
                list.add(i);
            } else if (max == value) {
                list.add(i);
            }

        }

        list.sort(Comparator.naturalOrder());


        for (int i : list) {
            System.out.print(i + " ");
        }




    }


    private static int solve(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : list[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }

        return count;
    }

}
