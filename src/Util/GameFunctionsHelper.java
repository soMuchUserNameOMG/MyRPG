package Util;

import Entities.Bosses.Boss;
import Entities.Bosses.GoblinBoss;
import Entities.Monsters.*;
import PlayerAssets.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class GameFunctionsHelper {
    // 这个我就不动你的了，不是因为懒
    public static void endRound() {
        System.out.println("输入任意键或按下回车结束回合!");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = bf.readLine();
            if (str.length() != 0) {
                System.out.println("\n输入任意键进入下一回合!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Monster monsterSpawn(Player player) {
        Random rd = new Random();
        int spawnMonster = rd.nextInt(6);
        int origin = player.level;
        if (origin - 1 <= 0) {
            origin = 1;
        }
        int monsterLevel = rd.nextInt(origin, player.level + 2);
        return switch (spawnMonster) {
            case 2 -> new Zombie(monsterLevel);
            case 3 -> new DemonizedBeast(monsterLevel);
            case 4 -> new Ghost(monsterLevel);
            case 5 -> new Slime(monsterLevel);
            default -> new Goblin(monsterLevel);
        };
    }

    public static Monster monsterSpawn(int mLevel) {
        Random rd = new Random();
        int spawnMonster = rd.nextInt(6);
        return switch (spawnMonster) {
            case 2 -> new Zombie(mLevel);
            case 3 -> new DemonizedBeast(mLevel);
            case 4 -> new Ghost(mLevel);
            case 5 -> new Slime(mLevel);
            default -> new Goblin(mLevel);
        };
    }

    public static Boss bossSpawn(Player player) {
        Random rd = new Random();
        int spawnBoss = rd.nextInt(6);
        int origin = player.level;
        if (origin - 1 <= 0) {
            origin = 1;
        }
        int bossLevel = rd.nextInt(origin, player.level + 2);
        return new GoblinBoss(bossLevel);
    }

    public static void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int smartInt(Scanner sc) {
        try {
            return Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("请正确输入数值!");
            return 0;
        }
    }

    public static boolean probabilityJudge(int lowerLimit, int upperLimit, int value) {
        return value >= lowerLimit && value < upperLimit;
    }

    public static void blankOperate() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            bf.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
