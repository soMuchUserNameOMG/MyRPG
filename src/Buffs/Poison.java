package Buffs;

import Entities.Entity;

import static Util.FrameUtil.FIGHT_FRAME;

public class Poison extends Buff {
    public double damage;

    public Poison() {
        this.life = 3;
        this.level = 1;
        this.damage = 10;
    }

    public Poison(double damage, int life) {
        this.life = life;
        this.level = 0;
        this.damage = damage;
    }

    @Override
    public void effect(Entity entity) {
        if (entity.HP - this.damage >= 0) {
            entity.HP -= this.damage;
            FIGHT_FRAME.write("["+entity.name+"受到腐化效果,受到了"+this.damage+"点伤害!]");
        }
        else entity.HP = 0;
        this.life--;
    }

    @Override
    public void finalEffect(Entity entity) {

    }
}

