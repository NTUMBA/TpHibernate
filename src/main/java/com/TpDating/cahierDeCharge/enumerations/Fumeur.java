package com.TpDating.cahierDeCharge.enumerations;

public enum Fumeur {
   // YES,NO,OCCAS
    YES ("yes"),
     NO ("no"),
     ENSOIREE ("ensoiree"),
     SOMETIMES ("sometimes");
 
     private String name;
 
     Fumeur(String name) {
         this.name = name;
     }
 
     @Override
     public String toString() {
         return name;
     }
 }
