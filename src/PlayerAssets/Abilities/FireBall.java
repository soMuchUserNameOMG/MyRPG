package PlayerAssets.Abilities;

import Entities.Monsters.Monster;
import Main.Main;
import PlayerAssets.Player;

import static Util.FrameUtil.OTHER_FRAME;

public class FireBall extends Ability {
    public double damage = 20;

    public FireBall(String name, int special, int level, int coolDown) {
        super(name, special, level, coolDown);
        this.MpReduce = 10;
    }

    @Override
    public double abilityRelease(Monster m) {
        Player p = Main.getPlayer();
        if (!mpJudge(p)) {
            OTHER_FRAME.write("你的魔力值不足以释放这个技能!");
            OTHER_FRAME.out();
            return 1;
        }
        OTHER_FRAME.write("你释放了" + this.name);
        m.HP -= this.damage;
        OTHER_FRAME.write("对怪物造成了" + this.damage + "点伤害");
        OTHER_FRAME.out();
        return 0;
    }

    @Override
    public void abilityLevelUp() {
        OTHER_FRAME.write("你选择升级了" + this.name);
        OTHER_FRAME.write(this.name + "的等级上升一级");
        double temp1 = this.damage;
        this.damage += 10;
        OTHER_FRAME.write("伤害:" + temp1 + "--->" + this.damage);
        if (this.level > 2 & this.level % 2 == 0) {
            double temp2 = this.MpReduce;
            this.MpReduce += 5;
            OTHER_FRAME.write("魔法值消耗:" + temp2 + "--->" + this.MpReduce);
            OTHER_FRAME.out();
        }
        OTHER_FRAME.out();
    }
}
