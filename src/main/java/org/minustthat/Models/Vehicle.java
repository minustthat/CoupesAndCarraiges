package org.minustthat.Models;

public class Vehicle {
    private String vinNumber;
    private String make;
    private String model;
    private int year;
    private boolean sold;
    private int odometerReading;
    private Type type;
    private String color;
    private double price;




    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Vehicle(String vinNumber, String make, String model, int year, boolean sold,
                   int odometerReading, Type type,String color, double price) {
            this.vinNumber = vinNumber;
            this.year = year;
            this.make = make;
            this.model = model;
            this. type = type;
            this.color = color;
            this.odometerReading = odometerReading;
            this.price = price;

        }
        public Vehicle(){

        }

        // <editor-fold desc="getters and setters">
        public String getVinNumber() {
            return vinNumber;
        }

        public void setVinNumber(String vinNumber) {
            this.vinNumber = vinNumber;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getOdometerReading() {
            return odometerReading;
        }

        public void setOdometerReading(int odometerReading) {
            this.odometerReading = odometerReading;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    public boolean isSold() {
        return sold;
    }
        // </editor-fold>
    public String toString(){
        return STR.
                """
                Vin : \{vinNumber}
                Make : \{make}
                Model : \{model}
                Year : \{year}
                Sold : \{sold}
                Mileage: \{odometerReading}
                Type : \{type}
                Color : \{color}
                Price : \{price}
    """;
    }


}
