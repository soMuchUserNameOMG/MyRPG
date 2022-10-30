package PlayerAssets.Equipment;

import Util.GameFunctionsHelper;
import frame.Frame;

import java.io.Serial;
import java.io.Serializable;

public class Weapon extends Equipment implements Serializable {
    @Serial
    private static final long serialVersionUID = 159753061123L;

    public double damage;

    public Weapon(String name, double damage, int maxDurability) {
        this.level = 1;
        this.name = name;
        this.damage = damage;
        this.durability = maxDurability;
    }

    public Weapon() {

    }

    @Override
    public void upgrade(Frame frame) {
        frame.write(this.name+"升级了!");
        int temp = this.level;
        this.level++;
        double temp2 = this.damage;
        this.damage += 5;
        frame.write("等级:"+temp+"--->"+level);
        frame.write("伤害:"+temp2+"--->"+damage);
        if(this.durability < 150000) {
            int temp3 = this.durability;
            this.durability += this.level * 100;
            frame.write("耐久值:"+temp3+"--->"+durability);
        }
        frame.out();
        GameFunctionsHelper.sleep(1500);
    }
}
