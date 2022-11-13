package Entities.Monsters;

import Buffs.Buff;
import Entities.Entity;
import Item.Loot;
import PlayerAssets.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Monster extends Entity {
    public double strength;
    public double defense;
    public Buff[] buffs = new Buff[5];

    public abstract boolean abilityRelease(Player p);

    public abstract void info();

    public abstract Loot loot();

    public void buffEffect() {
        Object[] buffs1 = this.getBuff();
        for (Object buff : buffs1) {
            if (buff instanceof Buff) {
                if (((Buff) buff).life > 0) {
                    ((Buff) buff).effect(this);
                } else {
                    ((Buff) buff).finalEffect(this);
                }
            }
        }
    }

    public void newBuff(Buff buff) {
        int isNullBuff = 0;
        for (Buff buff1 : buffs) {
            if (buff1 != null) {
                isNullBuff++;
            }
        }
        buffs[isNullBuff] = buff;
    }

    public Object[] getBuff() {
        List<Buff> activeBuffs = new ArrayList<>();
        for (Buff buff : buffs) {
            if (buff != null) {
                activeBuffs.add(buff);
            }
        }
        return activeBuffs.toArray();
    }
}
