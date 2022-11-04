package view;

import controller.Controller;
import model.Vehicle;

public class View {

    private final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        for (Vehicle vehicle : controller.getAllRedVehicles()) {
            if (vehicle != null) {
                System.out.println(vehicle);
            }
        }

        // model -> all the entities (Bicyle, Motorcycle, Car that extends a common Vehicle class)
        // repository -> an array of all the vehicles with all types
        // controller -> control what is in repository, more exacly call all the method from repository
        // (CRUD, filter methods)
        // view -> call all the methods from controller
        // main -> create all the objects (Repository, Controller, View).
    }
}
