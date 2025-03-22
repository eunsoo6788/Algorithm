package backjoon.graph.unionfind;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main17352 {

    /**
     * 여러분의 다리가 되어 드리겠습니다!
     * 골드5
     * 유니온 파인드
     * sol
     */

    private static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        parent = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < num - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= num; i++) {
            int val = find(i);
            set.add(val);
        }


        for (int i : set) {
            System.out.print(i + " ");
        }

    }


    private static int find(int x) {
        if (parent[x] == x) {
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
