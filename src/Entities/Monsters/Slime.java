package Entities.Monsters;

import PlayerAssets.Player;

import java.util.Scanner;

import static Util.FrameUtil.FIGHT_FRAME;

public class Slime extends Monster {
    public Slime(int mLevel) {
        this.level = mLevel;
        this.maxHP = this.level * 65;
        this.HP = this.maxHP;
        this.defense = 5;
        this.strength = this.level * 3;
        this.name = "史莱姆";
    }

    @Override
    public void abilityRelease(Player p) {
        this.HP += Math.round(Math.pow(1.41421, level + 2));
        FIGHT_FRAME.write("[史莱姆缓慢聚合中]");
        FIGHT_FRAME.noCleanOut();
    }

    @Override
    public void info() {
        FIGHT_FRAME.write("介绍:");
        FIGHT_FRAME.write("怪物名称:" + this.name);
        FIGHT_FRAME.write("怪物属性:");
        FIGHT_FRAME.write("怪物最大血量:" + this.maxHP + "怪物当前血量:" + this.HP);
        FIGHT_FRAME.write("怪物防御力:" + this.defense + "怪物攻击力:" + this.strength);
        FIGHT_FRAME.write("怪物特有技能:自聚合(缓慢回复生命值)");
        FIGHT_FRAME.buttonChinese("任意键继续");
        FIGHT_FRAME.out();
        new Scanner(System.in).nextInt();
    }

    @Override
    public double giveExp() {
        return level * 15 + strength * 10 + defense * 10;
    }
}
