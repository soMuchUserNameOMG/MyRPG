package Buffs;

import Entities.Entity;
import PlayerAssets.Player;

public class BerserkBuff extends Buff {

    public boolean effected;
    public BerserkBuff(double times,int life) {
        this.times = times;
        this.life = life;
        this.effected = false;
    }

    public double times;

    @Override
    public void effect(Entity entity) {
        if (entity instanceof Player) {
            if (this.effected) return;
            double temp = ((Player) entity).strength;
            ((Player) entity).strength = ((Player) entity).strength * times;
            if (this.life == 0) {
                ((Player) entity).strength = temp;
            }
        }
    }
}
