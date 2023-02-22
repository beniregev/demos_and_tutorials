package com.beniregev.demos_and_tutorials.examples.show_as_jason.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum AlaCarteType {
    NONE("NONE"),
    CALL_CENTER("Call Center - Standard"),
    AUTO_ATTENDANT("Auto Attendant - Standard"),
    PRE_ALERTING("Pre-Alerting Announcement"),
    CLIENT_LICENSE_4("Client License 4"),
    BROADWORKS_AGENT("BroadWorks Agent");

    private final String alaCarte;

    AlaCarteType(String alaCarte) {
        this.alaCarte = alaCarte;
    }

    @JsonCreator
    public static AlaCarteType create(int value) {
        switch (value) {
            case 1: return CALL_CENTER;
            case 2: return AUTO_ATTENDANT;
            case 3: return PRE_ALERTING;
            case 4: return CLIENT_LICENSE_4;
            case 5: return BROADWORKS_AGENT;
            default: return NONE;
        }
    }
}
