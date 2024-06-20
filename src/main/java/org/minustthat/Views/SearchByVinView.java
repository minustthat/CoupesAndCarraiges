package org.minustthat.Views;

import org.minustthat.Controllers.VehicleController;
import org.minustthat.Models.Vehicle;

import java.util.Scanner;

public class SearchByVinView {
VehicleController vehicleController;
public SearchByVinView(VehicleController vehicleController){
    this.vehicleController = vehicleController;
}
    public void getUserVin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the vin you would like to search for");
        String vinNum = scanner.nextLine();
        System.out.println(vehicleController.searchByVin(vinNum));
    }



}
