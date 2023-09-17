package com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.minesweeper_awt;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *  <div>
 *      <div>Minesweeper, the classic game in Java and AWT UI.</div>
 *      <div>
 *          Redesigned and rewritten to practice Pure Java, and adapted
 *          to Java 8 new features (e.g., Lambdas, etc.).
 *      </div>
 *  </div>
 * @author binyamin.regev 2023-02-26
 * @since jdk1.8.0_361
 */
public class MinesweeperBoard implements ActionListener, MouseListener {
    private final JFrame screen;
    private final JButton smiley = new JButton("");
    private final JPanel composite = new JPanel();

    ImageIcon smileyImageIcon = null;
    ImageIcon tImageIcon = null;
    ImageIcon pitImageIcon = null;
    ImageIcon lossImageIcon = null;
    ImageIcon cryImageIcon = null;
    ImageIcon oneImageIcon = null;
    ImageIcon twoImageIcon = null;
    ImageIcon threeImageIcon = null;
    ImageIcon fourImageIcon = null;
    ImageIcon fiveImageIcon = null;

    public MinesweeperBoard() {
        screen = new JFrame("MineSweeper by Binyamin Regev");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setVisible(true);
        screen.setResizable(false);
        screen.setJMenuBar(createMenuBar());
        loadMinesweeperImages();

        composite.setLayout(new BorderLayout());
        smiley.setPreferredSize(new Dimension(25, 25));
        smiley.setIcon(smileyImageIcon);
        JPanel topPanel = new JPanel();
        topPanel.add(smiley);
        composite.add(topPanel, BorderLayout.NORTH);
        smiley.addActionListener(this);
        smiley.addMouseListener(this);
        arrangeButtons();
        screen.add(composite);
        screen.pack();
    }

    public void loadMinesweeperImages() {
        smileyImageIcon = getScaledImage("C:\\Patches\\images\\smiley.png");
        tImageIcon = getScaledImage("C:\\images\\t.png");
        pitImageIcon = getScaledImage("C:\\images\\pit.png");
        lossImageIcon = getScaledImage("C:\\images\\loss.png");
        cryImageIcon = getScaledImage("C:\\images\\cry.png");
        oneImageIcon = getScaledImage("C:\\images\\1.png");
        twoImageIcon = getScaledImage("C:\\images\\2.png");
        threeImageIcon = getScaledImage("C:\\images\\3.png");
        fourImageIcon = getScaledImage("C:\\images\\4.png");
        fiveImageIcon = getScaledImage("C:\\images\\5.png");


    }

    public JMenuBar createMenuBar() {

        JMenuBar mBar = new JMenuBar();
        JMenu game = new JMenu("Game");

        JMenu help = new JMenu("Help");

        final JMenuItem miNew = new JMenuItem("New");
        final JMenuItem miBeg = new JMenuItem("Beginner");
        final JMenuItem miInter = new JMenuItem("Intermediate");
        final JMenuItem miExp = new JMenuItem("Expert");
        final JMenuItem miExit = new JMenuItem("Exit");

        final JMenuItem about = new JMenuItem("About MineSweeper....");

        game.add(miNew);
        game.add(miBeg);
        game.add(miInter);
        game.add(miExp);
        game.add(miExit);

        help.add(about);

        ActionListener menuListener = ae -> {
            if (miNew == ae.getSource()) {
                buttonWidth = 10;
                buttonHeight = 10;
                mines = 10;
                reset();
            }
            if (miBeg == ae.getSource()) {
                buttonWidth = 12;
                buttonHeight = 12;
                mines = 12;
                reset();

            }
            if (miInter == ae.getSource()) {
                buttonWidth = 15;
                buttonHeight = 15;
                mines = 50;
                reset();

            }
            if (miExp == ae.getSource()) {
                buttonWidth = 24;
                buttonHeight = 30;
                mines = 80;
                reset();
            }
            if (miExit == ae.getSource()) {
                screen.dispose();
                System.exit(0);
            }

            if (about == ae.getSource()) {
                System.out.println(" Binyamin Regev");
            }
        };

        miNew.addActionListener(menuListener);
        miBeg.addActionListener(menuListener);
        miInter.addActionListener(menuListener);
        miExp.addActionListener(menuListener);
        miExit.addActionListener(menuListener);
        about.addActionListener(menuListener);
        mBar.add(game);
        mBar.add(help);
        return mBar;
    }

    private int buttonWidth = 10;

    private int buttonHeight = 10;
    private int mines = 8;
    int[][] mineArray;
    JButton[][] button;
    JPanel mineSpan = null;

    public void arrangeButtons() {
        mineArray = new int[buttonWidth][buttonHeight];
        button = new JButton[buttonWidth][buttonHeight];
        boolean starting = true;
        if (mineSpan != null) {
            composite.remove(mineSpan);
            mineSpan = null;
            starting = false;

        }
        mineSpan = new JPanel();
        mineSpan.setLayout(new GridLayout(buttonWidth, buttonHeight));

        for (int i = 0; i < buttonWidth; i++) {
            for (int j = 0; j < buttonHeight; j++) {
                mineArray[i][j] = 0;
                button[i][j] = new JButton("");
                button[i][j].setBackground(Color.WHITE);
                button[i][j].setPreferredSize(new Dimension(16, 16));
                button[i][j].addActionListener(this);
                button[i][j].addMouseListener(this);
                mineSpan.add(button[i][j]);
            }
        }

        mineSpan.setVisible(true);
        composite.add(mineSpan, BorderLayout.CENTER);
        if (starting) {
            minesFormat();
        }
        screen.pack();
    }

    public void reset() {
        smiley.setIcon(smileyImageIcon);
        arrangeButtons();
        for (int i = 0; i < buttonWidth; i++) {
            for (int j = 0; j < buttonHeight; j++) {
                mineArray[i][j] = 0;
                button[i][j].addActionListener(this);
                button[i][j].addMouseListener(this);
                button[i][j].setText("");
                button[i][j].setBackground(Color.WHITE);
            }
        }
        minesFormat();
        System.out.println("\n");
    }

    public void minesFormat() {
        int[] mine = getRandomNos(buttonWidth, buttonHeight, mines);
        int count = 1;
        for (int i = 0; i < buttonWidth; i++) {
            for (int j = 0; j < buttonHeight; j++) {
                for (int k = 0; k < mine.length && mine[k] != 0; k++) {
                    if (count == mine[k]) {
                        mineArray[i][j] = 9;
                        break;
                    }
                }
                count++;
            }
        }

        int boxCount;
        for (int i = 0; i < buttonWidth; i++) {
            for (int j = 0; j < buttonHeight; j++) {
                boxCount = 0;
                if (mineArray[i][j] != 9) {
                    if (i > 0 && j > 0 && mineArray[i - 1][j - 1] == 9)
                        boxCount++;

                    if (i > 0 && mineArray[i - 1][j] == 9)
                        boxCount++;

                    if (i > 0 && j < buttonHeight - 1 && mineArray[i - 1][j + 1] == 9)
                        boxCount++;

                    if (i < buttonWidth - 1 && j > 0 && mineArray[i + 1][j - 1] == 9)
                        boxCount++;

                    if (i < buttonWidth - 1 && mineArray[i + 1][j] == 9)
                        boxCount++;

                    if (i < buttonWidth - 1 && j < buttonHeight - 1 && mineArray[i + 1][j + 1] == 9)
                        boxCount++;

                    if (j > 0 && mineArray[i][j - 1] == 9)
                        boxCount++;

                    if (j < buttonHeight - 1 && mineArray[i][j + 1] == 9)
                        boxCount++;

                    mineArray[i][j] = boxCount;
                }
            }
        }

        for (int i = 0; i < buttonWidth; i++) {
            for (int j = 0; j < buttonHeight; j++) {
                System.out.print(" " + mineArray[i][j]);
            }
            System.out.println();
        }
    }

    public int[] getRandomNos(int buttonWidth, int buttonHeight, int mines) {
        Random rand = new Random();
        int[] randomMines = new int[buttonWidth * buttonHeight];
        boolean in; //  Default value of boolean data type is false
        int count = 0;
        while (count < mines) {
            int randomNumber = (buttonWidth * buttonHeight) * (rand.nextInt()) + 1;
            in = false;
            for (int i = 0; i < count; i++) {
                if (randomMines[i] == randomNumber) {
                    in = true;
                    break;
                }
            }
            if (!in) {
                randomMines[count++] = randomNumber;
            }
        }
        return randomMines;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == smiley) {
            reset();
        } else {
            for (int i = 0; i < buttonWidth; i++)
                for (int j = 0; j < buttonHeight; j++) {
                    if (button[i][j] == ae.getSource()) {
                        if (mineArray[i][j] == 9) {
                            for (int k = 0; k < buttonWidth; k++) {
                                for (int l = 0; l < buttonHeight; l++) {
                                    if (mineArray[k][l] == 9) {
                                        button[k][l].setIcon(pitImageIcon);
                                    }
                                    button[k][l].removeActionListener(this);
                                    button[k][l].removeMouseListener(this);
                                }
                            }
                        }
                        if (mineArray[i][j] == 1) {
                            button[i][j].setIcon(oneImageIcon);
                        }
                        if (mineArray[i][j] == 2) {
                            button[i][j].setIcon(twoImageIcon);
                        }
                        if (mineArray[i][j] == 3) {
                            button[i][j].setIcon(threeImageIcon);
                        }
                        if (mineArray[i][j] == 4) {
                            button[i][j].setIcon(fourImageIcon);
                        }
                        if (mineArray[i][j] == 5) {
                            button[i][j].setIcon(fiveImageIcon);
                        }
                        if (mineArray[i][j] == 0) {
                            findAllEmpty(i, j);
                        }
                    }
                }
        }
    }

    public void findAllEmpty(int boxX, int boxY) {
        int[] arrX = new int[(buttonWidth) * (buttonHeight)];
        int[] arrY = new int[(buttonWidth) * (buttonHeight)];
        int cntEmpty = 0;
        for (int i = 0; i < ((buttonWidth) * (buttonHeight)); i++) {
            arrX[i] = -1;
            arrY[i] = -1;
        }
        arrX[cntEmpty] = boxX;
        arrY[cntEmpty] = boxY;
        cntEmpty++;
        for (int i = 0; i < cntEmpty; i++) {
            if (arrX[i] > 0) {
                int xxX = arrX[i] - 1;
                int yyY = arrY[i];
                if (mineArray[xxX][yyY] == 0 && !findIn(arrX, arrY, cntEmpty, xxX, yyY)) {
                    arrX[cntEmpty] = xxX;
                    arrY[cntEmpty] = yyY;
                    cntEmpty++;
                }
            }

            if (arrX[i] < (buttonWidth - 1)) {
                int xxX = arrX[i] + 1;
                int yyY = arrY[i];
                if (mineArray[xxX][yyY] == 0 && !findIn(arrX, arrY, cntEmpty, xxX, yyY)) {
                    arrX[cntEmpty] = xxX;
                    arrY[cntEmpty] = yyY;
                    cntEmpty++;
                }
            }

            if (arrY[i] > 0) {
                int xxX = arrX[i];
                int yyY = arrY[i] - 1;
                if (mineArray[xxX][yyY] == 0 && !findIn(arrX, arrY, cntEmpty, xxX, yyY)) {
                    arrX[cntEmpty] = xxX;
                    arrY[cntEmpty] = yyY;
                    cntEmpty++;
                }
            }

            if (arrY[i] < (buttonHeight - 1)) {
                int xxX = arrX[i];
                int yyY = arrY[i] + 1;
                if (mineArray[xxX][yyY] == 0 && !findIn(arrX, arrY, cntEmpty, xxX, yyY)) {
                    arrX[cntEmpty] = xxX;
                    arrY[cntEmpty] = yyY;
                    cntEmpty++;
                }
            }
        }

        for (int k = 0; k < cntEmpty; k++) {
            button[arrX[k]][arrY[k]].setBackground(new Color(200, 200, 250));
        }

    }

    public boolean findIn(int[] arrX, int[] arrY, int cntEmpty, int xxX, int yyY) {
        for (int j = 0; j < cntEmpty; j++) {
            if ((arrX[j] == (xxX)) && (arrY[j] == (yyY))) {
                return true;
            }
        }
        return false;
    }

    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    public void mousePressed(MouseEvent me) {
        for (int i = 0; i < buttonWidth; i++)
            for (int j = 0; j < buttonHeight; j++) {
                if (button[i][j] == me.getSource()) {
                    smiley.setIcon(cryImageIcon);
                }
            }

        if (me.getSource() == smiley) {
            smiley.setIcon(cryImageIcon);
        }
    }

    public void mouseReleased(MouseEvent me) {
        // TODO Auto-generated method stub
        if (me.getSource() == smiley) {
            smiley.setIcon(smileyImageIcon);
        }
        for (int i = 0; i < buttonWidth; i++)
            for (int j = 0; j < buttonHeight; j++) {
                if (button[i][j] == me.getSource()) {
                    if (mineArray[i][j] == 9) {
                        smiley.setIcon(lossImageIcon);
                    } else {
                        smiley.setIcon(smileyImageIcon);
                    }
                }
            }

    }

    public ImageIcon getScaledImage(String imageString) {
        ImageIcon imageIcon = new ImageIcon(imageString);
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImage);
        return imageIcon;
    }


    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }

    public static void main(String[] args) {
        MinesweeperBoard gameBoard = new MinesweeperBoard();
    }
}
