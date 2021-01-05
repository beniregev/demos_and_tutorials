package com.beniregev.demos_and_tutorials.examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.charset.StandardCharsets.UTF_8;

public class LargeFileWriteAndReadExample {
    //  region FINALs
    private static final int RANDOM_RANGE_BOUND = 1000000000;
    private static final int LINES_COUNT_BOUND = 1000;
    private static final String DEFAULT_FILE_PATH = "./resources"; //  "d:/temp";
    private static final String DATA_FILES = "datafiles";
    private static final String TEXT_FILES_PATH = "text";
    private static final String DATA_FILE_NAME = "very_large_file.txt";
    private static final String SYSTEM_LINE_SEPARATOR = System.lineSeparator();
    //  endregion

    private Path dataFilesDirectory; // For TEXT files to be used in this example
    private String resourceFile;

    public LargeFileWriteAndReadExample() {
        super();
        Path dirToCreate = Paths.get(DEFAULT_FILE_PATH, DATA_FILES, TEXT_FILES_PATH);
        System.out.println("Constructor --> LargeFileWriteAndReadExample(): " + dirToCreate.toString());
        if (!Files.exists(dirToCreate)) {
            try {
                this.setDataFilesDirectory(Files.createDirectories(dirToCreate));
                System.out.println("Constructor --> LargeFileWriteAndReadExample(): directories created: " + this.getDataFilesDirectory() + " ; dir created? " + Files.exists(this.getDataFilesDirectory()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.setDataFilesDirectory(dirToCreate);
        }
        System.out.println("Constructor --> LargeFileWriteAndReadExample(): " + dataFilesDirectory.toString() + "\\" + DATA_FILE_NAME);
    }

    public LargeFileWriteAndReadExample(final Path dataFilesDirectory) {
        this.setDataFilesDirectory(dataFilesDirectory);
    }

    public String getResourceFile() {
        return this.resourceFile;
    }

    public void setResourceFile(final String resourceFile) {
        this.resourceFile = resourceFile;
    }

    public Path getDataFilesDirectory() {
        return dataFilesDirectory;
    }

    public void setDataFilesDirectory(final Path dataFilesDirectory) {
        this.dataFilesDirectory = dataFilesDirectory;
    }

    public void writeLargeFile() throws IOException {
        Path pathFile = Paths.get(this.getDataFilesDirectory().toString(), DATA_FILE_NAME);
        Files.write(pathFile, "".getBytes(UTF_8), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        for (int i = 0; i < LINES_COUNT_BOUND; i++) {
            String content = (int) (Math.random() * RANDOM_RANGE_BOUND + 1) + SYSTEM_LINE_SEPARATOR;
            Files.write(pathFile, content.getBytes(UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }

    public void readLargeFile() throws IOException {
        // The name of the file to open.
        String fileName = this.getDataFilesDirectory().toString() + "\\" + DATA_FILE_NAME;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //  Line number
            int i = 1;

            // This will reference one line at a time
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("(" + i + ")  " + line);
                i++;
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LargeFileWriteAndReadExample example = new LargeFileWriteAndReadExample();
        try {
            System.out.println("-------------------------------------------------");
            System.out.println("example.writeLargeFile()...");
            example.writeLargeFile();
            System.out.println("-------------------------------------------------");
            System.out.println("example.readLargeFile()...");
            example.readLargeFile();
            System.out.println("-------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
