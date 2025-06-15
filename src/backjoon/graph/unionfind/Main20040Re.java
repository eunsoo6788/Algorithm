package backjoon.graph.unionfind;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20040Re {


    private static int[] parents;
    private static int[] result;


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        parents = new int[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            parents[i] = i;
        }

        int answer = 0;
        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int s = find(Integer.parseInt(st.nextToken()));
            int e = find(Integer.parseInt(st.nextToken()));



            if (s != e) {
                union(e, s);
            } else {
                answer = i+1;
                break;
            }


        }


        System.out.println(answer);


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
