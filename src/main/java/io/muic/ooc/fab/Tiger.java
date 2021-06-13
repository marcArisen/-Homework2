package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Tiger extends Animal{
    // Characteristics shared by all tigers (class variables).

    // The age at which a fox can start to breed.
    /*private static final int BREEDING_AGE = 15;
    // The age to which a fox can live.
    private static final int MAX_AGE = 150;
    // The likelihood of a fox breeding.
    private static final double BREEDING_PROBABILITY = 0.08;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    // Random generator*/
    private static final Random RANDOM = new Random();

    // The fox's food level, which is increased by eating rabbits.
    private int foodLevel;
    @Override
    public void initialize(boolean randomAge, Field field, Location location) {
        super.initialize(randomAge,field,location);
        foodLevel = RANDOM.nextInt(Rabbit.getRabbitFoodValue());
    }

    public void act(List<Actor> newTiger) {
        incrementHunger();
        super.act(newTiger);
    }

    @Override
    protected Location moveToNewLocation() {
        Location newLocation = findFood();
        if (newLocation == null){
            newLocation = field.freeAdjacentLocation(location);
        }
        return newLocation;
    }

    private void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            setDead();
        }
    }

    private Location findFood() {
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    foodLevel = Rabbit.getRabbitFoodValue();
                    return where;
                }
            }
            else if (animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    foodLevel = Fox.getFoxFoodValue();
                    return where;
                }
            }

        }
        return null;
    }

    @Override
    public int getMaxAge() {
        return 120;
    }

    @Override
    protected double getBreedingProbability() {
        return 0.08;
    }

    @Override
    protected int getMaxLitterSize() {
        return 2;
    }

    @Override
    protected int getBreedingAge() {
        return 15;
    }

   /* @Override
    protected Animal createYoung(boolean randomAge, Field field, Location location) {
        return AnimalFactory.createAnimal(this.getClass(),field,location);
    }*/
}
