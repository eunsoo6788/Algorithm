package programmers;

public class Sol172927 {

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int diamond = 0;
        int iron = 0;
        int stone = 0;

        for (String mineral : minerals) {
            if (mineral.equals("diamond")) {
                diamond++;
            } else if (mineral.equals("iron")) {
                iron++;
            } else {
                stone++;
            }
        }


        // 동일한 종류의 광물을 뽑는 경우
        if (diamond < picks[0]) {
            answer += diamond;
            picks[0] -= diamond;
            diamond = 0;
        } else {
            answer += picks[0];
            diamond -= picks[0];
            picks[0] = 0;
        }

        if (iron < picks[1]) {
            answer += iron;
            picks[1] -= iron;
            iron = 0;
        } else {
            answer += picks[1];
            iron -= picks[1];
            picks[1] = 0;
        }

        if (stone < picks[2]) {
            answer += stone;
            picks[2] -= stone;
            stone = 0;
        } else {
            answer += picks[2];
            stone -= picks[2];
            picks[2] = 0;
        }


        // 서로 다른 종류의 광물을 뽑는 경우
        if (iron < picks[0]) {
            answer += iron;
            picks[0] -= iron;
            iron = 0;
        } else {
            answer += picks[0];
            iron -= picks[0];
            picks[0] = 0;
        }


        if (stone < picks[1]) {
            answer += stone;
            picks[1] -= stone;
            stone = 0;
        } else {
            answer += picks[1];
            stone -= picks[1];
            picks[1] = 0;
        }


        if (stone < picks[0]) {
            answer += stone;
            picks[0] -= stone;
            stone = 0;
        } else {
            answer += picks[0];
            stone -= picks[0];
            picks[0] = 0;
        }



        if (diamond < picks[1]) {
            answer += diamond * 5;
            picks[1] -= diamond;
            diamond = 0;
        } else {
            answer += picks[1] * 5;
            diamond -= picks[1];
            picks[1] = 0;
        }

        if (iron < picks[2]) {
            answer += iron * 5;
            picks[2] -= iron;
            iron = 0;
        } else {
            answer += picks[2] * 5;
            iron -= picks[2];
            picks[2] = 0;
        }


        if (diamond < picks[2]) {
            answer += diamond * 25;
            picks[2] -= diamond;
            diamond = 0;
        } else {
            answer += picks[2] * 25;
            diamond -= picks[2];
            picks[2] = 0;
        }



        return answer;
    }


    public static void main(String[] args) {
        Sol172927 sol = new Sol172927();
        int[] picks = {1,3,2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(sol.solution(picks, minerals));
    }


}
