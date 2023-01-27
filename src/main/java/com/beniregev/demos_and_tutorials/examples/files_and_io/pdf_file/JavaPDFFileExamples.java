package com.beniregev.demos_and_tutorials.examples.files_and_io.pdf_file;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author beni.regev
 * @since Java 1.8_u161
 */
public class JavaPDFFileExamples {
    private final String TAB = "\t";
    private final String DOUBLE_TAB = "\t\t";
    private final String NEW_LINE = "\n";
    private final String SPACE = " ";
    private final String TAG_LEFT = "<";
    private final String TAG_RIGHT = ">";
    //  Structure: ...[a-zA-Z_-] <[A-Za-z]>...
    private final String REGEX_COLUMN_AND_TAG = ".*([A-Za-z_-]+ {1}\u003c{1}[A-Za-z]+\u003e{1})(.*|\\s*)";
    private final String PDF_FILENAME = "ISO20022_PaymentsInitiation_2020_2021.pdf";
    private final Pattern PATTERN = Pattern.compile(this.REGEX_COLUMN_AND_TAG);
    public void openPDFFileWindowsPlatformSolution() {
        System.out.println(TAB + "method openPDFFileWindowsPlatformSolution() -- Start");
        try {
            if ((new File(PDF_FILENAME)).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler " + this.PDF_FILENAME);
                p.waitFor();
            } else {
                System.out.println(TAB + "File '" + this.PDF_FILENAME + "' does not exists");
            }
            System.out.println(TAB + "method openPDFFileWindowsPlatformSolution() -- Done");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void openPDFFileCrossPlatformSolution() {
        System.out.println(TAB + "method openPDFFileCrossPlatformSolution() -- Start");
        try {
            File pdfFile = new File("c:/Java-Interview.pdf");
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println(TAB + "Awt Desktop is not supported!");
                }
            } else {
                System.out.println(TAB + "File \""+ pdfFile + "\"does not exists!");
            }
            System.out.println(TAB + "method openPDFFileCrossPlatformSolution() -- Done");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void readPdfUsingApachePdfBox() {
        System.out.println(TAB + "method readPdfUsingApachePdfBox() -- Start");
        try (PDDocument document = PDDocument.load(new File(this.PDF_FILENAME))) {
//            Class<?> documentClass = document.getClass();

            if (!document.isEncrypted()) {
                System.out.println(DOUBLE_TAB + "* new PDFTextStripperByArea()...");
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                System.out.println(DOUBLE_TAB + "* tStripper.getText(-=*document*=-)...");
                PDFTextStripper tStripper = new PDFTextStripper();
                System.out.println(DOUBLE_TAB + "* new PDFTextStripper()...");
                String pdfFileInText = tStripper.getText(document);

                // split by whitespace
                System.out.println(DOUBLE_TAB + "* pdfFileInText.split(\"\\\\r?\\\\n\")...");
                String[] lines = pdfFileInText.split("\\r?\\n");
                System.out.println(DOUBLE_TAB + "* Filter the PDF file lines and gathering them into List<String>...");
                List<String> matchingLines = Arrays.stream(lines)
                        .filter(line -> PATTERN.matcher(line).find())
                        .filter(x -> !x.contains("<Document>"))
                        .collect(Collectors.toList());

                System.out.println("--------------------------------------------------------------------------------------------------");
                System.out.println(TAB + "Print only the matching lines containing Column and Tag:");
                System.out.println("-------------------------------------------------");
                matchingLines.stream().forEach(ln -> {
                    Matcher matcher = PATTERN.matcher(ln);
                    if (matcher.matches()) {
                        System.out.println("Matches" + TAB + ln + NEW_LINE +
                                TAB + matcher.group(0).substring(0, matcher.group(0).indexOf(matcher.group(2))).trim());
                    } else {
                        System.out.println(TAB + ln);
                    }
                });

//                for (String line : matchingLines) {
//                    Matcher matcher = Pattern.compile(this.REGEX_COLUMN_AND_TAG).matcher(line);
//                    System.out.println(matcher.matches() ?
//                            matcher.group(0).substring(0, matcher.group(0).indexOf(matcher.group(2))).trim() :
//                            "*******" + line);
//                }

//                matchingLines = matchingLines.stream()
//                        .map(line -> Pattern.compile(this.REGEX_COLUMN_AND_TAG).matcher(line).group(1))
//                        .collect(Collectors.toList());

//                System.out.println(DOUBLE_TAB + "* Take List<String> and create mapDictionary...");
//                Map<String, String> mapDictionary = matchingLines.stream()
//                                .collect(Collectors.toMap(
//                                        part -> part.substring(0, part.indexOf(SPACE)),
//                                        part -> part.substring(part.indexOf(SPACE)+1, part.indexOf(TAG_RIGHT)),
//                                        (o1, o2) -> o1,
//                                        ConcurrentHashMap::new));

//                System.out.println("--------------------------------------------------------------------------------------------------");
//                System.out.println(TAB + "Print all the lines in the PDF files:");
//                System.out.println("-------------------------------------------------");
//                for (String line : lines) {
//                    System.out.println(line);
//                }

//                System.out.println("--------------------------------------------------------------------------------------------------");
//                System.out.println(TAB + "Print only the matching lines containing Column and Tag:");
//                System.out.println("-------------------------------------------------");
//                matchingLines.stream().forEach(ln -> System.out.println("\t" + ln));

//                System.out.println("--------------------------------------------------------------------------------------------------");
//                System.out.println(TAB + "Print the matchingLines Column + Tag: ");
//                System.out.println("-------------------------------------------------");
//                matchingLines.stream()
//                        .forEach(ln -> {
//                            String[] strings = ln.split(SPACE);
//                            System.out.println(DOUBLE_TAB + "| " + strings[0] + " | " + strings[1] + " |");
//                        });

//                System.out.println("--------------------------------------------------------------------------------------------------");
//                System.out.println(TAB + "Print the mapDictionary: ");
//                System.out.println("-------------------------------------------------");
//                mapDictionary.forEach((key, value) -> System.out.println( DOUBLE_TAB + key + " : " + value));
                System.out.println("--------------------------------------------------------------------------------------------------");
                System.out.println(TAB + "method readPdfUsingApachePdfBox() -- Done");
            }
        } catch (InvalidPasswordException ipe) {
            ipe.printStackTrace();
            System.out.println("-------------------------------------------------");
            System.out.println(ipe.getMessage());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("-------------------------------------------------");
            System.out.println(ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        JavaPDFFileExamples examples = new JavaPDFFileExamples();
        examples.openPDFFileWindowsPlatformSolution();
        examples.openPDFFileCrossPlatformSolution();
        examples.readPdfUsingApachePdfBox();
    }

    private boolean isValidColumnAndTagString(String stringText) {
        return Pattern.compile(this.REGEX_COLUMN_AND_TAG).matcher(stringText).matches();
    }
}
