import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

public class Exiter {

    User32.MSG msg;
    User32.HHOOK hHook;

    public Exiter(){
        WinUser.HOOKPROC hookProc = new HOOKPROC_bg();
        WinDef.HINSTANCE hInst = Kernel32.INSTANCE.GetModuleHandle(null);
        if(hHook!=null) {
            return;
        }
        User32.HHOOK hHook = User32.INSTANCE.SetWindowsHookEx(User32.WH_KEYBOARD_LL, hookProc, hInst, 0);
        msg = new User32.MSG();
    }
    public void checkExit(){
        User32.INSTANCE.GetMessage(msg, null, 1, 1);
        msg = new User32.MSG();
    }
}


class HOOKPROC_bg implements WinUser.HOOKPROC {

    public HOOKPROC_bg() {
    }

    public WinDef.LRESULT callback(int nCode, WinDef.WPARAM wParam, WinUser.KBDLLHOOKSTRUCT info) {

        // Escape is 27
        if (info.vkCode==26) {
            System.out.println("Exited program");
            System.exit(0);
        }
        return new WinDef.LRESULT(0);
    }
}
