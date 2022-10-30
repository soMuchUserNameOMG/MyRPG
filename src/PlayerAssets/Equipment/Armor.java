package PlayerAssets.Equipment;

import Util.GameFunctionsHelper;
import frame.Frame;

import java.io.Serial;
import java.io.Serializable;

public class Armor extends Equipment implements Serializable {
    @Serial
    private static final long serialVersionUID = 7145632L;

    public double armorValue;

    public Armor() {
    }

    public Armor(double armorValue, String name, int maxDurability) {
        this.level = 1;
        this.name = name;
        this.armorValue = armorValue;
        this.durability = maxDurability;
    }

    @Override
    public void upgrade(Frame frame) {
        frame.write(this.name+"升级了!");
        int temp = this.level;
        this.level++;
        double temp2 = this.armorValue;
        this.armorValue += 1.5;
        frame.write("等级:"+temp+"--->"+level);
        frame.write("盔甲值:"+temp2+"--->"+armorValue);
        if(this.durability < 150000) {
            int temp3 = this.durability;
            this.durability += this.level * 100;
            frame.write("耐久值:"+temp3+"--->"+durability);
        }
        frame.out();
        GameFunctionsHelper.sleep(1500);
    }
}
