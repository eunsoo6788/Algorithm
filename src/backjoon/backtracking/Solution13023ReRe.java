package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution13023ReRe {

    /**
     * ABCDE
     * 백트래킹
     * not sol
     * 골드 5
     */


    private static int[] result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i;
        }


        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            union(s, e);
        }

        boolean friend = true;
        for (int i = 0; i < num; i++) {
            if (find(i) != 0) {
                friend = false;
                break;
            }
        }

        System.out.println(friend ? 1 : 0);

    }

    private static int find(int x) {
        if (x == result[x]) {
            return x;
        }
        return result[x] = find(result[x]);
    }

    private static void union(int x, int y) {
        x=find(x);
        y=find(y);

        if (x != y) {
            if (x < y) {
                result[y] = x;
            } else {
                result[x] = y;
            }
        }
    }


}
