import com.sun.jna.platform.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import static java.nio.file.StandardCopyOption.*;

public class Filer {

    public static void incrementRunCounter() throws IOException, InterruptedException {
        AIBM.checkInterrupted();
        // Read number
        File file = new File("src\\runCounter.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String text = reader.readLine();
        int count = Integer.parseInt(text);
        count = count + 1;
        reader.close();

        Waiter.wait(50);

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

    //replacing the preset settings with our settings for impact
    public static void loadPreset() throws IOException, InterruptedException {
        AIBM.checkInterrupted();
        Typer.command(".preset save user");
        String appData = System.getenv("APPDATA");
        Path src = Paths.get("src\\Presets_Schematics\\AIBM_preset.json");
        Path dest = Paths.get(appData + "\\.minecraft\\Impact\\presets\\AIBM_preset.json");
        Files.copy(src, dest, REPLACE_EXISTING);
        Typer.command(".preset load AIBM_preset");
    }

    //addint our portal schematic to the schematics folder
    public static void schematicsFolder() throws IOException, InterruptedException {
        AIBM.checkInterrupted();
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

    //interpreting current user settings and making adjustments to fit our needs
    public static void setBaritoneSettings() throws IOException, InterruptedException {
        AIBM.checkInterrupted();
        //locating the files needed and reading them into File objects, then BufferedReader
        String appData = System.getenv("APPDATA");
        File user = new File(appData + "\\.minecraft\\baritone\\settings.txt");
        BufferedReader readerUser = new BufferedReader(new FileReader(user));
        File ours = new File("src\\Presets_Schematics\\AIBM_baritone_settings.txt");
        BufferedReader readerOurs = new BufferedReader(new FileReader(ours));

        //defining some objects to use during loops so they do not need to be created and destroyed all the time
        String stUser;
        String stOurs;
        int counter = 0;

        //where we will store our values to be tested against eachother
        HashMap<String, String> userSettings = new HashMap<>();
        HashMap<String, String> ourSettings = new HashMap<>();

        //our final command Stack that we iterate through to change the settings we need
        Stack<String> out = new Stack<>();

        //read in the users settings file and create the HashMap
        while ((stUser = readerUser.readLine()) != null) {
            AIBM.checkInterrupted();
            String[] splitUser = stUser.split(" ", 2);
            userSettings.put(splitUser[0], splitUser[1]);
        }

        //create HashMap for our desired settings
        while ((stOurs = readerOurs.readLine()) != null) {
            AIBM.checkInterrupted();
            String[] splitOurs = stOurs.split(" ", 2);
            ourSettings.put(splitOurs[0], splitOurs[1]);
        }

        //for every entry @userData in @userSettings
        for (HashMap.Entry<String,String> userData : userSettings.entrySet()) {
            AIBM.checkInterrupted();

            //get the @key for this entry @userData
            String key = userData.getKey();

            //this function does not matter, but likely will get updated every time without this
            //its super annoying so we just remove it
            if (key.equals("chatControl")) {
                continue;
            }

            //if @ourSettings contains this @key
            if (ourSettings.containsKey(key)) {

                //if the values of both entries are the same
                if (userData.getValue().equals(ourSettings.get(key))) {

                    //remove the entry from @ourSettings so it is not updated at the end
                    ourSettings.remove(key);
                    continue;
                }

                //if the values are not the same
                else {

                    //push the updated to the Stack @out
                    out.push(key + " " + ourSettings.get(key));

                    //remove the entry from @ourSettings so it is not updated at the end
                    ourSettings.remove(key);

                    //increment the settings updated @counter
                    counter++;
                    continue;
                }
            }

            //if @ourSettings does not contain this @key
            else {

                //push the updated to the Stack @out
                out.push("reset " + key);

                //increment the settings updated @counter
                counter++;
                continue;
            }
        }

        //for everything left in @ourSettings after checking the users settings
        for (HashMap.Entry<String,String> ourData : ourSettings.entrySet()) {
            AIBM.checkInterrupted();

            //push these remaining items to the Stack @out
            out.push(ourData.getKey() + " " + ourData.getValue());

            //increment settings updated @counter
            counter++;
        }

        //while @out is not empty
        while (!out.empty()) {
            AIBM.checkInterrupted();

            //pop from @out and run the command using Typer.command
            Typer.command(".b " + out.pop());
        }

        //report number of settings changed, cased for singular or plural
        if (counter == 1) {
            System.out.println("1 baritone setting was updated for this run");
        }
        else {
            System.out.println(counter + " baritone settings were updated for this run");
        }
    }
}
