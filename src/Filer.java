import java.io.*;

public class Filer {

    public void incrementRunCounter() throws IOException, InterruptedException {
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
}
