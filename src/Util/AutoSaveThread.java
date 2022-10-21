package Util;

import PlayerAssets.Player;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class AutoSaveThread extends Thread {
    Player p;

    public AutoSaveThread() {

    }

    public AutoSaveThread(Player p) {
        this.p = p;
    }

    @Override
    public void run() {
        Timer autoSaveTimer = new Timer();
        AutoSaveTask autoSaveTask = new AutoSaveTask(p);
        autoSaveTimer.schedule(autoSaveTask, new Date(), 5000 * 5);
    }

}
