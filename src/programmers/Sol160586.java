package programmers;

import java.util.HashMap;
import java.util.Map;

public class Sol160586 {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {

                var existValue = 0;
                if (map.containsKey(keymap[i].charAt(j))) {
                    existValue = map.get(keymap[i].charAt(j));
                    map.put(keymap[i].charAt(j), Math.min(j+1,existValue));

                } else {
                    map.put(keymap[i].charAt(j), j+1);
                }

            }
        }


        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int[] result = new int[target.length()];

            for (int j = 0; j < target.length(); j++) {

                if (map.containsKey(target.charAt(j))) {
                    result[j] = map.get(target.charAt(j));
                } else {
                    result[j] = -1;
                }



                if (j == target.length()- 1 ){
                    for (int k = 0; k < result.length; k++) {
                        answer[i] += result[k];

                        if (result[k] == -1) {
                            answer[i] = -1;
                            break;
                        }

                    }
                }
            }
        }


        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

        return answer;
    }


    public static void main(String[] args) {
        Sol160586 sol = new Sol160586();
        String[] keymap = {"ABCDE"};
        String[] targets = {"FGHIJ"};
        System.out.println(sol.solution(keymap, targets));
    }
}
