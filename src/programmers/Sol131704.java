package programmers;

import java.util.Stack;

public class Sol131704 {

    public int solution(int[] order) {
        int answer = 0;


        Stack<Integer> stack = new Stack<>();



        for (int i = 1 ; i <= order.length; i++) {

            // 바로 물건을 싣는 경우
            if (order[answer] == i) {
                answer++;
            } else {
                stack.push(i);
            }


            // 다른 컨베이어 벨트
            boolean isOther = true;
            while (isOther && !stack.isEmpty()) {
                var value =stack.peek();

                if (value == order[answer]) {
                    stack.pop();
                    answer++;
                } else {
                    isOther = false;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Sol131704 sol = new Sol131704();
        int[] order = {4, 3, 1, 2, 5};
        System.out.println(sol.solution(order));
    }

}
