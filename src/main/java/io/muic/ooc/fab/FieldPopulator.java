package io.muic.ooc.fab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FieldPopulator {

    private static final Random RANDOM = new Random();


    private Map<AnimalType,Double> probablityMap = new HashMap<AnimalType, Double>(){{
        AnimalType[] animalTypes = AnimalType.values();
        for(int i = 0; i < animalTypes.length; i++){
            put(animalTypes[i],animalTypes[i].getBreedingProbablity())   ;
        }
    }} ;



    public void populate(Field field, List<Actor> animals) {

        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                for (Map.Entry<AnimalType,Double> entry : probablityMap.entrySet()){
                    if (RANDOM.nextDouble() <= entry.getValue()) {
                            Location location = new Location(row, col);
                            Actor animal = AnimalFactory.createAnimal(entry.getKey(), field,location);
                            animals.add(animal);
                            break;
                    }
                }
                // else leave the location empty.
            }
        }
    }

}
