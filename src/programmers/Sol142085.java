package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sol142085 {

    public int solution(int n, int k, int[] enemy) {
        int damage = 0;

        int anser = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < enemy.length; i++) {


            if (k != 0) {
                k--;
                pq.add(enemy[i]);
                anser++;

                continue;
            }

            if (pq.peek() < enemy[i]) {
                damage += pq.poll();
                pq.add(enemy[i]);
            } else {
                damage += enemy[i];
            }

            if (damage > n ) {
                break;
            }

            anser++;
        }

        return anser;
    }

    public static void main(String[] args) {
        Sol142085 sol = new Sol142085();
        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        System.out.println(sol.solution(n, k, enemy));
    }
}
