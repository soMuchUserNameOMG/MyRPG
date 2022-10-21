package Entities.Monsters;

import Buffs.Poison;
import PlayerAssets.Player;

import java.util.Scanner;

import static Util.FrameUtil.FIGHT_FRAME;

public class Zombie extends Monster {
    public Zombie(int mLevel) {
        this.level = mLevel;
        this.maxHP = this.level * 50;
        this.HP = this.maxHP;
        this.defense = this.level * 1.5;
        this.strength = this.level * 4;
        this.name = "僵尸";
    }

    public void abilityRelease(Player p) {
        if (p.buffs[0] == null) {
            p.buffs[0] = new Poison();
        }
    }

    @Override
    public void info() {
        FIGHT_FRAME.write("介绍:");
        FIGHT_FRAME.write("怪物名称:" + this.name);
        FIGHT_FRAME.write("怪物属性:");
        FIGHT_FRAME.write("怪物最大血量:" + this.maxHP + "怪物当前血量:" + this.HP);
        FIGHT_FRAME.write("怪物防御力:" + this.defense + "怪物攻击力:" + this.strength);
        FIGHT_FRAME.write("怪物特有技能:攻击腐化");
        FIGHT_FRAME.buttonChinese("任意键继续");
        FIGHT_FRAME.out();
        new Scanner(System.in).nextInt();
    }

    @Override
    public double giveExp() {
        return Double.parseDouble(String.format("%.1f", level * 5 + strength * 15 + defense * 20 / 3));
    }
}
