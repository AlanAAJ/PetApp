package com.expeditors.PetApp.types;

public enum PetType {
    NONE(0), DOG(1), CAT(2), FISH(3), UNKNOWN(4);

    private int value;
    private PetType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
