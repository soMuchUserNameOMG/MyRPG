package Entities;

import java.io.Serial;
import java.io.Serializable;

public class Entity implements Serializable {
    @Serial
    private static final long serialVersionUID = 66666666L;

    public double HP;
    public double maxHP;
    public int level;

    public String name;
}
