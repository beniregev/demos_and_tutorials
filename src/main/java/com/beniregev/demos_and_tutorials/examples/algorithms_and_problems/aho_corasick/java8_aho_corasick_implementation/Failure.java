package com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.aho_corasick.java8_aho_corasick_implementation;

import java.util.LinkedList;

public class Failure {
    private Tree tree;
    private LinkedList<Integer> queue;


    private int[] fail= new int[200];

    Failure(Tree tree, LinkedList queue){
        this.tree = tree;
        this.queue=queue;
    }

    /**
     * On dira qu'une transition "fail" si cette derniere n'est pas utilisée
     * (pour le moment, voir méthode "creer_delta") à la création d'un mot
     * @param state Etat actuel
     * @param i Caractère lu
     * @return Vrai si la combinaison (state,i) fail, faux sinon
     */
    public boolean isFail(int state, int i){
        return tree.CommandeTab[state][i] == -1;
    }

    /**
     * Remplis le tableau fail d'arborescence
     * C
     */
    public void creer_fail(){
        int state,s;
        for(int i = 0; i< tree.maxChar; i++) {
            if (tree.CommandeTab[0][i] > 0) {
                s = tree.CommandeTab[0][i];
                queue.add(s);
                fail[s] = 0;
            }
        }
        while(!queue.isEmpty()){
            int r= queue.removeFirst();
            for(int i = 0; i< tree.maxChar; i++) {
                if (!isFail(r,i)){
                    s = tree.CommandeTab[r][i];
                    queue.add(s);
                    state=fail[r];
                    while(isFail(state,i)) {
                        state=fail[state];
                    }
                    fail[s]= tree.CommandeTab[state][i];
                    if(tree.output[fail[s]] != null)
                        tree.output[s] += " " + tree.output[fail[s]];
                }

            }
        }
    }

    /**
     * Affiche le tableau fail[]
     */
    void afficher_fail(){
        for(int i=0;i<fail.length;i++){
            if(fail[i] != 0)
                System.out.println(" si " + i + " fail , on va dans l'etat  " + fail[i]);
        }
    }

    /**
     * Remplis une seconde fois CommandeTab en utilisant le tableau fail
     * De ce fait, l'automate deviens finis et deterministe
     * Il n'y a donc plus de "fail" (=-1) dans CommandeTab,
     * Ces derniers sont remplacés par des transitions normale dans CommandeTab
     */
    public void creer_delta(){
        int s;
        for(int i = 0; i< tree.maxChar; i++) {
            if (tree.CommandeTab[0][i] > 0)
                queue.add(tree.CommandeTab[0][i]);
        }
        while(!queue.isEmpty()){
            int r = queue.removeFirst();
            for(int i = 0; i< tree.maxChar; i++) {
                if (tree.CommandeTab[r][i] != -1)
                    queue.add(tree.CommandeTab[r][i]);
                else
                    tree.CommandeTab[r][i] = tree.CommandeTab[fail[r]][i];
            }
        }
    }
}
