package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2839 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num + 1];

        if (num <= 4){
            arr = new int[6];
        }

        arr[3] = 1;
        arr[5] = 1;

        for (int i = 6 ; i <= num ; i++) {

            if (arr[i-3] != 0 && arr[i-5] != 0){
                arr[i] = Math.min(arr[i-3], arr[i-5]) + 1;
            } else if(arr[i-3] != 0) {
                arr[i] = arr[i-3] + 1;
            } else if(arr[i-5] != 0) {
                arr[i] = arr[i-5] + 1;
            }
        }

        System.out.println(arr[num] == 0 ? -1 : arr[num]);

    }


}
