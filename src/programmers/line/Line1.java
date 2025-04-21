package programmers.line;

import java.util.*;

public class Line1 {

    private static Set<Integer> answerSet;
    private static int problemNum;
    private static List<int[]>[] problemsList;


    public int solution(int[][] problems) {

        problemNum = problems.length;
        problemsList = new List[problemNum];

        for (int i = 0; i < problemNum; i++) {
            problemsList[i] = new ArrayList<>();
        }

        answerSet = new HashSet<>();

        for (int i = 0; i < problemNum; i++) {
            if (problems[i][1] == 1) {
                problemsList[i].add(new int[]{problems[i][0]});
            } else {
                for (int j = 1; j <= problems[i][0] / 2; j++) {

                    problemsList[i].add(new int[]{j, problems[i][0] - j});
                }
            }
        }


        for (int i = 1; i <= problemNum; i++) {
            backTracking(0,0,0, i);
        }




        return answerSet.size();
    }


    private static void backTracking(int index, int count, int sum, int num) {



        if (count == num) {
            answerSet.add(sum);
            return;
        }

        for (int i = index; i < problemNum; i++) {

            if (problemsList[i].get(0).length == 1) {
                backTracking(i +1 , count+1, sum, num);
                backTracking(i +1 , count+1, sum + problemsList[i].get(0)[0], num);
            } else {
                backTracking(i +1 , count+1, sum, num);
                backTracking(i +1 , count+1, sum + problemsList[i].get(0)[0] + problemsList[i].get(0)[1], num);

                for (int j = 0; j < problemsList[i].size(); j++) {
                    backTracking(i +1 , count+1, sum + problemsList[i].get(j)[0], num);
                    backTracking(i +1 , count+1, sum + problemsList[i].get(j)[1], num);
                }


            }


        }


    }


    public static void main(String[] args) {
        Line1 sol = new Line1();
        int[][] A = {{6,2},{4,2}};

        System.out.println(sol.solution(A));
    }
}
