package lesson6;

import java.util.Random;

public abstract class SuperHero {
    protected String name;
    protected int attack;
    protected float health;
    protected int defence;
    private final Random random = new Random();

    public SuperHero(String name, int attack, float health, int defence) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.defence = defence;
    }
    public void attack(SuperHero hero){
        // в качестве аргумента в метод передается герой, которого нужно атаковать
        // от показателя здоровья атакуемого героя отнимается показатель атаки атакующего героя
        // атаковать можно, если герой не мертв
        float dealDamage = this.attack + (this.attack - ((float)this.attack / this.defence)); //переменная уменьшает показатель атаки на показатель защиты
        if (!hero.isDead()) {
            hero.health -= dealDamage;
            System.out.println(this.name + " атаковал " + hero.name + " на " + dealDamage + " HP " + hero.name + " = "
            + hero.health);
        } else {
            System.out.println(hero.name + " мертв " + hero.isDead());
        }
    }
    //метод, ограничивающий здоровье, т.е. если здоровье <=0, то возвращается true, т.е. герой мертв
    public boolean isDead (){
        return this.health <= 0;
    }
    public void healSelf(){
        float sumHeal = 0.1f * this.defence; //увеличиваем здоровье на 0,01 от уровня защиты
        this.health += sumHeal;
        System.out.println(this.name + " полечился на " + sumHeal);

    }
    public String getHeroInfo(){
        return name + " HP: " + health;
    }


//  public String getName() {
//        return name;
//    }

    public int getAttack() {
        return attack;
    }

//    public int getHealth() {
//        return health;
//    }

    public int getDefence() {
        return defence;
    }
}
