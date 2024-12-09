package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution16198 {

    /**
     * 백준 : 에너지 모으기 16198
     * 알고리즘 : 백트래킹
     * not sol
     * 실버 1
     */

    private static int num;
    private static int answer;
    private static int[] arr;
    private static boolean[] visited;
    private static List<Integer> list;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        arr = new int[num];
        visited = new boolean[num];

        visited[0] = true;
        visited[num -1] = true;


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        list = new ArrayList<>();

        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            list.add(arr[i]);
        }


        backtracking(0,0);

        System.out.println(answer);

    }


    private static void backtracking(int depth,  int sum) {

        if (depth == num-2) {
            answer = Math.max(answer, sum);
        }


        for (int i = 1  ; i < num-1 ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.remove(i);
                backtracking(depth+1, sum + (list.get(i-1)*list.get(i)));
                list.add(arr[i]);
                visited[i] = false;
            }
        }




    }




}
