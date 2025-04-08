
package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution15664 {

    /**
     * N과 M (11)
     * 실버2
     * 백트래킹
     */


    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        arr = new int[num ];
        visited = new boolean[num ];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();

        backtracking(num, len, 0, list, 0);

        System.out.println(sb);
    }


    private static void backtracking(int num, int len, int depth, List<Integer> list, int before) {

        if (depth == len) {
            String s = "";
            for (int i : list) {
                s += i+" ";
            }

            if (!set.contains(s)) {
                set.add(s);
                sb.append(s).append('\n');
            }

            return;
        }


        for (int i = 0; i < num; i++) {
            list.add(arr[i]);
            backtracking(num,len, depth+1,list, arr[i]);
            list.remove(depth);

        }


    }


}
