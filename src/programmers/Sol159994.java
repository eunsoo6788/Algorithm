package programmers;

import java.util.ArrayList;
import java.util.List;

public class Sol159994 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        List<String> list = new ArrayList<>();
        for (String str : goal) {
            list.add(str);
        }

        List<String> card1 = new ArrayList<>();
        for (String str : cards1) {
            card1.add(str);
        }

        List<String> card2 = new ArrayList<>();
        for (String str : cards2) {
            card2.add(str);
        }



        boolean isStart1 = true;
        boolean isStart2 = true;
        while (isStart1 || isStart2) {

            if (!card1.isEmpty()) {
                if (list.get(0).equals(card1.get(0))) {
                    list.remove(0);
                    card1.remove(0);
                    isStart1 = true;
                } else {
                    isStart1 = false;
                }


            } else {
                isStart1 = false;
            }

            if (!card2.isEmpty()) {
                if (list.get(0).equals(card2.get(0))) {
                    list.remove(0);
                    card2.remove(0);
                    isStart2 = true;
                }
                else {
                    isStart2 = false;
                }
            }
            else {
                isStart2 = false;
            }

        }


        return list.isEmpty() ? "Yes" : "No";
    }


    public static void main(String[] args) {
        Sol159994 sol = new Sol159994();
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(sol.solution(cards1, cards2, goal));
    }
}
