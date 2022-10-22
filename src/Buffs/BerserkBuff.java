package Buffs;

import Entities.Entity;
import PlayerAssets.Player;
import Util.GameFileController;

public class BerserkBuff extends Buff {

    public boolean effected;
    public double temp;
    public BerserkBuff(double times,int life) {
        this.times = times;
        this.life = life;
        this.effected = false;
    }

    public double times;

    @Override
    public void effect(Entity entity) {
        if (this.effected) return;
        if (entity instanceof Player) {
            this.temp = ((Player) entity).strength;
            ((Player) entity).strength = ((Player) entity).strength * times;
            GameFileController.setStuck(true);
            this.effected = true;
        }
    }

    @Override
    public void finalEffect(Entity entity) {
        if(entity instanceof Player){
            ((Player) entity).strength = temp;
        }
        GameFileController.setStuck(false);
    }
}
