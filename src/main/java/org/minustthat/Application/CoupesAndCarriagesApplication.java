package org.minustthat.Application;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;
import org.minustthat.Controllers.VehicleController;
import org.minustthat.Models.Vehicle;
import org.minustthat.Services.QueryVehicleDAO;
import org.minustthat.Services.VehicleDAO;
import org.minustthat.Views.SearchByMakeView;
import org.minustthat.Views.SearchByModelView;
import org.minustthat.Views.SearchByYearView;
import org.minustthat.Views.SearchByVinView;

public class CoupesAndCarriagesApplication {
DataSource dataSource;
VehicleDAO vehicleDAO;
VehicleController vehicleController;
SearchByModelView searchByModelView;
SearchByMakeView searchByMakeView;
SearchByYearView searchByYearView;
SearchByVinView searchByVinView;
public CoupesAndCarriagesApplication(){
    this.dataSource = buildDataSource();
    this.vehicleDAO = new QueryVehicleDAO(dataSource);
    this.vehicleController = new VehicleController(vehicleDAO);
    this.searchByModelView = new SearchByModelView(vehicleController);
    this.searchByMakeView = new SearchByMakeView(vehicleController);
    this.searchByYearView = new SearchByYearView(vehicleController);
    this.searchByVinView = new SearchByVinView(vehicleController);
}


    public void  run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Hello, please choose from the following items: 
                1. Search By Vin 
                2. Search By Make 
                3. Search By Model 
                4. Search by Year 
                5. Display Full Inventory  
           
                """);
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                searchByVinView.getUserVin();
                break;
            case 2:
                searchByMakeView.displayMake();
                break;
            case 3:
                searchByModelView.searchModels();
                break;
            case 4:
                searchByYearView.displayMatchingYear();
                break;

            case 5:
                vehicleController.listVehicles();
        }
    }



    public static DataSource buildDataSource(){
       try(FileInputStream fileInputStream = new FileInputStream("src/main/resources/Configuration.properties")){
           Properties properties = new Properties();
           properties.load(fileInputStream);
           String connectionString = properties.getProperty("db.connectionString");
           String userName = properties.getProperty("db.username");
           String password = properties.getProperty("db.password");

           BasicDataSource basicDataSource = new BasicDataSource();
           basicDataSource.setUrl(connectionString);
           basicDataSource.setUsername(userName);
           basicDataSource.setPassword(password);
           return basicDataSource;


       } catch (Exception e){
           System.out.println(e.getLocalizedMessage());
       }
return null;
    }

    public void getMatchingModels(){

    }
}
