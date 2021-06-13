package io.muic.ooc.fab;

import java.awt.*;

public enum AnimalType {
    RABBIT(0.08, Rabbit.class, 9,Color.ORANGE),
    FOX(0.02, Fox.class, 6,Color.BLUE),
    TIGER(0.02, Tiger.class, 5,Color.red),
    HUNTER(0.01,Hunter.class,0,Color.CYAN)
    ;


    private double breedingProbablity;

    private int foodvalue;


    private Color color;


    private Class animalClass;

    AnimalType(double breedingProbablity, Class animalClass, int foodvalue, Color color){
        this.breedingProbablity = breedingProbablity;
        this.animalClass = animalClass;
        this.foodvalue = foodvalue;
        this.color = color;
    }

    public int getfoodvalue(){
        return foodvalue;
    }

    public double getBreedingProbablity() {
        return breedingProbablity;
    }

    public Class getAnimalClass() {
        return animalClass;
    }

    public Color getColor() {
        return color;
    }

}
