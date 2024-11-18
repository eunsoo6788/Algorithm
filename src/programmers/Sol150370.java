package programmers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sol150370 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();

        LocalDate now = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        Map<String, Integer> map = new HashMap<>();

        for (String term : terms) {
            String[] split = term.split(" ");
            map.put(split[0], Integer.parseInt(split[1]));
        }

        int count = 1;
        for (String privacy : privacies) {
            String[] split = privacy.split(" ");
            LocalDate date = LocalDate.parse(split[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));

            if (now.isAfter(date.plusMonths(map.get(split[1])))) {
                list.add(count);
            }

            if (now.equals(date.plusMonths(map.get(split[1])))) {
                list.add(count);
            }

            count++;
        }



        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    public static void main(String[] args) {
        Sol150370 sol = new Sol150370();
        String today = "2021.07.01";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(sol.solution(today, terms, privacies));
    }
}
