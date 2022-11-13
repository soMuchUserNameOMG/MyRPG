package Entities.Monsters;

import Entities.InterFaces.Dodgeable;
import Item.Loot;
import PlayerAssets.Player;
import Util.GameFunctionsHelper;

import java.util.Random;

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

    public boolean abilityRelease(Player p, double damage) {
        Random dodgeChanceRd = new Random();
        int dodgeChance = dodgeChanceRd.nextInt(10);
        if (dodgeChance > 5) return false;
        this.HP = this.HP + damage;
        FIGHT_FRAME.write("[幽灵闪避了这次攻击]");
        FIGHT_FRAME.noCleanOut();
        return true;
    }

    @Override
    public boolean abilityRelease(Player p) {

        return false;
    }

    @Override
    public void info() {
        FIGHT_FRAME.write("介绍:");
        FIGHT_FRAME.write("怪物名称:" + this.name);
        FIGHT_FRAME.write("怪物属性:");
        FIGHT_FRAME.write("怪物最大血量:" + this.maxHP + "怪物当前血量:" + this.HP);
        FIGHT_FRAME.write("怪物防御力:" + this.defense + "怪物攻击力:" + this.strength);
        FIGHT_FRAME.write("怪物特有技能:虚实之间(有一定概率攻击不到)");
        FIGHT_FRAME.buttonChinese("任意键继续...");
        FIGHT_FRAME.out();
        GameFunctionsHelper.blankOperate();
    }

    @Override
    public Loot loot() {
        return new Loot(Double.parseDouble(String.format("%.1f", level * 25 + strength * 22 / 3)), GameFunctionsHelper.goldCalculate(this));
    }
}
