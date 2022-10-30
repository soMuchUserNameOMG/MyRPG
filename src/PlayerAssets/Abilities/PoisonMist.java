package PlayerAssets.Abilities;

import Buffs.Poison;
import Entities.Monsters.Bosses.Boss;
import Entities.Monsters.Monster;
import Main.Main;
import PlayerAssets.Player;

import static Util.FrameUtil.OTHER_FRAME;

public class PoisonMist extends Ability {
    public double damage = 8;
    public int time = 3;

    public PoisonMist(String name, int special, int level, int coolDown) {
        super(name, special, level, coolDown);
        this.MpReduce = 25;
    }

    @Override
    public double abilityRelease(Monster m) {
        if (!mpJudge()) {
            OTHER_FRAME.write("你的魔力值不足以释放这个技能!");
            OTHER_FRAME.out();
            return 1;
        }
        OTHER_FRAME.write("你选择释放了" + this.name);
        if(!(m instanceof Boss)) m.newBuff(new Poison(damage, time));
        OTHER_FRAME.write("对怪物造成了中毒效果!");
        return 0;
    }

    @Override
    public void abilityLevelUp() {
        OTHER_FRAME.write("你选择升级了" + this.name);
        OTHER_FRAME.write(this.name + "的等级上升一级");
        double temp1 = this.damage;
        this.damage += 4;
        OTHER_FRAME.write("伤害:" + temp1 + "--->" + this.damage);
        if (this.level % 3 == 0) {
            int temp2 = this.time;
            this.time++;
            double temp3 = this.MpReduce;
            this.MpReduce += 10;
            OTHER_FRAME.write("毒雾持续时间:" + temp2 + "--->" + this.time);
            OTHER_FRAME.write("消耗魔力值:" + temp3 + "--->" + this.MpReduce);
        }
    }
}
