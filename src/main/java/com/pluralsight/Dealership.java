package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;
    private ArrayList<Vehicle> saleVehicles;
    private ArrayList<Vehicle> leasedVehicles;

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory, ArrayList<Vehicle> saleVehicles, ArrayList<Vehicle> leasedVehicles) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
        this.saleVehicles = saleVehicles;
        this.leasedVehicles = leasedVehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Vehicle> getSaleVehicles() {
        return saleVehicles;
    }

    public void setSaleVehicles(ArrayList<Vehicle> saleVehicles) {
        this.saleVehicles = saleVehicles;
    }

    public ArrayList<Vehicle> getLeasedVehicles() {
        return leasedVehicles;
    }

    public void setLeasedVehicles(ArrayList<Vehicle> leasedVehicles) {
        this.leasedVehicles = leasedVehicles;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }


}