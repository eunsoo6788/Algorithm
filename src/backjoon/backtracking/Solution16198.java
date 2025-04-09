
package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution16198 {

    /**
     * 에너지 모의기
     * 실버1
     * 백트래킹
     */


    private static List<Integer> list;
    private static int num;
    private static int max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        backtracking(0,0);

        System.out.println(max);

    }


    private static void backtracking(int depth, int sum) {

        if (list.size() == 2) {
            max = Math.max(max, sum);
            return;
        }


        for (int i = 1; i < list.size()-1; i++) {
            int num = list.get(i);
            list.remove(i);
            backtracking(depth+1, sum + (list.get(i) * list.get(i-1)));
            list.add(i,num);
        }


    }


}
