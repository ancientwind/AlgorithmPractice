package com.wayne.algo.graph;

import com.wayne.algo.basics.ArrayStack;
import com.wayne.algo.basics.Queue;

/**
 * Created by wayne on 2017/11/20.
 */
public class Graph {

    public final int MAX_VERTEXS = 10;
    public Vertex vertexList[]; // array of vertices
    public int adjMat[][]; // adjacency of vertices
    public int numOfVertex = 0;

    public Graph() {
        this.vertexList = new Vertex[MAX_VERTEXS];

        this.adjMat = new int[MAX_VERTEXS][MAX_VERTEXS];
        for (int i = 0; i <= MAX_VERTEXS; i++) {
            for (int j = 0; j <= MAX_VERTEXS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        this.vertexList[this.numOfVertex++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        this.adjMat[start][end] = 1;
        this.adjMat[end][start] = 1; // edge of no direction
    }

    public void displayVertex(int v) {
        System.out.println(this.vertexList[v].label);
    }

    // depth-first search
    public void dfs() {
        ArrayStack stack = new ArrayStack(this.numOfVertex);

        this.vertexList[0].visit();
        stack.push(0);

        while (!stack.isEmpty()) {

            int vertex = (int) stack.peak();
            int child = this.getUnVisitedSubVertex(vertex);
            if (child != -1) {
                this.vertexList[child].visit();
                stack.push(child);
            }
            else {
               stack.pop();
            }
        }

        this.resetVisitStatus();
    }

    // breadth first search
    public void bfs() {

        Queue queue = new Queue(this.numOfVertex);

        this.vertexList[0].visit();
        queue.add(0);

        while (!queue.isEmpty()) {
            int vertex = queue.element();
            int child = this.getUnVisitedSubVertex(vertex);
            if (child != -1) {
                this.vertexList[child].visit();
                queue.add(child);
            }
            else {
                queue.remove();
            }
        }

    }

    private void resetVisitStatus() {
        for (int i = 0; i < this.MAX_VERTEXS; i++) {
            this.vertexList[i].wasVisited = false;
        }
    }

    // index indicates which vertex
    public int getUnVisitedSubVertex(int index) {

        if (index >= 0 && index <= this.MAX_VERTEXS) {
            for (int i = index + 1; i < this.numOfVertex; i++) {
                if (this.adjMat[index][i] == 1 && !this.vertexList[i].wasVisited) {
                    return i;
                }
            }
        }

        return -1;
    }

}
