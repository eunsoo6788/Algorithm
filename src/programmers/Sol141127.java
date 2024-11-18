package programmers;

import java.util.HashMap;
import java.util.Map;

public class Sol141127 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;


        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> wantedMap = new HashMap<>();

        int total = 0;

        // want 배열 크기 까지만 map에 저장
        for (int i = 0; i < want.length; i++) {
            wantedMap.put(want[i], number[i]);
            total += number[i];
        }

        for (int i = 0 ; i < total; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }

        // map 크기와 want 목록 크기가 동일하면 해당 i 정답
        for (int i = 0; i < discount.length - total; i++) {


            boolean isAnswer = true;
            for (int j = 0; j < want.length; j++) {
                if (map.get(want[j]) != wantedMap.get(want[j])) {
                    isAnswer = false;
                    break;
                }
            }

            if (isAnswer) {
                answer = i + 1;
                break;
            } else {
                map.put(discount[i], map.get(discount[i]) - 1);
                map.put(discount[i + total], map.getOrDefault(discount[i + total], 0) + 1);

                if (map.get(discount[i]) == 0) {
                    map.remove(discount[i]);
                }
            }

        }




        return answer;
    }

    public static void main(String[] args) {
        Sol141127 sol = new Sol141127();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};


        System.out.println(sol.solution(want, number, discount));
    }


}
