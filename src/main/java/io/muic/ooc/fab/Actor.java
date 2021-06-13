package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public abstract class Actor {

    private boolean alive = true;

    // The fox's position.
    protected Location location;
    // The field occupied.
    protected Field field;
    // Individual characteristics (instance fields).
    // The fox's age.


    private static final Random RANDOM = new Random();

    public void initialize(boolean randomAge, Field field, Location location) {
        this.field = field;
        setLocation(location);

    }

    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    public Location getLocation() {
        return location;
    }

    public  boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    protected abstract void act(List<Actor> actors);

    protected abstract Location moveToNewLocation();



}
