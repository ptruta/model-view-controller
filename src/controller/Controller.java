package controller;

import model.*;
import repository.IRepository;

import java.util.Arrays;

public class Controller implements IController {
    private final IRepository repo;
    int id = 0;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    @Override
    public void addVehicle(VehicleType type, String colour, String brand, String model) {
        var v = switch (type) {
            case CAR -> new Car(id, colour, brand, model);
            case BICYCLE -> new Bicycle(id, colour, brand, model);
            case MOTORCYCLE -> new Motorcycle(id, colour, brand, model);
        };
        repo.add(v);
        id++;
    }

    @Override
    public void deleteVehicle(int id) {
        repo.delete(id);
    }

    @Override
    public Vehicle[] getAllRedVehicles() {
        var vehicles = repo.GetAll();
        Vehicle[] res = new Vehicle[vehicles.length];
        var resSize = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle == null) {
                break;
            }
            if (vehicle.getColour().equalsIgnoreCase("red")) {
                res[resSize] = vehicle;
                resSize += 1;
            }
        }
        return res;
    }

}
