package programmers;

import java.util.Stack;

public class Sol12973 {

    public int solution(String s)
    {

        Stack<Character> stack = new Stack<>();


        for (int i = 0 ; i < s.length(); i++) {


            if (!stack.isEmpty() && s.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }


        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Sol12973 sol = new Sol12973();
        String s = "baabaa";
        System.out.println(sol.solution(s));
    }
}
