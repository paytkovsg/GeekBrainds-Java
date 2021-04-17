package lesson6;

import java.sql.SQLOutput;

public class Homework6 {
    private static int round = 1;

    public static void main(String[] args) {
//        String exampleString = "Example";
//        long startTime = System.nanoTime();
//        for (int i = 0; i < 100; i++) {
//            exampleString += i;
//
//        }
//        float deltaTime = System.nanoTime() - startTime;
//        System.out.println(exampleString);
//        System.out.println("work time string" + deltaTime * 0.000001f);

        //создаем героев
        LigthHero ligthHero = new LigthHero("LigthHero", 5, 100, 20);
        DarkHero darkHero = new DarkHero("DarkHero", 10, 150, 5);

        System.out.println(ligthHero.getHeroInfo());
        System.out.println(darkHero.getHeroInfo());

        while (!ligthHero.isDead() || !darkHero.isDead()) {
            System.out.println("**** Round " + round + " ****");
            ligthHero.attack(darkHero);
            if (darkHero.isDead()) {
                System.out.println("lightHero win");
                break;
            }
            darkHero.attack(ligthHero);
            if (ligthHero.isDead()) {
                System.out.println("darkHero win");
                break;
            }
            ligthHero.healSelf();
            darkHero.healSelf();
            System.out.println(ligthHero.getHeroInfo());
            System.out.println(darkHero.getHeroInfo());
            round++;
        }










    }
}
