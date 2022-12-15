package PlayerAssets.Abilities.Default;

import Entities.Monsters.Monster;
import PlayerAssets.Abilities.Ability;

public class EmptyAbility extends Ability {

    public EmptyAbility(String name, int special, int level, int coolDown) {
        super(name, special, level, coolDown);
        this.setDesc("空");
    }

    @Override
    public double abilityRelease(Monster m) {
        return 1;
    }

    @Override
    public void abilityLevelUp() {

    }
}
