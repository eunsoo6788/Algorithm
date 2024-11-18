package programmers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution92341 {


    public int[] solution(int[] fees, String[] records) {


        // <차량 번호, 주차내역>
        Map<String, LocalDateTime> car = new HashMap<>();
        // <차량 번호, 주차 시간>
        Map<String, Integer> fare = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");

            LocalDateTime time = LocalDateTime.parse("2024-10-10 " + split[0], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            String carNumber = split[1];
            String inOut = split[2];


            if ("IN".equals(inOut)) {
                car.put(carNumber, time);
            } else {
                LocalDateTime inTime = car.get(carNumber);
                Long diffMinute = Duration.between(inTime, time).toMinutes();
                fare.put(carNumber, fare.getOrDefault(carNumber, 0 ) + diffMinute.intValue());
                car.remove(carNumber);
            }
        }


        for (String key : car.keySet()) {
            LocalDateTime inTime = car.get(key);
            Long diffMinute = Duration.between(inTime, LocalDateTime.of(2024,10,10,23,59)).toMinutes();
            fare.put(key, fare.getOrDefault(key, 0) + diffMinute.intValue());
        }


        String[][] answer = new String[fare.size()][2];
        int idx = 0;
        // 요금 계산
        for (String key : fare.keySet()) {

            int time = fare.get(key);

            int money = fees[1];
            time -= fees[0];

            if (time > 0) {
                money += (time / fees[2]) * fees[3];
                if (time % fees[2] != 0) {
                    money += fees[3];
                }
            }

            answer[idx][0] = key;
            answer[idx][1] = String.valueOf(money);

            idx++;
        }

        Arrays.sort(answer, (o1, o2) -> Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));

        int[] result = new int[answer.length];

        for (int i = 0 ; i < answer.length ; i++) {
            result[i] = Integer.parseInt(answer[i][1]);
        }


        return result;
    }

    public static void main(String[] args) {
        Solution92341 solution92341 = new Solution92341();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution92341.solution(fees, records)));

    }

}
