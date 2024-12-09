package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution1342 {

    /**
     * 백준 : 행운의 문자열
     * 알고리즘 : 백트래킹
     * not sol
     * 실버 1
     */


    private static char[] arr;
    private static int num;
    private static boolean[] visited;
    private static Set<String> stringSet;
    private static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        num = str.length();
        arr = new char[num];
        visited = new boolean[num];
        stringSet = new HashSet<>();
        answer = 0;

        for (int i = 0; i < num; i++) {
            arr[i] = str.charAt(i);
        }

        backTracking(0,"");

        System.out.println(answer);
    }

    private static void backTracking(int depth, String str) {

        if (depth == num) {
            if (!stringSet.contains(str)) {
                stringSet.add(str);
                answer++;
            }
            return;
        }


        for (int i = 0 ; i < num ; i++) {
            if (!visited[i]) {
                if (str.length() > 0 && str.charAt(str.length()-1) != arr[i]){
                    visited[i] =true;
                    backTracking(depth +1, str + arr[i]);
                    visited[i] =false;
                } else if (str.length() == 0) {
                    visited[i] =true;
                    backTracking(depth +1, str + arr[i]);
                    visited[i] =false;
                }
            }
        }



    }

}
