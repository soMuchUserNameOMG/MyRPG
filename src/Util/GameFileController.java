package Util;


import Main.Main;
import PlayerAssets.Player;

import java.io.*;

public class GameFileController {

    public static AutoSaveThread autoSaveThread;
    public static void savePlayer(Player p) {
        try {
            File gameData = new File("GameData");
            if (!gameData.exists()) {
                gameData.mkdirs();
            }
            ObjectOutputStream playerSaveStream = new ObjectOutputStream(new FileOutputStream("GameData/Player.data"));
            playerSaveStream.writeObject(p);
            playerSaveStream.flush();
            playerSaveStream.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public static Player loadPlayer() {
        try {
            File playerData = new File("GameData/Player.data");
            if (!playerData.exists()) {
                //System.out.println("错误!存档不存在!");
                return null;
            }
            try (ObjectInputStream playerLoadStream = new ObjectInputStream(new FileInputStream("GameData/Player.data"))) {
                return (Player) playerLoadStream.readObject();
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    public static void autoSave(Player p) {
        if (p == null) {
            return;
        }
        autoSaveThread = new AutoSaveThread(p);
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();
    }

    public static void saveMain(Main main) {
        File dataFile = new File("GameData");
        if (!dataFile.exists()) {
            dataFile.mkdirs();
        }
        try {
            ObjectOutputStream mainSaveStream = new ObjectOutputStream(new FileOutputStream("GameData/Main.data"));
            mainSaveStream.writeObject(main);
            mainSaveStream.flush();
            mainSaveStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Main loadMain() {
        File mainData = new File("GameData/Main.data");
        if (!mainData.exists()) return new Main();
        try {
            ObjectInputStream mainLoadStream = new ObjectInputStream(new FileInputStream("GameData/Main.data"));
            return (Main) mainLoadStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Main();
        }
    }
}
