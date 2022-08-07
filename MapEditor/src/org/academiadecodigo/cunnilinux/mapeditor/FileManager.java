package org.academiadecodigo.cunnilinux.mapeditor;

import java.io.*;

public class FileManager {

    private static final String FILEPATH = "resources/map.txt";
    public static void saver(String map) throws IOException {
        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter(FILEPATH));
        writer.write(map);
        writer.close();




    }


    public static String load() throws IOException {
        String result = "";
        BufferedReader reader = null;


            String line;
            reader = new BufferedReader(new FileReader(FILEPATH));
            while ((line = reader.readLine()) != null) {
                result += line + "\n";

            }



                reader.close();
            return result;
    }
}
