package programmers;

import java.util.Arrays;

public class Sol43165 {

    public int solution(int[] numbers, int target) {
        int answer = 0;




        return answer;
    }

    private void dfs(int[] numbers, int target, int sum, int index) {
        if (index == numbers.length) {
            if (sum == target) {

            }
            return;
        }

        dfs(numbers, target, sum + numbers[index], index + 1);
        dfs(numbers, target, sum - numbers[index], index + 1);
    }


    public static void main(String[] args) {
        Sol43165 sol = new Sol43165();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(sol.solution(numbers, target));
    }

}
