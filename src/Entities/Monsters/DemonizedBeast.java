package Entities.Monsters;

import Item.Loot;
import PlayerAssets.Player;
import Util.GameFunctionsHelper;
import frame.Frame;

import java.util.Random;

import static Util.FrameUtil.FIGHT_FRAME;


public class DemonizedBeast extends Monster {
    public DemonizedBeast(int mLevel) {
        this.level = mLevel;
        this.maxHP = this.level * 65;
        this.HP = this.maxHP;
        this.defense = this.level * 2;
        this.strength = this.level * 5;
        this.name = "魔化野兽";
    }

    @Override
    public boolean abilityRelease(Player p) {
        Random chanceRd = new Random();
        int chance = chanceRd.nextInt(2);
        if (chance == 0) return false;
        FIGHT_FRAME.write("[魔化野兽对你进行了连击]");
        double damage = this.strength * 2 - p.defense -p.armor.armorValue;
        if (damage <= 0) damage = 1;
        p.HP = p.HP - damage;
        FIGHT_FRAME.write("[对你造成了" + damage + "点伤害]");
        FIGHT_FRAME.out();
        return true;
    }

    @Override
    public void info() {
        Frame f = new Frame();
        f.write("介绍:");
        f.write("怪物名称:" + this.name);
        f.write("怪物属性:");
        f.write("怪物最大血量:" + this.maxHP + "怪物当前血量:" + this.HP);
        f.write("怪物防御力:" + this.defense + "怪物攻击力:" + this.strength);
        f.write("怪物特有技能:连击");
        f.buttonChinese("任意键继续...");
        f.out();
        GameFunctionsHelper.blankOperate();
    }

    @Override
    public Loot loot() {
        return new Loot(Double.parseDouble(String.format("%.1f", level * 6 + strength * 8 + defense * 10 / 3)),GameFunctionsHelper.goldCalculate(this));
    }

}
