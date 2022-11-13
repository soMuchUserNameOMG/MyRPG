package Entities.Monsters.Bosses;

import Buffs.Shocking;
import Item.Loot;
import PlayerAssets.Player;
import Util.GameFunctionsHelper;

import static Util.FrameUtil.FIGHT_FRAME;

public class GoblinBoss extends Boss {


    public GoblinBoss(int bossLevel) {
        this.level = bossLevel;
        this.maxHP = bossLevel * 200;
        this.HP = maxHP;
        this.defense = bossLevel * 5;
        this.name = "哥布林领主";
    }

    @Override
    public void abilityRelease1(Player player) {
        for (int j = 0;j < player.buffs.length;j++){
            if(player.buffs[j] == null){
                player.buffs[j] = new Shocking();
                FIGHT_FRAME.write("["+name+"释放了震撼吼!]");
                FIGHT_FRAME.write("[你将有一个回合无法行动!]");
                FIGHT_FRAME.out();
                return;
            }
        }
        successReleaseFlag = false;

    }

    @Override
    public void abilityRelease2(Player player) {
        FIGHT_FRAME.write("[" + name + "释放了锤击!]");
        double damage = strength + level * 2 + 10;
        FIGHT_FRAME.write("[你受到了" + damage + "点伤害]");
        FIGHT_FRAME.out();
        player.HP = player.HP - damage;
    }

    @Override
    public void abilityRelease3(Player player) {
        FIGHT_FRAME.write("[" + name + "释放了生命回复!]");
        FIGHT_FRAME.out();
        double heal = this.level * 15 + 10;
        if (this.HP + heal > this.maxHP) {
            this.HP = maxHP;
            return;
        }
        this.HP = HP + heal;
    }

    @Override
    public void info() {
        FIGHT_FRAME.write("介绍:");
        FIGHT_FRAME.write("怪物名称:" + this.name);
        FIGHT_FRAME.write("怪物属性:");
        FIGHT_FRAME.write("怪物血量:"+this.HP+"/"+this.maxHP);
        FIGHT_FRAME.write("怪物防御力:" + this.defense);
        FIGHT_FRAME.write( "怪物攻击力:" + this.strength);
        FIGHT_FRAME.write("怪物特有技能1:震撼吼(使你下一回合无法行动)");
        FIGHT_FRAME.write("怪物特有技能2:锤击(造成大量伤害)");
        FIGHT_FRAME.write("怪物特有技能3:生命回复(回复一定血量)");
        FIGHT_FRAME.write("任意键继续...");
        FIGHT_FRAME.out();
        GameFunctionsHelper.blankOperate();
    }

    @Override
    public Loot loot() {
        return new Loot (this.level * 15 + this.strength * 15 + this.defense * 10 + this.maxHP,GameFunctionsHelper.goldCalculate(this));
    }
}
