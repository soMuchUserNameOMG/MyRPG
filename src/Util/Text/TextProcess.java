package Util.Text;

import PlayerAssets.Player;
import Util.GameFunctionsHelper;
import frame.Frame;

import java.util.Scanner;

import static Util.FrameUtil.MAIN_FRAME;

public class TextProcess {
    //这个类的目的是为了处理大量的文本输出和剧情对话显示
    public static void firstTimeText() {
        Frame f = new Frame();
        f.write("欢迎来到我的RPG游戏(MyRPG)!");
        f.noCleanOut();
        sleep(1500);
        f.write("这是你第一次进入这个游戏");
        f.noCleanOut();
        sleep(1500);
        f.write("在这个游戏里,你扮演的是一名勇者,因为各种各样的原因,俗套地踏上了打败魔王的路途(真的有人会去认真写剧情介绍吗....)");
        f.noCleanOut();
        sleep(1500);
        f.noCleanOut();
        f.write("好了,祝你在这个游戏里玩的愉快!");
        f.noCleanOut();
        sleep(1500);
        f.title(Main.Main.title);
        f.buttonChinese("任意键继续");
        f.noCleanOut();
        GameFunctionsHelper.blankOperate();
    }

    public static void enterGameText() {
        Frame f = new Frame();
        f.title(Main.Main.title);
        f.write("欢迎进入MyRPG");
        f.write("请选择你的操作:");
        f.buttonChinese("开始新游戏");
        f.buttonChinese("读取之前的存档");
        f.buttonChinese("退出游戏");
        f.out();
    }

    public static void mainMenuText(Player player) {
        player.simpleInfo(MAIN_FRAME);
        MAIN_FRAME.title(Main.Main.title);
        MAIN_FRAME.write("现在你走了" + player.walkDistance + "的路程,距离到达魔王城还有" + (1000 - player.walkDistance) + "的路程");
        MAIN_FRAME.write();
        MAIN_FRAME.write("请选择你现在要做什么");
        player.simpleInfo(MAIN_FRAME);
        TextProcess.button(player, MAIN_FRAME);
        MAIN_FRAME.out();
    }

    public static void button(Player player, Frame f) {
        f.buttonChinese("探索");

        f.buttonChinese("就地讨伐怪物");

        if (player.freeAttributePoints > 0) f.buttonChinese("属性点*");
        else f.buttonChinese("属性点");

        if (player.freeSkillPoints > 0) f.buttonChinese("技能点*");
        else f.buttonChinese("技能点");

        f.buttonChinese("保存并退出");
    }

    public static void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
