package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11048 {

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr, 0, 0);



        System.out.println(answer);

    }

    private static void dfs(int[] arr, int index, int depth) {

        if (index >= arr.length -1 ) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = 0 ; i < arr[index] ; i++) {
            dfs(arr,index + 1 + i,depth + 1);
        }

// 진은수야 화이팅이다! 바부뿌욱
    }



}
