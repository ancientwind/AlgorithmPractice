package com.wayne.algo.graph;

/**
 * Created by wayne on 2017/11/20.
 */
public class Vertex {

    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }

    public void visit() {
        System.out.println(this.label);
        this.wasVisited = true;
    }

}
