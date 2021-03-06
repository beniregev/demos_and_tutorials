package com.beniregev.demos_and_tutorials.model;

/**
 * Represents a machine in an environment.
 *
 * @author Binyamin Regev
 */
public class Machine {

    private String hostname;

    /**
     * Constructor.
     */
    public Machine() {
    }

    /**
     * Constructor.
     *
     * @param hostname identifier for this machine
     */
    public Machine(final String hostname) {
        this.hostname = hostname;
    }

    /**
     * @return the identifier for this machine
     */
    public String getHostname() {
        return hostname;
    }

}
