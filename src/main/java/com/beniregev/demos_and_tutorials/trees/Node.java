package com.beniregev.demos_and_tutorials.trees;

public class Node {
    private String val;
    private Node[] children;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }
}
