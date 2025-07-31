package backjoon.graph.unionfind;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1976ReRe {

    private static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int visitNum = Integer.parseInt(br.readLine());

        parents = new int[num+1];
        for (int i = 1; i <= num; i++) {
            parents[i] = i;
        }


        for (int y = 0; y < num; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < num; x++) {

                int isVisited = Integer.parseInt(st.nextToken());

                if (isVisited == 1) {
                    union(x+1, y+1);
                }
            }
        }


        StringTokenizer st = new StringTokenizer(br.readLine());
        int now = find(Integer.parseInt(st.nextToken()));
        boolean same = true;
        for (int i = 0 ; i < visitNum-1; i++) {
            if (now != parents[find(Integer.parseInt(st.nextToken()))]) {
                same = false;
                break;
            }
        }

        if (same) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }

    private static int find(int x) {
        if (x == parents[x]) {
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
