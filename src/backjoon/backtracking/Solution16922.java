package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution16922 {

    private static int[] arr = {1,5,10,20};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int num = Integer.parseInt(st.nextToken());



        Set<Integer> set = new HashSet<>();

        backtracking(set, 0, 0, num);

        System.out.println(set.size());

    }

    private static void backtracking(Set<Integer> set, int depth, int value, int num) {

        if (depth == num) {
            set.add(value);
            return;
        }


        for (int i = 0 ; i < 4 ; i++) {
            backtracking(set, depth + 1, value+ arr[i], num);
        }




    }


}
