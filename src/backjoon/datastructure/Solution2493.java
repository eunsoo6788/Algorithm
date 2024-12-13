package backjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution2493 {

    /**
     * 탑 2493
     * 자료구조 - 스택
     * 골드5
     * sol
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr= new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[num];

        Stack<int[]> stack = new Stack<>();

        for (int i = num-1 ; i >= 1 ; i--) {

            int nextValue = arr[i-1];
            int nowValue = arr[i];

            if (nextValue >= nowValue) {
                answer[i] = i;

                while(!stack.isEmpty()) {

                    int[] poll = stack.peek();

                    if (nextValue >= poll[0] ) {
                        answer[poll[1]] = i;
                        stack.pop();
                    } else {
                        break;
                    }

                }


            } else {
                stack.add(new int[]{arr[i],i});
            }
        }


        for (int i : answer) {
            System.out.print(i + " ");
        }

        System.out.println();


    }


}
