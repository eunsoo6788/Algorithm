package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2529 {

    /**
     * 백준 : 부등호
     * 알고리즘 : 백트래킹
     * not sol
     * 실버 1
     */


    private static char[] arr;
    private static int num;
    private static int MIN = Integer.MAX_VALUE;
    private static int MAX = 0;

    private static String[] minArr;
    private static String[] maxArr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        arr = new char[num];
        visited = new boolean[10];

        minArr = new String[num+1];
        maxArr = new String[num+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        backTracking(0, new int[num+1]);

        for (String str : maxArr){
            System.out.print(str);
        }
            System.out.println();

        for (String str : minArr){
            System.out.print(str);
        }


    }


    private static void backTracking(int depth, int[] valueArr) {

        if (depth == num+1) {
            boolean success = true;
            for (int i = 0 ; i < num ; i++ ){

                char sign = arr[i];


                if (sign =='<') {
                    if (valueArr[i] < valueArr[i+1]) {
                        continue;
                    } else {
                        success = false;
                        return;
                    }
                } else {
                    if (valueArr[i] > valueArr[i+1]) {
                        continue;
                    } else {
                        success = false;
                        return;
                    }
                }
            }

            if (success) {
                String value = "";
                for (int i : valueArr) {
                    value += i;
                }

                if (MIN > Integer.parseInt(value)) {
                    for (int i = 0 ; i< num+1; i++){
                        minArr[i] = valueArr[i] +"";
                    }
                }

                if (MAX < Integer.parseInt(value)) {
                    for (int i = 0 ; i< num+1; i++){
                        maxArr[i] = valueArr[i] +"";
                    }
                }


            }


            return;

        }




        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= 9; j++) {

                if (!visited[j]) {

                    visited[j] = true;
                    valueArr[depth] = j;
                    backTracking(depth+1, valueArr);

                    visited[j] = false;
                }

            }
        }


    }


}
