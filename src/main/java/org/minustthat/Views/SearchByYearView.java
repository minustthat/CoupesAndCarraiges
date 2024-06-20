package org.minustthat.Views;

import org.minustthat.Controllers.VehicleController;

import java.util.Scanner;

public class SearchByYearView {
    VehicleController vehicleController;

    public SearchByYearView(VehicleController vehicleController){
        this.vehicleController = vehicleController;
    }

    public void displayMatchingYear(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input year would like to search for.");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println(vehicleController.searchByYear(year));
    }
}
