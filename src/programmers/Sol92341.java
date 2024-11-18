package programmers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Sol92341 {

    public int[] solution(int[] fees, String[] records) {

        Map<String, LocalDateTime> map = new HashMap<>();
        Map<String, Integer> priceMap = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String time = "2024-10-10 " + split[0];
            String car = split[1];
            String inOut = split[2];

            if (inOut.equals("IN")) {
                map.put(car, LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            } else {
                LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                Duration diff = Duration.between(LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), map.get(car));

                long minutes = diff.toMinutes();

                // 요금 계산
                if (minutes <= fees[0]) {
                    priceMap.put(car, priceMap.getOrDefault(car,0) + fees[1]);
                } else {
                    long over = minutes - fees[0];
                    long overFee = (over / fees[2]) * fees[3];
                    if (over % fees[2] != 0) {
                        overFee += fees[3];
                    }

                    priceMap.put(car, priceMap.getOrDefault(car,0) +  (int) (fees[1] + overFee));
                }

                map.remove(car);
            }




        }


//        for (String key : map.keySet()) {
//            Duration diff = Duration.between(LocalDateTime.parse("2024-10-10 23:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), map.get(key));
//            long minutes = diff.toMinutes();
//
//            // 요금 계산
//            if (minutes <= fees[0]) {
//                priceMap.put(key, priceMap.getOrDefault(key,0) + fees[1]);
//            } else {
//                long over = minutes - fees[0];
//                long overFee = (over / fees[2]) * fees[3];
//                if (over % fees[2] != 0) {
//                    overFee += fees[3];
//                }
//
//                priceMap.put(key, priceMap.getOrDefault(key,0) +  (int) (fees[1] + overFee));
//            }
//
//            map.remove(key);
//        }

        return priceMap.keySet()
                .stream()
                .sorted()
                .mapToInt(priceMap::get)
                .toArray();
    }




    public static void main(String[] args) {
        Sol92341 sol = new Sol92341();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {
            "05:34 5961 IN",
            "06:00 0000 IN",
            "06:34 0000 OUT",
            "07:59 5961 OUT",
            "07:59 0148 IN",
            "18:59 0000 IN",
            "19:09 0148 OUT",
            "22:59 5961 IN",
            "23:00 5961 OUT"
        };
        System.out.println(Arrays.toString(sol.solution(fees, records)));
    }



}
