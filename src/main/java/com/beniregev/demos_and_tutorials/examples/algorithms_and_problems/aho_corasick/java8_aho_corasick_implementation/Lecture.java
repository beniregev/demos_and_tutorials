package com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.aho_corasick.java8_aho_corasick_implementation;

public class Lecture {
    private Tree arbo;
    private Failure fail;

    public Lecture(Tree arbo, Failure fail) {
        this.arbo = arbo;
        this.fail = fail;
    }

    /**
     * Parcours le texte "texte" et nous indique à chaque fois quel mot a été trouvé.
     * Le texte est parcouru une seule fois
     * @param texte : Texte dans lequel on va chercher les mots clés
     */
    public void Lire(String texte){
        int j = 0;
        int etat = 0;
        for(int i=0;i<texte.length();i++){
            etat = arbo.CommandeTab[etat][texte.charAt(i)];
            if(arbo.output[etat] != null) {
                System.out.println("A la position " + i + ", il y a \"" + arbo.output[etat] + "\"");
                if(i>=10)
                    j = i-10;
                while(j<i+10 && j < texte.length()){
                    System.out.print(texte.charAt(j));
                    j++;
                }
                System.out.print("\n\n");
            }
        }
    }
}
