package backjoon.graph.unionfind;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1043 {

    /**
     * 거짓말
     * 골드4
     * 유니온 파인드
     * not sol
     */

    private static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int partyNum = Integer.parseInt(st.nextToken());

        parent = new int [nodeNum+1];
        for (int i = 1; i <= nodeNum; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int smartNodeNum = Integer.parseInt(st.nextToken());
        int[] smartNodes = new int[nodeNum+1];
        for (int i = 0; i < smartNodeNum; i++) {
            smartNodes[Integer.parseInt(st.nextToken())] = 1;
        }


        for (int i = 0 ; i < partyNum ; i++) {
            st = new StringTokenizer(br.readLine());
            int personNum = Integer.parseInt(st.nextToken());

            boolean found = false;
            for (int j = 0 ; j < personNum ; j++) {
                if (smartNodes[j] == 1) {
                    found = true;
                    break;
                }
            }

            if (found) {
                for (int j = 0 ; j < personNum ; j++) {

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
