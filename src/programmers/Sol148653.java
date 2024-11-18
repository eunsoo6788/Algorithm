package programmers;

import java.util.HashMap;
import java.util.Map;

public class Sol148653 {

    public int solution(int storey) {
        int answer = 0;

        int addition = 0;



        if (storey%10 + addition >= 6) {
            answer += 10 - storey%10;
            addition = 1;
            storey /= 10;
        } else {
            answer += storey%10;
            addition = 0;
            storey /= 10;
        }


        while (storey/10 > 0) {

            var namogy = storey%10;

            if (namogy + addition >= 6) {
                answer += 10 - namogy;
                addition = 1;
                storey /= 10;
            } else {
                answer += namogy;
                addition = 0;
                storey /= 10;
            }


        }






        return answer + storey%10 + addition;
    }


    public static void main(String[] args) {
        Sol148653 sol = new Sol148653();
        int storey = 16;
        System.out.println(sol.solution(storey));
    }

}
