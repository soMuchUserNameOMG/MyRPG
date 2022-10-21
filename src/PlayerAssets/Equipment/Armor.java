package PlayerAssets.Equipment;

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
    public void reinForce() {

    }
}
