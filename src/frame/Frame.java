package frame;

import java.util.Arrays;

public class Frame {

    /**
     * 标题缩进数
     */
    private static int titleRetraction = 2;

    /**
     * 文本缩进数
     */
    private static int retraction = 2;

    /**
     * 属性缩进数
     */
    private static int attributeRetraction = 80;

    /**
     * 按钮缩进数
     */
    private static int buttonRetraction = 2;

    /**
     * 按钮间距数
     */
    private static final int buttonSpacing = 3;

    /*
    帧的内容
     */
    private final char[] line1;
    private char[] line2;
    private final char[] line3;
    private char[] line4;
    private char[] line5;
    private char[] line6;
    private char[] line7;
    private char[] line8;
    private char[] line9;
    private char[] line10;
    private char[] line11;
    private char[] line12;
    private char[] line13;
    private char[] line14;
    private char[] line15;
    private char[] line16;
    private char[] line17;
    private char[] line18;
    private char[] line19;
    private char[] line20;
    private char[] line21;
    private char[] line22;
    private char[] line23;
    private char[] line24;
    private char[] line25;
    private char[] line26;
    private final char[] line27;
    private char[] line28;
    private final char[] line29;

    /*
    标记write方法执行到了第几行
     */
    private int lineNum;

    /*
    标记属性打到了第几行
     */
    private int attributeLine;

    /*
    标记添加的按钮的个数和位置
     */
    private int buttonCount;
    private int buttonPos;

    /**
     * 构造一个空的frame对象
     */
    public Frame() {

        this.lineNum = 1;

        this.attributeLine = 1;

        this.buttonCount = 1;
        this.buttonPos = 2 + buttonRetraction;

        this.line1 = new char[]{'█', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '█'};
        this.line2 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line3 = new char[]{'█', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '█'};
        this.line4 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line5 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line6 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line7 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line8 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line9 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line10 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line11 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line12 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line13 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line14 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line15 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line16 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line17 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line18 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line19 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line20 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line21 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line22 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line23 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line24 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line25 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line26 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line27 = new char[]{'█', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '█'};
        this.line28 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line29 = new char[]{'█', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '█'};
    }

    /**
     * 防Bug，无实际作用
     */
    public void title() {
    }

    /**
     * 打入标题，你最好只调一次
     *
     * @param str 标题内容
     */
    public void title(String str) {
        char[] charArr = str.toCharArray();
        System.arraycopy(charArr, 0, this.line2, 2 + titleRetraction, charArr.length);
    }

    /**
     * 和 println() 的括号里啥也不写是一个道理
     */
    public void write() {
        lineNum++;
    }

    /**
     * 打入内容，只能调11次，多调无用
     *
     * @param str 文本内容
     */
    public void write(String str) {
        if (this.lineNum > 11) return;
        this.write(str, this.lineNum);
        this.lineNum++;
    }

    /**
     * BUG制造机，非开发者切勿使用
     */
    public void write(String str, int lines) {
        char[] charArr = str.toCharArray();
        switch (lines) {
            case 1 -> System.arraycopy(charArr, 0, this.line5, 2 + retraction, charArr.length);
            case 2 -> System.arraycopy(charArr, 0, this.line7, 2 + retraction, charArr.length);
            case 3 -> System.arraycopy(charArr, 0, this.line9, 2 + retraction, charArr.length);
            case 4 -> System.arraycopy(charArr, 0, this.line11, 2 + retraction, charArr.length);
            case 5 -> System.arraycopy(charArr, 0, this.line13, 2 + retraction, charArr.length);
            case 6 -> System.arraycopy(charArr, 0, this.line15, 2 + retraction, charArr.length);
            case 7 -> System.arraycopy(charArr, 0, this.line17, 2 + retraction, charArr.length);
            case 8 -> System.arraycopy(charArr, 0, this.line19, 2 + retraction, charArr.length);
            case 9 -> System.arraycopy(charArr, 0, this.line21, 2 + retraction, charArr.length);
            case 10 -> System.arraycopy(charArr, 0, this.line23, 2 + retraction, charArr.length);
            case 11 -> System.arraycopy(charArr, 0, this.line25, 2 + retraction, charArr.length);
        }
    }

    /**
     * 和 println() 的括号里啥也不写是一个道理
     */
    public void attribute() {
        attributeLine++;
    }


    public void attribute(String str) {
        char[] charArr = str.toCharArray();
        switch (this.attributeLine) {
            case 1 -> System.arraycopy(charArr, 0, this.line4, 2 + attributeRetraction, charArr.length);
            case 2 -> System.arraycopy(charArr, 0, this.line6, 2 + attributeRetraction, charArr.length);
            case 3 -> System.arraycopy(charArr, 0, this.line8, 2 + attributeRetraction, charArr.length);
            case 4 -> System.arraycopy(charArr, 0, this.line10, 2 + attributeRetraction, charArr.length);
            case 5 -> System.arraycopy(charArr, 0, this.line12, 2 + attributeRetraction, charArr.length);
            case 6 -> System.arraycopy(charArr, 0, this.line14, 2 + attributeRetraction, charArr.length);
            case 7 -> System.arraycopy(charArr, 0, this.line16, 2 + attributeRetraction, charArr.length);
            case 8 -> System.arraycopy(charArr, 0, this.line18, 2 + attributeRetraction, charArr.length);
            case 9 -> System.arraycopy(charArr, 0, this.line20, 2 + attributeRetraction, charArr.length);
            case 10 -> System.arraycopy(charArr, 0, this.line22, 2 + attributeRetraction, charArr.length);
            case 11 -> System.arraycopy(charArr, 0, this.line24, 2 + attributeRetraction, charArr.length);
            case 12 -> System.arraycopy(charArr, 0, this.line26, 2 + attributeRetraction, charArr.length);
        }
        this.attributeLine++;
    }

    public void clearAttribute() {
        Frame blankFrame = new Frame();
        this.line4 = blankFrame.line4;
        this.line6 = blankFrame.line6;
        this.line10 = blankFrame.line10;
        this.line12 = blankFrame.line12;
        this.line14 = blankFrame.line14;
        this.line16 = blankFrame.line16;
        this.line18 = blankFrame.line18;
        this.line20 = blankFrame.line20;
        this.line22 = blankFrame.line22;
        this.line24 = blankFrame.line24;
        this.line26 = blankFrame.line26;
        attributeLine = 1;
    }

    /**
     * 防Bug，无实际作用
     */
    public void button() {
    }

    /**
     * 中文按钮，打在倒数第二行
     *
     * @param str 按钮内容，仅支持中文
     */
    public void buttonChinese(String str) {

        char[] charArr = (buttonCount + ".【" + str + "】").toCharArray();

        System.arraycopy(charArr, 0, this.line28, buttonPos, charArr.length);
        buttonPos += (str.length() + 4 + buttonSpacing);

        this.buttonCount++;
    }

    /**
     * 怕你有需求
     *
     * @param str 按钮内容，仅支持English
     */
    public void buttonEnglish(String str) {
        char[] charArr = (buttonCount + ".【" + str + "】").toCharArray();

        System.arraycopy(charArr, 0, this.line28, buttonPos, charArr.length);
        buttonPos += (str.length() + 4 + buttonSpacing);

        this.buttonCount++;
    }

    /**
     * 输出，调用就完了
     */
    /**
     * 这块也是我加的
     * 因为我为了适配需要单窗口重复利用
     * 因此这个out方法就有点过于耦合了,只能一次使用
     * 所以加了selfClean()方法
     * 但是又带来了一大堆麻烦
     * 下面的几个out变种就是麻烦的产物
     */
    public void out() {
        String frameStr = getFrameStr();
        System.out.println(frameStr);
        selfClean(this);
    }

    /**
     * 带动画效果的输出
     *
     * @param style 选择你所需要的动画类型
     */
    public void out(FrameAnimations style) {
        switch (style) {
            case BE_ATTACK -> {
                Frame original = new Frame();
                Frame animations = new Frame();
                original.clone(this);
                animations.buttonPos = this.buttonPos;
                original.buttonPos = this.buttonPos;

                System.arraycopy(original.line2, 2, animations.line2, 1, original.line2.length - 2);

                System.arraycopy(original.line4, 2, animations.line4, 1, original.line4.length - 2);
                System.arraycopy(original.line5, 2, animations.line5, 1, original.line5.length - 2);
                System.arraycopy(original.line6, 2, animations.line6, 1, original.line6.length - 2);
                System.arraycopy(original.line7, 2, animations.line7, 1, original.line7.length - 2);
                System.arraycopy(original.line8, 2, animations.line8, 1, original.line8.length - 2);
                System.arraycopy(original.line9, 2, animations.line9, 1, original.line9.length - 2);
                System.arraycopy(original.line10, 2, animations.line10, 1, original.line10.length - 2);
                System.arraycopy(original.line11, 2, animations.line11, 1, original.line11.length - 2);
                System.arraycopy(original.line12, 2, animations.line12, 1, original.line12.length - 2);
                System.arraycopy(original.line13, 2, animations.line13, 1, original.line13.length - 2);
                System.arraycopy(original.line14, 2, animations.line14, 1, original.line14.length - 2);
                System.arraycopy(original.line15, 2, animations.line15, 1, original.line15.length - 2);
                System.arraycopy(original.line16, 2, animations.line16, 1, original.line16.length - 2);
                System.arraycopy(original.line17, 2, animations.line17, 1, original.line17.length - 2);
                System.arraycopy(original.line18, 2, animations.line18, 1, original.line18.length - 2);
                System.arraycopy(original.line19, 2, animations.line19, 1, original.line19.length - 2);
                System.arraycopy(original.line20, 2, animations.line20, 1, original.line20.length - 2);
                System.arraycopy(original.line21, 2, animations.line21, 1, original.line21.length - 2);
                System.arraycopy(original.line22, 2, animations.line22, 1, original.line22.length - 2);
                System.arraycopy(original.line23, 2, animations.line23, 1, original.line23.length - 2);
                System.arraycopy(original.line24, 2, animations.line24, 1, original.line24.length - 2);
                System.arraycopy(original.line25, 2, animations.line25, 1, original.line25.length - 2);
                System.arraycopy(original.line26, 2, animations.line26, 1, original.line26.length - 2);

                System.arraycopy(original.line28, 2, animations.line28, 1, original.line28.length - 2);

                Arrays.fill(original.line28, ' ');
                Arrays.fill(original.line29, ' ');

                Arrays.fill(animations.line28, ' ');
                Arrays.fill(animations.line29, ' ');

                for (int i = 0; i < 5; i++) {
                    animations.out();
                    sleep(40);
                    original.out();
                    sleep(40);
                }
                sleep(300);
                this.out();
            }
            case GAME_OVER -> {
                Frame backup = new Frame();
                backup.clone(this);
                backup.buttonPos = this.buttonPos;
                char[] xArr = {
                        '█', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',
                        'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',
                        'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',
                        'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',
                        'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',
                        'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',
                        'X', 'X', 'X', 'X'
                };
                Arrays.fill(this.line28, ' ');
                Arrays.fill(this.line29, ' ');
                int sleepNum = 200;
                Frame frameNew = new Frame();
                Arrays.fill(frameNew.line28, ' ');
                Arrays.fill(frameNew.line29, ' ');
                Frame original = new Frame();
                Frame animations = new Frame();
                original.clone(this);
                animations.clone(this);
                Arrays.fill(animations.line28, ' ');
                Arrays.fill(animations.line29, ' ');

                this.out();
                sleep(sleepNum / 2);
                frameNew.out();
                sleep(sleepNum / 2);
                this.out();
                sleep(sleepNum / 2);
                frameNew.out();
                sleep(sleepNum / 2);
                this.out();
                sleep(sleepNum);
                frameNew.out();
                sleep(sleepNum);
                this.out();
                sleep(sleepNum);
                frameNew.out();
                sleep(sleepNum);
                this.out();
                sleep(sleepNum * 2);
                frameNew.out();
                sleep(sleepNum * 2);
                this.out();
                sleep(sleepNum * 2);
                frameNew.out();
                sleep(sleepNum * 2);
                this.out();

                animations.line4 = xArr;
                animations.line26 = xArr;
                sleep(sleepNum * 3);
                animations.out();
                animations.line5 = xArr;
                animations.line25 = xArr;
                sleep(sleepNum);
                animations.out();
                animations.line6 = xArr;
                animations.line24 = xArr;
                sleep(sleepNum);
                animations.out();
                animations.line7 = xArr;
                animations.line23 = xArr;
                sleep(sleepNum);
                animations.out();
                animations.line8 = xArr;
                animations.line22 = xArr;
                sleep(sleepNum);
                animations.out();
                animations.line9 = xArr;
                animations.line21 = xArr;
                sleep(sleepNum);
                animations.out();
                animations.line10 = xArr;
                animations.line20 = xArr;
                sleep(sleepNum);
                animations.out();
                animations.line11 = xArr;
                animations.line19 = xArr;
                sleep(sleepNum);
                animations.out();
                animations.line12 = xArr;
                animations.line18 = xArr;
                sleep(sleepNum);
                animations.out();
                animations.line13 = xArr;
                animations.line17 = xArr;
                sleep(sleepNum);
                animations.out();
                animations.line14 = xArr;
                animations.line16 = xArr;
                sleep(sleepNum);
                animations.out();
                animations.line15 = xArr;
                sleep(sleepNum);
                animations.out();

                sleep(sleepNum * 3);

                System.out.println(animationFrames[0][0] + "\n\n");
                sleep(sleepNum * 4);
                animations.out();
                sleep(sleepNum * 4);
                System.out.println(animationFrames[0][0] + "\n\n");
                sleep(sleepNum * 4);
                animations.out();
                sleep(sleepNum * 4);
                System.out.println(animationFrames[0][0] + "\n\n");
                sleep(sleepNum * 4);
                animations.out();
                sleep(sleepNum * 4);

                System.out.println(
                        animationFrames[0][0] + "\n" +
                                String.valueOf(delBlank(buttonPos, backup.line28)) + "\n" +
                                String.valueOf(backup.line29)
                );
            }
        }
    }

    //这块是我写的,没注释

    /**
     * 算了还是写一下吧
     * 这玩意就是为了适配而存在的
     * 没调selfClean()方法
     * 可以还原原来的延迟输出,例如读档时的变化
     */
    public void noCleanOut() {
        String frameStr = getFrameStr();
        System.out.println(frameStr);
    }


    /**
     * 清除char数组文本后的空格，防止cmd的自动换行造成Bug
     *
     * @param chars 传入需要处理的char数组
     * @return 返回处理完毕的char数组
     */
    private static char[] delBlank(char[] chars) {
        for (int i = 57; i < chars.length; i++) {
            if (chars[i] == ' ') {
                char[] newChars = new char[i + 1];
                System.arraycopy(chars, 0, newChars, 0, newChars.length);
                return newChars;
            }
        }
        return chars;
    }

    /**
     * 清除char数组文本后的空格，防止cmd的自动换行造成Bug
     *
     * @param chars 传入需要处理的char数组
     * @return 返回处理完毕的char数组
     */
    private static char[] delBlankForAttribute(char[] chars) {
        for (int i = Frame.attributeRetraction + 8; i < chars.length; i++) {
            if (chars[i] == ' ') {
                char[] newChars = new char[i + 1];
                System.arraycopy(chars, 0, newChars, 0, newChars.length);
                return newChars;
            }
        }
        return chars;
    }

    /**
     * 清除char数组按钮后的空格，按钮行专用
     *
     * @param offset 从哪里开始清除
     * @param chars  传入需要处理的char数组
     * @return 返回处理完毕的char数组
     */
    private static char[] delBlank(int offset, char[] chars) {
        for (int i = offset; i < chars.length; i++) {
            if (chars[i] == ' ') {
                char[] newChars = new char[i + 1];
                System.arraycopy(chars, 0, newChars, 0, newChars.length);
                return newChars;
            }
        }
        return chars;
    }

    /**
     * 复制一个全新的，一摸一样的Frame
     *
     * @param src 被clone的Frame
     */
    public void clone(Frame src) {

        System.arraycopy(src.line2, 0, this.line2, 0, src.line2.length);

        System.arraycopy(src.line4, 0, this.line4, 0, src.line4.length);
        System.arraycopy(src.line5, 0, this.line5, 0, src.line5.length);
        System.arraycopy(src.line6, 0, this.line6, 0, src.line6.length);
        System.arraycopy(src.line7, 0, this.line7, 0, src.line7.length);
        System.arraycopy(src.line8, 0, this.line8, 0, src.line8.length);
        System.arraycopy(src.line9, 0, this.line9, 0, src.line9.length);
        System.arraycopy(src.line10, 0, this.line10, 0, src.line10.length);
        System.arraycopy(src.line11, 0, this.line11, 0, src.line11.length);
        System.arraycopy(src.line12, 0, this.line12, 0, src.line12.length);
        System.arraycopy(src.line13, 0, this.line13, 0, src.line13.length);
        System.arraycopy(src.line14, 0, this.line14, 0, src.line14.length);
        System.arraycopy(src.line15, 0, this.line15, 0, src.line15.length);
        System.arraycopy(src.line16, 0, this.line16, 0, src.line16.length);
        System.arraycopy(src.line17, 0, this.line17, 0, src.line17.length);
        System.arraycopy(src.line18, 0, this.line18, 0, src.line18.length);
        System.arraycopy(src.line19, 0, this.line19, 0, src.line19.length);
        System.arraycopy(src.line20, 0, this.line20, 0, src.line20.length);
        System.arraycopy(src.line21, 0, this.line21, 0, src.line21.length);
        System.arraycopy(src.line22, 0, this.line22, 0, src.line22.length);
        System.arraycopy(src.line23, 0, this.line23, 0, src.line23.length);
        System.arraycopy(src.line24, 0, this.line24, 0, src.line24.length);
        System.arraycopy(src.line25, 0, this.line25, 0, src.line25.length);
        System.arraycopy(src.line26, 0, this.line26, 0, src.line26.length);

        System.arraycopy(src.line28, 0, this.line28, 0, src.line28.length);
    }

    /**
     * 你懂的
     */
    private static void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 动画帧的内容
     */
    private static final String[][] animationFrames = new String[][]{
            {
                    """
█=====================================================================================================================█
█
█=====================================================================================================================█
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXX        XXXXX   XXXXXX   X   XXXX        XXXXXXXXXXXX        XXX  XXXXX  XX         XX        XXXXXXXXXXXXX
█XXXXXXXXX  XXXXXXXXXXX  X  XXXXX       XXX  XXXXXXXXXXXXXXXXXX  XXXXXX  XX  XXXXX  XX  XXXXXXXXX  XXXXX  XXXXXXXXXXXX
█XXXXXXXXX  XXXXXXXXXXX  X  XXXX  XX XX  XX  XXXXXXXXXXXXXXXXXX  XXXXXX  XX  XXXXX  XX  XXXXXXXXX  XXXXX  XXXXXXXXXXXX
█XXXXXXXXX  XXXXXXXXXX  XXX  XXX  XX XX  XX  XXXXXXXXXXXXXXXXXX  XXXXXX  XXX  XXX  XXX  XXXXXXXXX  XXXX   XXXXXXXXXXXX
█XXXXXXXXX  XXX   XXX   XXX   XX  XX XX  XX         XXXXXXXXXXX  XXXXXX  XXX  XXX  XXX         XX       XXXXXXXXXXXXXX
█XXXXXXXXX  XXXXX  XX  XXXXX  XX  XX XX  XX  XXXXXXXXXXXXXXXXXX  XXXXXX  XXXX  X  XXXX  XXXXXXXXX  XX   XXXXXXXXXXXXXX
█XXXXXXXXX  XXXXX  XX         XX  XX XX  XX  XXXXXXXXXXXXXXXXXX  XXXXXX  XXXX  X  XXXX  XXXXXXXXX  XXXX  XXXXXXXXXXXXX
█XXXXXXXXXX       XXX  XXXXX  XX  XX XX  XXX        XXXXXXXXXXXX        XXXXXX   XXXXX         XX  XXXXX  XXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
█=====================================================================================================================█""",
            },
    };

    public void selfClean(Frame f) {
        this.lineNum = 1;

        this.attributeLine = 1;

        this.buttonCount = 1;
        this.buttonPos = 2 + buttonRetraction;

        this.line2 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line4 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line5 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line6 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line7 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line8 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line9 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line10 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line11 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line12 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line13 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line14 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line15 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line16 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line17 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line18 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line19 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line20 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line21 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line22 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line23 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line24 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line25 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line26 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.line28 = new char[]{'█', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};


    }

    public String getFrameStr() {
        return String.valueOf(this.line1) + "\n" +
                String.valueOf(delBlank(this.line2)) + "\n" +
                String.valueOf(this.line3) + "\n" +
                String.valueOf(delBlankForAttribute(this.line4)) + "\n" +
                String.valueOf(delBlank(this.line5)) + "\n" +
                String.valueOf(delBlankForAttribute(this.line6)) + "\n" +
                String.valueOf(delBlank(this.line7)) + "\n" +
                String.valueOf(delBlankForAttribute(this.line8)) + "\n" +
                String.valueOf(delBlank(this.line9)) + "\n" +
                String.valueOf(delBlankForAttribute(this.line10)) + "\n" +
                String.valueOf(delBlank(this.line11)) + "\n" +
                String.valueOf(delBlankForAttribute(this.line12)) + "\n" +
                String.valueOf(delBlank(this.line13)) + "\n" +
                String.valueOf(delBlankForAttribute(this.line14)) + "\n" +
                String.valueOf(delBlank(this.line15)) + "\n" +
                String.valueOf(delBlankForAttribute(this.line16)) + "\n" +
                String.valueOf(delBlank(this.line17)) + "\n" +
                String.valueOf(delBlankForAttribute(this.line18)) + "\n" +
                String.valueOf(delBlank(this.line19)) + "\n" +
                String.valueOf(delBlankForAttribute(this.line20)) + "\n" +
                String.valueOf(delBlank(this.line21)) + "\n" +
                String.valueOf(delBlankForAttribute(this.line22)) + "\n" +
                String.valueOf(delBlank(this.line23)) + "\n" +
                String.valueOf(delBlankForAttribute(this.line24)) + "\n" +
                String.valueOf(delBlank(this.line25)) + "\n" +
                String.valueOf(delBlankForAttribute(this.line26)) + "\n" +
                String.valueOf(this.line27) + "\n" +
                String.valueOf(delBlank(buttonPos, this.line28)) + "\n" +
                String.valueOf(this.line29);
    }
}
