package Util;

import PlayerAssets.Abilities.Ability;
import PlayerAssets.Abilities.Default.EmptyAbility;
import PlayerAssets.Player;


import java.util.TimerTask;

public class AutoSaveTask extends TimerTask {
    Player p;
    public volatile boolean stuckFlag;

    public AutoSaveTask(Player p) {
        this.p = p;
    }

    public AutoSaveTask() {
    }

    @Override
    public void run() {
        if(!stuckFlag) {
            for (Ability a : p.abilities) {
                if (a instanceof EmptyAbility) {
                    break;
                }
                a.LastRelease = -1;
            }
            GameFileController.savePlayer(p);
        }
    }
}
