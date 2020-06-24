import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

public class Exiter {
    public Exiter(){
        WinUser.HOOKPROC hookProc = new HOOKPROC_bg();
        WinDef.HINSTANCE hInst = Kernel32.INSTANCE.GetModuleHandle(null);

        User32.HHOOK hHook = User32.INSTANCE.SetWindowsHookEx(User32.WH_KEYBOARD_LL, hookProc, hInst, 0);
        if (hHook == null)
            return;
        User32.MSG msg = new User32.MSG();
        System.err.println("Please press any key ....");
        while (true) {
            User32.INSTANCE.GetMessage(msg, null, 0, 0);
        }
    }
}


class HOOKPROC_bg implements WinUser.HOOKPROC {

    public HOOKPROC_bg() {
    }

    public WinDef.LRESULT callback(int nCode, WinDef.WPARAM wParam, WinDef.LPARAM lParam) {
        System.err.println("callback bbbnhkilhjkibh nCode: " + nCode);
        return new WinDef.LRESULT(0);
    }
}
