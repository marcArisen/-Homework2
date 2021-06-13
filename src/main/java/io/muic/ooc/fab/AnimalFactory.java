package io.muic.ooc.fab;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class AnimalFactory {

    private static Map<AnimalType,Class> animalClassMap = new HashMap<AnimalType, Class>(){{
        AnimalType[] animalTypes = AnimalType.values();
        for(int i = 0; i < animalTypes.length; i++){
            put(animalTypes[i],animalTypes[i].getAnimalClass());
        }
    }} ;

    public static Actor createAnimal(AnimalType animalType, Field field, Location location){
        Class animalClass = animalClassMap.get(animalType);
        return createAnimal(animalClass,field,location);
    }



    public static Actor createAnimal(Class animalClass,Field field,Location location){
       if (animalClass != null){
           try{
               //Animal animal = (Animal) animalClass.newInstance();
               Actor animal = (Actor) animalClass.getDeclaredConstructor().newInstance();
               animal.initialize(true,field,location);
               return animal;
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           } catch (InstantiationException | NoSuchMethodException e) {
               e.printStackTrace();
           } catch (InvocationTargetException e) {
               e.printStackTrace();
           }
       }
      /* switch (animalType){
           case RABBIT:
               return new Rabbit(true,field,location);
           case FOX:
               return new Fox(true,field,location);
           case TIGER:
               return new Tiger(true,field,location);
           default: throw new IllegalArgumentException("Wrong Argument Type");

       }*/


    throw  new IllegalArgumentException("Error");
    }
}
