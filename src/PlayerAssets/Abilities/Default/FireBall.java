package PlayerAssets.Abilities.Default;

import Buffs.Buff;
import Buffs.Burning;
import Entities.Monsters.Monster;
import Main.Main;
import PlayerAssets.Abilities.Ability;
import PlayerAssets.Player;
import Util.GameFunctionsHelper;

import java.util.Scanner;

import static Util.FrameUtil.OTHER_FRAME;

public class FireBall extends Ability {
    public double damage = 20;
    int buffLevel;
    int buffLife;

    public FireBall(String name, int special, int level, int coolDown) {
        super(name, special, level, coolDown);
        this.buffLife = 1;
        this.buffLevel = 1;
        this.setDesc("火球术可以对敌人造成"+this.damage+"点的可观伤害,并且还附带一定的燃烧效果");
        this.MpReduce = 10;
    }

    @Override
    public double abilityRelease(Monster m) {
        if (!mpJudge()) {
            OTHER_FRAME.write("你的魔力值不足以释放这个技能!");
            OTHER_FRAME.out();
            return 1;
        }
        OTHER_FRAME.write("你释放了" + this.name);
        m.HP -= this.damage;
        OTHER_FRAME.write("对怪物造成了" + this.damage + "点伤害");
        OTHER_FRAME.write("同时给怪物造成了燃烧效果");
        m.newBuff(new Burning(buffLevel,buffLife));
        OTHER_FRAME.out();
        return 0;
    }

    @Override
    public void abilityLevelUp() {
        OTHER_FRAME.write("你选择升级了" + this.name);
        OTHER_FRAME.write(this.name + "的等级上升一级");
        int temp = this.level;
        this.level++;
        OTHER_FRAME.write("等级:"+temp+"--->"+level);
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
        if(this.level % 3 == 0){
            GameFunctionsHelper.sleep(3500);
            boolean exitFlag = false;
            while(!exitFlag) {
                OTHER_FRAME.write("你可以选择升级燃烧时间或者是燃烧等级");
                OTHER_FRAME.buttonChinese("燃烧时间");
                OTHER_FRAME.buttonChinese("燃烧等级");
                OTHER_FRAME.out();
                switch (new Scanner(System.in).next()) {
                    case "1" -> {
                        int tempLife = this.buffLife;
                        this.buffLife++;
                        OTHER_FRAME.write("燃烧时间:" + tempLife + "--->" + this.buffLife);
                        OTHER_FRAME.out();
                        exitFlag = true;
                    }

                    case "2" -> {
                        int tempLevel = this.buffLevel;
                        this.buffLevel++;
                        OTHER_FRAME.write("燃烧等级:" + tempLevel + "--->" + this.buffLevel);
                        OTHER_FRAME.out();
                        exitFlag = true;
                    }

                    default -> {
                        OTHER_FRAME.write("请正确输入数值!");
                        OTHER_FRAME.out();
                    }
                }
            }
        }
        GameFunctionsHelper.sleep(1500);
    }
}
