package PlayerAssets;

import Buffs.Buff;
import Entities.Entity;
import Entities.InterFaces.Dodgeable;
import Entities.Monsters.Bosses.Boss;
import Entities.Monsters.Monster;
import Main.Main;
import PlayerAssets.Abilities.*;
import PlayerAssets.Equipment.Armor;
import PlayerAssets.Equipment.Weapon;
import Util.GameFileController;
import Util.GameFunctionsHelper;
import Util.Text.TextProcess;
import frame.Frame;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static Util.FrameUtil.*;

public class Player extends Entity implements Serializable {
    @Serial
    private static final long serialVersionUID = 2604625800L;

    public double maxMP;
    public double MP;
    public double defense;
    public double agility;
    public double strength;
    public double exp;
    public int walkDistance;
    public int walkTime;
    public double requireExp;
    public int freeAttributePoints;
    public int freeSkillPoints;
    public Ability[] abilities = new Ability[6];
    public Buff[] buffs = new Buff[5];
    public boolean actChance;
    public Weapon weapon;
    public Armor armor;

    //level变量仅为调试作用,实际中默认为1
    public Player(String name, int level) {
        this.name = name;
        this.maxHP = 100 * level;
        this.HP = this.maxHP;
        this.maxMP = 200 * level;
        this.MP = this.maxMP;
        this.strength = 10 * level;
        this.agility = 5 * level;
        this.defense = 2 * level;
        this.walkDistance = 0;
        this.level = level;
        this.exp = 0;
        this.requireExp = 100;
        this.freeAttributePoints = 0;
        this.freeSkillPoints = 0;
        this.abilities[0] = new MutiAttack("多次连斩", 0, 1, 3);
        for (int i = 1; i < abilities.length; i++) {
            abilities[i] = new EmptyAbility("空", 0, 0, 0);
        }
        this.weapon = new Weapon("训练战士用的木剑", 3, 2147483647);
        this.actChance = true;
        this.armor = new Armor(3, "新手木甲", 2147483647);
    }

    //debug构造方法
    public Player(double maxHP, double maxMP, double defense, double strength, String name, Weapon wp) {
        this.maxHP = maxHP;
        this.HP = maxMP;
        this.maxMP = maxMP;
        this.MP = maxMP;
        this.defense = defense;
        this.strength = strength;
        this.name = name;
        this.weapon = wp;
    }

    //无参构造
    public Player() {

    }


    //对于怪物的战斗方法(内部细节注释请看下面)
    public void fight(Monster m) {
        Scanner fightSc = new Scanner(System.in);
        FIGHT_FRAME.selfClean(FIGHT_FRAME);
        FIGHT_FRAME.write("你遭遇了怪物,进入战斗状态!!");
        this.simpleInfo(FIGHT_FRAME);
        //停止自动保存
        GameFileController.setStuck(true);
        /*
         * 进入战斗循环
         * 一方hp小于等于0时自动退出
         * */
        for (int fightCount = 1; this.HP > 0 && m.HP > 0; fightCount++) {
            //回合开始前buff作用
            buffsEffect();
            /*
             * 如玩家受到震撼效果,则会进入此分支
             * 在此分支中,玩家无法行动
             * 分支结束后直接进入下一回合
             * */
            if (!this.actChance) {
                double monsterDamage = m.strength - this.defense - this.armor.armorValue;
                if (monsterDamage <= 0) monsterDamage = 1;
                FIGHT_FRAME.write("现在是战斗的第" + fightCount + "回合!");
                FIGHT_FRAME.write("你受到了震撼吼的影响,你本回合无法行动!");
                this.HP = this.HP - monsterDamage;
                FIGHT_FRAME.write("怪物对你造成了" + monsterDamage + "点伤害");
                FIGHT_FRAME.title(Main.title);
                FIGHT_FRAME.out();
                GameFunctionsHelper.endRound();
                continue;
            }
            //以下两行代码输出通常战斗文本
            this.simpleInfo(FIGHT_FRAME);
            fightText(fightCount, m.name, m.HP, m.maxHP, HP, maxHP, m.level, MP, maxMP);
            //主要战斗功能模块,玩家操作选择
            try {
                int fightFunction = Integer.parseInt(fightSc.nextLine());
                switch (fightFunction) {
                    //普通攻击
                    case 1 -> {
                        //计算伤害值
                        double playerDamage = this.strength + this.weapon.damage - m.defense;
                        double monsterDamage = m.strength - this.defense - this.armor.armorValue;
                        //防止负数
                        if (playerDamage <= 0) playerDamage = 1;
                        if (monsterDamage <= 0) monsterDamage = 1;
                        FIGHT_FRAME.write("你对怪物造成了" + playerDamage + "点伤害!");
                        this.simpleInfo(FIGHT_FRAME);
                        FIGHT_FRAME.title(Main.title);
                        m.HP = m.HP - playerDamage;
                        //闪避成功分支,玩家不受伤害
                        if (dodge(m)) {
                            FIGHT_FRAME.write("[你闪避了怪物的攻击!]");
                            this.simpleInfo(FIGHT_FRAME);
                            FIGHT_FRAME.title(Main.title);
                        } else {
                            //闪避失败分支
                            FIGHT_FRAME.write("怪物对你造成了" + monsterDamage + "点伤害");
                            this.simpleInfo(FIGHT_FRAME);
                            FIGHT_FRAME.title(Main.title);
                            this.HP = this.HP - monsterDamage;
                        }
                        //怪物闪避分支
                        if (m instanceof Dodgeable) {
                            /*
                            * 怪物通过技能释放的方式进行闪避
                            * 技能释放方法有布尔返回值
                            * 如果返回false,则说明未闪避成功
                            * 进行正常的文本输出
                            * */
                            if (!((Dodgeable) m).abilityRelease(this, playerDamage)) FIGHT_FRAME.out();
                        }
                        /*
                        * 普通怪物释放技能分支
                        * 通过返回布尔值判断是否释放成功
                        * 返回true则在此方法内不进行输出(因为在释放技能方法内已有文本输出)
                        * 返回false则进行普通输出
                        * */
                        else if (!(m.abilityRelease(this))) FIGHT_FRAME.out();
                        this.weapon.durability = (int) (this.weapon.durability - m.defense * 0.5);
                        //结束回合
                        GameFunctionsHelper.endRound();
                        //窗口自清理
                        FIGHT_FRAME.selfClean(FIGHT_FRAME);
                    }
                    case 2 -> {

                        //怪物信息
                        m.info();
                        fightCount = fightCount - 1;
                    }
                    case 3 -> {
                        /*
                        * 玩家技能释放
                        * 通过布尔值判断是否释放成功
                        * 如释放不成功(如冷却未到)则返回上一级界面(战斗界面)并重新选择操作
                        * 释放成功则进入下一回合
                        * */
                        if (!abilityRelease(m, fightCount)) {
                            fightCount--;
                        }
                        GameFunctionsHelper.endRound();
                    }

                    //为debug操作
                    case 666 -> {
                        m.HP = 0;
                        System.out.println("一键秒杀成功");
                    }

                    case 555 -> {
                        this.HP = 0;
                        System.out.println("自杀成功");
                    }

                    //防止int数值错误
                    default -> {
                        System.out.println("请正确输入数值!");
                        fightCount = fightCount - 1;
                    }
                }

                //防止int转换错误
            } catch (NumberFormatException e) {
                System.out.println("请正确输入数值!");
                fightCount = fightCount - 1;
            }
        }
        if (this.HP <= 0) {
            FIGHT_FRAME.write("战斗结束,你输了!");
            FIGHT_FRAME.out();
            GameFunctionsHelper.blankOperate();
            buffClean();
            MAIN_FRAME.selfClean(MAIN_FRAME);
            MAIN_FRAME.title(Main.title);
            simpleInfo(MAIN_FRAME);
            TextProcess.mainMenuText(this);
            this.HP = 10;
            resetAbility();
            GameFileController.setStuck(false);
        } else if (m.HP <= 0) {
            exp = exp + m.giveExp();
            FIGHT_FRAME.write("战斗结束,你获得了胜利!");
            FIGHT_FRAME.write("恭喜你获得了" + m.giveExp() + "点经验值");
            levelUp(FIGHT_FRAME);
            FIGHT_FRAME.out();
            GameFunctionsHelper.blankOperate();
            buffClean();
            MAIN_FRAME.selfClean(MAIN_FRAME);
            MAIN_FRAME.title(Main.title);
            simpleInfo(MAIN_FRAME);
            TextProcess.mainMenuText(this);
            resetAbility();
            this.HP = maxHP;
            GameFileController.setStuck(false);
        } else {
            System.out.println("未知错误!");
            GameFileController.setStuck(false);
        }
    }

    public static void fightText(int fightCount, String monsterName, double hp, double monsterMaxHP, double HP, double playerMaxHP, int mLevel, double playerMP, double playerMaxMP) {
        FIGHT_FRAME.write("==========================");
        FIGHT_FRAME.write("现在是战斗的第" + fightCount + "回合!");
        FIGHT_FRAME.write("-------------------------------");
        FIGHT_FRAME.write("你的血量:" + HP + "/" + playerMaxHP + "\t" + monsterName + "血量:" + hp + "/" + monsterMaxHP + "\t等级:" + mLevel);
        FIGHT_FRAME.write("你的魔力值:" + playerMP + "/" + playerMaxMP);
        FIGHT_FRAME.write("-------------------------------");
        FIGHT_FRAME.write("请选择你现在要做什么");
        FIGHT_FRAME.buttonChinese("战斗");
        FIGHT_FRAME.buttonChinese("怪物信息");
        FIGHT_FRAME.buttonChinese("释放技能");
        FIGHT_FRAME.title(Main.title);
        FIGHT_FRAME.out();
    }

    public boolean abilityRelease(Monster m, int fightCount) {
        Scanner releaseSc = new Scanner(System.in);
        FIGHT_FRAME.write("请选择你要释放哪一个技能");
        int i = 1;
        for (Ability a : abilities) {
            FIGHT_FRAME.write(i + "." + a.name);
            i++;
        }
        FIGHT_FRAME.out();
        int releaseFunction = GameFunctionsHelper.smartInt(releaseSc);
        switch (releaseFunction) {
            case 1 -> {
                if (abilities[0].LastRelease == -1) {
                    return abilitySuccessfulRelease(m, fightCount);
                } else if (!abilities[0].isCoolingDown(fightCount)) {
                    return abilitySuccessfulRelease(m, fightCount);
                } else {
                    System.out.println("此技能还在冷却中!");
                    return false;
                }
            }
            case 2 -> {
                return singleAbilityRelease(1, fightCount, m);
            }

            case 3 -> {
                return singleAbilityRelease(2, fightCount, m);
            }

            case 4 -> {
                return singleAbilityRelease(3, fightCount, m);
            }

            case 5 -> {
                return singleAbilityRelease(4, fightCount, m);
            }

            case 6 -> {
                return singleAbilityRelease(5, fightCount, m);
            }
            default -> {
                System.out.println("请正确输入数值!");
                return false;
            }
        }
    }

    private boolean singleAbilityRelease(int index, int fightCount, Monster m) {
        if (abilities[index].LastRelease == -1) {
            if (abilities[index].abilityRelease(m) != 0) return false;
            abilities[index].LastRelease = fightCount;
            return true;
        } else if (!abilities[index].isCoolingDown(fightCount)) {
            if (abilities[index].abilityRelease(m) != 0) return false;
            abilities[index].LastRelease = fightCount;
            return true;
        } else {
            System.out.println("此技能还在冷却中!");
            return false;
        }
    }

    private boolean abilitySuccessfulRelease(Monster m, int fightCount) {
        double damage = abilities[0].abilityRelease(m);
        FIGHT_FRAME.out();
        if (m instanceof Dodgeable) {
            ((Dodgeable) m).abilityRelease(this, damage);
        }
        m.HP = m.HP - damage;
        FIGHT_FRAME.write("[你发动了" + abilities[0].name + "]");
        FIGHT_FRAME.write("[对怪物造成了" + damage + "点伤害]");
        FIGHT_FRAME.write("怪物生命值:" + m.HP + "/" + m.maxHP);
        FIGHT_FRAME.out();
        abilities[0].LastRelease = fightCount;
        return true;
    }

    public void resetAbility() {
        for (Ability a : abilities
        ) {
            if (!(a instanceof EmptyAbility)) {
                a.LastRelease = -1;
            }
        }
    }

    //玩家简要信息(显示在主菜单中)
    public void simpleInfo(Frame f) {
        Math.round(1.0);
        f.clearAttribute();
        f.attribute("等级    " + level);
        f.attribute("经验    " + Math.round(requireExp) + "/" + Math.round(exp));
        f.attribute("属性点  " + Math.round(freeAttributePoints));
        f.attribute("生命值  " + Math.round(HP) + "/" + Math.round(maxHP));
        f.attribute("魔力值  " + Math.round(MP) + "/" + Math.round(maxMP));
        f.attribute("攻击力  " + Math.round(strength));
        f.attribute("防御力  " + Math.round(defense));
        f.attribute("敏捷    " + Math.round(agility));
        f.attribute("距离    " + "1000/" + walkDistance);
        f.attribute("武器    " + weapon.name + "\t伤害:" + Math.round(weapon.damage));
        f.attribute("盔甲    " + armor.name + "\t盔甲值:" + armor.armorValue);
        f.attribute("输入6以查看详细信息....");
    }

    //玩家详细信息

    public void detailInfo(Frame f) {
        Math.round(1.0);
        f.clearAttribute();
        f.write("姓名    " + name);
        f.write("等级    " + level);
        f.write("经验    " + Math.round(requireExp) + "/" + Math.round(exp));
        f.write("属性点  " + Math.round(freeAttributePoints));
        f.write("生命值  " + Math.round(HP) + "/" + Math.round(maxHP));
        f.write("魔力值  " + Math.round(MP) + "/" + Math.round(maxMP));
        f.write("攻击力  " + Math.round(strength));
        f.write("防御力  " + Math.round(defense));
        f.write("敏捷    " + Math.round(agility));
        f.write("距离    " + "1000/" + walkDistance);
        f.write("键入任意键进入下一页");
        f.out();
        GameFunctionsHelper.blankOperate();
        f.write("武器信息:");
        f.write("\t武器名称:" + this.weapon.name);
        f.write("\t武器等级:" + this.weapon.level);
        f.write("\t武器攻击力:" + this.weapon.damage);
        f.write("\t武器剩余耐久:" + this.weapon.durability + "/" + this.weapon.maxDurability);
        f.write("盔甲信息:");
        f.write("\t盔甲名称:" + this.armor.name);
        f.write("\t盔甲等级:" + this.armor.level);
        f.write("\t盔甲防御值:" + this.armor.armorValue);
        f.write("\t盔甲剩余耐久:" + this.armor.durability + "/" + this.armor.maxDurability);
        f.write("输入任意键退出");
        f.out();
        GameFunctionsHelper.blankOperate();
        TextProcess.mainMenuText(this);
    }

    //升级方法
    public void levelUp(Frame f) {
        if (requireExp - exp <= 0) {
            level++;
            f.write("恭喜你升级了,你现在的等级是:" + level + "级");
            exp = 0;
            requireExp = level * 100 + requireExp * 5 / 4;
            freeAttributePoints = freeAttributePoints + level * 3 - 2;
            freeSkillPoints = freeSkillPoints + level / 2;
            f.write("[你得到了" + (level * 3 - 2) + "点属性点]");
            f.write("[你得到了" + level / 2 + "点技能点]");
            this.HP = maxHP;
            this.MP = maxMP;
        }
    }

    //属性点分配
    public void assignAttributePoints(Frame f) {
        f.selfClean(f);
        Scanner scanner = new Scanner(System.in);
        boolean exitFlag = false;
        if (freeAttributePoints <= 0) f.write("您当前没有自由属性点可以分配!");
        else {
            f.write("请输入你想要分配的属性点,当前自由属性点:" + freeAttributePoints + "    ");

            f.buttonChinese("生命");
            f.buttonChinese("魔力");
            f.buttonChinese("力量");
            f.buttonChinese("防御");
            f.buttonChinese("敏捷");
            f.buttonChinese("退出");

            f.write("提示:连续键入2次可以一次性分配10点属性值");

            f.write();

            f.write("生命    " + maxHP);
            f.write("魔力    " + maxMP);
            f.write("力量    " + strength);
            f.write("防御    " + defense);
            f.write("敏捷    " + agility);

            f.noCleanOut();
        }
        while (!exitFlag && freeAttributePoints > 0) {
            f.write("请输入你想要分配的属性点,当前自由属性点:" + freeAttributePoints + "    ", 1);
            f.noCleanOut();
            try {
                int integer = Integer.parseInt(scanner.next());
                switch (integer) {
                    case 1 -> {
                        double beforeHP = maxHP;
                        this.maxHP += 30;
                        f.write("生命    " + beforeHP + "--->" + maxHP, 4);
                        this.freeAttributePoints--;
                    }
                    case 2 -> {
                        double beforeMP = maxMP;
                        this.maxMP += 40;
                        f.write("魔力    " + beforeMP + "--->" + maxMP, 5);
                        this.freeAttributePoints--;
                    }
                    case 3 -> {
                        double beforeStrength = strength;
                        this.strength += 2;
                        f.write("力量    " + beforeStrength + "--->" + strength, 6);
                        this.freeAttributePoints--;
                    }
                    case 4 -> {
                        double beforeDefense = defense;
                        this.defense += 1.5;
                        f.write("防御    " + beforeDefense + "--->" + defense, 7);
                        this.freeAttributePoints--;
                    }
                    case 5 -> {
                        double beforeAgility = agility;
                        this.agility += 0.5;
                        f.write("敏捷    " + beforeAgility + "--->" + agility, 8);
                        this.freeAttributePoints--;
                    }
                    case 6 -> {
                        exitFlag = true;
                        f = new frame.Frame();
                    }

                    case 11 -> {
                        double beforeHP = maxHP;
                        this.maxHP += 300;
                        f.write("生命    " + beforeHP + "--->" + maxHP, 4);
                        this.freeAttributePoints -= 10;
                    }

                    case 22 -> {
                        double beforeMP = maxMP;
                        this.maxMP += 400;
                        f.write("魔力    " + beforeMP + "--->" + maxMP, 5);
                        this.freeAttributePoints -= 10;
                    }

                    case 33 -> {
                        double beforeStrength = strength;
                        this.strength += 20;
                        f.write("力量    " + beforeStrength + "--->" + strength, 6);
                        this.freeAttributePoints -= 10;
                    }

                    case 44 -> {
                        double beforeDefense = defense;
                        this.defense += 15;
                        f.write("防御    " + beforeDefense + "--->" + defense, 7);
                        this.freeAttributePoints -= 10;
                    }

                    case 55 -> {
                        double beforeAgility = agility;
                        this.agility += 5;
                        f.write("敏捷    " + beforeAgility + "--->" + agility, 8);
                        this.freeAttributePoints -= 10;
                    }

                    default -> System.out.println("请正确输入数值!");
                }

            } catch (NumberFormatException e) {
                System.out.println("请正确输入数值!");
            }
//            f.out();

            if (!(freeAttributePoints > 0)) {
                f = new frame.Frame();
                f.write("您当前没有自由属性点可以分配!");
            }
        }
        MAIN_FRAME.selfClean(MAIN_FRAME);
        TextProcess.mainMenuText(this);
    }

    //技能点分配
    public void assignSkillPoints(Frame f) {
        f = new frame.Frame();
        Scanner abilityLevelUpSc = new Scanner(System.in);
        boolean exitFlag = false;
        if (this.freeSkillPoints <= 0) {
            f.write("你没有足够的自由技能点!");
        } else {
            f.write("请选择你需要升级的技能!(1-5),键入6退出");
            f.write("剩余技能点： " + freeSkillPoints);
            f.write();

            for (int i = 0; i < this.abilities.length; i++) {
                if (!(abilities[i] instanceof EmptyAbility))
                    f.write((i + 1) + ". " + abilities[i].name + " Level." + abilities[i].level);
                else f.write((i + 1) + ". " + "技能槽为空!(可选择点亮获取新技能!)");
            }
            f.out();
        }
        while (this.freeSkillPoints > 0 && !exitFlag) {
            int levelUpFunction = GameFunctionsHelper.smartInt(abilityLevelUpSc);
            switch (levelUpFunction) {
                case 1 -> {
                    abilities[0].abilityLevelUp();
                    this.freeSkillPoints--;
                }

                case 2 -> {
                    if (abilities[1] instanceof EmptyAbility) {
                        getNewAbility();
                    } else abilities[1].abilityLevelUp();
                    this.freeSkillPoints--;
                }

                case 3 -> {
                    if (abilities[2] instanceof EmptyAbility) {
                        getNewAbility();
                    } else abilities[2].abilityLevelUp();
                    this.freeSkillPoints--;
                }

                case 4 -> {
                    if (abilities[3] instanceof EmptyAbility) {
                        getNewAbility();
                    } else abilities[3].abilityLevelUp();
                    this.freeSkillPoints--;
                }

                case 5 -> {
                    if (abilities[4] instanceof EmptyAbility) {
                        getNewAbility();
                    } else abilities[4].abilityLevelUp();
                    this.freeSkillPoints--;
                }

                case 6 -> exitFlag = true;

                default -> {
                }
            }
            f.write("请选择你需要升级的技能!(1-5),键入6退出");
            f.write("剩余技能点： " + freeSkillPoints);
            f.write();
            for (int i = 0; i < this.abilities.length; i++) {
                if (!(abilities[i] instanceof EmptyAbility))
                    f.write((i + 1) + ". " + abilities[i].name + " Level." + abilities[i].level);
                if (abilities[i] instanceof EmptyAbility & this.freeSkillPoints <= 0) f.write((i + 1) + "." + "技能槽为空!");
                if (abilities[i] instanceof EmptyAbility & this.freeSkillPoints > 0)
                    f.write((i + 1) + ". " + "技能槽为空!(可选择点亮获取新技能!)");

            }
            f.out();
        }
        MAIN_FRAME.selfClean(MAIN_FRAME);
        TextProcess.mainMenuText(this);
    }

    //buff作用
    public void buffsEffect() {
        for (Buff b : buffs) {
            if (b != null) {
                if (b.life > 0) {
                    b.effect(this);
                } else {
                    b.finalEffect(this);
                    b = null;
                }
            }
        }
    }

    public void newBuff(Buff b) {
        int emptyBuff = 0;
        for (Buff b1 : buffs
        ) {
            if (b1 != null) {
                emptyBuff++;
            } else {
                buffs[emptyBuff] = b;
            }
        }
    }

    public void explore(Frame f) {
        f.write("正在探索中...");
        this.simpleInfo(f);
        f.out();
        TextProcess.sleep(1000);
        Random exploreRD = new Random();
        int exploreChance = exploreRD.nextInt(101);
        if (GameFunctionsHelper.probabilityJudge(0, 40, exploreChance)) {
            this.fight(GameFunctionsHelper.monsterSpawn(this));
            move();
        } else if (GameFunctionsHelper.probabilityJudge(40, 60, exploreChance)) {
            f.write("你什么都没发现,走了一点路程");
            f.write("获得少量经验!");
            this.exp += this.level * 5;
            TextProcess.button(this, f);
            this.simpleInfo(f);
            f.out();
            move();
        } else if (GameFunctionsHelper.probabilityJudge(60, 80, exploreChance) && this.walkDistance <= 15) {
            f.write("你什么都没发现,走了一点路程");
            f.write("获得少量经验!");
            this.exp += this.level * 5;
            TextProcess.button(this, f);
            this.simpleInfo(f);
            f.out();
            move();
        } else if (GameFunctionsHelper.probabilityJudge(80, 90, exploreChance) && this.walkDistance > 15) {
            f.write("你遭遇了boss!\n");
            this.simpleInfo(f);
            f.noCleanOut();
            this.fight(GameFunctionsHelper.bossSpawn(this));
            move();
        } else if (GameFunctionsHelper.probabilityJudge(60, 80, exploreChance) && this.walkDistance > 15) {
            this.fight(GameFunctionsHelper.monsterSpawn(this));
            move();
        } else if(GameFunctionsHelper.probabilityJudge(0, 100, exploreChance)){
            f.write("你遇到了特殊事件!");
            f.write("一位老者将要给你的装备升级,是否同意?");
            f.buttonChinese("同意");
            f.buttonChinese("不同意");
            f.out();
            switch (GameFunctionsHelper.smartInt(new Scanner(System.in))){
                case 1 -> {
                    this.weapon.upgrade(f);
                    this.armor.upgrade(f);
                    this.simpleInfo(f);
                    TextProcess.button(this, f);
                    f.out();
                }

                case 2 -> {
                    f.write("你不同意让他给你强化武器");
                    this.simpleInfo(f);
                    TextProcess.button(this, f);
                    f.out();
                }
            }
        } else {
            f.write("你发现了奇遇!");
            f.write("(Version alpha0.1,该系统尚未实装)");
            f.write("所以给予你大量经验");
            this.requireExp = 0;
            this.levelUp(f);
            this.simpleInfo(f);
            TextProcess.button(this, f);
            f.out();
            move();
        }

    }

    public void move(){
        this.walkTime++;
        this.walkDistance = walkTime / 3;
    }

    //清理buff用(在战斗结束时或自动存档时)
    public void buffClean() {
        for (Buff buff : buffs) {
            if (buff != null) {
                buff.life = 0;
                buff.finalEffect(this);
            }
        }
        Arrays.fill(this.buffs, null);
    }

    public boolean dodge(Monster monster) {
        if (monster instanceof Boss) return false;
        double dodgeChance = this.agility - monster.strength / 2;
        Random dodgeRandom = new Random();
        int dodgeFlag = dodgeRandom.nextInt(0, 101);
        return dodgeFlag < dodgeChance;
    }

    public void attackMonsterOnTheSpot(Frame f) {
        f.write("正在寻找怪物中.");
        f.out();
        GameFunctionsHelper.sleep(300);
        f.write("正在寻找怪物中...");
        f.noCleanOut();
        GameFunctionsHelper.sleep(300);
        f.write("已找到可讨伐的怪物!");
        f.noCleanOut();
        GameFunctionsHelper.sleep(500);
        this.fight(GameFunctionsHelper.monsterSpawn(this));
    }

    public void getNewAbility() {
        OTHER_FRAME.write("请选择你要点亮哪一个技能");
        OTHER_FRAME.write("1.治疗术");
        OTHER_FRAME.write("2.爆裂火球");
        OTHER_FRAME.write("3.冰锥术");
        OTHER_FRAME.write("4.毒雾术");
        OTHER_FRAME.write("5.狂暴");
        OTHER_FRAME.out();
        int unactivatedAbility = 0;
        for (Ability a : abilities) {
            if (!(a instanceof EmptyAbility)) {
                unactivatedAbility++;
            }
        }
        switch (GameFunctionsHelper.smartInt(new Scanner(System.in))) {
            case 1 -> {
                this.abilities[unactivatedAbility] = new SelfHeal("治疗术", 1, 1, 2);
            }
            case 2 -> {
                this.abilities[unactivatedAbility] = new FireBall("爆裂火球", 1, 1, 3);
            }
            case 3 -> {
                this.abilities[unactivatedAbility] = new IcePick("冰锥术", 1, 1, 3);
            }
            case 4 -> {
                this.abilities[unactivatedAbility] = new PoisonMist("毒雾术", 1, 1, 4);
            }

            case 5 -> {
                this.abilities[unactivatedAbility] = new Berserk("狂暴", 1, 1, 4);
            }
        }
    }

}
