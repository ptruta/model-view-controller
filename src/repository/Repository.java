package repository;

import exceptions.CustomException;
import model.Vehicle;
import model.Vehicle;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Repository implements IRepository {
    private final Vehicle[] vehicles = new Vehicle[100];
    private int vehicleCount = 0;

    @Override
    public void add(Vehicle v) {
        if (isVehicleInParkingLot(v.getId())) {
            throw new CustomException("Vehicle is already in the parking lot.");
        }

        if (vehicleCount == 100) {
            throw new CustomException("Parking lot is full.");
        }
        vehicles[vehicleCount++] = v;
    }

    @Override
    public void delete(int id) {
        if (!isVehicleInParkingLot(id)) {
            throw new CustomException("Vehicle is not in the parking lot.");
        }

        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getId() == id) {
                if (vehicleCount - (i + 1) >= 0)
                    System.arraycopy(vehicles, i + 1, vehicles, i + 1 - 1, vehicleCount - (i + 1));
            }
            vehicleCount--;
        }
    }

    private boolean isVehicleInParkingLot(int id) {
        if (vehicleCount == 0) {
            return false;
        }
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Vehicle[] GetAll() {
        Vehicle[] res = new Vehicle[vehicleCount];
        System.arraycopy(vehicles, 0, res, 0, vehicleCount);
        return res;
    }
}

