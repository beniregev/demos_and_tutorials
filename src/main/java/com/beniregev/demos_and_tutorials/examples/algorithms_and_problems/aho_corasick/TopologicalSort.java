package com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.aho_corasick;

import com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.Vertex;

import java.util.*;

public class TopologicalSort{

    public static void topologicalSort(Graph graph){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        boolean[] visited = new boolean[graph.vertices.length];
        visited[0] = true;
        Vertex[] vertices = graph.vertices;
        while (!stack.isEmpty()){
            int currVertex = stack.pop();
            // Process here.
            System.out.println("Vertex: " + currVertex +
                    ", Edges: " + vertices[currVertex].toString());
            for (Integer i : vertices[currVertex]){
                if (!visited[i]){
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args){
        boolean[][] matrix = new boolean[6][6];
        matrix[0][1] = true;
        matrix[0][2] = true;
        matrix[1][0] = true;  // 0 1 1 0 0 0
        matrix[1][3] = true;  // 1 0 0 1 0 0
        matrix[2][0] = true;  // 1 0 0 1 0 0
        matrix[2][3] = true;  // 0 1 1 0 1 0
        matrix[3][1] = true;  // 0 0 0 1 0 1
        matrix[3][2] = true;  // 0 0 0 0 1 0
        matrix[3][4] = true;
        matrix[4][3] = true;
        matrix[4][5] = true;
        matrix[5][4] = true;
        Graph graph = new Graph(matrix);
        topologicalSort(graph);
    }
}
