package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution12919 {

    /**
     * A와 B 2 12919
     * 골드5
     * 알고리즘 : dfs
     * Not Sol
     */

    private static boolean success = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String start = br.readLine();
        String target = br.readLine();

        dfs(start,target);

        System.out.println(success ? 1 : 0);

    }







    private static void dfs(String str, String target) {


        if (str.length() == target.length()) {
            if (str.equals(target)) {
                success = true;
            }
           return;
        }


        dfs(str + "A",target);


        str += "B";
        String convertStr = "";
        for (int i = str.length()-1 ; i >= 0 ; i--) {
            convertStr += str.charAt(i);
        }

        dfs(convertStr,target);

    }
}
