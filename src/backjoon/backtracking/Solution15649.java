
package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution15649 {

    /**
     * N과 M (1)
     * 실버3
     * 백트래킹
     */

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        visited = new boolean[num+1];

        List<Integer> list = new ArrayList<>();

        backtracking(num,len,0, list);

    }



    private static void backtracking(int num, int len, int depth,List<Integer> list) {

        if (depth == len) {

           for (int i : list) {
               System.out.print(i + " ");
           }
            System.out.println();
            return;
        }


        for (int i = 1 ; i <= num ;i++) {

            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                backtracking(num,len, depth+1,list);
                list.remove(depth);
                visited[i] = false;
            }


        }






    }





}
