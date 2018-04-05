package com.TpDating.cahierDeCharge.enumerations;

public enum Alcool {
    YES ("yes"),
    NO ("no"),
    ENSOIREE ("ensoiree"),
    SOMETIMES ("sometimes");

    private String name;

    Alcool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
