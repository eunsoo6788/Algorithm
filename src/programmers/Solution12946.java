package programmers;

import java.util.Arrays;
import java.util.Stack;

public class Solution12946 {


    public int[][] solution(int n) {
        int[][] answer = {};


        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

//        bfs();




        return answer;
    }


    private void bfs(Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3, int n, int count) {



        while (stack3.size() < n) {


            for (int i= 0; i < 3 ; i++) {

                if (!stack1.isEmpty()) {
                    int num = stack1.pop();

                    if (stack2.isEmpty() || stack2.peek() > num) {
                        stack2.push(num);
                    }

                    if (stack3.isEmpty() || stack3.peek() > num) {
                        stack3.push(num);
                    }
                }

                if (!stack2.isEmpty()) {
                    int num = stack2.pop();

                    if (stack2.isEmpty() || stack2.peek() > num) {
                        stack2.push(num);
                    }

                    if (stack3.isEmpty() || stack3.peek() > num) {
                        stack3.push(num);
                    }
                }

                if (!stack3.isEmpty()) {
                    int num = stack3.pop();

                    if (stack2.isEmpty() || stack2.peek() > num) {
                        stack2.push(num);
                    }

                    if (stack1.isEmpty() || stack1.peek() > num) {
                        stack1.push(num);
                    }
                }


            }






        }






    }


    public static void main(String[] args) {
        Solution12946 sol = new Solution12946();
        int n = 3;
        System.out.println(Arrays.deepToString(sol.solution(n)));
    }
}
