package com.example.sangsakaair.aircraft;

import java.util.ArrayList;

public abstract class Aircraft {
    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public boolean isFlying() {
        return flying;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    protected boolean assigned = false;
    protected boolean flying = false;
    protected int capacity = 0;

    public int getCapacity() {
        return capacity;
    }

    public int getRange() {
        return range;
    }

    public String getRegistration() {
        return registration;
    }

    protected int range;
    protected String location;
    protected String registration;

    protected String type;

    public Aircraft(String registration, String type){
        this.registration = registration;
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }








}
