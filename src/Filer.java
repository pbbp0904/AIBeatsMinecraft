import com.sun.jna.platform.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;

public class Filer {

    public static void incrementRunCounter() throws IOException, InterruptedException {
        // Read number
        File file = new File("src\\runCounter.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String text = reader.readLine();
        int count = Integer.parseInt(text);
        count = count + 1;
        reader.close();

        Thread.sleep(50);

        //Write number
        FileWriter writer = new FileWriter("src\\runCounter.txt", false);
        writer.write(String.valueOf(count));
        writer.close();
    }

    public static int getGUIScale() throws IOException {
        // Read the number
        String appData = System.getenv("APPDATA");
        File file = new File(appData + "\\.minecraft\\options.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String st;
        while ((st = reader.readLine()) != null) {
            if (st.contains("guiScale:")) {
                System.out.println();
                return Integer.parseInt(st.substring(9, 10));
            }
        }
        return 0;
    }

    public static String getInventoryKey() throws IOException {
        // Read the number
        String appData = System.getenv("APPDATA");
        File file = new File(appData + "\\.minecraft\\options.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String st;
        while ((st = reader.readLine()) != null) {
            if (st.contains("key_key.inventory:key.keyboard.")) {
                return st.substring(31);
            } else if (st.contains("key_key.inventory:key.mouse.")) {
                System.out.println("A movement key is bound to a non-keyboard button. Please rebind to a button on the keyboard.");
                System.exit(-1);
            }
        }
        return null;
    }

    public static String[] getMovementKeys() throws IOException {
        // Read the number
        String appData = System.getenv("APPDATA");
        File file = new File(appData + "\\.minecraft\\options.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String st;
        String[] out = new String[6];
        while ((st = reader.readLine()) != null) {
            if (st.contains("key_key.forward:key.")) {
                if (st.contains("key_key.forward:key.keyboard.")) {
                    out[0] = st.substring(29);
                } else if (st.contains("key_key.forward:key.mouse.")) {
                    System.out.println("The move forward key is bound to a non-keyboard button. Please rebind to a button on the keyboard.");
                    System.exit(-1);
                }
            } else if (st.contains("key_key.left:key.")) {
                if (st.contains("key_key.left:key.keyboard.")) {
                    out[1] = st.substring(26);
                } else if (st.contains("key_key.left:key.mouse.")) {
                    System.out.println("The move left key is bound to a non-keyboard button. Please rebind to a button on the keyboard.");
                    System.exit(-1);
                }
            } else if (st.contains("key_key.back:key.")) {
                if (st.contains("key_key.back:key.keyboard.")) {
                    out[2] = st.substring(26);
                } else if (st.contains("key_key.back:key.mouse.")) {
                    System.out.println("The move back key is bound to a non-keyboard button. Please rebind to a button on the keyboard.");
                    System.exit(-1);
                }
            } else if (st.contains("key_key.right:key.")) {
                if (st.contains("key_key.right:key.keyboard.")) {
                    out[3] = st.substring(27);
                } else if (st.contains("key_key.right:key.mouse.")) {
                    System.out.println("The move right key is bound to a non-keyboard button. Please rebind to a button on the keyboard.");
                    System.exit(-1);
                }
            } else if (st.contains("key_key.sneak:key.")) {
                if (st.contains("key_key.sneak:key.keyboard.")) {
                    out[4] = st.substring(27);
                } else if (st.contains("key_key.sneak:key.mouse.")) {
                    System.out.println("The sneak key is bound to a non-keyboard button. Please rebind to a button on the keyboard.");
                    System.exit(-1);
                }
            } else if (st.contains("key_key.jump:key.")) {
                if (st.contains("key_key.jump:key.keyboard.")) {
                    out[5] = st.substring(26);
                } else if (st.contains("key_key.jump:key.mouse.")) {
                    System.out.println("The jump key is bound to a non-keyboard button. Please rebind to a button on the keyboard.");
                    System.exit(-1);
                }
            }
        }
        for (String ob : out) {
            if (ob == null) {
                System.out.println("Error occured gathering movement keys. Quitting...");
                System.exit(-1);
                return null;
            }
        }
        return out;
    }

    public static void loadPreset() throws IOException {
        Typer.command(".preset save user");
        String appData = System.getenv("APPDATA");
        Path src = Paths.get("src\\Presets_Schematics\\AIBM.json");
        Path dest = Paths.get(appData + "\\.minecraft\\Impact\\presets\\AIBM.json");
        Files.copy(src, dest, REPLACE_EXISTING);
        Typer.command(".preset load AIBM");
}

    public static void schematicsFolder() throws IOException {
        String appData = System.getenv("APPDATA");
        File loc = new File(appData + "\\.minecraft\\schematics");
        if (!(loc.exists() && loc.isDirectory())){
            loc.mkdir();
        }
        Path src = Paths.get("src\\Presets_Schematics\\AIBM_portal.schematic");
        Path dest = Paths.get(appData + "\\.minecraft\\schematics\\AIBM_portal.schematic");
        Files.copy(src, dest, REPLACE_EXISTING);

        Path src2 = Paths.get("src\\Presets_Schematics\\AIBM_shield.schematic");
        Path dest2 = Paths.get(appData + "\\.minecraft\\schematics\\AIBM_shield.schematic");
        Files.copy(src2, dest2, REPLACE_EXISTING);

    }
}
