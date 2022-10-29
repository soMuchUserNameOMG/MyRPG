package Util;


import Buffs.Poison;
import Entities.Monsters.Bosses.GoblinBoss;
import Entities.Monsters.Goblin;
import Entities.Monsters.Monster;
import PlayerAssets.Player;

public class Debug {
    public static void main(String[] args) throws InterruptedException {
        init();
        Player p = new Player("adw",10);
        p.fight(new Goblin(10));
    }

    public static void init(){
        GameFileController.autoSaveThread = new AutoSaveThread();
    }
}
