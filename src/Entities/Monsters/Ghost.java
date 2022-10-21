package Entities.Monsters;

import Entities.InterFaces.Dodgeable;
import PlayerAssets.Player;

import java.util.Random;
import java.util.Scanner;

import static Util.FrameUtil.FIGHT_FRAME;

public class Ghost extends Monster implements Dodgeable {
    public Ghost(int mLevel) {
        this.level = mLevel;
        this.maxHP = this.level * 30;
        this.HP = this.maxHP;
        this.defense = 0;
        this.strength = this.level * 3;
        this.name = "幽灵";
    }

    public void abilityRelease(Player p, double damage) {
        Random dodgeChanceRd = new Random();
        int dodgeChance = dodgeChanceRd.nextInt(11);
        if (dodgeChance > 7) return;
        this.HP = this.HP + damage;
        FIGHT_FRAME.write("[幽灵闪避了这次攻击]");
        FIGHT_FRAME.noCleanOut();
    }

    @Override
    public void abilityRelease(Player p) {

    }

    @Override
    public void info() {
        FIGHT_FRAME.write("介绍:");
        FIGHT_FRAME.write("怪物名称:" + this.name);
        FIGHT_FRAME.write("怪物属性:");
        FIGHT_FRAME.write("怪物最大血量:" + this.maxHP + "怪物当前血量:" + this.HP);
        FIGHT_FRAME.write("怪物防御力:" + this.defense + "怪物攻击力:" + this.strength);
        FIGHT_FRAME.write("怪物特有技能:虚实之间(有一定概率攻击不到)");
        FIGHT_FRAME.buttonChinese("任意键继续");
        FIGHT_FRAME.out();
        new Scanner(System.in).nextInt();
    }

    @Override
    public double giveExp() {
        return Double.parseDouble(String.format("%.1f", level * 25 + strength * 22 / 3));
    }
}
