package Entities.Monsters;

import Item.Loot;
import PlayerAssets.Player;
import Util.GameFunctionsHelper;

import java.util.Random;

import static Util.FrameUtil.FIGHT_FRAME;

public class Goblin extends Monster {
    public Goblin() {
    }

    public Goblin(int mLevel) {
        this.level = mLevel;
        this.maxHP = this.level * 55;
        this.HP = this.maxHP;
        this.defense = this.level * 2;
        this.strength = this.level * 4.5 - this.level;
        this.name = "哥布林";
    }

    public boolean abilityRelease(Player p) {
        Random rd = new Random();
        if (rd.nextInt(9) == 0 | rd.nextInt(9) == 1) {
            if (this.HP < this.maxHP - 25 * this.level * 0.5) {
                this.HP = this.HP + 25 * level * 0.5;
                FIGHT_FRAME.write("[哥布林回复了一定血量]");
                FIGHT_FRAME.noCleanOut();
            } else {
                FIGHT_FRAME.write("[哥布林回复了一定血量]");
                FIGHT_FRAME.noCleanOut();
                this.HP = this.maxHP;
            }
            return true;
        }
        return false;
    }

    public void info() {
        FIGHT_FRAME.write("介绍:");
        FIGHT_FRAME.write("怪物名称:" + this.name);
        FIGHT_FRAME.write("怪物属性:");
        FIGHT_FRAME.write("怪物最大血量:" + this.maxHP + "怪物当前血量:" + this.HP);
        FIGHT_FRAME.write("怪物防御力:" + this.defense + "怪物攻击力:" + this.strength);
        FIGHT_FRAME.write("怪物特有技能:回复血量");
        FIGHT_FRAME.buttonChinese("任意键继续...");
        FIGHT_FRAME.out();
        GameFunctionsHelper.blankOperate();
    }

    public Loot loot() {
        return new Loot(level * 5 + strength * 10 + defense * 5, GameFunctionsHelper.goldCalculate(this));
    }
}
