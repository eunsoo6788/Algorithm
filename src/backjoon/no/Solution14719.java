package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution14719 {

    /**
     * 백준 : 빗물 14719
     * 알고리즘 : 구현
     * not sol
     * 골드 5
     */



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());

        int[] arr = new int[xSize];

        StringTokenizer xSt = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < xSize ; i++) {
            arr[i] = Integer.parseInt(xSt.nextToken());
        }



        for (int i : arr) {
            if (i != 0) {

            }
        }



    }





}
