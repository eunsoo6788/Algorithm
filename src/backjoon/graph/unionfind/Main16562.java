package backjoon.graph.unionfind;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main16562 {

    /**
     * 친구비
     * 골드4
     * 유니온 파인드
     * sol
     */

    private static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());

        parent = new int [nodeNum+1];
        for (int i = 1; i <= nodeNum; i++) {
            parent[i] = i;
        }

        int[] arr = new int[nodeNum+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= nodeNum; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i <= nodeNum; i++) {

            int parent = find(i);
            int value = map.getOrDefault(parent,0);

            if (value == 0) {
                map.put(parent,arr[i]);
            } else {
                map.put(parent,Math.min(arr[i],value));
            }

        }

        int sum = 0;
        for (int value : map.values()) {
            sum += value;
        }

        if (sum > cost) {
            System.out.println("Oh no");
        } else {
            System.out.println(sum);

        }


    }


    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }



}
