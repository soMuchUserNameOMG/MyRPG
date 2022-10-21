package Main;

import PlayerAssets.Player;
import Util.GameFileController;
import Util.GameFunctionsHelper;
import Util.Text.TextProcess;

import java.io.Serializable;
import java.util.Scanner;

import static Util.FrameUtil.MAIN_FRAME;
import static Util.FrameUtil.OTHER_FRAME;

/**
 * 此项目为java初学者所做
 * 此项目仅供学习
 * 可能会没有太多注释....
 *
 * &#064;author:Player0
 * &#064;version:alpha0.1
 */
public class Main implements Serializable {
    public static final long serialVersionUID = 1234567890L;

    public static final String title = "MYRPG-VersionAlpha0.1";

    public static Player p;
    public boolean firstTimeEnter = true;
    private static final Scanner MAIN_SCANNER = new Scanner(System.in);
    private static Main main = new Main();

    public static void main(String[] args) {
        main = GameFileController.loadMain();
        if (main.firstTimeEnter) {
            TextProcess.firstTimeText();
            main.firstTimeEnter = false;
            GameFileController.saveMain(main);
        }
        enterGame();
        GameFileController.autoSave(p);
        TextProcess.mainMenuText(p);
        while (true) {
            mainMenu();
        }
    }

    public static void enterGame() {
        TextProcess.enterGameText();
        try {
            int mainFunction = Integer.parseInt(MAIN_SCANNER.next());
            switch (mainFunction) {
                case 1 -> {
                    newPlayer();
                }
                case 2 -> {
                    MAIN_FRAME.write("正在加载存档中....");
                    MAIN_FRAME.out();
                    MAIN_FRAME.write();
                    Player player = GameFileController.loadPlayer();
                    GameFunctionsHelper.sleep(500);
                    if (player == null) {
                        MAIN_FRAME.write("未能成功加载存档,新建角色或退出");
                        MAIN_FRAME.write("(键入1新建角色,键入2退出):");
                        MAIN_FRAME.out();
                        int mainFunction2 = GameFunctionsHelper.smartInt(MAIN_SCANNER);
                        switch (mainFunction2) {
                            case 1 -> newPlayer();
                            default -> System.exit(0);
                        }
                    } else {
                        p = player;
                        MAIN_FRAME.write("已成功找到存档文件");
                        MAIN_FRAME.noCleanOut();
                        GameFunctionsHelper.sleep(300);
                        MAIN_FRAME.write("正在加载类....");
                        MAIN_FRAME.noCleanOut();
                        GameFunctionsHelper.sleep(300);
                        MAIN_FRAME.write("正在new对象....");
                        MAIN_FRAME.noCleanOut();
                        GameFunctionsHelper.sleep(500);
                        MAIN_FRAME.write("加载存档成功!");
                        MAIN_FRAME.noCleanOut();
                        GameFunctionsHelper.sleep(100);
                        MAIN_FRAME.write();
                        MAIN_FRAME.write();
                        MAIN_FRAME.write();
                        MAIN_FRAME.write();
                        MAIN_FRAME.write("准备进入游戏.", 11);
                        MAIN_FRAME.noCleanOut();
                        GameFunctionsHelper.sleep(200);
                        MAIN_FRAME.write("准备进入游戏...", 11);
                        MAIN_FRAME.noCleanOut();
                        GameFunctionsHelper.sleep(200);
                        MAIN_FRAME.write("准备进入游戏.....", 11);
                        MAIN_FRAME.noCleanOut();
                        GameFunctionsHelper.sleep(200);
                        MAIN_FRAME.write("准备进入游戏.......", 11);
                        MAIN_FRAME.noCleanOut();
                        GameFunctionsHelper.sleep(500);
                        MAIN_FRAME.selfClean(MAIN_FRAME);
                    }
                }
                case 3 -> {
                    System.out.println("正在退出...");
                    GameFunctionsHelper.sleep(1500);
                    System.exit(0);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("请正确输入数值!");
        }
    }

    public static void newPlayer() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        System.out.println("\n请输入勇者名称:");
        String name = MAIN_SCANNER.next();
        System.out.println("你的名字是:" + name + "!");
        p = new Player(name, 1);
        GameFunctionsHelper.sleep(500);
    }

    public static void mainMenu() {
        MAIN_FRAME.title(Main.title);
        p.simpleInfo(MAIN_FRAME);
        switch (GameFunctionsHelper.smartInt(MAIN_SCANNER)) {
            case 1 -> p.explore(MAIN_FRAME);

            case 2 -> p.attackMonsterOnTheSpot(MAIN_FRAME);

            case 3 -> p.assignAttributePoints(MAIN_FRAME);

            case 4 -> p.assignSkillPoints(MAIN_FRAME);

            case 5 -> {
                GameFileController.savePlayer(p);
                System.exit(0);
            }

            case 6 -> p.detailInfo(OTHER_FRAME);

            case 666 -> {
                p.HP = p.maxHP;
                p.MP = p.maxMP;
                System.out.println("回复到满状态!\n");
            }

            case 999 -> {
                p.freeAttributePoints += 100;
                p.freeSkillPoints += 100;
                System.out.println("已添加100点自由属性点与100点自由技能点");
                TextProcess.mainMenuText(p);
            }
            default -> {
                TextProcess.mainMenuText(p);
            }
        }
    }

    public static Player getPlayer() {
        return p;
    }
}
