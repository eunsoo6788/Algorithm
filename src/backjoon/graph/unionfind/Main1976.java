package backjoon.graph.unionfind;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1976 {

    private static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int cityTripNum = Integer.parseInt(br.readLine());


        parent = new int [num+1];
        for (int i = 1; i <= num; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (value == 1) {
                    union(i+1, j+1);
                }

            }
        }

        int[] tripCity = new int[cityTripNum];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cityTripNum; i++) {
            tripCity[i] = Integer.parseInt(st.nextToken());
        }


        boolean tripSuccess = true;

        for (int i = 0; i < cityTripNum-1; i++) {

            int city1 = find(tripCity[i]);
            int city2 = find(tripCity[i+1]);

            if (city1 != city2) {
                tripSuccess = false;
            }

        }

        if (tripSuccess) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
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
