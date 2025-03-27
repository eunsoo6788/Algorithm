package backjoon.graph.unionfind;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1717ReReReRe {


    private static int[] parent;


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        parent = new int[nodeNum + 1];
        for (int i = 0; i <= nodeNum; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());

            int flag = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (flag == 0) {
                union(num1, num2);
            } else if (flag == 1) {
                if (find(num1) != find(num2)) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
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
