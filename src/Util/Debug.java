package Util;


import Buffs.Poison;
import Entities.Monsters.Bosses.GoblinBoss;
import Entities.Monsters.Goblin;
import Entities.Monsters.Monster;
import PlayerAssets.Abilities.Ability;
import PlayerAssets.Player;

public class Debug {
    static Player p = new Player("DebugPlayer",10);
    public static void main(String[] args) throws InterruptedException {
        init();
        p.fight(new Goblin(10));
    }

    public static void init(){
        for (Ability a : p.abilities
                ) {
            a.p = p;
        }
        GameFileController.autoSaveThread = new AutoSaveThread();
    }
}
