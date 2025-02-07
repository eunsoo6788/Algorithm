package backjoon.graph.unionfind;


import java.io.*;
import java.util.StringTokenizer;

public class Main1717Re {
    static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 0 ; i <= n ; i++) {
            parent[i] = i;
        }

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0 ) {
                // union
                union(a,b);
            } else {
                // find
                int a1 = find(a);
                int b1 = find(b);

                System.out.println(a1==b1 ? "YES" : "NO");
            }

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
        y= find(y);

        if (x!=y){
            if (x<y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }

    }

}
