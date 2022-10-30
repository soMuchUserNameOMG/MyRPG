package Util;

import Entities.Monsters.Bosses.Boss;
import Entities.Monsters.Bosses.GoblinBoss;
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
        return switch (spawnMonster) {
            case 2 -> new Zombie(dangerFactorCalculate(player));
            case 3 -> new DemonizedBeast(dangerFactorCalculate(player));
            case 4 -> new Ghost(dangerFactorCalculate(player));
            case 5 -> new Slime(dangerFactorCalculate(player));
            default -> new Goblin(dangerFactorCalculate(player));
        };
    }

    public static Boss bossSpawn(Player player) {
        Random rd = new Random();
        int spawnBoss = rd.nextInt(6);
        int origin = dangerFactorCalculate(player);
        int bossLevel = rd.nextInt(origin, player.level + 2);
        return switch (spawnBoss){
            default -> new GoblinBoss(bossLevel);
        };
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

    //怪物危险系数计算
    public static int dangerFactorCalculate(Player player){
        Random rd = new Random();
        if(player.walkDistance <= 5){
            return 1;
        } else if(player.walkDistance <= 10){
            return rd.nextInt(1,4);
        } else if (player.walkDistance <= 20) {
            return rd.nextInt(2,6);
        } else if(player.walkDistance <= 35){
            return rd.nextInt(4,11);
        } else if (player.walkDistance <= 50) {
            return rd.nextInt(6,15);
        } else {
            return  rd.nextInt(8,100);
        }
    }
}
