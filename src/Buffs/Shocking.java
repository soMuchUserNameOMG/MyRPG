package Buffs;

import Entities.Entity;
import PlayerAssets.Player;

public class Shocking extends Buff {
    {
        this.life = 1;
    }

    @Override
    public void effect(Entity entity) {
        if (entity instanceof Player) {
            ((Player) entity).actChance = false;
            this.life--;

        }
    }

    @Override
    public void finalEffect(Entity entity) {
            ((Player) entity).actChance = true;
    }
}
