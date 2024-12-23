package backjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution13305 {

    /**
     * 백준 : 상어 키우기 30892
     * 알고리즘 : 스택, 그리드, 구현
     * not sol
     * 실버 1
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int sharkNum = Integer.parseInt(st.nextToken());
        long sharkFeedNum = Integer.parseInt(st.nextToken());
        long sharkSize = Integer.parseInt(st.nextToken());

        StringTokenizer stArr = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[sharkNum];

        for (int i = 0; i < sharkNum; i++) {
            arr[i] = Integer.parseInt(stArr.nextToken());
        }

        Arrays.sort(arr);

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> trashStack = new Stack<>();

        for (int i = sharkNum - 1; i >= 0; i--) {
            stack.add(arr[i]);
        }


        while (sharkFeedNum > 0) {

            if (stack.isEmpty()) {
                break;
            }


            if (stack.size() >= 2) {
                int nowNum = stack.pop();
                int nextNum = stack.peek();

                //
                if (nowNum < sharkSize && nextNum < sharkSize) {
                    trashStack.add(nowNum);
                } else if (nowNum < sharkSize && nextNum >= sharkSize) {
                    sharkSize += nowNum;
                    sharkFeedNum--;
                }
            } else {

                int nowNum = stack.pop();

                //
                if (nowNum >= sharkSize) {
                    trashStack.add(nowNum);
                } else if (nowNum < sharkSize) {
                    sharkSize += nowNum;
                    sharkFeedNum--;
                }
            }


        }



        while (!trashStack.isEmpty()) {

            if (sharkFeedNum == 0) {
                break;
            }

            if (trashStack.peek() >= sharkSize) {
                trashStack.pop();
            } else {
                sharkSize += trashStack.pop();
                sharkFeedNum--;
            }


        }

        System.out.println(sharkSize);



    }


}
