package com.hesshes.studytobe.domain;

// list 5-3
public enum Level {
    BASIC(1), SILVER(2), GOLD(3);

    private final int value;

    Level(int value) {
        this.value = value;
    }

    public int intValue() {
        return this.value;
    }

    public static Level valueOf(int value) {
        switch (value) {
        case 1:
            return BASIC;
        case 2:
            return SILVER;
        case 3:
            return GOLD;
        default:
            throw new AssertionError("Unkown value : " + value);
        }
    }

}
