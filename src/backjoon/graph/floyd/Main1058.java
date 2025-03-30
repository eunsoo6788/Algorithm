package backjoon.graph.floyd;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1058 {

    /**
     * 친구
     * 실버2
     * 알고리즘 : 플로이드 워셜
     */



    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] result = new int[num];
        List<Integer>[] nodes = new List[num];


        for (int i = 0; i < num; i++) {
            nodes[i] = new ArrayList<>();
        }


        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            for (int j = 0; j < num; j++) {
                if (str.charAt(j) == 'Y') {
                    nodes[i].add(j);
                }
            }
        }


        for (int i = 0; i < num; i++) {
            boolean[] visited = new boolean[num];


            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{i, 0});
            visited[i] = true;

            int count = 0;
            while (!q.isEmpty()) {
                int[] now = q.poll();
                count = Math.max(count, now[1]);

                if (now[1] >= 2) continue;

                for (int next : nodes[now[0]]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        count++;
                        q.add(new int[]{next, now[1]+1});
                    }
                }
            }

            result[i] = count;
        }


        Arrays.sort(result);
        System.out.println(result[num-1]);



    }


}
