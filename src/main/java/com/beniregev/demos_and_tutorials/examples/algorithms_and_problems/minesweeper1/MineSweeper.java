package com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.minesweeper1;

import java.util.Random;
import java.util.Scanner;

/**
 * <div>
 *     <h1>Learn Java by Building the Minesweeper Game</h1>
 *     <p>
 *         This class is a simple command-line (CLI) based Minesweeper game built
 *         step-by-step according to a guide.
 *     </p>
 *     <p>
 *         If you are a beginner in Java (just like I was when I developed this game)
 *         and want some hands-on practice, making a game might be an interesting way
 *         to learn! This code is going to be beginner-friendly, so enjoy :)
 *     </p>
 *     <p>
 *         I hope you are familiar with the rules of minesweeper, if not you can check
 *         <a href="https://www.wikihow.com/Play-Minesweeper">this</a> out first.
 *     </p>
 *     <p>
 *         <div>
 *             <h2>Logic</h2>
 *             <ol>
 *                 <li>
 *                     As we know, Minesweeper consists of a matrix of cells behind which
 *                     several mines are hidden. And our goal is to find out all the cells
 *                     that don’t carry the bombs. To make the matrix (or game field) we
 *                     are going to use two 2D arrays- the first one will contain all the
 *                     numbers and bombs, and the second one will contain only the data
 *                     that is to be displayed on the screen.
 *                 </li>
 *                 <li>
 *                     The setup and placement of bombs will be done in a randomized fashion.
 *                 </li>
 *                 <li>
 *                     At each turn, the player/user will be prompted to enter the row and
 *                     column number. The selected cell will get exposed and if there’s a
 *                     bomb behind it, the game will be over. If not, the cell’s neighbors
 *                     will be displayed on the screen, based on which the user can play his
 *                     next chance.
 *                 </li>
 *             </ol>
 *         </div>
 *     </p>
 *     <p>
 *         <div>
 *             <h2>Let’s Code!</h2>
 *             <p>
 *                 <div>
 *                     <em>Step 1:&nbsp;</em>&nbsp;Let’s begin with the creation of a ‘MineSweeper’ class
 *                     and add the following main function to it. Along with the main function, let us
 *                     also initialize two 2d arrays as explained in Logic point 1.
 *                 </div>
 *                 <div>
 *                     We will create the main class {@code MineSweeper} the {@code public static void main}
 *                     method, and declare 2d arrays: one for the user-board and another for the minefield.
 *                 </div>
 *                 <div>
 *                     Every time we run the code, the main method will create an object belonging to the class
 *                     {@code MineSweeper}. This class is going to contain methods and rules that will dictate
 *                     the game.
 *                 </div>>
 *             </p>
 *             <p>
 *                 <div>
 *                     <em>Step 2:&nbsp;</em>&nbsp;Now let’s proceed by adding methods to the game. The first method
 *                     that you can add is the startGame method.
 *                 </div>
 *                 <div>
 *                     Creating {@code public void startGame()} method.
 *                     <ul>This method will:
 *                         <li>Display the entry-level game/introduction messages.</li>
 *                         <li>Setup the minesweeper playing field.</li>
 *                         <li>Run the game until the player wins/loses.</li>
 *                         <li>Display final message.</li>
 *                     </ul>
 *                 </div>
 *             </p>
 *             <p>
 *                 <div>
 *                     <p>
 *                         <em>Step 3:&nbsp;</em>&nbsp;The {@code public void setupField()} method is going
 *                         to be used to set up the mines in the play-field. Currently, I have set up 10 bombs
 *                         in the field.
 *                     </p>
 *                     <p>
 *                         As explained in <em>logic point 2</em>, we will choose random integers from 0–9 for the
 *                         row and column values and place a bomb on each of those locations.
 *                     </p>
 *                     <p>
 *                         At the end of this method, we will call {@code buildHidden} method which will build the
 *                         hidden matrix.
 *                     </p>
 *                 </div>
 *             </p>
 *             <p>
 *                 <div>
 *                     <p>
 *                         <em>Step 4:&nbsp;</em>&nbsp;After the setting up of the mines, we will build our hidden
 *                         matrix, consisting of the mine proximity neighbor numbers and the mines.
 *                     </p>
 *                     <p>
 *                         The logic behind this is pretty simple. We will choose each cell and count the number
 *                         of bombs present in all of its neighboring cells. This value will be saved in the hidden
 *                         matrix cell.
 *                     </p>
 *                     <p>
 *                         At the end of this method, we will call {@code buildHidden} method which will build the
 *                         hidden matrix.
 *                     </p>
 *                 </div>
 *             </p>
 *             <p>
 *                 <div>
 *                     <p>
 *                         <em>Step 5:&nbsp;</em>&nbsp;Looking back at Step 2, we can now complete the
 *                         {@code displayVisible} method. The goal of this method is to display the current
 *                         progress of the game to the player (after each move).
 *                     </p>
 *                 </div>
 *             </p>
 *             <p>
 *                 <div>
 *                     <p>
 *                         <em>Step 6:&nbsp;</em>&nbsp;The {@code public boolean playMove()} method will allow
 *                         the player to select a cell, and expose the selected cell and its neighbors. If the
 *                         selected cell contains a mine, the ‘Game Over’ message will be displayed. This method
 *                         will be called after each turn.
 *                     </p>
 *                 </div>
 *             </p>
 *             <p>
 *                 <div>
 *                     <p>
 *                         <em>Step 7:&nbsp;</em>&nbsp;The next two methods: {@code public void fixVisible(int i, int j)}
 *                         and {@code public void fixNeighbours(int i, int j)} will be useful to change our hidden and
 *                         visible 2D arrays.
 *                     </p>
 *                 </div>
 *             </p>
 *             <p>
 *                 <div>
 *                     <p>
 *                         <em>Step 8:&nbsp;</em>&nbsp;Now for the second-last step, let’s build the
 *                         {@code public boolean checkWin} method. This method will be used to check
 *                         if the player has evaded all the mines on the playing field.
 *                     </p>
 *                     <p>It will return a boolean value back to the startGame function present in Step 2.</p>
 *                 </div>
 *             </p>
 *             <p>
 *                 <div>
 *                     <p>
 *                         <em>Step 9:&nbsp;</em>&nbsp;Finally, let’s build the {@code public void displayHidden}
 *                         method. This method will be called whenever a player loses or wins a game.
 *                     </p>
 *                     <p>
 *                         {@code public void displayHidden()} method will display our hidden 2d array, which will
 *                         be containing all the mines and mine-proximity neighbor numbers.
 *                     </p>
 *                     <p>
 *                         Now, you can just save the file, compile the code, execute it and start playing!!
 *                     </p>
 *                     <p></p>
 *                 </div>
 *             </p>
 *         </div>
 *     </p>
 *     <p>
 *         <h2>Future Additions</h2>
 *         <div>
 *             <p>
 *                 Although this game is playable as it is now, I want to add multiple enhancements to improve
 *                 the logic and the gaming experience.
 *             </p>
 *             <ol>Here are a few suggestions:
 *                 <li>
 *                     When selecting a cell (entering the row and column) - checking the neighbours IS NOT
 *                     recursive, and doesn't get to the edges when there are the number of mines around the
 *                     cell.
 *                 </li>
 *                 <li>
 *                     Change the game field according to a difficulty level; the player can be prompted to
 *                     input a difficulty level according to which the number of mines or the playing field
 *                     size can be increased.
 *                 </li>
 *                 <li>
 *                     Improve the logic so as to improve the gaming experience. There can be a few changes
 *                     made to increase the logical efficiency of the code. Find them out by playing the game
 *                     and scrupulously going through the code!
 *                 </li>
 *                 <li>
 *                     Think of adding a UI. Currently, this game is to be played on the command line. I can
 *                     add a nice UI that improves the user experience.
 *                 </li>
 *             </ol>
 *             <p>
 *                 These are just a few suggestions that are clearly noticeable. However, remember that the sky is the limit!
 *             </p>
 *         </div>
 *     </p>
 * </div>
 */
public class MineSweeper {
    private final Random random = new Random();
    private int[][] fieldVisible = new int[10][10];
    private int[][] fieldHidden = new int[10][10];

    public void startGame() {
        System.out.println("\n\n================Welcome to Minesweeper ! ================\n");
        setupField();

        boolean flag = true;
        while(flag) {
            displayVisible();
            flag = playMove();
            if(checkWin()) {
                displayHidden();
                System.out.println("\n================You WON!!!================");
                break;
            }
        }
    }

    public void setupField() {
        int var1=0;
        while(var1!=10) {
            int i = random.nextInt(10);
            int j = random.nextInt(10);
            fieldHidden[i][j] = 100;
            var1++;
        }
        buildHidden();
    }

    public void buildHidden() {
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                int cnt=0;
                if(fieldHidden[i][j]!=100) {
                    if(i!=0) {
                        if(fieldHidden[i-1][j]==100) cnt++;
                        if(j!=0 && fieldHidden[i-1][j-1]==100) cnt++;
                    }
                    if(i!=9) {
                        if(fieldHidden[i+1][j]==100) cnt++;
                        if(j!=9 && fieldHidden[i+1][j+1]==100) cnt++;
                    }
                    if(j!=0) {
                        if(fieldHidden[i][j-1]==100) cnt++;
                        if(i!=9 && fieldHidden[i+1][j-1]==100) cnt++;
                    }
                    if(j!=9) {
                        if(fieldHidden[i][j+1]==100) cnt++;
                        if(i!=0 && fieldHidden[i-1][j+1]==100) cnt++;
                    }
                    fieldHidden[i][j] = cnt;
                }
            }
        }
    }

    public boolean checkWin() {
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                if(fieldVisible[i][j]==0 && fieldHidden[i][j]!=100) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean playMove() {
        Scanner sc= new Scanner(System.in);
        System.out.print("\nEnter Row Number: ");
        int i= sc.nextInt();
        System.out.print("Enter Column Number: ");
        int j= sc.nextInt();

        if(i<0 || i>9 || j<0 || j>9 || fieldVisible[i][j]!=0) {
            System.out.print("\nIncorrect Input!!");
            return true;
        }

        if(fieldHidden[i][j]==100) {
            displayHidden();
            System.out.print("Oops! You stepped on a mine!\n============GAME OVER============");
            return false;
        }
        else if(fieldHidden[i][j]==0) {
            fixVisible(i, j);
        }
        else {
            fixNeighbours(i, j);
        }
        return true;
    }

    public void fixVisible(int i, int j) {
        fieldVisible[i][j] = 50;
        if(i!=0) {
            fieldVisible[i-1][j] = fieldHidden[i-1][j];
            if(fieldVisible[i-1][j]==0) fieldVisible[i-1][j] = 50;
            if(j!=0) {
                fieldVisible[i-1][j-1] = fieldHidden[i-1][j-1];
                if(fieldVisible[i-1][j-1]==0) fieldVisible[i-1][j-1]=50;

            }
        }
        if(i!=9) {
            fieldVisible[i+1][j]=fieldHidden[i+1][j];
            if(fieldVisible[i+1][j]==0) fieldVisible[i+1][j]=50;
            if(j!=9) {
                fieldVisible[i+1][j+1]= fieldHidden[i+1][j+1];
                if(fieldVisible[i+1][j+1]==0) fieldVisible[i+1][j+1] = 50;
            }
        }
        if(j!=0) {
            fieldVisible[i][j-1]=fieldHidden[i][j-1];
            if(fieldVisible[i][j-1]==0) fieldVisible[i][j-1] = 50;
            if(i!=9) {
                fieldVisible[i+1][j-1]=fieldHidden[i+1][j-1];
                if(fieldVisible[i+1][j-1]==0) fieldVisible[i+1][j-1] = 50;
            }
        }
        if(j!=9) {
            fieldVisible[i][j+1]=fieldHidden[i][j+1];
            if(fieldVisible[i][j+1]==0) fieldVisible[i][j+1] = 50;
            if(i!=0) {
                fieldVisible[i-1][j+1]=fieldHidden[i-1][j+1];
                if(fieldVisible[i-1][j+1]==0) fieldVisible[i-1][j+1] = 50;
            }
        }
    }

    public void fixNeighbours(int i, int j) {
        int x = random.nextInt()%4;

        fieldVisible[i][j] = fieldHidden[i][j];

        if(x==0) {
            if(i!=0 && fieldHidden[i-1][j]!=100) {
                fieldVisible[i-1][j] = fieldHidden[i-1][j];
                if(fieldVisible[i-1][j]==0)  fieldVisible[i-1][j] = 50;
            }
            if(j!=0 && fieldHidden[i][j-1]!=100) {
                fieldVisible[i][j-1] = fieldHidden[i][j-1];
                if(fieldVisible[i][j-1]==0)  fieldVisible[i][j-1] = 50;
            }
            if(i!=0 && j!=0 && fieldHidden[i-1][j-1]!=100) {
                fieldVisible[i-1][j-1] = fieldHidden[i-1][j-1];
                if(fieldVisible[i-1][j-1]==0)  fieldVisible[i-1][j-1] = 50;
            }
        }
        else if(x==1) {
            if(i!=0 && fieldHidden[i-1][j]!=100) {
                fieldVisible[i-1][j] = fieldHidden[i-1][j];
                if (fieldVisible[i-1][j]==0)  fieldVisible[i-1][j] = 50;
            }
            if(j!=9 && fieldHidden[i][j+1]!=100) {
                fieldVisible[i][j+1] = fieldHidden[i][j+1];
                if(fieldVisible[i][j+1]==0)  fieldVisible[i][j+1] = 50;
            }
            if(i!=0 && j!=9 && fieldHidden[i-1][j+1]!=100) {
                fieldVisible[i-1][j+1] = fieldHidden[i-1][j+1];
                if(fieldVisible[i-1][j+1]==0)  fieldVisible[i-1][j+1] = 50;
            }
        }
        else if(x==2) {
            if(i!=9 && fieldHidden[i+1][j]!=100) {
                fieldVisible[i+1][j] = fieldHidden[i+1][j];
                if(fieldVisible[i+1][j]==0)  fieldVisible[i+1][j] = 50;
            }
            if(j!=9 && fieldHidden[i][j+1]!=100) {
                fieldVisible[i][j+1] = fieldHidden[i][j+1];
                if(fieldVisible[i][j+1]==0)  fieldVisible[i][j+1] = 50;
            }
            if(i!=9 && j!=9 && fieldHidden[i+1][j+1]!=100) {
                fieldVisible[i+1][j+1] = fieldHidden[i+1][j+1];
                if(fieldVisible[i+1][j+1]==0)  fieldVisible[i+1][j+1] = 50;
            }
        }
        else {
            if(i!=9 && fieldHidden[i+1][j]!=100) {
                fieldVisible[i+1][j] = fieldHidden[i+1][j];
                if(fieldVisible[i+1][j]==0)  fieldVisible[i+1][j] = 50;
            }
            if(j!=0 && fieldHidden[i][j-1]!=100) {
                fieldVisible[i][j-1] = fieldHidden[i][j-1];
                if(fieldVisible[i][j-1]==0)  fieldVisible[i][j-1] = 50;
            }
            if(i!=9 && j!=0 && fieldHidden[i+1][j-1]!=100) {
                fieldVisible[i+1][j-1] = fieldHidden[i+1][j-1];
                if(fieldVisible[i+1][j-1]==0)  fieldVisible[i+1][j-1] = 50;
            }
        }
    }

    public void displayVisible() {
        System.out.print("\t ");
        for(int i=0; i<10; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();
        for(int i=0; i<10; i++) {
            System.out.print(i + "\t| ");
            for(int j=0; j<10; j++) {
                if(fieldVisible[i][j]==0) {
                    System.out.print("?");
                }
                else if(fieldVisible[i][j]==50) {
                    System.out.print(" ");
                }
                else {
                    System.out.print(fieldVisible[i][j]);
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public void displayHidden() {
        System.out.print("\t ");
        for(int i=0; i<10; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.print("\n");
        for(int i=0; i<10; i++) {
            System.out.print(i + "\t| ");
            for(int j=0; j<10; j++) {
                if(fieldHidden[i][j]==0) {
                    System.out.print(" ");
                }
                else if(fieldHidden[i][j]==100) {
                    System.out.print("X");
                }
                else {
                    System.out.print(fieldHidden[i][j]);
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        MineSweeper mineSweeper = new MineSweeper();
        mineSweeper.startGame();
    }
}
