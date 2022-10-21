package PlayerAssets.Abilities;

import Buffs.BerserkBuff;
import Entities.Bosses.Boss;
import Entities.Monsters.Monster;
import Main.Main;
import PlayerAssets.Player;

import static Util.FrameUtil.OTHER_FRAME;

public class Berserk extends Ability {
    public double times = 1.5;
    public int time = 2;

    public Berserk(String name, int special, int level, int coolDown) {
        super(name, special, level, coolDown);
        this.MpReduce = 35;
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
        OTHER_FRAME.write("你的力量增幅了" + this.times + "倍!");
        OTHER_FRAME.out();
        p.buffs[2] = new BerserkBuff(times,time);
        p.MP -= this.MpReduce;
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
        OTHER_FRAME.write("你释放了" + this.name);
        OTHER_FRAME.write("你的力量增幅了" + this.times + "倍!");
        OTHER_FRAME.out();
        p.buffs[2] = new BerserkBuff(times,time);
        p.MP -= this.MpReduce;
        return 0;
    }

    @Override
    public void abilityLevelUp() {
        OTHER_FRAME.write("你选择升级了" + this.name);
        OTHER_FRAME.write(this.name + "的等级上升一级");
        double temp = times;
        times += 0.5;
        OTHER_FRAME.write("力量提升倍数:" + temp + "--->" + times);
        if (this.level % 4 == 0) {
            int temp2 = time;
            time++;
            OTHER_FRAME.write("持续时间:" + temp2 + "--->" + time);
            double temp3 = MpReduce;
            MpReduce += 15;
            OTHER_FRAME.write("消耗魔力值:" + temp3 + "--->" + MpReduce);
        }
    }
}
