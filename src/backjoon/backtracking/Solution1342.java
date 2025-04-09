
package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1342 {

    /**
     * 행운의 문자열
     * 실버1
     * 백트래킹
     */


    private static int[] arr;
    private static boolean[] visited;
    private static String str;
    private static Set<String> set = new HashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        arr = new int[str.length()];
        visited = new boolean[str.length()];

        for (int i = 0 ; i < str.length() ; i++) {
            arr[i] = str.charAt(i) ;
        }

        backtracking(0,"");

        System.out.println(set.size());


    }


    private static void backtracking(int depth, String sum) {


        if (depth == str.length()) {

            char c = sum.charAt(0);
            for (int i = 1 ; i < sum.length() ; i++) {
                if (c==sum.charAt(i)) {
                    return;
                }
                c = sum.charAt(i);
            }

            if (!set.contains(sum)) {
                set.add(sum);
            }

            return;
        }


        for (int i = 0 ; i < arr.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth+1,sum+arr[i]);
                visited[i] = false;
            }
        }



    }


}
