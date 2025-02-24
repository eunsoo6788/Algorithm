package backjoon.graph.unionfind;


import java.io.*;
import java.util.StringTokenizer;

public class Main1976Re {

    private static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityNum = Integer.parseInt(br.readLine());
        int tripNum = Integer.parseInt(br.readLine());

        parents = new int[cityNum+1];


        for (int i = 1; i <= cityNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= cityNum; j++) {

                if (1 == Integer.parseInt(st.nextToken())) {
                    union(i,j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = find(Integer.parseInt(st.nextToken()));

        for (int i = 1 ; i < tripNum ; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (start != find(now)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");



    }


    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);


        if (x != y) {
            if (x < y) {
                parents[y] = x;
            } else {
                parents[x] = y;
            }
        }

    }


}
