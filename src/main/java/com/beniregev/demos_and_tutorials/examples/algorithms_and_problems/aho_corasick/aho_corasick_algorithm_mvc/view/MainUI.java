package com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.aho_corasick.aho_corasick_algorithm_mvc.view;

import com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.aho_corasick.aho_corasick_algorithm_mvc.controller.Utility;
import com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.aho_corasick.aho_corasick_algorithm_mvc.controller.AhoCorasick;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class MainUI {
    public static long preprocessingTimer, processingTimer;

    public static void main(String[] args){

        Utility util = new Utility();
        File f = null;
        HashSet<String> keywords = new HashSet<String>(); //prepare keywords
        String assetHome = new StringBuilder("src/main/java/com/beniregev/")
                .append("demos_and_tutorials/examples/algorithms/")
                .append("aho_corasick/")
                .append("aho_corasick_algorithm_mvc/")
                .append("asset/").toString();
        //String asset_Home = "src/main/java/com/beniregev/aho_corasick/asset/"; //to run anywhere
        //String assetHome = "C:/Java AhoCorasick/Asset/"; //to run externally
        String outputHome = "C:/Java AhoCorasick/AhoCorasick Results/";
        String output_PreProcessTimeURI="", output_InProcessTimeURI="", output_ProcessMemoryURI="";

        try {
            switch (args[0]) {
                case "50":
                    f = new File(assetHome+"snortruleskeyword0050.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime0050.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime0050.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory0050.txt";
                    break;
                case "100":
                    f = new File(assetHome+"snortruleskeyword0100.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime0100.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime0100.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory0100.txt";
                    break;
                case "200":
                    f = new File(assetHome+"snortruleskeyword0200.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime0200.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime0200.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory0200.txt";
                    break;
                case "300":
                    f = new File(assetHome+"snortruleskeyword0300.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime0300.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime0300.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory0300.txt";
                    break;
                case "400":
                    f = new File(assetHome+"snortruleskeyword0400.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime0400.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime0400.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory0400.txt";
                    break;
                case "500":
                    f = new File(assetHome+"snortruleskeyword0500.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime0500.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime0500.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory0500.txt";
                    break;
                case "600":
                    f = new File(assetHome+"snortruleskeyword0600.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime0600.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime0600.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory0600.txt";
                    break;
                case "700":
                    f = new File(assetHome+"snortruleskeyword0700.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime0700.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime0700.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory0700.txt";
                    break;
                case "800":
                    f = new File(assetHome+"snortruleskeyword0800.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime0800.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime0800.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory0800.txt";
                    break;
                case "900":
                    f = new File(assetHome+"snortruleskeyword0900.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime0900.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime0900.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory0900.txt";
                    break;
                case "1000":
                    f = new File(assetHome+"snortruleskeyword1000.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime1000.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime1000.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory1000.txt";
                    break;
                case "1100":
                    f = new File(assetHome+"snortruleskeyword1100.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime1100.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime1100.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory1100.txt";
                    break;
                case "1200":
                    f = new File(assetHome+"snortruleskeyword1200.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime1200.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime1200.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory1200.txt";
                    break;
                case "1300":
                    f = new File(assetHome+"snortruleskeyword1300.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime1300.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime1300.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory1300.txt";
                    break;
                case "1400":
                    f = new File(assetHome+"snortruleskeyword1400.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime1400.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime1400.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory1400.txt";
                    break;
                case "1500":
                    f = new File(assetHome+"snortruleskeyword1500.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime1500.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime1500.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory1500.txt";
                    break;
                case "1600":
                    f = new File(assetHome+"snortruleskeyword1600.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime1600.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime1600.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory1600.txt";
                    break;
                case "1700":
                    f = new File(assetHome+"snortruleskeyword1700.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime1700.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime1700.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory1700.txt";
                    break;
                case "1800":
                    f = new File(assetHome+"snortruleskeyword1800.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime1800.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime1800.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory1800.txt";
                    break;
                case "1900":
                    f = new File(assetHome+"snortruleskeyword1900.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime1900.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime1900.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory1900.txt";
                    break;
                case "2000":
                    f = new File(assetHome+"snortruleskeyword2000.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime2000.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime2000.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory2000.txt";
                    break;
                case "2100":
                    f = new File(assetHome+"snortruleskeyword2100.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime2100.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime2100.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory2100.txt";
                    break;
                case "2200":
                    f = new File(assetHome+"snortruleskeyword2200.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime2200.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime2200.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory2200.txt";
                    break;
                case "2300":
                    f = new File(assetHome+"snortruleskeyword2300.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime2300.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime2300.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory2300.txt";
                    break;
                case "2400":
                    f = new File(assetHome+"snortruleskeyword2400.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime2400.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime2400.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory2400.txt";
                    break;
                case "2500":
                    f = new File(assetHome+"snortruleskeyword2500.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime2500.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime2500.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory2500.txt";
                    break;
                case "2600":
                    f = new File(assetHome+"snortruleskeyword2600.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime2600.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime2600.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory2600.txt";
                    break;
                case "2700":
                    f = new File(assetHome+"snortruleskeyword2700.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime2700.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime2700.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory2700.txt";
                    break;
                case "2800":
                    f = new File(assetHome+"snortruleskeyword2800.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime2800.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime2800.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory2800.txt";
                    break;
                case "2900":
                    f = new File(assetHome+"snortruleskeyword2900.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime2900.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime2900.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory2900.txt";
                    break;
                case "3000":
                    f = new File(assetHome+"snortruleskeyword3000.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime3000.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime3000.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory3000.txt";
                    break;
                case "3100":
                    f = new File(assetHome+"snortruleskeyword3100.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime3100.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime3100.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory3100.txt";
                    break;
                case "3200":
                    f = new File(assetHome+"snortruleskeyword3200.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime3200.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime3200.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory3200.txt";
                    break;
                case "3300":
                    f = new File(assetHome+"snortruleskeyword3300.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime3300.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime3300.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory3300.txt";
                    break;
                case "3400":
                    f = new File(assetHome+"snortruleskeyword3400.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime3400.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime3400.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory3400.txt";
                    break;
                case "3500":
                    f = new File(assetHome+"snortruleskeyword3500.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime3500.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime3500.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory3500.txt";
                    break;
                case "3600":
                    f = new File(assetHome+"snortruleskeyword3600.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime3600.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime3600.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory3600.txt";
                    break;
                case "3700":
                    f = new File(assetHome+"snortruleskeyword3700.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime3700.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime3700.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory3700.txt";
                    break;
                case "3800":
                    f = new File(assetHome+"snortruleskeyword3800.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime3800.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime3800.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory3800.txt";
                    break;
                case "3900":
                    f = new File(assetHome+"snortruleskeyword3900.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime3900.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime3900.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory3900.txt";
                    break;
                case "4000":
                    f = new File(assetHome+"snortruleskeyword4000.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime4000.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime4000.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory4000.txt";
                    break;
                case "below20_200":
                    f = new File(assetHome+"below20_0200.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime_Below20_200.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime_Below20_200.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory_Below20_200.txt";
                    break;
                case "below20_400":
                    f = new File(assetHome+"below20_0400.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime_Below20_400.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime_Below20_400.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory_Below20_400.txt";
                    break;
                case "below20_600":
                    f = new File(assetHome+"below20_0600.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime_Below20_600.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime_Below20_600.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory_Below20_600.txt";
                    break;
                case "below20_800":
                    f = new File(assetHome+"below20_0800.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime_Below20_800.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime_Below20_800.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory_Below20_800.txt";
                    break;
                case "below20_1000":
                    f = new File(assetHome+"below20_1000.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime_Below20_1000.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime_Below20_1000.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory_Below20_1000.txt";
                    break;
                case "above20_200":
                    f = new File(assetHome+"above20_0200.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime_Above20_200.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime_Above20_200.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory_Above20_200.txt";
                    break;
                case "above20_400":
                    f = new File(assetHome+"above20_0400.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime_Above20_400.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime_Above20_400.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory_Above20_400.txt";
                    break;
                case "above20_600":
                    f = new File(assetHome+"above20_0600.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime_Above20_600.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime_Above20_600.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory_Above20_600.txt";
                    break;
                case "above20_800":
                    f = new File(assetHome+"above20_0800.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime_Above20_800.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime_Above20_800.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory_Above20_800.txt";
                    break;
                case "above20_1000":
                    f = new File(assetHome+"above20_1000.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTime_Above20_1000.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTime_Above20_1000.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemory_Above20_1000.txt";
                    break;
                case "kjvcustom":
                    f = new File(assetHome+"snortruleskeyword4000.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTimekjvcustom.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTimekjvcustom.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemorykjvcustom.txt";
                    break;
                default:
//				f = new File(asset_Home+"snortrulessimplekeyword.txt");
//				f = new File(asset_Home+"snortruleskeyword4000.txt");
//				f = new File(asset_Home+"below20_0200.txt");
//				f = new File(asset_Home+"below20_1000.txt");
//				f = new File(asset_Home+"above20_0200.txt");
                    f = new File(assetHome+"above20_1000.txt");
                    output_PreProcessTimeURI = outputHome+"AhoCorasick_PreProcessTimeSimple.txt";
                    output_InProcessTimeURI = outputHome+"AhoCorasick_InProcessTimeSimple.txt";
                    output_ProcessMemoryURI = outputHome+"AhoCorasick_ProcessMemorySimple.txt";
                    break;
            }
//			File f = new File(asset_Home+"kjvkeyword_simple.txt");
//			File f = new File(asset_Home+"snortrules.txt");
//			File f = new File(asset_Home+"snortruleskeyword.txt");
//			File f = new File(asset_Home+"SimpleDatabase.txt");
            keywords=util.readKeyword(f); //load keywords from file

        } catch (Exception e) {
            e.printStackTrace();
        }

        AhoCorasick ahoCorasick = new AhoCorasick();

        preprocessingTimer = System.nanoTime();
        ahoCorasick.prepareGoToFunction(keywords); //prepare ahocorasick goTo function
        ahoCorasick.prepareFailFromFunction(); //prepare ahocorasick fail function
//		preprocessingTimer = System.currentTimeMillis() - preprocessingTimer;
        preprocessingTimer = System.nanoTime() - preprocessingTimer;
        System.out.println("Finish preprocessing in "+preprocessingTimer + " nanosecond(s)");

        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Calculate the used memory
        long preprocessingMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory for preprocessing: " + preprocessingMemory+" Bytes");

        System.out.println("Aho Corasick is READY....BEGIN pattern matching...");

        try {
//			f = new File(asset_Home+"kjv.txt");
//			f = new File(asset_Home+"kjv_bug.txt");
//			f = new File(asset_Home+"SimpleInputString.txt");
            switch (args[0]) {
                case "kjvcustom":
                    f = new File(assetHome+"kjv_custom.txt");
                    break;
                case "simple":
//				f = new File(asset_Home+"snortrulesSimpleInputFile.txt");
                    f = new File(assetHome+"snortrulesInputFile.txt");
//				f = new File(asset_Home+"m_orange3.1_100.txt");
                    break;
                default:
//				f = new File(asset_Home+"snortrulesInputFile.txt");
//				f = new File(asset_Home+"hbot.txt");
//				f = new File(asset_Home+"slowdownload.txt");
                    f = new File(assetHome+"m_orange3.1_100.txt");
                    break;
            }
            //inputString = util.readInputString(f, Charset.defaultCharset());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ahoCorasick.patternMatching(f);

        System.out.println("Finish multi-pattern matching in "+processingTimer + " nanosecond(s)");

        System.out.println("DONE matching...WRITING results now...");

        try {
            util.writeOutput(AhoCorasick.outputList);
        } catch (Exception e) {
            System.out.println("writeOutput Error: "+e);
        }

        try {
            PrintWriter preprocessTimerWriter = new PrintWriter(new BufferedWriter(new FileWriter(output_PreProcessTimeURI, true)));
            preprocessTimerWriter.println(""+preprocessingTimer);
            preprocessTimerWriter.close();
            PrintWriter preprocessMemoryWriter = new PrintWriter(new BufferedWriter(new FileWriter(output_ProcessMemoryURI, true)));
            preprocessMemoryWriter.println(""+preprocessingMemory);
            preprocessMemoryWriter.close();
            PrintWriter processTimerWriter = new PrintWriter(new BufferedWriter(new FileWriter(output_InProcessTimeURI, true)));
            processTimerWriter.println(""+processingTimer);
            processTimerWriter.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
        System.out.println("COMPLETED");
        runtime.gc();
    }
}
