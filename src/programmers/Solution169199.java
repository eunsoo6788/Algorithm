package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution169199 {


    public int solution(String[] board) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();







        return answer;
    }


    private void bfs(Queue<int[]> queue, int x, int y) {



        queue.add(new int[]{x,y});


        while (!queue.isEmpty()) {



            for (int i = 0 ; i < 4 ; i++) {


                if (i == 0) {

                }



            }



        }




    }


    public static void main(String[] args) {
        Solution169199 sol = new Solution169199();
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(sol.solution(board));
    }


}
