package PlayerAssets.Equipment;

import java.io.Serial;
import java.io.Serializable;

public abstract class Equipment implements Serializable,Upgradeable {
    @Serial
    private static final long serialVersionUID = 654654654654L;

    public String name;
    public int durability;
    public int maxDurability;
    public int level;

}
