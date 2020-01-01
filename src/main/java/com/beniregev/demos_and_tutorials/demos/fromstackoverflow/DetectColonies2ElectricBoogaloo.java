package com.beniregev.demos_and_tutorials.demos.fromstackoverflow;

public class DetectColonies2ElectricBoogaloo {
    public static void main(String [] args) {

        String fileAndPath = "C:/development/JavaProjects/IdeaProjects/demos_and_tutorials/src/main/java/com/beniregev/demos_and_tutorials/demos/fromstackoverflow/" + "Slide.dat";
        Slide culture = new Slide(fileAndPath);

        culture.displaySlide();
        culture.displayColonies();

    }
}
