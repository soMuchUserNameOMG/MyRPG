package Entities.Monsters;

import Buffs.Poison;
import Item.Loot;
import PlayerAssets.Player;
import Util.GameFunctionsHelper;

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

    public boolean abilityRelease(Player p) {
        for(int j = 0;j < p.buffs.length;j++){
            if(p.buffs[j] instanceof Poison){
              return false;
            } else if(p.buffs[j] == null){
                p.buffs[j] = new Poison();
                FIGHT_FRAME.write("[僵尸的攻击对你造成了腐化效果(下个回合生效)!]");
                FIGHT_FRAME.out();
                return true;
            }
        }
        return false;
    }

    @Override
    public void info() {
        FIGHT_FRAME.write("介绍:");
        FIGHT_FRAME.write("怪物名称:" + this.name);
        FIGHT_FRAME.write("怪物属性:");
        FIGHT_FRAME.write("怪物最大血量:" + this.maxHP + "怪物当前血量:" + this.HP);
        FIGHT_FRAME.write("怪物防御力:" + this.defense + "怪物攻击力:" + this.strength);
        FIGHT_FRAME.write("怪物特有技能:攻击腐化");
        FIGHT_FRAME.buttonChinese("任意键继续...");
        FIGHT_FRAME.out();
        GameFunctionsHelper.blankOperate();
    }

    @Override
    public Loot loot() {
        return new Loot(Double.parseDouble(String.format("%.1f", level * 5 + strength * 15 + defense * 20 / 3)),GameFunctionsHelper.goldCalculate(this));
    }
}
