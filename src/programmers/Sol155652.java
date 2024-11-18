package programmers;

import java.util.HashMap;
import java.util.Map;

public class Sol155652 {

    public String solution(String s, String skip, int index) {
        String answer = "";

        String[] alpha = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Map<String, Integer> map = new HashMap<>();

        String[] skipArr = skip.split("");
        String[] strArr = s.split("");

        for (int i =0 ; i < alpha.length; i++) {
            map.put(alpha[i], i);
        }

        for (int i = 0; i < strArr.length; i++) {

            int strIndex = map.get(strArr[i]);

            for (int j = 0; j < index; j++) {
                strIndex++;

                if (strIndex == 26) {
                    strIndex = 0;
                }

                for (int k = 0; k < skipArr.length; k++) {
                    if (alpha[strIndex].equals(skipArr[k])) {
                        strIndex++;
                    }
                }
            }

            answer += alpha[strIndex];
        }


        return answer;
    }

    public static void main(String[] args) {
        Sol155652 sol = new Sol155652();
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(sol.solution(s, skip, index));
    }


}
