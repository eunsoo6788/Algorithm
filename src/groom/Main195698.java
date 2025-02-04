package groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main195698 {

    /**
     * 구름 : 연합 195698
     * 알고리즘 : 유니온 파인드
     * not sol
     * 레벨2
     */


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());


        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[nodeNum + 1];

        for (int i = 0; i <= nodeNum; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeNum; i++) {
            StringTokenizer stMap = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stMap.nextToken());
            int end = Integer.parseInt(stMap.nextToken());
            list.get(start).add(end);
        }

        int count = 0;
        for (int i = 1; i <= nodeNum; i++) {

            if (!visited[i]) {
                visited[i] = true;
                dfs(list, i, visited);
                count++;
            }

        }

        System.out.println(count);
    }

    private static void dfs(ArrayList<ArrayList<Integer>> list, int startNode, boolean[] visited) {

        for (int node : list.get(startNode)) {
            if (!visited[node]) {
                visited[node] = true;
                dfs(list, node, visited);
            }
        }


    }
}
