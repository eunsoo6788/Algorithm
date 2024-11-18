package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution42583 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<int[]> wait = new LinkedList<>();
        for (int wight : truck_weights) {
            wait.add(new int[]{wight, 0});
        }

        Queue<int[]> running = new LinkedList<>();

        // 첫번쨰 트럭 출발
        running.add(wait.poll());
        int time = 1;
        int truckWeight = running.peek()[0];
        for (int[] truck : running) {
            truck[1]++;
        }


        while (!running.isEmpty()) {

            // 다 건넌 트럭 제거
            int[] firstRunning = running.peek();

            if (firstRunning[1] == bridge_length) {
                running.poll();
                truckWeight -= firstRunning[0];
            }


            // 앞으로 한칸씩 전진
            for (int[] truck : running) {
                truck[1]++;
            }

            time++;

            // 추가로 더 건널 수 있는 트럭 있는지 확인
            if (!wait.isEmpty()) {
                int[] firstWait = wait.peek();
                if (firstWait[0] + truckWeight <= weight) {
                    running.add(wait.poll());
                    truckWeight += firstWait[0];
                }
            }

        }


        return time;
    }


    public static void main(String[] args) {
        Solution42583 solution42583 = new Solution42583();
        System.out.println(solution42583.solution(2, 10, new int[]{7,4,5,6}));
    }
}
