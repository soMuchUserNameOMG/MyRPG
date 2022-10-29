package PlayerAssets.Abilities;


import Entities.Monsters.Monster;
import Util.GameFunctionsHelper;

import static Util.FrameUtil.OTHER_FRAME;

public class MutiAttack extends Ability {

    public double damage = 10;
    public int frequency = 3;

    public MutiAttack(String name, int special, int level, int coolDown) {
        super(name, special, level, coolDown);
    }

    @Override
    public double abilityRelease(Monster m) {
        double damage = this.damage * this.frequency - m.defense;
        m.HP = m.HP - damage;
        return damage;
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
        OTHER_FRAME.write(this.name + ": " + "Lv." + temp + "--->" + "Lv." + this.level);
        OTHER_FRAME.write(this.name + "伤害" + ":" + temp2 + "--->" + this.damage);
        OTHER_FRAME.write("键入任意键继续...");
        OTHER_FRAME.out();
        GameFunctionsHelper.blankOperate();
    }
}
