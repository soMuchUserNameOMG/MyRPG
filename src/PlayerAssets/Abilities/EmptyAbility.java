package PlayerAssets.Abilities;

import Entities.Monsters.Monster;

public class EmptyAbility extends Ability {

    public EmptyAbility(String name, int special, int level, int coolDown) {
        super(name, special, level, coolDown);
    }

    @Override
    public double abilityRelease(Monster m) {
        return 1;
    }

    @Override
    public void abilityLevelUp() {

    }
}
