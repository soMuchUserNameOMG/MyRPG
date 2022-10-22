package Util;

import PlayerAssets.Player;

import java.util.Date;
import java.util.Timer;

/**
 * 这个类是自动保存的线程
 */

public class AutoSaveThread extends Thread {
    Player p;
    boolean stuckFlag;

    public AutoSaveThread() {

    }

    public AutoSaveThread(Player p) {
        this.p = p;
    }

    @Override
    public void run() {
        if(!stuckFlag){
            Timer autoSaveTimer = new Timer();
            AutoSaveTask autoSaveTask = new AutoSaveTask(p);
            autoSaveTimer.schedule(autoSaveTask, new Date(), 5000 * 5);
        }
    }

}
