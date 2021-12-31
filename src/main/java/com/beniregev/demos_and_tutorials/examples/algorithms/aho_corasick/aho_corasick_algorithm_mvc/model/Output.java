package com.beniregev.demos_and_tutorials.examples.algorithms.aho_corasick.aho_corasick_algorithm_mvc.model;

public class Output {
    String outputString;
    int lineNumber,outputStartPoint,outputEndPoint;

    public Output(String outputString, int lineNumber, int outputStartPoint,
                  int outputEndPoint) {
        super();
        this.outputString = outputString;
        this.lineNumber = lineNumber;
        this.outputStartPoint = outputStartPoint;
        this.outputEndPoint = outputEndPoint;
    }

    public String getOutputString() {
        return outputString;
    }

    public void setOutputString(String outputString) {
        this.outputString = outputString;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getOutputStartPoint() {
        return outputStartPoint;
    }

    public void setOutputStartPoint(int outputStartPoint) {
        this.outputStartPoint = outputStartPoint;
    }

    public int getOutputEndPoint() {
        return outputEndPoint;
    }

    public void setOutputEndPoint(int outputEndPoint) {
        this.outputEndPoint = outputEndPoint;
    }
}
