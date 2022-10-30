package PlayerAssets.Abilities;

import Entities.Monsters.Monster;
import Main.Main;
import PlayerAssets.Player;
import Util.GameFunctionsHelper;

import static Util.FrameUtil.OTHER_FRAME;

public class SelfHeal extends Ability {
    public double healValue = 30;
    public Player p;

    public SelfHeal(String name, int special, int level, int coolDown) {
        super(name, special, level, coolDown);
        this.MpReduce = 20;
    }

    @Override
    public double abilityRelease(Monster m) {
        p = Main.getPlayer();
        if (!mpJudge()) {
            OTHER_FRAME.write("你的魔力值不足以释放这个技能!");
            OTHER_FRAME.out();
            return 1;
        }
        if ((p.HP += healValue) > p.maxHP) {
            p.HP = p.maxHP;
        }
        OTHER_FRAME.write("你治疗了" + healValue + "点血量");
        OTHER_FRAME.write("你的血量:" + p.HP + "/" + p.maxHP);
        OTHER_FRAME.out();
        return 0;
    }

    @Override
    public void abilityLevelUp() {
        OTHER_FRAME.write("你选择升级了" + this.name);
        OTHER_FRAME.write(this.name + "的等级提升一级");
        OTHER_FRAME.write(this.name + "的治疗量与魔力消耗上升了");
        int temp = this.level;
        double temp2 = this.healValue;
        double temp3 = this.MpReduce;
        this.level++;
        this.healValue += 20;
        this.MpReduce += 25;
        OTHER_FRAME.write(this.name + "Lv." + temp + "--->" + "Lv." + this.level);
        OTHER_FRAME.write(this.name + "治疗量:" + temp2 + "--->" + this.healValue);
        OTHER_FRAME.write("魔力消耗:" + temp3 + "--->" + this.MpReduce);
        OTHER_FRAME.write("键入任意键继续..");
        OTHER_FRAME.out();
        GameFunctionsHelper.blankOperate();
    }

}
