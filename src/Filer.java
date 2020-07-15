import java.io.*;

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
        File file = new File(appData+"\\.minecraft\\options.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String st;
        while ((st = reader.readLine()) != null){
              if (st.contains("guiScale:")){
                  System.out.println();
                  return Integer.parseInt(st.substring(9,10));
              }
        }
        return 0;
    }

    public static String getInventoryKey() throws IOException {
        // Read the number
        String appData = System.getenv("APPDATA");
        File file = new File(appData+"\\.minecraft\\options.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String st;
        while ((st = reader.readLine()) != null){
            if (st.contains("key_key.inventory:key.keyboard.")){
                return st.substring(31);
            }
            else if (st.contains("key_key.inventory:key.mouse.")){
                System.out.println("A movement key is bound to a non-keyboard button. Please rebind to a button on the keyboard.");
                System.exit(-1);
            }
        }
        return null;
    }

    public static String[] getMovementKeys() throws IOException {
        // Read the number
        String appData = System.getenv("APPDATA");
        File file = new File(appData+"\\.minecraft\\options.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String st;
        String[] out = new String[4];
        while ((st = reader.readLine()) != null){
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
}
