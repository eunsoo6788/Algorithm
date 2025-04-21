package programmers.line;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Line3 {



    public int solution(String[] code) {
        int answer = 0;

        Set<String> set = new HashSet<>();

        for (int i = 0; i < code.length; i++) {

            String s = code[i];
            String newS = "";
            for (int j = 0; j < s.length(); j++) {

                if (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    newS += "0";
                } else {
                    newS += s.charAt(j);
                }


            }

            if (set.contains(newS)) {
                answer++;
            } else {
                set.add(newS);
            }



        }




        return answer;
    }


    public static void main(String[] args) {
        Line3 sol = new Line3();
        String[] code = {"1A1AA","2B2BB","3C3CC", "4D4DD", "56789"};

        System.out.println(sol.solution(code));
    }
}
