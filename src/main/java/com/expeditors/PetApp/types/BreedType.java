package com.expeditors.PetApp.types;

public enum BreedType {
    NONE(0), MIXED(1), SANBERNARDO(2), ALEMAN(3), BULLDOG(4), UNKNOWN(5);

    private int value;
    private BreedType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
