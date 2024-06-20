package org.minustthat.Controllers;

import org.minustthat.Models.Vehicle;
import org.minustthat.Services.QueryVehicleDAO;
import org.minustthat.Services.VehicleDAO;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleController {
    VehicleDAO queryVehicleDAO;
    public VehicleController(VehicleDAO vehicleDAO){
        this.queryVehicleDAO = vehicleDAO;

    }

    public Vehicle searchByVin(String vin){
        Vehicle vehicle = new Vehicle();
        List<Vehicle> vehicleList = queryVehicleDAO.getAllVehicles();
        for(Vehicle v: vehicleList){
            if (v.getVinNumber() == vin){
                vehicle = v;
            }
        }
        return vehicle;
    }

    public void listVehicles(){
        List<Vehicle> vehicleList = queryVehicleDAO.getAllVehicles();
        for(Vehicle vehicle : vehicleList){
            System.out.println(vehicle.toString());
        }
    }
    public List<Vehicle> searchByModel(String model){
        List<Vehicle> vehicleList = queryVehicleDAO.getAllVehicles();
        // to search
        List<Vehicle> matches = vehicleList.stream()
                .filter(v-> v.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
        return matches;
    }

    public List<Vehicle> searchByMake(String make){
        List<Vehicle> vehicles = queryVehicleDAO.getAllVehicles();
        List<Vehicle> matchedMakes = vehicles.stream()
                .filter(v-> v.getMake().equalsIgnoreCase(make))
                .collect(Collectors.toList());
        return matchedMakes;
    }

  public List<Vehicle> searchByYear(int year){
        List<Vehicle> vehicleList =  queryVehicleDAO.getAllVehicles();
        List<Vehicle> matchingYears = vehicleList.stream()
                .filter(v-> v.getYear() == year)
                .collect(Collectors.toList());
        return matchingYears;
  }
}
