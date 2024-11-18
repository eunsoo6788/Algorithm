package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Sol11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int totalSize = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int[] arr = new int[totalSize];


        for (int i = 0; i < totalSize; i++) {
            var arrMoney = Integer.parseInt(br.readLine());

            if (arrMoney <= money) {
                arr[i] = arrMoney;
            }
        }


        var result = solve(arr, money);
        System.out.println(result);

    }


    private static int solve (int[] arr, int money) {

        int count = 0;
        int total = money;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (total == 0) {
                break;
            }

            if (arr[i] == 0) {
                continue;
            }

            if (arr[i] <= total) {
                count += total / arr[i];
                total = total % arr[i];
            }


        }

        return count;



    }



}
