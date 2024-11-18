package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Sol12941 {

    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        return answer;
    }

    public static void main(String[] args) {
        Sol12941 sol = new Sol12941();
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println(sol.solution(A, B));
    }
}
