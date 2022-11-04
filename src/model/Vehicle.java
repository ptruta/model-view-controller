package model;

import java.util.Objects;

public abstract class Vehicle {
    private final int id;
    private final VehicleType type;
    private final String colour;
    private final String brand;
    private final String model;
    private final int numberOfWheels;

    protected Vehicle(int id, VehicleType type, String colour, String brand, String model, int numberOfWheels) {
        this.id = id;
        this.type = type;
        this.colour = colour;
        this.brand = brand;
        this.model = model;
        this.numberOfWheels = numberOfWheels;
    }


    public int getId() {
        return id;
    }


    public VehicleType getType() {
        return type;
    }


    public String getColour() {
        return colour;
    }


    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }


    public int getNumberOfWheels() {
        return numberOfWheels;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return getId() == vehicle.getId()
                && getNumberOfWheels() == vehicle.getNumberOfWheels()
                && getType() == vehicle.getType()
                && Objects.equals(getColour(), vehicle.getColour())
                && Objects.equals(getBrand(), vehicle.getBrand()) && Objects.equals(getModel(), vehicle.getModel());
    }


    public int hashCode() {
        return Objects.hash(getId(), getType(), getColour(), getBrand(), getModel(), getNumberOfWheels());
    }


    public String toString() {
        return
                "id=" + id +
                " type=" + type.toString().toLowerCase() +
                " colour='" + colour + '\'' +
                " brand='" + brand + '\'' +
                " model='" + model + '\'' +
                " NumberOfWheels=" + numberOfWheels +
                '}';
    }
}
