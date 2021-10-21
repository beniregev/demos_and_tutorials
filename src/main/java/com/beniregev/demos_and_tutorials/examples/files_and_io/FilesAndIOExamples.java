package com.beniregev.demos_and_tutorials.examples.files_and_io;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Paths;

public class FilesAndIOExamples {
    private static final String TXT_FILE = "test_file.txt";
    private static final String PDF_FILE = "ISO20022_PaymentsInitiation_2020_2021.pdf";

    private static final String WORKING_DIRECTORY = System.getProperty("user.dir");
    private static final String RESOURCES_DIRECTORY = WORKING_DIRECTORY + "/src/main/resources";

    private void printCurrentWorkingDirectory1() {
        String userDirectory = System.getProperty("user.dir");
        System.out.println("printCurrentWorkingDirectory1() - using System.getProperty(\"user.dir\") = " + userDirectory);
    }

    private void printCurrentWorkingDirectory2() {
        String userDirectory = Paths.get("")
                .toAbsolutePath()
                .toString();
        System.out.println("printCurrentWorkingDirectory2() - using Path class = " + userDirectory);
    }

    private void printCurrentWorkingDirectory3() {
        String userDirectory = new File("").getAbsolutePath();
        System.out.println("printCurrentWorkingDirectory3() - using File class = " + userDirectory);
    }

    private void printCurrentWorkingDirectory4() {
        String userDirectory = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
        System.out.println("printCurrentWorkingDirectory4() - using FileSystem class = " + userDirectory);
    }

    // get a file from the resources folder, root of classpath in JAR

    /**
     * <h2>Working Directory for JAR file</h2>
     * <p>
     *     Do not use {@code System.getProperty("user.dir")}, {@link File} or {@link Paths}
     *     to access a file that is inside a JAR file, it is not going to work. Instead, we
     *     should use {@code getClass().getClassLoader().getResourceAsStream()}.
     * </p>
     *
     * @param fileName Name of the file to access inside the JAR file
     * @return
     */
    public InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    public boolean isFileExists(String workingDirectory, String fileName) {
        return new File(workingDirectory + "/" + fileName).exists();
    }

    public void deleteFile(File file) {
        if (file.exists()) {
            file.delete();
            System.out.println("file \"" + file.getName() + "\" was deleted!");
        }
    }

    public void createNewFile(String fileName) {
        try {
            String dataLine = "This is line number ";
            File file = new File(fileName);
            this.deleteFile(file);
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i=1; i<10; i++) {
                bw.write(dataLine + String.valueOf(10+i) + "\n");
            }
            bw.close();
            fw.close();
            System.out.println("file \"" + fileName + "\" was created!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FilesAndIOExamples examples = new FilesAndIOExamples();

        System.out.println("Working Directory: " + WORKING_DIRECTORY);
        System.out.println("Resources Directory: " + RESOURCES_DIRECTORY);
        System.out.println("Text file-name: " + TXT_FILE);
        System.out.println("PDF file-name: " + PDF_FILE);
        System.out.println("-------------------------------------------------\n");
        examples.printCurrentWorkingDirectory1();
        examples.printCurrentWorkingDirectory2();
        examples.printCurrentWorkingDirectory3();
        examples.printCurrentWorkingDirectory4();

        System.out.println("Is \"" + PDF_FILE + "\" file exists in working directory? " + examples.isFileExists(WORKING_DIRECTORY, PDF_FILE));
        System.out.println("Is \"" + PDF_FILE + "\" file exists in PDF resource directory? " + examples.isFileExists(RESOURCES_DIRECTORY + "/pdf", PDF_FILE));
        examples.createNewFile(TXT_FILE);
    }
}
