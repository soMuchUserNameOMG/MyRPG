package PlayerAssets.Abilities;

import Entities.Bosses.Boss;
import Entities.Monsters.Monster;
import PlayerAssets.Player;

import java.io.Serial;
import java.io.Serializable;

public abstract class Ability implements Serializable {
    @Serial
    private static final long serialVersionUID = 1500122385L;
    public double MpReduce;

    public String name;
    public int level;
    public int coolDown;
    public int special;
    public int LastRelease = -1;

    public Ability(String name, int special, int level, int coolDown) {
        this.name = name;
        this.special = special;
        this.level = level;
        this.coolDown = coolDown;
    }

    public abstract double abilityRelease(Monster m);

    public abstract double abilityRelease(Boss b);

    public boolean isCoolingDown(int fightCount) {
        if ((fightCount - LastRelease) >= coolDown) {
            return false;
        } else if ((fightCount - LastRelease) < coolDown) {
            return true;
        } else {
            return true;
        }
    }

    public abstract void abilityLevelUp();

    public boolean mpJudge(Player p) {
        return !(p.MP - this.MpReduce < 0);
    }
}
