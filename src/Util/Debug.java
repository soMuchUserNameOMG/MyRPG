package Util;


import Buffs.Poison;
import Entities.Monsters.Goblin;
import Entities.Monsters.Monster;

public class Debug {
    public static void main(String[] args) throws InterruptedException {
        Monster m = new Goblin(1);
        while (m.HP > 0) {
            m.buffs[0] = new Poison(10, 1000);
            m.buffEffect();
            System.out.println(m.HP);
        }
    }
}
