package backjoon.graph.unionfind;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main25187 {


    private static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int answerNum = Integer.parseInt(st.nextToken());


        int[][] map = new int[nodeNum + 1][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= nodeNum; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == 0) {
                map[i][0]++;
            } else {
                map[i][1]++;
            }
        }


        parent = new int[nodeNum + 1];
        for (int i = 1; i <= nodeNum; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            a = find(a);
            b = find(b);

            if (a != b) {

                union(a, b);

                int newNum = find(a);

                if (a == newNum) {
                    map[a][0] += map[b][0];
                    map[a][1] += map[b][1];
                } else {
                    map[b][0] += map[a][0];
                    map[b][1] += map[a][1];
                }

            }



        }


        for (int i = 0 ; i < answerNum; i++) {
            int num = find(Integer.parseInt(br.readLine()));

            int bad = map[num][0];
            int clean = map[num][1];

            if (clean > bad) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }



    }


    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }


    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }

}
