package io.muic.ooc.fab;

public class Rabbit extends Animal {
    // Characteristics shared by all rabbits (class variables).

/*    // The age at which a rabbit can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a rabbit can live.
    private static final int MAX_AGE = 40;
    // The likelihood of a rabbit breeding.
    private static final double BREEDING_PROBABILITY = 0.12;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    // A shared random number generator to control breeding.

    private static final int RABBIT_FOOD_VALUE = 9;

    private static final Random RANDOM = new Random();*/

    /**
     * Create a new rabbit. A rabbit may be created with age zero (a new born)
     * or with a random age.
     *
     * @param randomAge If true, the rabbit will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    @Override
    public void initialize(boolean randomAge, Field field, Location location) {
        super.initialize(randomAge,field,location);
    }

    /**
     * This is what the rabbit does most of the time - it runs around. Sometimes
     * it will breed or die of old age.
     *
     * @param newRabbits A list to return newly born rabbits.
     */

    @Override
    protected Location moveToNewLocation() {
        return field.freeAdjacentLocation(location);
    }



    /*public void run(List<Rabbit> newRabbits) {
        incrementAge();
        if (isAlive()) {
            giveBirth(newRabbits);
            // Try to move into a free location.
            Location newLocation = field.freeAdjacentLocation(location);
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                // Overcrowding.
                setDead();
            }
        }
    }
*/
    @Override
    protected double getBreedingProbability() {
        return 0.12;
    }

    @Override
    protected int getMaxLitterSize() {
        return 4;
    }

    @Override
    public int getMaxAge() {
        return 40;
    }

    @Override
    protected int getBreedingAge() {
        return 5;
    }

   /* @Override
    protected Animal createYoung(boolean randomAge, Field field, Location location) {
      *//*  Rabbit rabbit = new Rabbit();
        rabbit.initialize(randomAge,field,location);*//*
         return AnimalFactory.createAnimal(this.getClass(),field,location);
    }*/

    static int getRabbitFoodValue(){
        return 9;
    }
}
