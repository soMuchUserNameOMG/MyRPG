package PlayerAssets.Equipment;

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
    public void reinForce() {

    }
}
