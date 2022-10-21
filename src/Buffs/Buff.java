package Buffs;

import Entities.Entity;

import java.io.Serial;
import java.io.Serializable;

public abstract class Buff implements Serializable {
    @Serial
    private static final long serialVersionUID = 753159753L;

    public int life;

    public int level;

    public abstract void effect(Entity entity);
}
