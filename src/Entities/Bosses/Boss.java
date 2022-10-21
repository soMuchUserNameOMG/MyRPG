package Entities.Bosses;

import Entities.Entity;
import PlayerAssets.Player;

public abstract class Boss extends Entity {
    public double strength;
    public double defense;
    public String name;

    public abstract boolean bossAbilityRelease(Player player);

    public abstract void bossAbilityRelease1(Player player);

    public abstract void bossAbilityRelease2(Player player);

    public abstract void bossAbilityRelease3(Player player);

    public abstract void info();

    public abstract int giveExp();
}
