package Util;

import PlayerAssets.Abilities.Ability;
import PlayerAssets.Abilities.EmptyAbility;
import PlayerAssets.Player;


import java.util.TimerTask;

public class AutoSaveTask extends TimerTask {
    Player p;

    public AutoSaveTask(Player p) {
        this.p = p;
    }

    public AutoSaveTask() {
    }

    @Override
    public void run() {
        for (Ability a : p.abilities) {
                if (a instanceof EmptyAbility) {
                    break;
                }
                a.LastRelease = -1;
            }
            GameFileController.savePlayer(p);
    }
}
