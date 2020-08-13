import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class Typer {

    private static Robot robot;
    private static final int shortSleep;
    private static final int longSleep;
    private static Integer inventoryKey;
    private static Integer moveForward;
    private static Integer moveLeft;
    private static Integer moveBack;
    private static Integer moveRight;
    private static Integer sneak;
    private static Integer jump;
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
        if (s.equals("unknown")) {
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

    public static void pressKey (String s, int waitTime){
        pressKey(s);
        Waiter.wait(waitTime);
    }

    public static void pressKey (int i){
        robot.keyPress(i);
        robot.keyRelease(i);
    }
    
    public static void holdKey(String s){
        if (s.equals("unknown")) {
            System.out.println("Unknown key has been requested to type. Quitting... [TYPER]");
            System.exit(-1);
        }
        else if (k.get(s).size() == 1) {
            robot.keyPress(k.get(s).get(0));
        }
        else if (k.get(s).size() == 2) {
            robot.keyPress(k.get(s).get(1));
            robot.keyPress(k.get(s).get(0));
        }
    }

    public static void holdKey (String s, int waitTime){
        holdKey(s);
        Waiter.wait(waitTime);
    }

    public static void holdKey (int i){
        robot.keyPress(i);
    }

    public static void releaseKey(String s){
        if (s.equals("unknown")) {
            System.out.println("Unknown key has been requested to type. Quitting... [TYPER]");
            System.exit(-1);
        }
        else if (k.get(s).size() == 1) {
            robot.keyRelease(k.get(s).get(0));
        }
        else if (k.get(s).size() == 2) {
            robot.keyRelease(k.get(s).get(1));
            robot.keyRelease(k.get(s).get(0));
        }
    }

    public static void releaseKey (String s, int waitTime){
        releaseKey(s);
        Waiter.wait(waitTime);
    }

    public static void releaseKey (int i){
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
        pressKey("enter", longSleep);
    }

    public static void command(String text){
        type(text.substring(0,1));
        type(text.substring(1));
        pressKey("enter", longSleep);
    }

    public static void startMoveForward(){
        holdKey(moveForward);
    }

    public static void stopMoveForward(){
        releaseKey(moveForward);
    }

    public static void startMoveLeft(){
        holdKey(moveLeft);
    }

    public static void stopMoveLeft(){
        releaseKey(moveLeft);
    }

    public static void startMoveBack(){
        holdKey(moveBack);
    }

    public static void stopMoveBack(){
        releaseKey(moveBack);
    }

    public static void startMoveRight(){
        holdKey(moveRight);
    }

    public static void stopMoveRight(){
        releaseKey(moveRight);
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

    public static void openInventory(){
        pressKey(inventoryKey);
    }

    public static void sneak(){
        holdKey(sneak);
        Waiter.wait(50);
        releaseKey(sneak);
    }

    public static void doSneak(){
        holdKey(sneak);
    }

    public static void stopSneak(){
        releaseKey(sneak);
    }

    public static void jump(){
        holdKey(jump);
        Waiter.wait(50);
        releaseKey(jump);
    }

    public static void doJump(){
        holdKey(jump);
    }

    public static void stopJump(){
        releaseKey(jump);
    }

    public static void closeInventory(){
        pressKey("escape");
    }

    public static void setKeyBinds() throws IOException {
        inventoryKey = k.get(Filer.getInventoryKey()).get(0);

        String[] s = Filer.getMovementKeys();
        moveForward = k.get(s[0]).get(0);
        moveLeft = k.get(s[1]).get(0);
        moveBack = k.get(s[2]).get(0);
        moveRight = k.get(s[3]).get(0);
        sneak = k.get(s[4]).get(0);
        jump = k.get(s[5]).get(0);

    }

    public static void createHashMap(){

        k = new HashMap<>();

        //Begin lower case letters
        k.put("a", new ArrayList<>(Collections.singletonList(KeyEvent.VK_A)));
        k.put("b", new ArrayList<>(Collections.singletonList(KeyEvent.VK_B)));
        k.put("c", new ArrayList<>(Collections.singletonList(KeyEvent.VK_C)));
        k.put("d", new ArrayList<>(Collections.singletonList(KeyEvent.VK_D)));
        k.put("e", new ArrayList<>(Collections.singletonList(KeyEvent.VK_E)));
        k.put("f", new ArrayList<>(Collections.singletonList(KeyEvent.VK_F)));
        k.put("g", new ArrayList<>(Collections.singletonList(KeyEvent.VK_G)));
        k.put("h", new ArrayList<>(Collections.singletonList(KeyEvent.VK_H)));
        k.put("i", new ArrayList<>(Collections.singletonList(KeyEvent.VK_I)));
        k.put("j", new ArrayList<>(Collections.singletonList(KeyEvent.VK_J)));
        k.put("k", new ArrayList<>(Collections.singletonList(KeyEvent.VK_K)));
        k.put("l", new ArrayList<>(Collections.singletonList(KeyEvent.VK_L)));
        k.put("m", new ArrayList<>(Collections.singletonList(KeyEvent.VK_M)));
        k.put("n", new ArrayList<>(Collections.singletonList(KeyEvent.VK_N)));
        k.put("o", new ArrayList<>(Collections.singletonList(KeyEvent.VK_O)));
        k.put("p", new ArrayList<>(Collections.singletonList(KeyEvent.VK_P)));
        k.put("q", new ArrayList<>(Collections.singletonList(KeyEvent.VK_Q)));
        k.put("r", new ArrayList<>(Collections.singletonList(KeyEvent.VK_R)));
        k.put("s", new ArrayList<>(Collections.singletonList(KeyEvent.VK_S)));
        k.put("t", new ArrayList<>(Collections.singletonList(KeyEvent.VK_T)));
        k.put("u", new ArrayList<>(Collections.singletonList(KeyEvent.VK_U)));
        k.put("v", new ArrayList<>(Collections.singletonList(KeyEvent.VK_V)));
        k.put("w", new ArrayList<>(Collections.singletonList(KeyEvent.VK_W)));
        k.put("x", new ArrayList<>(Collections.singletonList(KeyEvent.VK_X)));
        k.put("y", new ArrayList<>(Collections.singletonList(KeyEvent.VK_Y)));
        k.put("z", new ArrayList<>(Collections.singletonList(KeyEvent.VK_Z)));
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
        k.put("1", new ArrayList<>(Collections.singletonList(KeyEvent.VK_1)));
        k.put("2", new ArrayList<>(Collections.singletonList(KeyEvent.VK_2)));
        k.put("3", new ArrayList<>(Collections.singletonList(KeyEvent.VK_3)));
        k.put("4", new ArrayList<>(Collections.singletonList(KeyEvent.VK_4)));
        k.put("5", new ArrayList<>(Collections.singletonList(KeyEvent.VK_5)));
        k.put("6", new ArrayList<>(Collections.singletonList(KeyEvent.VK_6)));
        k.put("7", new ArrayList<>(Collections.singletonList(KeyEvent.VK_7)));
        k.put("8", new ArrayList<>(Collections.singletonList(KeyEvent.VK_8)));
        k.put("9", new ArrayList<>(Collections.singletonList(KeyEvent.VK_9)));
        k.put("0", new ArrayList<>(Collections.singletonList(KeyEvent.VK_0)));
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

        //Begin Keypad Numbers
        k.put("NP1", new ArrayList<>(Collections.singletonList(KeyEvent.VK_NUMPAD1)));
        k.put("NP2", new ArrayList<>(Collections.singletonList(KeyEvent.VK_NUMPAD2)));
        k.put("NP3", new ArrayList<>(Collections.singletonList(KeyEvent.VK_NUMPAD3)));
        k.put("NP4", new ArrayList<>(Collections.singletonList(KeyEvent.VK_NUMPAD4)));
        k.put("NP5", new ArrayList<>(Collections.singletonList(KeyEvent.VK_NUMPAD5)));
        k.put("NP6", new ArrayList<>(Collections.singletonList(KeyEvent.VK_NUMPAD6)));
        k.put("NP7", new ArrayList<>(Collections.singletonList(KeyEvent.VK_NUMPAD7)));
        k.put("NP8", new ArrayList<>(Collections.singletonList(KeyEvent.VK_NUMPAD8)));
        k.put("NP9", new ArrayList<>(Collections.singletonList(KeyEvent.VK_NUMPAD9)));
        k.put("NP0", new ArrayList<>(Collections.singletonList(KeyEvent.VK_NUMPAD0)));
        //End Keypad Numbers

        //Begin symbols
        k.put(";", new ArrayList<>(Collections.singletonList(KeyEvent.VK_SEMICOLON)));
        k.put(":", new ArrayList<>(Arrays.asList(KeyEvent.VK_SEMICOLON, KeyEvent.VK_SHIFT)));

        k.put("tab", new ArrayList<>(Collections.singletonList(KeyEvent.VK_TAB)));
        k.put("\t", new ArrayList<>(Collections.singletonList(KeyEvent.VK_TAB)));

        k.put("period", new ArrayList<>(Collections.singletonList(KeyEvent.VK_PERIOD)));
        k.put(".", new ArrayList<>(Collections.singletonList(KeyEvent.VK_PERIOD)));
        k.put(">", new ArrayList<>(Arrays.asList(KeyEvent.VK_PERIOD, KeyEvent.VK_SHIFT)));

        k.put("comma", new ArrayList<>(Collections.singletonList(KeyEvent.VK_COMMA)));
        k.put(",", new ArrayList<>(Collections.singletonList(KeyEvent.VK_COMMA)));
        k.put("<", new ArrayList<>(Arrays.asList(KeyEvent.VK_COMMA, KeyEvent.VK_SHIFT)));

        k.put("/", new ArrayList<>(Collections.singletonList(KeyEvent.VK_SLASH)));
        k.put("?", new ArrayList<>(Arrays.asList(KeyEvent.VK_SLASH, KeyEvent.VK_SHIFT)));

        k.put("`", new ArrayList<>(Collections.singletonList(192)));
        k.put("~", new ArrayList<>(Arrays.asList(192, KeyEvent.VK_SHIFT)));

        k.put("-", new ArrayList<>(Collections.singletonList(KeyEvent.VK_MINUS)));
        k.put("_", new ArrayList<>(Arrays.asList(KeyEvent.VK_MINUS, KeyEvent.VK_SHIFT)));

        k.put("=", new ArrayList<>(Collections.singletonList(KeyEvent.VK_EQUALS)));
        k.put("+", new ArrayList<>(Arrays.asList(KeyEvent.VK_PLUS, KeyEvent.VK_SHIFT)));

        k.put("[", new ArrayList<>(Collections.singletonList(KeyEvent.VK_OPEN_BRACKET)));
        k.put("{", new ArrayList<>(Arrays.asList(KeyEvent.VK_OPEN_BRACKET, KeyEvent.VK_SHIFT)));

        k.put("]", new ArrayList<>(Collections.singletonList(KeyEvent.VK_CLOSE_BRACKET)));
        k.put("}", new ArrayList<>(Arrays.asList(KeyEvent.VK_CLOSE_BRACKET, KeyEvent.VK_SHIFT)));

        k.put("space", new ArrayList<>(Collections.singletonList(KeyEvent.VK_SPACE)));
        k.put(" ", new ArrayList<>(Collections.singletonList(KeyEvent.VK_SPACE)));


        k.put("enter", new ArrayList<>(Collections.singletonList(KeyEvent.VK_ENTER)));
        k.put("shift", new ArrayList<>(Collections.singletonList(KeyEvent.VK_SHIFT)));
        k.put("left.shift", new ArrayList<>(Collections.singletonList(KeyEvent.VK_SHIFT)));
        k.put("control", new ArrayList<>(Collections.singletonList(KeyEvent.VK_CONTROL)));
        k.put("escape", new ArrayList<>(Collections.singletonList(KeyEvent.VK_ESCAPE)));
        k.put("left.control", new ArrayList<>(Collections.singletonList(KeyEvent.VK_CONTROL)));



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
        k.put("unknown", new ArrayList<>(Collections.singletonList(-1)));

    }
}
