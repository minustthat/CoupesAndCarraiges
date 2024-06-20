package org.minustthat.Services;

import org.minustthat.Models.Type;
import org.minustthat.Models.Vehicle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryVehicleDAO implements VehicleDAO {
    DataSource dataSource;
    public QueryVehicleDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Vehicle getVehicleByVin(String vin) {

        try(Connection connection = dataSource.getConnection()){
            String query = """
                    SELECT * FROM vehicles WHERE vin = ?
                    """;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,vin);

            ResultSet set = statement.executeQuery();
            if(set.next()){
                String carVin = set.getString("vin");
                String make = set.getString("make");
                String model = set.getString("model");
                int year = set.getInt("year");
                boolean sold = set.getBoolean("sold");
                int odometer = set.getInt("odometer");
                Type type = Type.valueOf(set.getString("type"));
                String color = set.getString("color");
                double price = set.getDouble("price");
                Vehicle vehicle = new Vehicle(carVin,make,model,year,sold,odometer,type,color,price);
                return vehicle;
            }


        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Vehicle> getVehicleByMake(String make) {
        List <Vehicle> vehicleList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            String query = """
                    Select vin
                    ,make
                    ,model
                    ,year
                    WHERE make = ?
                    """;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, make);

            ResultSet row = statement.executeQuery(query);
            while(row.next()){
                String vin = row.getString("vin");
                String Vmake = row.getString("make");
                String CarModel = row.getString("model");
                int year = row.getInt("year");
                boolean sold = row.getBoolean("sold");
                int odometer = row.getInt("odometer");
                Type type = Type.valueOf(String.valueOf(row.getString("type")));
                String color = row.getString("color");
                double price = row.getDouble("price");
                Vehicle vehicle = new Vehicle(vin,Vmake,CarModel,year,sold, odometer, type, color, price );
                vehicleList.add(vehicle);
            }
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> getVehicleByModel(String model) {
        List <Vehicle> vehicleList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            String query = """
                    Select vin
                    ,make
                    ,model
                    ,year
                    WHERE model = ?
                    """;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, model);

            ResultSet row = statement.executeQuery(query);
            while(row.next()){
                String vin = row.getString("vin");
                String make = row.getString("make");
                String CarModel = row.getString("model");
                int year = row.getInt("year");
                boolean sold = row.getBoolean("sold");
                int odometer = row.getInt("odometer");
                Type type = Type.valueOf(String.valueOf(row.getString("type")));
                String color = row.getString("color");
                double price = row.getDouble("price");
                Vehicle vehicle = new Vehicle(vin,make,CarModel,year,sold, odometer, type, color, price );
                vehicleList.add(vehicle);
            }
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
return vehicleList;
    }

    @Override
    public List<Vehicle> getVehicleByYear(int year) {
        List <Vehicle> vehicleList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            String query = """
                    Select vin
                    ,make
                    ,model
                    ,year
                    WHERE year = ?
                    """;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, year);

            ResultSet row = statement.executeQuery(query);
            while(row.next()){
                String vin = row.getString("vin");
                String Vmake = row.getString("make");
                String CarModel = row.getString("model");
                int Vyear = row.getInt("year");
                boolean sold = row.getBoolean("sold");
                int odometer = row.getInt("odometer");
                Type type = Type.valueOf(String.valueOf(row.getString("type")));
                String color = row.getString("color");
                double price = row.getDouble("price");
                Vehicle vehicle = new Vehicle(vin,Vmake,CarModel,Vyear,sold, odometer, type, color, price );
                vehicleList.add(vehicle);
            }
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return vehicleList;
    }

    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            String query = """
                    SELECT vin
                    ,make
                    ,model
                    ,year
                    ,sold
                    ,odometer
                    ,type
                    ,color
                    ,price
                    FROM vehicles""";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet set = statement.executeQuery(query);
            while(set.next()){
                String vin = set.getString("vin");
                String make = set.getString("make");
                String model = set.getString("model");
                int year = set.getInt("year");
                boolean sold = set.getBoolean("sold");
                int odometerReading = set.getInt("odometer");
                Type type = Type.valueOf(set.getString("type").toUpperCase());
                String color = set.getString("color");
                double price = set.getDouble("price");
                Vehicle vehicle = new Vehicle(vin, make, model, year, sold, odometerReading, type, color, price);
                vehicles.add(vehicle);

            }


        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return  vehicles;
    }
}
