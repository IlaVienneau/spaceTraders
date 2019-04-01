package com.example.spacetrader.entity;

public enum StarType {
    MAINSEQUENCE, REDGIANT, SUPERGIANT, BLUEGIANT, WHITEDWARF,
    BINARY;

    public String toFormattedString() {
        switch (this) {
            case MAINSEQUENCE:
                return "Main Sequence";
            case REDGIANT:
                return "Red Giant";
            case SUPERGIANT:
                return "Super Giant";
            case BLUEGIANT:
                return "Blue Giant";
            case WHITEDWARF:
                return "White Dwarf";
            case BINARY:
                return "Binary";
            default:
                return "";
        }
    }

    }
