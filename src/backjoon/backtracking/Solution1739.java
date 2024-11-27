package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1739 {

    /**
     * 프로그래머스
     * 백트래킹
     * sol
     * 골드 5
     */

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int length = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());


        char[] arr = new char[size];
        boolean[] visited = new boolean[size];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            arr[i] = st1.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        backtracking(arr,visited,0,-1,new char[length], length);

    }

    private static void backtracking(char[] arr, boolean[] visited, int depth, int index, char[] answer, int length) {

        if (depth == length ) {

            int mo = 0;

            for (char i : answer) {
                switch (i) {
                    case 'a': mo++; break;
                    case 'e': mo++; break;
                    case 'i': mo++; break;
                    case 'o': mo++; break;
                    case 'u': mo++; break;
                }
            }

            int ja = length -mo;

            if (mo >= 1 && ja >= 2) {
                for (char i : answer) {
                    System.out.print(i);
                }
                System.out.println();
            }


            return;
        }



        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && i > index) {
                visited[i] = true;
                answer[depth] = arr[i];
                backtracking(arr, visited, depth + 1, i, answer, length);
                visited[i] = false;
            }
        }
    }





}
