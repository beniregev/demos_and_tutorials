package com.beniregev.demos_and_tutorials.examples.algorithms;

import java.util.ArrayDeque;

/**
 * <div>
 *     <h1>BFS = Breadth First Search</h1>
 *     <p>Searches from S -> E, not going over the #, only the .</p>
 * </div>
 */
public class BFS {
    static final int[] DD = {-1,1,0,0};
    static final int[] DA = {0,0,1,-1};

    public static void main(String[] args) {

        char[][] map = new char[50][50];
        int[][] steps = new int[50][50];
        Node start = new Node(-1,-1);
        // Find start
        outer : for (int d = 0; d < map.length; d++) {
            for (int a = 0; a < map[d].length; a++) {
                if (map[d][a] == 'S') {
                    start = new Node(d,a);
                    break outer;
                }
            }
        }

        // Start is found, now search
        // We are going to record number of moves.

        ArrayDeque<Node> Nodes = new ArrayDeque<>();
        Nodes.add(start);
        Node end = new Node(-1,-1);

        outer : while (Nodes.isEmpty() == false) {
            Node pop = Nodes.pollFirst();

            for (int type = 0; type < 4; type++) {
                int nd = pop.d + DD[type];
                int na = pop.a + DA[type];

                if ( map[nd][na] == 'E') {
                    end = new Node(nd,na);
                    steps[nd][na]= steps[pop.d][pop.a]+1;
                    break outer;
                }

                if (map[nd][na] == '.') {
                    map[nd][na] = '#';
                    steps[nd][na] = steps[pop.d][pop.a]+1;
                    Nodes.add(new Node(nd,na));
                }
            }
        }

        System.out.println(steps[end.d][end.a]);
    }

}

class Node {
    int d,a,steps; // Down, Across

    public Node(int dd, int aa) {
        d = dd;
        a = aa;
    }
}
