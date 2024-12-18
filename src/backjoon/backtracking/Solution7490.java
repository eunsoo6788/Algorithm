package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution7490 {

    private static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());


        for (int test = 0; test < testcase; test++) {
            target = Integer.parseInt(br.readLine());
            int[] arr = new int[target - 1];
            backtracking(0, arr);
        }


    }

    private static void backtracking(int index, int[] arr) {

        if (index == target - 2) {

            int sum = 1;
            for (int i = 2; i <= target; i++) {

                if (arr[i - 2] == 0) {
                    sum += i;
                }

                if (arr[i - 2] == 1) {
                    sum -= i;
                }

                if (arr[i - 2] == 2) {
                    int value = i;
                    while (arr[i - 2] == 2) {
                        value = value * 10 + (i + 1);
                        i++;
                    }
                    i--;
                    sum += value;
                }
            }

            if (sum == 0) {
                System.out.print("1");
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == 0) {
                        System.out.print("+");
                    }

                    if (arr[i] == 1) {
                        System.out.print("-");
                    }

                    if (arr[i] == 2) {
                        System.out.print(" ");
                    }

                    System.out.print(i + 2);
                }

                System.out.println();


            }

            return;
        }


        for (int i = 0; i < 3; i++) {
            arr[index] = i;
            backtracking(index + 1, arr);

        }

    }


}
