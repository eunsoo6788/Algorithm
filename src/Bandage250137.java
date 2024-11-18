import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bandage250137 {


    public int solution(int[] bandage, int health, int[][] attacks) {

        int endTimeSeconds = attacks[attacks.length-1][0];

        int bandageAdditionalCount = bandage[0];
        int bandageHeal = bandage[1];
        int bandageAdditionalHeal = bandage[2];
        int bandageSuccessCount = 0;
        int maxHealth = health;

        List<MonsterAttack> monsterAttacks = new ArrayList<>();
        addMonsterAttacks(attacks, monsterAttacks);




        for (int time =1 ; time <= endTimeSeconds ; time++) {

            // 몬스터 공격
            if (time == monsterAttacks.get(0).getTime()){
                health -= monsterAttacks.get(0).getDamage();
                monsterAttacks.remove(0);
                bandageSuccessCount = 0;

                if (health <= 0){
                    health = -1;
                    break;
                }


            } else {
                // 밴드지 사용
                health += bandageHeal;

                bandageSuccessCount ++;
                // 추가 치료
                if (bandageSuccessCount == bandageAdditionalCount){
                    health += bandageAdditionalHeal;
                    bandageSuccessCount = 0;
                }

                if (health > maxHealth) {
                    health = maxHealth;
                }

            }



            System.out.println(health);

        }





        return health;
    }



    private void addMonsterAttacks(int[][] attacks, List<MonsterAttack> monsterAttacks) {
        monsterAttacks.addAll(Arrays.stream(attacks)
                .map(attack -> new MonsterAttack(attack[0], attack[1]))
                .collect(Collectors.toList()));
    }



    class MonsterAttack {
        int time;
        int damage;

        public MonsterAttack(int time, int damage) {
            this.time = time;
            this.damage = damage;
        }

        public int getTime() {
            return time;
        }

        public int getDamage() {
            return damage;
        }
    }





}
