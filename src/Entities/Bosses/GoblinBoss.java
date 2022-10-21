package Entities.Bosses;

import Buffs.Shocking;
import PlayerAssets.Player;

import java.util.Random;

public class GoblinBoss extends Boss {
    boolean successReleaseFlag = true;

    public GoblinBoss(int bossLevel) {
        this.level = bossLevel;
        this.maxHP = bossLevel * 200;
        this.HP = maxHP;
        this.strength = bossLevel * 6;
        this.defense = bossLevel * 5;
        this.name = "哥布林领主";
    }

    @Override
    public boolean bossAbilityRelease(Player player) {
        Random abilityReleaseRd = new Random();
        int abilityReleaseCount = abilityReleaseRd.nextInt(12);
        switch (abilityReleaseCount) {
            case 1 -> {
                bossAbilityRelease1(player);
                return successReleaseFlag;
            }
            case 2, 3 -> {
                bossAbilityRelease2(player);
                return true;
            }
            case 4 -> {
                bossAbilityRelease3(player);
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    public void bossAbilityRelease1(Player player) {
        if (!(player.buffs[1] instanceof Shocking)) {
            player.buffs[1] = new Shocking();
            System.out.println("[" + name + "发动了震撼吼!]");
            System.out.println("你受到震撼效果,下一回合无法行动!");
        } else {
            successReleaseFlag = false;
        }

    }

    @Override
    public void bossAbilityRelease2(Player player) {
        System.out.println("[" + name + "释放了锤击!]");
        double damage = strength + level * 2 + 10;
        System.out.println("你受到了" + damage + "点伤害");
        player.HP = player.HP - damage;
    }

    @Override
    public void bossAbilityRelease3(Player player) {
        System.out.println("[" + name + "释放了生命回复!]");
        double heal = this.level * 15 + 10;
        if (this.HP + heal > this.maxHP) {
            this.HP = maxHP;
            return;
        }
        this.HP = HP + heal;
    }

    @Override
    public void info() {
        System.out.println("\n==========================");
        System.out.println("介绍:");
        System.out.println("怪物名称:" + this.name);
        System.out.println("怪物属性:");
        System.out.println("怪物最大血量:" + this.maxHP + "\n怪物当前血量:" + this.HP);
        System.out.println("怪物防御力:" + this.defense + "\n怪物攻击力:" + this.strength);
        System.out.println("怪物特有技能1:震撼吼(使你下一回合无法行动)");
        System.out.println("怪物特有技能2:锤击(造成大量伤害)");
        System.out.println("怪物特有技能3:生命回复(回复一定血量)");
        System.out.println("==========================\n");
    }

    @Override
    public int giveExp() {
        return (int) (this.level * 15 + this.strength * 15 + this.defense * 10);
    }
}
