package Buffs;

import Entities.Entity;

import static Util.FrameUtil.FIGHT_FRAME;

public class Burning extends Buff{
    double damage;

    public Burning(int level,int life){
        this.level = level;
        this.life = life;
        this.damage = level * 3 + 2;
    }

    @Override
    public void effect(Entity entity) {
        if (entity.HP - this.damage >= 0) {
            entity.HP -= this.damage;
            FIGHT_FRAME.write("["+entity.name+"受到燃烧效果,受到了"+this.damage+"点伤害!]");
        }
        else entity.HP = 0;
        this.life--;
    }

    @Override
    public void finalEffect(Entity entity) {

    }
}
