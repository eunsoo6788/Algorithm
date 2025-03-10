package programmers;

import java.util.Arrays;

public class Sol388351 {

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int size = schedules.length;



        for (int person = 0 ; person < size ; person++) {

            int startTime = schedules[person] + 10;

            for (int i = 0 ; i < 7 ; i++) {

                int time = timelogs[person][i];
                int day = (i + startday - 1) % 7 + 1;

                if (day == 6 || day == 0) {
                    continue;
                }


                if (startTime % 100 >= 60) {
                    int hour = startTime / 100 + 1;
                    int minute = startTime % 100 - 60;

                    startTime = hour*100 + minute;
                }

                System.out.println(startTime);


                if (startTime < time) {
                    break;
                }

                if (i == 6) {
                    answer++;
                }

            }



        }





        return answer;
    }
}