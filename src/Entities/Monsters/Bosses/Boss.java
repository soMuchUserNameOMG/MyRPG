package Entities.Monsters.Bosses;

import Entities.Monsters.Monster;
import Item.Loot;
import PlayerAssets.Player;

import java.util.Random;

public abstract class Boss extends Monster {
    boolean successReleaseFlag = true;

    public boolean abilityRelease(Player player){
        Random abilityReleaseRd = new Random();
        int abilityReleaseCount = abilityReleaseRd.nextInt(12);
        switch (abilityReleaseCount) {
            case 1 -> {
                abilityRelease1(player);
                return successReleaseFlag;
            }
            case 2, 3 -> {
                abilityRelease2(player);
                return true;
            }
            case 4 -> {
                abilityRelease3(player);
                return true;
            }
            default -> {
                return false;
            }
        }
    }



    public abstract void abilityRelease1(Player player);

    public abstract void abilityRelease2(Player player);

    public abstract void abilityRelease3(Player player);

    public abstract void info();

    public abstract Loot loot();
}
