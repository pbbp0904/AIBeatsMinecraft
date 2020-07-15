import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Typer {

    private static Robot robot;
    private static int shortSleep;
    private static int longSleep;
    private static Integer inventoryKey;
    private static String moveForward;
    private static String moveLeft;
    private static String moveBack;
    private static String moveRight;
    private static HashMap<String, ArrayList<Integer>> k;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        shortSleep = Waiter.getShortSleepTime();
        longSleep = Waiter.getLongSleepTime();

        createHashMap();

        try {
            setKeyBinds();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pressKey (String s){
        if (s == "unknown") {
            System.out.println("Unknown key has been requested to type. Quitting... [TYPER]");
            System.exit(-1);
        }
        else if (k.get(s).size() == 1) {
            robot.keyPress(k.get(s).get(0));
            robot.keyRelease(k.get(s).get(0));
            Waiter.waitShort();
        }
        else if (k.get(s).size() == 2) {
            robot.keyPress(k.get(s).get(1));
            robot.keyPress(k.get(s).get(0));
            robot.keyRelease(k.get(s).get(0));
            robot.keyRelease(k.get(s).get(1));
            Waiter.waitShort();
        }
    }

    public static void pressKey (String s, int waitTime){
        if (s == "unknown") {
            System.out.println("Unknown key has been requested to type. Quitting... [TYPER]");
            System.exit(-1);
        }
        else if (k.get(s).size() == 1) {
            robot.keyPress(k.get(s).get(0));
            robot.keyRelease(k.get(s).get(0));
        }
        else if (k.get(s).size() == 2) {
            robot.keyPress(k.get(s).get(1));
            robot.keyPress(k.get(s).get(0));
            robot.keyRelease(k.get(s).get(0));
            robot.keyRelease(k.get(s).get(1));
        }
    }

    public static void pressKey (int i){
        robot.keyPress(i);
        robot.keyRelease(i);
    }

    public static void type(String text) {
        for(int i = 0; i < text.length(); i++){
            Waiter.wait(shortSleep);
            pressKey(text.substring(i, i + 1));
        }
        Waiter.wait(longSleep);
    }

    public static void type(String text, int sleepS, int sleepL) {
        for(int i = 0; i < text.length(); i++){
            Waiter.wait(sleepS);
            pressKey(text.substring(i, i + 1));
        }
        Waiter.wait(sleepL);
    }

    public static void command(String text, int sleepS, int sleepL){
        type(text.substring(0,1), sleepS, sleepL);
        type(text.substring(1), sleepS, sleepL);
        pressEnter(longSleep);
    }

    public static void command(String text){
        type(text.substring(0,1));
        type(text.substring(1));
        pressEnter(longSleep);
    }

    public static void holdS(int sleepTime) {
        robot.keyPress(KeyEvent.VK_S);
        Waiter.wait(sleepTime);
    }

    public static void releaseS(int sleepTime) {
        robot.keyRelease(KeyEvent.VK_S);
        Waiter.wait(sleepTime);
    }

    public static void holdD(int sleepTime) {
        robot.keyPress(KeyEvent.VK_D);
        Waiter.wait(sleepTime);
    }

    public static void releaseD(int sleepTime) {
        robot.keyRelease(KeyEvent.VK_D);
        Waiter.wait(sleepTime);
    }

    public static void holdSpace(int sleepTime){
        robot.keyPress(KeyEvent.VK_SPACE);
        Waiter.wait(sleepTime);
    }

    public static void releaseSpace(int sleepTime) {
        robot.keyRelease(KeyEvent.VK_SPACE);
        Waiter.wait(sleepTime);
    }

    public static void leftClick(int sleepTime){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Waiter.wait(sleepTime);
    }

    public static void rightClick(int sleepTime){
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        Waiter.wait(sleepTime);
    }

    public static void holdLeftClick(int sleepTime) {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Waiter.wait(sleepTime);
    }

    public static void releaseLeftClick(int sleepTime) {
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Waiter.wait(sleepTime);
    }

    public static void holdRightClick(int sleepTime) {
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        Waiter.wait(sleepTime);
    }

    public static void releaseRightClick(int sleepTime) {
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        Waiter.wait(sleepTime);
    }

    public static void holdShift(int sleepTime) {
        robot.keyPress(KeyEvent.VK_SHIFT);
        Waiter.wait(sleepTime);
    }

    public static void releaseShift(int sleepTime) {
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Waiter.wait(sleepTime);
    }

    public static void pressEnter(int sleepTime) {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Waiter.wait(sleepTime);
    }

    public static void pressTab(int sleepTime) {
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Waiter.wait(sleepTime);
    }

    public static void pressEscape(int sleepTime) {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Waiter.wait(sleepTime);
    }

    public static void pressEnter() {
        pressKey("enter");
    }

    public static void pressTab() {
        pressKey("tab");
    }

    public static void pressEscape() {
        pressKey("escape");
    }

    public static void pressLControl() {
        robot.keyPress(0xA2);
        robot.keyRelease(0xA2);
    }

    public static void holdEscape(int sleepTime) {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        Waiter.wait(sleepTime);
    }

    public static void releaseEscape(int sleepTime) {
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Waiter.wait(sleepTime);
    }

    public static void openInventory(){

        Waiter.waitShort();
    }

    public static void closeInventory(){
        pressEscape();
        Waiter.waitShort();
    }

    public static void setKeyBinds() throws IOException {
        inventoryKey = k.get(Filer.getInventoryKey()).get(0);

        String[] s = Filer.getMovementKeys();
        s[0] = moveForward;
        s[1] = moveLeft;
        s[2] = moveBack;
        s[3] = moveRight;
    }

    public static void createHashMap(){

        //Begin lower case letters
        k.put("a", new ArrayList<>(Arrays.asList(KeyEvent.VK_A)));
        k.put("b", new ArrayList<>(Arrays.asList(KeyEvent.VK_B)));
        k.put("c", new ArrayList<>(Arrays.asList(KeyEvent.VK_C)));
        k.put("d", new ArrayList<>(Arrays.asList(KeyEvent.VK_D)));
        k.put("e", new ArrayList<>(Arrays.asList(KeyEvent.VK_E)));
        k.put("f", new ArrayList<>(Arrays.asList(KeyEvent.VK_F)));
        k.put("g", new ArrayList<>(Arrays.asList(KeyEvent.VK_G)));
        k.put("h", new ArrayList<>(Arrays.asList(KeyEvent.VK_H)));
        k.put("i", new ArrayList<>(Arrays.asList(KeyEvent.VK_I)));
        k.put("j", new ArrayList<>(Arrays.asList(KeyEvent.VK_J)));
        k.put("k", new ArrayList<>(Arrays.asList(KeyEvent.VK_K)));
        k.put("l", new ArrayList<>(Arrays.asList(KeyEvent.VK_L)));
        k.put("m", new ArrayList<>(Arrays.asList(KeyEvent.VK_M)));
        k.put("n", new ArrayList<>(Arrays.asList(KeyEvent.VK_N)));
        k.put("o", new ArrayList<>(Arrays.asList(KeyEvent.VK_O)));
        k.put("p", new ArrayList<>(Arrays.asList(KeyEvent.VK_P)));
        k.put("q", new ArrayList<>(Arrays.asList(KeyEvent.VK_Q)));
        k.put("r", new ArrayList<>(Arrays.asList(KeyEvent.VK_R)));
        k.put("s", new ArrayList<>(Arrays.asList(KeyEvent.VK_S)));
        k.put("t", new ArrayList<>(Arrays.asList(KeyEvent.VK_T)));
        k.put("u", new ArrayList<>(Arrays.asList(KeyEvent.VK_U)));
        k.put("v", new ArrayList<>(Arrays.asList(KeyEvent.VK_V)));
        k.put("w", new ArrayList<>(Arrays.asList(KeyEvent.VK_W)));
        k.put("x", new ArrayList<>(Arrays.asList(KeyEvent.VK_X)));
        k.put("y", new ArrayList<>(Arrays.asList(KeyEvent.VK_Y)));
        k.put("z", new ArrayList<>(Arrays.asList(KeyEvent.VK_Z)));
        //End lower case letters


        //Begin capital letters
        k.put("A", new ArrayList<>(Arrays.asList(KeyEvent.VK_A, KeyEvent.VK_SHIFT)));
        k.put("B", new ArrayList<>(Arrays.asList(KeyEvent.VK_B, KeyEvent.VK_SHIFT)));
        k.put("C", new ArrayList<>(Arrays.asList(KeyEvent.VK_C, KeyEvent.VK_SHIFT)));
        k.put("D", new ArrayList<>(Arrays.asList(KeyEvent.VK_D, KeyEvent.VK_SHIFT)));
        k.put("E", new ArrayList<>(Arrays.asList(KeyEvent.VK_E, KeyEvent.VK_SHIFT)));
        k.put("F", new ArrayList<>(Arrays.asList(KeyEvent.VK_F, KeyEvent.VK_SHIFT)));
        k.put("G", new ArrayList<>(Arrays.asList(KeyEvent.VK_G, KeyEvent.VK_SHIFT)));
        k.put("H", new ArrayList<>(Arrays.asList(KeyEvent.VK_H, KeyEvent.VK_SHIFT)));
        k.put("I", new ArrayList<>(Arrays.asList(KeyEvent.VK_I, KeyEvent.VK_SHIFT)));
        k.put("J", new ArrayList<>(Arrays.asList(KeyEvent.VK_J, KeyEvent.VK_SHIFT)));
        k.put("K", new ArrayList<>(Arrays.asList(KeyEvent.VK_K, KeyEvent.VK_SHIFT)));
        k.put("L", new ArrayList<>(Arrays.asList(KeyEvent.VK_L, KeyEvent.VK_SHIFT)));
        k.put("M", new ArrayList<>(Arrays.asList(KeyEvent.VK_M, KeyEvent.VK_SHIFT)));
        k.put("N", new ArrayList<>(Arrays.asList(KeyEvent.VK_N, KeyEvent.VK_SHIFT)));
        k.put("O", new ArrayList<>(Arrays.asList(KeyEvent.VK_O, KeyEvent.VK_SHIFT)));
        k.put("P", new ArrayList<>(Arrays.asList(KeyEvent.VK_P, KeyEvent.VK_SHIFT)));
        k.put("Q", new ArrayList<>(Arrays.asList(KeyEvent.VK_Q, KeyEvent.VK_SHIFT)));
        k.put("R", new ArrayList<>(Arrays.asList(KeyEvent.VK_R, KeyEvent.VK_SHIFT)));
        k.put("S", new ArrayList<>(Arrays.asList(KeyEvent.VK_S, KeyEvent.VK_SHIFT)));
        k.put("T", new ArrayList<>(Arrays.asList(KeyEvent.VK_T, KeyEvent.VK_SHIFT)));
        k.put("U", new ArrayList<>(Arrays.asList(KeyEvent.VK_U, KeyEvent.VK_SHIFT)));
        k.put("V", new ArrayList<>(Arrays.asList(KeyEvent.VK_V, KeyEvent.VK_SHIFT)));
        k.put("W", new ArrayList<>(Arrays.asList(KeyEvent.VK_W, KeyEvent.VK_SHIFT)));
        k.put("X", new ArrayList<>(Arrays.asList(KeyEvent.VK_X, KeyEvent.VK_SHIFT)));
        k.put("Y", new ArrayList<>(Arrays.asList(KeyEvent.VK_Y, KeyEvent.VK_SHIFT)));
        k.put("Z", new ArrayList<>(Arrays.asList(KeyEvent.VK_Z, KeyEvent.VK_SHIFT)));
        //End captial letters


        //Begin numbers
        k.put("1", new ArrayList<>(Arrays.asList(KeyEvent.VK_1)));
        k.put("2", new ArrayList<>(Arrays.asList(KeyEvent.VK_2)));
        k.put("3", new ArrayList<>(Arrays.asList(KeyEvent.VK_3)));
        k.put("4", new ArrayList<>(Arrays.asList(KeyEvent.VK_4)));
        k.put("5", new ArrayList<>(Arrays.asList(KeyEvent.VK_5)));
        k.put("6", new ArrayList<>(Arrays.asList(KeyEvent.VK_6)));
        k.put("7", new ArrayList<>(Arrays.asList(KeyEvent.VK_7)));
        k.put("8", new ArrayList<>(Arrays.asList(KeyEvent.VK_8)));
        k.put("9", new ArrayList<>(Arrays.asList(KeyEvent.VK_9)));
        k.put("0", new ArrayList<>(Arrays.asList(KeyEvent.VK_0)));
        k.put("!", new ArrayList<>(Arrays.asList(KeyEvent.VK_1, KeyEvent.VK_SHIFT)));
        k.put("@", new ArrayList<>(Arrays.asList(KeyEvent.VK_2, KeyEvent.VK_SHIFT)));
        k.put("#", new ArrayList<>(Arrays.asList(KeyEvent.VK_3, KeyEvent.VK_SHIFT)));
        k.put("$", new ArrayList<>(Arrays.asList(KeyEvent.VK_4, KeyEvent.VK_SHIFT)));
        k.put("%", new ArrayList<>(Arrays.asList(KeyEvent.VK_5, KeyEvent.VK_SHIFT)));
        k.put("^", new ArrayList<>(Arrays.asList(KeyEvent.VK_6, KeyEvent.VK_SHIFT)));
        k.put("&", new ArrayList<>(Arrays.asList(KeyEvent.VK_7, KeyEvent.VK_SHIFT)));
        k.put("*", new ArrayList<>(Arrays.asList(KeyEvent.VK_8, KeyEvent.VK_SHIFT)));
        k.put("(", new ArrayList<>(Arrays.asList(KeyEvent.VK_9, KeyEvent.VK_SHIFT)));
        k.put(")", new ArrayList<>(Arrays.asList(KeyEvent.VK_0, KeyEvent.VK_SHIFT)));
        //End Numbers


        //Begin symbols
        k.put(";", new ArrayList<>(Arrays.asList(KeyEvent.VK_SEMICOLON)));
        k.put(":", new ArrayList<>(Arrays.asList(KeyEvent.VK_SEMICOLON, KeyEvent.VK_SHIFT)));

        k.put("tab", new ArrayList<>(Arrays.asList(KeyEvent.VK_TAB)));
        k.put("\t", new ArrayList<>(Arrays.asList(KeyEvent.VK_TAB)));

        k.put("period", new ArrayList<>(Arrays.asList(KeyEvent.VK_PERIOD)));
        k.put(".", new ArrayList<>(Arrays.asList(KeyEvent.VK_PERIOD)));
        k.put(">", new ArrayList<>(Arrays.asList(KeyEvent.VK_PERIOD, KeyEvent.VK_SHIFT)));

        k.put("comma", new ArrayList<>(Arrays.asList(KeyEvent.VK_COMMA)));
        k.put(",", new ArrayList<>(Arrays.asList(KeyEvent.VK_COMMA)));
        k.put("<", new ArrayList<>(Arrays.asList(KeyEvent.VK_COMMA, KeyEvent.VK_SHIFT)));

        k.put("/", new ArrayList<>(Arrays.asList(KeyEvent.VK_SLASH)));
        k.put("?", new ArrayList<>(Arrays.asList(KeyEvent.VK_SLASH, KeyEvent.VK_SHIFT)));

        k.put("`", new ArrayList<>(Arrays.asList(192)));
        k.put("~", new ArrayList<>(Arrays.asList(192, KeyEvent.VK_SHIFT)));

        k.put("-", new ArrayList<>(Arrays.asList(KeyEvent.VK_MINUS)));
        k.put("_", new ArrayList<>(Arrays.asList(KeyEvent.VK_MINUS, KeyEvent.VK_SHIFT)));

        k.put("=", new ArrayList<>(Arrays.asList(KeyEvent.VK_EQUALS)));
        k.put("+", new ArrayList<>(Arrays.asList(KeyEvent.VK_PLUS, KeyEvent.VK_SHIFT)));

        k.put("[", new ArrayList<>(Arrays.asList(KeyEvent.VK_OPEN_BRACKET)));
        k.put("{", new ArrayList<>(Arrays.asList(KeyEvent.VK_OPEN_BRACKET, KeyEvent.VK_SHIFT)));

        k.put("]", new ArrayList<>(Arrays.asList(KeyEvent.VK_CLOSE_BRACKET)));
        k.put("}", new ArrayList<>(Arrays.asList(KeyEvent.VK_CLOSE_BRACKET, KeyEvent.VK_SHIFT)));

        k.put("space", new ArrayList<>(Arrays.asList(KeyEvent.VK_SPACE)));
        k.put(" ", new ArrayList<>(Arrays.asList(KeyEvent.VK_SPACE)));


        k.put("enter", new ArrayList<>(Arrays.asList(KeyEvent.VK_ENTER)));
        k.put("shift", new ArrayList<>(Arrays.asList(KeyEvent.VK_SHIFT)));
        k.put("control", new ArrayList<>(Arrays.asList(KeyEvent.VK_CONTROL)));
        k.put("escape", new ArrayList<>(Arrays.asList(KeyEvent.VK_ESCAPE)));



        //For your copy pasta pleasure, blank hashmap assign statements

//        k.put("", new ArrayList<>(Arrays.asList(KeyEvent.VK_)));
//        k.put("", new ArrayList<>(Arrays.asList(KeyEvent.VK_)));
//
//
//        k.put("", new ArrayList<>(Arrays.asList(KeyEvent.VK_, KeyEvent.VK_SHIFT)));
//        k.put("", new ArrayList<>(Arrays.asList(KeyEvent.VK_, KeyEvent.VK_SHIFT)));
//
//
//        k.put("", new ArrayList<>(Arrays.asList(KeyEvent.VK_)));
//        k.put("", new ArrayList<>(Arrays.asList(KeyEvent.VK_, KeyEvent.VK_SHIFT)));

        //End symbols

        //Unknown key. Only used in minecraft congif file for unassigned keys
        k.put("unknown", new ArrayList<>(Arrays.asList(-1)));

    }
}
