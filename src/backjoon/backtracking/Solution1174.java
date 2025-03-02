package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1174 {
    private static int number;
    private static int count = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        number = Integer.parseInt(br.readLine());

        if (number <= 9) {
            System.out.println(number - 1);
            return;
        }

        for (int i = 10; i <= 1000000; i++) {
            backtrack(i, i, 0);

            if (count == number) {
                System.out.println(i-1);
                return;
            }

        }


        System.out.println(-1);
        return;

    }


    //321
    private static void backtrack(int num, int now, int depth) {

        if (now < 10) {

            int[] arr = new int[depth + 1];

            for (int i = 0; i < depth + 1; i++) {
                arr[i] = num % 10;
                num /= 10;
            }

            for (int i = 0; i < depth; i++) {
                if (arr[i] >= arr[i + 1]) {
                    return;
                }
            }

            count++;
            return;

        } else if (num >= 10) {
            backtrack(num, now / 10, depth + 1);
        } else {}




    }

}
