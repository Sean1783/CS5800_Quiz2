package org.quiz2;

import java.time.LocalDateTime;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
    }
}


// Part 1
// a.
abstract class Vehicle {

}

class Car extends Vehicle {
}

class Motorcycle extends Vehicle {
}

class Truck extends Vehicle {
}

// b.
class TrafficLight {

    String currentColor = "Red";

    LocalDateTime now = LocalDateTime.now();

    public void showColor() {
        if (currentColor == "Red") {
            System.out.println(currentColor);
            currentColor = "Green";
        }
        else if (currentColor == "Green") {
            System.out.println(currentColor);
            currentColor = "Yellow";
        }
        else if (currentColor == "Yellow") {
            System.out.println(currentColor);
            currentColor = "Red";
        }
    }
}


// Part 2
class TrafficLightObserver implements PropertyChangeListener {

    private ArrayList<String> statuses = new ArrayList<>();
    public void printStatuses() {
        statuses.forEach(System.out::println);
    }

    public void propertyChange(PropertyChangeEvent event) {
        statuses.add((String) event.getNewValue());
    }
}

class TrafficLightConnection {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private String status = "";

    public String getStatus() {
        return status;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void setStatus(String status) {
        support.firePropertyChange("status", this.status, status);
        this.status = status;
    }
}


// Part 3

interface DrivingBehavior {
    void showBehavior(TrafficLightConnection trafficLightStatus);
}

class Aggressive implements DrivingBehavior {
    @Override
    public void showBehavior(TrafficLightConnection trafficLightStatus) {
        if (Objects.equals(trafficLightStatus.getStatus(), "Yellow")) {
            System.out.println("Faster");
        }
        else if (Objects.equals(trafficLightStatus.getStatus(), "Red")) {
            System.out.println("Slam Brake");
        }
        else if (Objects.equals(trafficLightStatus.getStatus(), "Green")) {
            System.out.println("Need4Speed");
        }
    }
}

class Normal implements DrivingBehavior {
    @Override
    public void showBehavior(TrafficLightConnection trafficLightStatus) {
        if (Objects.equals(trafficLightStatus.getStatus(), "Yellow")) {
            System.out.println("Slow");
        }
        else if (Objects.equals(trafficLightStatus.getStatus(), "Red")) {
            System.out.println("Stop");
        }
        else if (Objects.equals(trafficLightStatus.getStatus(), "Green")) {
            System.out.println("Go");
        }
    }
}

class Passive implements DrivingBehavior {
    @Override
    public void showBehavior(TrafficLightConnection trafficLightStatus) {
        if (Objects.equals(trafficLightStatus.getStatus(), "Yellow")) {
            System.out.println("Slower");
        }
        else if (Objects.equals(trafficLightStatus.getStatus(), "Red")) {
            System.out.println("Stop");
        }
        else if (Objects.equals(trafficLightStatus.getStatus(), "Green")) {
            System.out.println("Go Slow");
        }
    }
}


abstract class Part3Vehicle {
}

class Part3Car extends Vehicle {
    String type;
    TrafficLightConnection connection;
    public Part3Car() {
        this.type = "Car";
    }
    public void showType() {
        System.out.println(type);
    }
    public void outputVehicleBehavior(DrivingBehavior behavior) {
        showType();
        behavior.showBehavior(connection);
    }
}

class Part3Motorcycle extends Vehicle {
    String type;
    TrafficLightConnection connection;
    public Part3Motorcycle() {
        this.type = "Motorcycle";
    }
    public void showType() {
        System.out.println(type);
    }
    public void outputVehicleBehavior(DrivingBehavior behavior) {
        showType();
        behavior.showBehavior(connection);
    }
}

class Part3Truck extends Vehicle {
    String type;
    TrafficLightConnection connection;
    public Part3Truck() {
        this.type = "Truck";
    }
    public void showType() {
        System.out.println(type);
    }
    public void outputVehicleBehavior(DrivingBehavior behavior) {
        showType();
        behavior.showBehavior(connection);
    }
}