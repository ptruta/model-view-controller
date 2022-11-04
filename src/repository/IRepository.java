package repository;

import model.Vehicle;

public interface IRepository {
    void add(Vehicle v);

    void delete(int id);

    Vehicle[] GetAll();
}
