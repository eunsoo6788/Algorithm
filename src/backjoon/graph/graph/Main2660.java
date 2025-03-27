package backjoon.graph.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2660 {

    /**
     * 회장뽑기
     * 골드5
     * 알고리즘 : bfs, graph
     */

    private static int num;
    private static int min = Integer.MAX_VALUE;
    private static List<Integer>[] nodes;
    private static boolean[] visited;
    private static List<Integer> result;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        nodes = new List[num + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            nodes[i] = new ArrayList<>();
        }

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) {
                break;
            }

            nodes[a].add(b);
            nodes[b].add(a);
        }


        for (int i = 1; i <= num; i++) {
            visited = new boolean[num + 1];
            visited[i] = true;

            int depth = bfs(i);

            if (depth == min) {
                result.add(i);
            } else if (depth < min) {
                result.clear();
                result.add(i);
                min = depth;
            }

        }


        System.out.println(min + " " + result.size());
        Collections.sort(result);
        for (int i : result) {
            System.out.print(i + " ");
        }


    }


    private static int bfs(int node) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{node, 0});
        visited[node] = true;
        int depth = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i : nodes[now[0]]) {
                if (!visited[i]) {
                    visited[i] = true;
                    depth = Math.max(now[1]+1, depth);
                    q.add(new int[]{i, now[1] + 1});
                }
            }

        }

        return depth;
    }


}
