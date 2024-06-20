package org.minustthat.Views;
import org.minustthat.Controllers.VehicleController;
import org.minustthat.Models.Vehicle;
import org.minustthat.Services.QueryVehicleDAO;
import org.minustthat.Services.VehicleDAO;

import java.awt.desktop.SystemEventListener;
import java.util.List;
import java.util.Scanner;
public class SearchByModelView {
    VehicleController vehicleController;
    public SearchByModelView(VehicleController vehicleController){
        this.vehicleController = vehicleController;
    }
    VehicleDAO vehicleDAO;

    public void searchModels(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input model name you would like to search for");
        String carModel = scanner.nextLine();
        List <Vehicle> newVehicles = vehicleController.searchByModel(carModel);
      newVehicles.stream()
              .forEach(v-> System.out.println(v.toString()));



    }


}
