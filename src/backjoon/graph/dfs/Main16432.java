
package backjoon.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main16432 {

    /**
     * 떡장수와 호랑이
     * 골드4
     */

    private static List<Integer>[] list;
    private static int num;
    private static boolean finished = false;
    private static int[] arr;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        list = new List[num];
        arr = new int[num];
        visited = new boolean[num][10];

        for (int i = 0; i < num; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());

            for (int j = 0; j < size; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }

        }



        dfs(0,-1);

        if (!finished) {
            System.out.println(-1);
            return;
        }


        for (int i = 0; i < num; i++) {
            System.out.print(arr[i] + " ");
        }


    }


    private static void dfs(int depth, int before) {
        if (finished) return;

        if (depth == num) {
            finished = true;
            return;
        }

        for (int i = 0; i < list[depth].size(); i++) {
            int value = list[depth].get(i);

            if (value == before) continue;

            arr[depth] = value;
            dfs(depth + 1, value);

            if (finished) return; // 정답 찾으면 바로 종료
        }
    }

}
