package programmers;

import java.util.PriorityQueue;

public class Sol138477 {

    public int[] solution(int k, int[] score) {

        int[] answer = new int[score.length];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {

            if (priorityQueue.size() >= k) {

                var compare = score[i];

                priorityQueue.add(compare);
                priorityQueue.poll();

            } else {
                priorityQueue.add(score[i]);
            }

            answer[i] = priorityQueue.peek();
        }


        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

        return answer;
    }


    public static void main(String[] args) {
        Sol138477 sol = new Sol138477();
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        System.out.println(sol.solution(k, score));
    }
}
