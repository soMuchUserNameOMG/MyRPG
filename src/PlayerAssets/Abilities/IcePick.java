package PlayerAssets.Abilities;

import Entities.Bosses.Boss;
import Entities.Monsters.Monster;
import Main.Main;
import PlayerAssets.Player;
import Util.GameFunctionsHelper;

import java.util.Random;

import static Util.FrameUtil.OTHER_FRAME;

public class IcePick extends Ability {
    public double damage = 15;

    public IcePick(String name, int special, int level, int coolDown) {
        super(name, special, level, coolDown);
        this.MpReduce = 15;
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
        if (GameFunctionsHelper.probabilityJudge(0, 50, new Random().nextInt(0, 50))) {
            OTHER_FRAME.write("你触发了冰冻迟缓效果,但暂未实现");
            OTHER_FRAME.out();
            return 0;
        }
        OTHER_FRAME.out();
        return 0;
    }

    @Override
    public double abilityRelease(Boss b) {
        Player p = Main.getPlayer();
        if (!mpJudge(p)) {
            OTHER_FRAME.write("你的魔力值不足以释放这个技能!");
            OTHER_FRAME.out();
            return 1;
        }
        OTHER_FRAME.write("你释放了冰锥术!");
        b.HP -= this.damage;
        OTHER_FRAME.write("对怪物造成了" + this.damage + "点伤害");
        if (GameFunctionsHelper.probabilityJudge(0, 50, new Random().nextInt(0, 50))) {
            OTHER_FRAME.write("你触发了冰冻迟缓效果,但暂未实现");
            OTHER_FRAME.out();
            return 0;
        }
        OTHER_FRAME.out();
        return 0;
    }

    @Override
    public void abilityLevelUp() {
        OTHER_FRAME.write("你选择升级了" + this.name);
        OTHER_FRAME.write(this.name + "的等级上升一级");
        double temp1 = this.damage;
        this.damage += 8;
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
