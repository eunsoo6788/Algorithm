package programmers;

public class Sol172928 {

    public int[] solution(String[] park, String[] routes) {

        int[] answer = new int[2];
        String[][] map = new String[park.length][park[0].length()];

        int x = 0;
        int y = 0;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                map[i][j] = park[i].charAt(j) + "";
                if (map[i][j].equals("S")) {
                    x = i;
                    y = j;
                }
            }
        }


        int beforeX = x;
        int beforeY = y;
        for (int i = 0; i < routes.length ; i++ ){
            String[] route = routes[i].split(" ");

            for (int j = 0 ; j < Integer.parseInt(route[1]) ; j++) {
                if (route[0].equals("E")) {
                    y++;
                } else if (route[0].equals("W")) {
                    y--;
                } else if (route[0].equals("S")) {
                    x++;
                } else if (route[0].equals("N")) {
                    x--;
                }

                int result = failCheck(x, y, map);


                if (result == -1) {
                    x = beforeX;
                    y = beforeY;

                    break;
                }

            }

            beforeX = x;
            beforeY = y;

        }



        return new int[]{x, y};
    }


    private int failCheck(int x, int y, String[][] map) {
        if (x >= 0 && y >= 0 && x < map.length && y < map[0].length) {
            if (map[x][y].equals("O") || map[x][y].equals("S")) {
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Sol172928 sol = new Sol172928();
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        System.out.println(sol.solution(park, routes));
    }
}
