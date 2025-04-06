package backjoon.graph.unionfind;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17250 {


    private static int[] parents;


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        int[] arr = new int[nodeNum+1];
        for (int i = 1; i <= nodeNum; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        parents = new int[nodeNum+1];
        for (int i = 0; i <= nodeNum; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());


            int sNum = find(s);
            int eNum = find(e);

            if (sNum != eNum) {
                union(s, e);
                int newNum = find(s);

                if (newNum == sNum) {
                    arr[newNum] += arr[eNum];
                } else {
                    arr[newNum] += arr[sNum];
                }

                System.out.println(arr[newNum]);
            } else {
                System.out.println(arr[sNum]);
            }


        }


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
