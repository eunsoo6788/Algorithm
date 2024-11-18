package programmers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution176962 {

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int count = 0;


        Arrays.sort(plans, (o1, o2) -> {
            LocalDateTime time1 = LocalDateTime.parse("2024-10-10 " + o1[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            LocalDateTime time2 = LocalDateTime.parse("2024-10-10 " + o2[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            return time1.compareTo(time2);
        });


        // 남아있는 과제
        Stack<String[]> queue = new Stack<>();
        int remainTotalTime = 0;

        for (int i = 0; i < plans.length - 1; i++) {

            String firstSubject = plans[i][0];
            LocalDateTime firstTime = LocalDateTime.parse("2024-10-10 " + plans[i][1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            int firstRemainTime = Integer.parseInt(plans[i][2]);

            LocalDateTime secondTime = LocalDateTime.parse("2024-10-10 " + plans[i + 1][1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            int compareTime = (firstTime.plusMinutes(firstRemainTime)).compareTo(secondTime);
            long remainTime = Duration.between(firstTime.plusMinutes(firstRemainTime), secondTime).toMinutes();

            // 시간안엔 과제를 끝낼수 있는 케이스
            if (compareTime <= 0) {
                answer[count++] = firstSubject;

                // 남은 시간 총 계산
                remainTotalTime += remainTime;


                while (!queue.isEmpty() && remainTotalTime > 0) {
                    // 남은 시간에 과제를 끝낼수 있는 경우
                    if (Integer.parseInt(queue.peek()[1]) <= remainTotalTime) {
                        String[] poll = queue.pop();
                        answer[count++] = poll[0];
                        remainTotalTime -= Integer.parseInt(poll[1]);
                    } else {
                        break;
                    }
                }

                if (queue.isEmpty() || remainTotalTime <= 0) {
                    remainTotalTime = 0;
                }


            } else {
                // 시간안에 과제를 끝낼수 없는 경우
                queue.add(new String[]{firstSubject, String.valueOf(Math.abs(remainTime))});
            }


        }


        answer[count++] = plans[plans.length - 1][0];


        while (!queue.isEmpty()) {
            answer[count++] = queue.pop()[0];
        }



        return answer;

    }


    public static void main(String[] args) {
        Solution176962 solution176962 = new Solution176962();
        String[][] plans = new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        System.out.println(Arrays.toString(solution176962.solution(plans)));
    }


}
