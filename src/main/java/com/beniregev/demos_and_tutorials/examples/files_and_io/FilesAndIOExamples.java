package com.beniregev.demos_and_tutorials.examples.files_and_io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilesAndIOExamples {
    public static void main(String[] args) {
        try {
            String filename = "test_file.txt";
            String dataLine = "This is line number ";
            File file = new File(filename);
            if (file.exists()) {
                file.delete();
                System.out.println("file \"" + filename + "\" was deleted!");
            }
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i=1; i<10; i++) {
                bw.write(dataLine + String.valueOf(i) + "\n");
            }
            bw.close();
            fw.close();
            System.out.println("file \"" + filename + "\" was created!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
