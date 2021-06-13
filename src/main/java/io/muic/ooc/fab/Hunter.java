package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;

public class Hunter extends Actor{

    public void initialize(boolean randomAge, Field field, Location location) {
        super.initialize(randomAge,field,location);
    }

    @Override
    protected void act(List<Actor> actors) {
        if (isAlive()){
            Location newLocation = moveToNewLocation();
            if (newLocation != null){
                setLocation(newLocation);
            }
        }
    }

    @Override
    protected Location moveToNewLocation() {
        Location newLocation = hunting();
        if (newLocation == null){
            newLocation = field.freeAdjacentLocation(location);
        }
        return newLocation;
    }

    private Location hunting(){
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    return where;
                }
            }
            else if (animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    return where;
                }
            }
            else if (animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal;
                if (tiger.isAlive()) {
                    tiger.setDead();
                    return where;
                }
            }

        }
        return null;
    }
}
