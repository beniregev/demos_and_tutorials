package com.beniregev.demos_and_tutorials.examples.algorithms.aho_corasick;

import com.beniregev.demos_and_tutorials.examples.algorithms.Vertex;

import java.util.Collections;

public class Graph {
    Vertex[] vertices;

    Graph(boolean[][] matrix){
        this.vertices = graphFromAdjacencyMatrix(matrix);
    }

    public Vertex[] graphFromAdjacencyMatrix(boolean[][] matrix){
        //Add all vertices
        Vertex[] list = new Vertex[matrix.length];
        for (int vertex = 0; vertex < matrix.length; vertex++){
            Vertex newVertex = new Vertex();
            for (int edge = 0; edge < matrix[vertex].length; edge++){
                if (matrix[vertex][edge] == true){
                    newVertex.add(edge);
                }
            }
            list[vertex] = newVertex;
        }

        // We reverse the order of the edges so that the dfs works as a topological sort.
        // It makes the stack process vertex A before Vertex B if
        // encountered at the same time. (Lexicographical Order)
        for (Vertex v : list){
            Collections.reverse(v);
        }
        return list;

    }

}
