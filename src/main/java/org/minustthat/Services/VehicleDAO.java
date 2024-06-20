package org.minustthat.Services;

import org.minustthat.Models.Vehicle;
import java.util.*;

public interface VehicleDAO {
    Vehicle getVehicleByVin(String vin);
    List<Vehicle> getVehicleByMake(String make);
    List<Vehicle> getVehicleByModel(String model);
    List<Vehicle> getVehicleByYear(int year);
    public List<Vehicle> getAllVehicles();
}
