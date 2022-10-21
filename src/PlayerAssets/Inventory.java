package PlayerAssets;

import Item.Item;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Inventory implements Serializable {
    @Serial
    private static final long serialVersionUID = 71456532L;

    public int slots;
    public ArrayList<Item> StoredItems;

    public void Collect(Item[] items) {
        StoredItems.addAll(Arrays.asList(items));
    }
}
