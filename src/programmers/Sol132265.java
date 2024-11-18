package programmers;

import java.util.HashMap;
import java.util.Map;

public class Sol132265 {

    public int solution(int[] topping) {
        int answer = 0;


        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {

            map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
            map.put(topping[i], map.get(topping[i]) - 1);

            if (map.get(topping[i]) == 0) {
                map.remove(topping[i]);
            }

            if (map.size() == map2.size()){
                answer++;
            }
        }


        return answer;
    }


    public static void main(String[] args) {
        Sol132265 sol = new Sol132265();
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(sol.solution(topping));
    }


}
