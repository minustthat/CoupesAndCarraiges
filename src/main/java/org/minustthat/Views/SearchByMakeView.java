package org.minustthat.Views;

import org.minustthat.Controllers.VehicleController;

import java.util.Scanner;

public class SearchByMakeView {
    VehicleController vehicleController;
    public SearchByMakeView(VehicleController vehicleController){
        this.vehicleController = vehicleController;
    }
    Scanner scanner = new Scanner(System.in);
    public void displayMake(){
        System.out.println("Please insert the name of the make you are looking for.");
        String newMake = scanner.nextLine();
        System.out.println(vehicleController.searchByMake(newMake));
    }
}
