package backjoon.graph.unionfind;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11085 {

    private static int[][] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        parents = new int[nodeNum][2];
        for (int i = 0; i < nodeNum; i++) {
            parents[i][0] = i;
            parents[i][1] = Integer.MAX_VALUE;
        }

        for ( int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());



            s = find(s);
            e = find(e);

            if (s != e) {
                parents[s][1] = Math.min(Math.min(parents[e][1], w), parents[s][1]);
                parents[e][1] = Math.min(Math.min(parents[e][1], w), parents[s][1]);
                union(s, e);
            }

        }

        System.out.println(parents[find(end)][1]);



    }

    private static int find(int x) {
        if (x == parents[x][0]) {
            return x;
        }

        return parents[x][0] = find(parents[x][0]);
    }


    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parents[y][0] = x;
            } else {
                parents[x][0] = y;
            }
        }
    }

}
