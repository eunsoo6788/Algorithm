package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main6443 {

    /**
     * 에너그램
     * 골드5
     */

    private static int num;
    private static int length;
    private static char[] arr;
    private static boolean[] visited;
    private static String beforeStr;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        num = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        for (int i = 0; i < num; i++) {


            String str = br.readLine();
            length = str.length();
            arr = new char[length];
            visited = new boolean[length];
            beforeStr = "";
            for (int j = 0; j < length; j++) {
                arr[j] = str.charAt(j);
            }

            Arrays.sort(arr);

            solve(0, "");


        }
        System.out.println(sb);


    }

    private static void solve(int depth, String str) {

        if (depth == length) {
            if (str.equals(beforeStr)) {
                return;
            }

            sb.append(str).append('\n');
            beforeStr = str;

            return;
        }

        for (int i = 0; i < length; i++) {

            if (!visited[i]) {
                visited[i] = true;
                solve(depth + 1, str + arr[i]);
                visited[i] = false;
            }


        }


    }


}
