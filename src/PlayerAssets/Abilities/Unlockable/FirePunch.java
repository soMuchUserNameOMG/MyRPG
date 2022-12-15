package PlayerAssets.Abilities.Unlockable;

import Entities.Monsters.Monster;
import PlayerAssets.Abilities.Ability;

public class FirePunch extends Ability {
    public FirePunch(String name, int special, int level, int coolDown) {
        super(name, special, level, coolDown);
    }

    @Override
    public double abilityRelease(Monster m) {

        return 0;
    }

    @Override
    public void abilityLevelUp() {

    }
}
