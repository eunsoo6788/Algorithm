package programmers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Solution43238 {

    /**
     * 프로그래머스
     *
     * 레벨3?
     * NOT SOL
     */

    public static long solution(int n, int[] times) {

        int time = 0;
        int person = n - 2;


        List<int[]> list = new ArrayList<>();

        list.add(new int[]{7, 0});
        list.add(new int[]{10, 0});


        while (!list.isEmpty()) {


            for (int[] arr : list) {
                arr[1]++;
            }


            time++;


            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[0] - list.get(i)[1] == 1) {
                    if (person > 0) {
                        list.add(new int[]{list.get(i)[0], 0});
                        person--;
                    }
                    list.remove(i);
                }
            }
        }


        return time;
    }


    public static void main(String[] args) {
        Solution43238 solution176962 = new Solution43238();
        int[] arr = new int[]{7, 10};
        System.out.println(solution176962.solution(6, arr));
    }

}
