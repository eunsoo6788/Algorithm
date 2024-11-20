package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1463 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer numStringTokenizer = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(numStringTokenizer.nextToken());

        int[][] arr = new int[num][3];
        int[][] memorization = new int[num][3];

        for (int index = 0; index < num; index++) {
            StringTokenizer arrStringTokenizer = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < 3; i++) {
                arr[index][i] = Integer.parseInt(arrStringTokenizer.nextToken());
            }
        }

        memorization[0][0] = arr[0][0];
        memorization[0][1] = arr[0][1];
        memorization[0][2] = arr[0][2];


        for (int index = 1; index < num; index++) {
            memorization[index][0] = Math.min(memorization[index - 1][1] + arr[index][0], memorization[index - 1][2] + arr[index][0]);
            memorization[index][1] = Math.min(memorization[index - 1][0] + arr[index][1], memorization[index - 1][2] + arr[index][1]);
            memorization[index][2] = Math.min(memorization[index - 1][0] + arr[index][2], memorization[index - 1][1] + arr[index][2]);
        }


        System.out.println(Math.min(Math.min(memorization[num - 1][0], memorization[num - 1][1]), memorization[num - 1][2]));

    }


}
