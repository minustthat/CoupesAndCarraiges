package org.minustthat;

import org.minustthat.Application.CoupesAndCarriagesApplication;
import org.minustthat.Controllers.VehicleController;
import org.minustthat.Services.QueryVehicleDAO;
import org.minustthat.Services.VehicleDAO;

public class Main {
    public static void main(String[] args) {

        VehicleDAO queryVehicleDAO = new QueryVehicleDAO(CoupesAndCarriagesApplication.buildDataSource());
        CoupesAndCarriagesApplication cc = new CoupesAndCarriagesApplication();
        VehicleController vehicleController = new VehicleController(queryVehicleDAO);
        cc.run();
    }
}