package Entities.NPCs;

import PlayerAssets.Equipment.Equipment;
import PlayerAssets.Player;
import Util.GameFunctionsHelper;

import java.util.Locale;
import java.util.Scanner;

import static Util.FrameUtil.OTHER_FRAME;

public class Armorer {
    public void upgrade(Player player, Equipment[] equipments) {
        boolean flag = true;
        int total = 0;
        for (Equipment eq:equipments) {
            total += eq.level*5;
        }
        while (flag) {
            OTHER_FRAME.write("升级装备需要花费" + (total + 10) + "点金币");
            OTHER_FRAME.write("你确定吗?");
            OTHER_FRAME.buttonChinese("同意");
            OTHER_FRAME.buttonChinese("不同意");
            OTHER_FRAME.out();
            switch (new Scanner(System.in).nextLine().toUpperCase(Locale.ROOT)) {
                case "1" -> {
                    OTHER_FRAME.write("工匠开始升级装备!");
                    OTHER_FRAME.out();
                    for (Equipment eq:equipments
                         ) {
                        eq.upgrade(OTHER_FRAME);
                    }
                    flag = false;
                }

                case "2" -> {
                    OTHER_FRAME.write("你选择了取消升级装备!");
                    OTHER_FRAME.out();
                    flag = false;
                }

                default -> {
                    OTHER_FRAME.write("请正确输入数值!");
                    OTHER_FRAME.out();
                    GameFunctionsHelper.sleep(1500);
                }
            }
        }
    }
}
