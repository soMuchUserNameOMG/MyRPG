package Util;

import PlayerAssets.Player;

import java.util.Date;
import java.util.Timer;

/**
 * 这个类是自动保存的线程
 */

public class AutoSaveThread extends Thread {
    Player p;
    AutoSaveTask autoSaveTask = new AutoSaveTask();

    public AutoSaveThread() {

    }

    public AutoSaveThread(Player p) {
        this.p = p;
    }

    @Override
    public void run() {
            Timer autoSaveTimer = new Timer();
            this.autoSaveTask.p = this.p;
            autoSaveTimer.schedule(autoSaveTask, new Date(), 5000 * 5);
    }

    public void setStuck(boolean b){
        this.autoSaveTask.stuckFlag = b;
    }

}
