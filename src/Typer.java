import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class Typer {

    private static Robot robot;
    private static int shortSleep;
    private static int longSleep;
    private static String inventoryKey = "e";

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        shortSleep = 25;
        longSleep = 100;
    }

    public static void type(String text) {
        for(int i = 0; i < text.length(); i++){
            Waiter.wait(shortSleep);
            pressKey(text.charAt(i));
        }
        Waiter.wait(longSleep);
    }

    public static void type(String text, int sleepS, int sleepL) {
        for(int i = 0; i < text.length(); i++){
            Waiter.wait(sleepS);
            pressKey(text.charAt(i));
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

    public static void holdEscape(int sleepTime) {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        Waiter.wait(sleepTime);
    }

    public static void releaseEscape(int sleepTime) {
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Waiter.wait(sleepTime);
    }

    public static void openInventory(){
        Typer.type(inventoryKey, shortSleep, longSleep);
        Waiter.wait(longSleep);
    }

    public static void closeInventory(){
        Typer.type(inventoryKey, shortSleep, longSleep);
        Waiter.wait(longSleep);
    }

    public static void setInventoryKey(String e){
        inventoryKey = e;
    }

    public static void pressKey(char c){

        switch(c) {
            case 'a':
                robot.keyPress(KeyEvent.VK_A);
                robot.keyRelease(KeyEvent.VK_A);
                break;
            case 'b':
                robot.keyPress(KeyEvent.VK_B);
                robot.keyRelease(KeyEvent.VK_B);
                break;
            case 'c':
                robot.keyPress(KeyEvent.VK_C);
                robot.keyRelease(KeyEvent.VK_C);
                break;
            case 'd':
                robot.keyPress(KeyEvent.VK_D);
                robot.keyRelease(KeyEvent.VK_D);
                break;
            case 'e':
                robot.keyPress(KeyEvent.VK_E);
                robot.keyRelease(KeyEvent.VK_E);
                break;
            case 'f':
                robot.keyPress(KeyEvent.VK_F);
                robot.keyRelease(KeyEvent.VK_F);
                break;
            case 'g':
                robot.keyPress(KeyEvent.VK_G);
                robot.keyRelease(KeyEvent.VK_G);
                break;
            case 'h':
                robot.keyPress(KeyEvent.VK_H);
                robot.keyRelease(KeyEvent.VK_H);
                break;
            case 'i':
                robot.keyPress(KeyEvent.VK_I);
                robot.keyRelease(KeyEvent.VK_I);
                break;
            case 'j':
                robot.keyPress(KeyEvent.VK_J);
                robot.keyRelease(KeyEvent.VK_J);
                break;
            case 'k':
                robot.keyPress(KeyEvent.VK_K);
                robot.keyRelease(KeyEvent.VK_K);
                break;
            case 'l':
                robot.keyPress(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_L);
                break;
            case 'm':
                robot.keyPress(KeyEvent.VK_M);
                robot.keyRelease(KeyEvent.VK_M);
                break;
            case 'n':
                robot.keyPress(KeyEvent.VK_N);
                robot.keyRelease(KeyEvent.VK_N);
                break;
            case 'o':
                robot.keyPress(KeyEvent.VK_O);
                robot.keyRelease(KeyEvent.VK_O);
                break;
            case 'p':
                robot.keyPress(KeyEvent.VK_P);
                robot.keyRelease(KeyEvent.VK_P);
                break;
            case 'q':
                robot.keyPress(KeyEvent.VK_Q);
                robot.keyRelease(KeyEvent.VK_Q);
                break;
            case 'r':
                robot.keyPress(KeyEvent.VK_R);
                robot.keyRelease(KeyEvent.VK_R);
                break;
            case 's':
                robot.keyPress(KeyEvent.VK_S);
                robot.keyRelease(KeyEvent.VK_S);
                break;
            case 't':
                robot.keyPress(KeyEvent.VK_T);
                robot.keyRelease(KeyEvent.VK_T);
                break;
            case 'u':
                robot.keyPress(KeyEvent.VK_U);
                robot.keyRelease(KeyEvent.VK_U);
                break;
            case 'v':
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                break;
            case 'w':
                robot.keyPress(KeyEvent.VK_W);
                robot.keyRelease(KeyEvent.VK_W);
                break;
            case 'x':
                robot.keyPress(KeyEvent.VK_X);
                robot.keyRelease(KeyEvent.VK_X);
                break;
            case 'y':
                robot.keyPress(KeyEvent.VK_Y);
                robot.keyRelease(KeyEvent.VK_Y);
                break;
            case 'z':
                robot.keyPress(KeyEvent.VK_Z);
                robot.keyRelease(KeyEvent.VK_Z);
                break;
            case 'A':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_A);
                robot.keyRelease(KeyEvent.VK_A);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'B':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_B);
                robot.keyRelease(KeyEvent.VK_B);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'C':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_C);
                robot.keyRelease(KeyEvent.VK_C);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'D':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_D);
                robot.keyRelease(KeyEvent.VK_D);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'E':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_E);
                robot.keyRelease(KeyEvent.VK_E);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'F':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_F);
                robot.keyRelease(KeyEvent.VK_F);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'G':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_G);
                robot.keyRelease(KeyEvent.VK_G);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'H':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_H);
                robot.keyRelease(KeyEvent.VK_H);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'I':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_I);
                robot.keyRelease(KeyEvent.VK_I);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'J':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_J);
                robot.keyRelease(KeyEvent.VK_J);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'K':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_K);
                robot.keyRelease(KeyEvent.VK_K);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'L':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'M':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_M);
                robot.keyRelease(KeyEvent.VK_M);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'N':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_N);
                robot.keyRelease(KeyEvent.VK_N);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'O':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_O);
                robot.keyRelease(KeyEvent.VK_O);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'P':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_P);
                robot.keyRelease(KeyEvent.VK_P);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'Q':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_Q);
                robot.keyRelease(KeyEvent.VK_Q);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'R':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_R);
                robot.keyRelease(KeyEvent.VK_R);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'S':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_S);
                robot.keyRelease(KeyEvent.VK_S);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'T':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_T);
                robot.keyRelease(KeyEvent.VK_T);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'U':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_U);
                robot.keyRelease(KeyEvent.VK_U);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'V':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'W':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_W);
                robot.keyRelease(KeyEvent.VK_W);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'X':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_X);
                robot.keyRelease(KeyEvent.VK_X);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'Y':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_Y);
                robot.keyRelease(KeyEvent.VK_Y);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case 'Z':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_Z);
                robot.keyRelease(KeyEvent.VK_Z);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case '0':
                robot.keyPress(KeyEvent.VK_0);
                robot.keyRelease(KeyEvent.VK_0);
                break;
            case '1':
                robot.keyPress(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_1);
                break;
            case '2':
                robot.keyPress(KeyEvent.VK_2);
                robot.keyRelease(KeyEvent.VK_2);
                break;
            case '3':
                robot.keyPress(KeyEvent.VK_3);
                robot.keyRelease(KeyEvent.VK_3);
                break;
            case '4':
                robot.keyPress(KeyEvent.VK_4);
                robot.keyRelease(KeyEvent.VK_4);
                break;
            case '5':
                robot.keyPress(KeyEvent.VK_5);
                robot.keyRelease(KeyEvent.VK_5);
                break;
            case '6':
                robot.keyPress(KeyEvent.VK_6);
                robot.keyRelease(KeyEvent.VK_6);
                break;
            case '7':
                robot.keyPress(KeyEvent.VK_7);
                robot.keyRelease(KeyEvent.VK_7);
                break;
            case '8':
                robot.keyPress(KeyEvent.VK_8);
                robot.keyRelease(KeyEvent.VK_8);
                break;
            case '9':
                robot.keyPress(KeyEvent.VK_9);
                robot.keyRelease(KeyEvent.VK_9);
                break;
            case '.':
                robot.keyPress(KeyEvent.VK_PERIOD);
                robot.keyRelease(KeyEvent.VK_PERIOD);
                break;
            case ',':
                robot.keyPress(KeyEvent.VK_COMMA);
                robot.keyRelease(KeyEvent.VK_COMMA);
                break;
            case ' ':
                robot.keyPress(KeyEvent.VK_SPACE);
                robot.keyRelease(KeyEvent.VK_SPACE);
                break;
            case '-':
                robot.keyPress(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_MINUS);
                break;
            case '_':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case ':':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case '~':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(192);
                robot.keyRelease(192);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case '/':
                robot.keyPress(KeyEvent.VK_SLASH);
                robot.keyRelease(KeyEvent.VK_SLASH);
                break;
            case '{':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
                robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case '}':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
                robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case '[':
                robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
                robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
                break;
            case ']':
                robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
                robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
                break;
            case '@':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_2);
                robot.keyRelease(KeyEvent.VK_2);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case '=':
                robot.keyPress(KeyEvent.VK_EQUALS);
                robot.keyRelease(KeyEvent.VK_EQUALS);
                break;
            case '!':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
        }
    }
}
