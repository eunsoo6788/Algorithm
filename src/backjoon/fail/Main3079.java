package backjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main3079 {

    /**
     * 알고스팟
     * 골드4
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int queue = Integer.parseInt(st.nextToken());
        int person = Integer.parseInt(st.nextToken());

        int max = 0;
        int[] arr = new int[queue];
        for (int i = 0; i < queue; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        Arrays.sort(arr);

        int low = 0;
        int high = max;

        while (low <= high) {

            int mid = (low + high) / 2;







        }



    }


}
