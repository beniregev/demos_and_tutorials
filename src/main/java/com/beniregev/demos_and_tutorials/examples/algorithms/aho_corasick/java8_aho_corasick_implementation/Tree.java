package com.beniregev.demos_and_tutorials.examples.algorithms.aho_corasick.java8_aho_corasick_implementation;

/**
 * The tree has a CommandTab matrix of size maxState * maxChar
 * CommandTab represents the PLC in the form CommandTab [CurrentState] [NextCharacter] = NextStatus
 *
 * The output [maxState] array contains the words found for each state
 */
public class Tree {
    static int maxChar = 130;
    static int maxState = 100;

    int CommandeTab[][]= new int [maxState][maxChar];
    String output[] = new String[maxState];


    /**
     * Initialise toutes les cases de la matrice à "val"
     * @param mat la matrice
     * @param val la valeur
     */
    public void initialisation_mat(int mat[][], int val) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = val;
            }
        }
    }

    public Tree(){
        initialisation_mat(CommandeTab, -1);
    }

    /**
     * Rempli CommandeTab afin de créer l'automate
     * @param Mots : Mots clés à trouver
     */
    public void CreerArbo(String [] Mots){
        int newState = 0;
        for(int i=0;i<Mots.length;i++)
            newState = enter(Mots[i],newState);
        for(int i =0;i<maxChar;i++){
            if(CommandeTab[0][i]==-1)
                CommandeTab[0][i]=0;
        }
    }

    public int enter(String Mot,int newState){
        int state = 0, i;
        for(i = 0;i < Mot.length(); i++){
            if(CommandeTab[state][Mot.charAt(i)] != -1)
                state = CommandeTab[state][Mot.charAt(i)];
            else break;
        }

        for(int p = i;p < Mot.length();p++){
            newState++;
            CommandeTab[state][Mot.charAt(p)] = newState;
            state = newState;
        }
        output[state] = Mot;
        return newState;
    }

    /**
     * Affiche la matrice CommandeTab/l'automate
     */
    public void afficherArbo(){
        for(int i=0;i<this.CommandeTab.length;i++){
            for(int j=0;j<this.CommandeTab[i].length;j++){
                if(CommandeTab[i][j] > 0)
                    System.out.println(i + " " + CommandeTab[i][j] + " " + (char)j + '\n');
            }
        }
    }
}
