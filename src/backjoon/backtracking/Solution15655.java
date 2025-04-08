
package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution15655 {

    /**
     * N과 M (6)
     * 실버3
     * 백트래킹
     */


    private static boolean[] visited;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        arr = new int[num+1];
        visited = new boolean[num+1];

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i <= num ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();

        backtracking(num,len,0, list,0);

    }



    private static void backtracking(int num, int len, int depth,List<Integer> list, int before) {

        if (depth == len) {

           for (int i : list) {
               System.out.print(i + " ");
           }
            System.out.println();
            return;
        }


        for (int i = 1 ; i <= num ;i++) {

            if (!visited[i] && arr[i] > before) {
                visited[i] = true;
                list.add(arr[i]);
                backtracking(num,len, depth+1,list, arr[i]);
                list.remove(depth);
                visited[i] = false;
            }


        }






    }





}
