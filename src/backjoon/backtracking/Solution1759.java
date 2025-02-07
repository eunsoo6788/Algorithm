package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1759 {

    private static char[] arr;
    private static boolean[] visited;
    private static int length;
    private static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        length = Integer.parseInt(st1.nextToken());
        num = Integer.parseInt(st1.nextToken());
        arr = new char[num];
        visited = new boolean[num];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < num; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs("", 0, 0);


    }

    private static void dfs(String str, int depth, int index) {

        if (depth == length) {

            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                    count++;
                }
            }

            if (count >= 1 && length-count >= 2) {
                System.out.println(str);
            }

            return;
        }

        for (int i = 0; i < num; i++) {

            if (!visited[i] && index <= i) {
                visited[i] = true;
                dfs(str + arr[i], depth + 1, i);
                visited[i] = false;
            }
        }

    }


}
