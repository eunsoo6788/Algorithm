package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution17298 {

    public static void main(String[] args) throws IOException {

        /**
         * 오큰수 17298
         * 자료구조
         * 골드 4
         * not sol
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        int[] arr = new int[num];
        arr[num -1] = -1;

        int rightBigValue = stack.pop();
        int popValue = rightBigValue;
        int index = num -2;

        while (!stack.isEmpty()) {

            int now = stack.pop();

            if (now < popValue) {
                rightBigValue = popValue;
                arr[index] = rightBigValue;
                popValue = now;
            } else if (now < rightBigValue) {
                arr[index] = rightBigValue;
                popValue = now;
            } else {
                arr[index] = -1;
                rightBigValue = now;
                popValue = rightBigValue;
            }

            index--;
        }


        for (int i : arr) {
            System.out.print(i + " ");
        }





    }


}
