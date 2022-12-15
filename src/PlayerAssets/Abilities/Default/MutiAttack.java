package PlayerAssets.Abilities.Default;


import Entities.Monsters.Monster;
import PlayerAssets.Abilities.Ability;
import Util.GameFunctionsHelper;

import static Util.FrameUtil.OTHER_FRAME;

public class MutiAttack extends Ability {

    public double damage = 10;
    public int frequency = 3;

    public MutiAttack(String name, int special, int level, int coolDown) {
        super(name, special, level, coolDown);
        this.setDesc("多次连斩能够每次给敌人造成"+this.damage+"点的不俗伤害"+"并且一次性可以击打出"+this.frequency+"次攻击,且随着升级而提升");
    }

    @Override
    public double abilityRelease(Monster m) {
        return this.damage * this.frequency - m.defense;
    }

    @Override
    public void abilityLevelUp() {
        OTHER_FRAME.write("你选择升级了" + this.name + "!");
        OTHER_FRAME.write(this.name + "的等级上升一级!");
        OTHER_FRAME.write(this.name + "的伤害提升了!");
        int temp = this.level;
        double temp2 = this.damage;
        this.damage += 10;
        this.level++;
        if ((this.level % 3) == 0) {
            int temp3 = this.frequency;
            this.frequency++;
            OTHER_FRAME.write(this.name + "的连击次数上升!");
            OTHER_FRAME.write(this.name + "连击次数:" + temp3 + "--->" + this.frequency);
        }
        OTHER_FRAME.write("等级:" + temp + "--->" + this.level);
        OTHER_FRAME.write(this.name + "伤害" + ":" + temp2 + "--->" + this.damage);
        OTHER_FRAME.out();
        GameFunctionsHelper.sleep(1500);
    }
}
