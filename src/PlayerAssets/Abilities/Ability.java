package PlayerAssets.Abilities;

import Entities.Monsters.Bosses.Boss;
import Entities.Monsters.Monster;
import PlayerAssets.Player;

import java.io.Serial;
import java.io.Serializable;

import static Util.FrameUtil.OTHER_FRAME;

public abstract class Ability implements Serializable {
    @Serial
    private static final long serialVersionUID = 1500122385L;
    public double MpReduce;

    public String name;
    public int level;
    public int coolDown;
    public int special;
    public int LastRelease = -1;

    public Player p;

    private String desc;

    public Ability(String name, int special, int level, int coolDown) {
        this.name = name;
        this.special = special;
        this.level = level;
        this.coolDown = coolDown;
    }

    public abstract double abilityRelease(Monster m);

    public boolean isCoolingDown(int fightCount) {
        if ((fightCount - LastRelease) >= coolDown) {
            return false;
        } else if ((fightCount - LastRelease) < coolDown) {
            return true;
        } else {
            return true;
        }
    }

    public abstract void abilityLevelUp();

    public boolean mpJudge() {
        return !(p.MP - this.MpReduce < 0);
    }

    public void info(){
        OTHER_FRAME.write("技能名:"+this.name);
        OTHER_FRAME.write("等级:"+this.level);
        OTHER_FRAME.write("消耗MP:"+this.MpReduce);
        OTHER_FRAME.write("释放间隔:"+this.coolDown);
        OTHER_FRAME.write(this.getDesc());
        OTHER_FRAME.write("=================================================================================================");
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }
}
