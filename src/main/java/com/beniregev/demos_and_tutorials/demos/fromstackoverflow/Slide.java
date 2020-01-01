package com.beniregev.demos_and_tutorials.demos.fromstackoverflow;

import java.io.*;

public class Slide {
    private char NON_COLONY = '0';
    private char [][] slideData;

    /**
     * constructor
     * pre: Slide file contains valid slide data in the format:
     * first line: lenght of slide
     * second line: width of slide
     * remaining lines: slide data
     * post: Slide data has been loaded from slide file.
     */
    public Slide(String s) {
        try {
            File slideFile = new File(s);

            FileReader in = new FileReader(slideFile);
            BufferedReader readSlide = new BufferedReader(in);

            int length = Integer.parseInt(readSlide.readLine());
            int width = Integer.parseInt(readSlide.readLine());
            slideData = new char[length][width];

            for (int row = 0; row < length; row++) {
                for (int col = 0; col < width; col++) {
                    slideData[row][col] = (char)readSlide.read();
                }
                readSlide.readLine();   //read past end-of-line characters
            }
            readSlide.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
       } catch (IOException e) {
            System.out.println("Problem reading file.");
            System.err.println("IOException: " + e.getMessage());
        }
    }

    /**
     * Determines a colony size
     * pre: none
     * post: All colony cells adjoining and including cell (Row, Col) have
     * been changed to NON_COLONY, and count of these cells is returned.
     */
    private int collectCells(int row, int col , char colour) {
        if ((row < 0) || (row >= slideData.length) || (col < 0) || (col >= slideData[0].length) || (slideData[row][col] != colour)) {
            return(0);
        } else {
            slideData[row][col] = NON_COLONY;
            return(1 +
                    collectCells(row + 1, col , colour) +
                    collectCells(row - 1, col , colour) +
                    collectCells(row, col + 1 , colour) +
                    collectCells(row, col - 1 , colour) +
                    collectCells(row - 1 , col - 1 , colour) +
                    collectCells(row + 1 , col + 1 , colour) +
                    collectCells(row - 1 , col + 1 , colour) +
                    collectCells(row + 1 , col - 1 , colour));
        }
    }

    /**
     * Analyzes a slide for colonies and displays colony data
     * pre: none
     * post: Colony data has been displayed.
     */
    public void displayColonies() {
        int count;

        System.out.format("%-10s %-10s %-10s" , "LOCATION" , "SIZE" , "COLOUR");
        System.out.println();

        for (int row = 0; row < slideData.length; row++) {
            for (int col = 0; col < slideData[0].length; col++) {
                for (int i = 1; i <= 9; i++) {
                    if (slideData[row][col] == i) {
                        count = collectCells(row , col , (char)i);
                        System.out.format("%-10s %-10s %-10s" , "(" + row + "," + col + ")" , count , i);
                    }
                }
            }
        }
    }


    /**
     * Displays a slide.
     * pre: none
     * post: Slide data has been displayed.
     */
    public void displaySlide() {

        for (int row = 0; row < slideData.length; row++) {
            for (int col = 0; col < slideData[0].length; col++) {
                System.out.print(slideData[row][col]);
            }
            System.out.println();
        }
    }
}
