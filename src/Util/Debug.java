package Util;


import Buffs.Poison;
import Entities.Monsters.Bosses.GoblinBoss;
import Entities.Monsters.Goblin;
import Entities.Monsters.Monster;
import Entities.NPCs.Armorer;
import PlayerAssets.Abilities.Ability;
import PlayerAssets.Abilities.Default.*;
import PlayerAssets.Player;
import frame.Frame;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import static Util.FrameUtil.OTHER_FRAME;

public class Debug {
    static Player p = new Player("DebugPlayer",10);
    public static void main(String[] args) throws InterruptedException {
        getAllDefaultAbilities();
        init();
        new Scanner(System.in).nextLine();
        addPoints();
        p.assignSkillPoints(new Frame());
        p.fight(new Goblin(20));
    }

    public static void init(){
        for (Ability a : p.abilities
                ) {
            a.p = p;
        }
        GameFileController.autoSaveThread = new AutoSaveThread();
    }

    public static void getAllDefaultAbilities(){
        p.abilities[0] = new MutiAttack("多次连斩", 0, 1, 3);
        p.abilities[1] = new SelfHeal("治疗术", 1, 1, 2);
        p.abilities[2] = new FireBall("爆裂火球", 1, 1, 3);
        p.abilities[3] = new IcePick("冰锥术", 1, 1, 3);
        p.abilities[4] = new PoisonMist("毒雾术", 1, 1, 4);
        p.abilities[5] = new Berserk("狂暴", 1, 1, 4);
    }

    public static void addPoints(){
        p.freeSkillPoints += 100;
    }
}
