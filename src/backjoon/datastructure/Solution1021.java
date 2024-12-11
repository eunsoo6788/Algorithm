package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1021 {

    /**
     * 회전하는 큐 1021
     * 자료구조
     * 실버 3
     * not sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());


        StringTokenizer arrSt = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[num];
        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(arrSt.nextToken());
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= size ; i++) {
            deque.add(i);
        }





    }


}
