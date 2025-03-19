package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution6443 {

    /**
     * 애너그램
     * 백트래킹
     * not sol
     * 골드5
     */

    private static char[] arr;
    private static boolean[] visited;
    private static List<String> list = new ArrayList<>();




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());


        for (int i = 0; i < num; i++) {

            String str = br.readLine();

            arr = new char[str.length()];
            visited = new boolean[str.length()];

            for (int j = 0; j < str.length(); j++) {
                arr[j] = str.charAt(j);
            }

            solve(0,"");

            Collections.sort(list);

            for (String s : list) {
                System.out.println(s);
            }

            list.clear();

        }


    }


    private static void solve(int depth, String str) {

        if (depth == arr.length) {
            if (!list.contains(str)) {
                list.add(str);
            }
            return;
        }


        for (int i = 0; i < arr.length; i++) {

            if (!visited[i]) {
                visited[i] = true;
                solve(depth + 1, str + arr[i]);
                visited[i] = false;
            }
        }


    }


}
