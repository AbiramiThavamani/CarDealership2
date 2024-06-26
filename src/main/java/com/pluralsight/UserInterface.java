package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;



public class UserInterface {

    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void display() {
        init();
        boolean quit = false;
        while (!quit) {
            System.out.println("---------- Menu ----------");
            System.out.println("1. Get vehicles by price");
            System.out.println("2. Get vehicles by make and model");
            System.out.println("3. Get vehicles by year");
            System.out.println("4. Get vehicles by color");
            System.out.println("5. Get vehicles by mileage");
            System.out.println("6. Get vehicles by type");
            System.out.println("7. Get all vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("10.Create ContractRequest");
            System.out.println("11. Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "10":
                    processCreateContractRequest();
                case "11":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int max = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int max = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {
        System.out.print("Enter vehicle vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter vehicle make: ");
        String make = scanner.nextLine();

        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine();

        System.out.print("Enter vehicle year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter vehicle price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine();

        System.out.print("Enter vehicle mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter vehicle type (Car, Truck, SUV, Motorcycle): ");
        String type = scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);

        dealership.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest() {
        System.out.print("Enter the VIN of the vehicle you wish to remove: ");
        int vin = scanner.nextInt();

        boolean vehicleRemoved = false;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle removed successfully!");
                vehicleRemoved = true;
                break;
            }
        }

        if (!vehicleRemoved) {
            System.out.println("Vehicle not found. Please try again.");
            return;
        }

        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        dealership = manager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    public void processCreateContractRequest() {
        System.out.println("Enter Vin of the Vehicle: ");
        int vin = scanner.nextInt();

        Vehicle vehicle = null;
        for (Vehicle vehicle1 : dealership.getAllVehicles()) {
            if (vehicle1.getVin() == vin) {
                vehicle = vehicle1;
                break;
            }
        }

        if (vehicle != null) {
            System.out.println("Select the contract type:");
            System.out.println("1 Sales Contract");
            System.out.println("2 Lease Contract ");
            System.out.println("Enter your choice: ");
            int contractTypeChoice = scanner.nextInt();

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    createSalesContract(vehicle);
                    break;
                case 2:
                    createLeaseContract(vehicle);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. ");

            }


            if (contractTypeChoice == 1) {
                createSalesContract(vehicle);

            } else if (contractTypeChoice == 2) {
                createLeaseContract(vehicle);
            } else {
                System.out.println("Invalid contract type choice");
            }
        } else {
            System.out.println("vehicle not found");
        }

    }

    public void createSalesContract(Vehicle vehicle) {
        System.out.println("Creating sales Contract");
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String contractOfDate = currentDate.format(dateFormatter);

        System.out.println("Enter Customer name: ");
        scanner.nextLine();
        String customerName = scanner.nextLine().trim();

        System.out.println("Enter Customer email: ");
        String customerEmail = scanner.nextLine().trim();
        // calculating sales tax amount 5% vehicle price
        double salesTaxAmount = vehicle.getPrice() * 0.05;
        double recordingFee = 100.00;
        double processingFee = (vehicle.getPrice() < 10000) ? 295.00 : 495.00;
        System.out.println("Enter finance (yes/no): ");
        boolean finance = Boolean.parseBoolean(scanner.nextLine());


        String formattedSalesTaxAmount = String.format("%.2f", salesTaxAmount);
        String formattedRecordingFee = String.format("%.2f", recordingFee);
        String formattedProcessingFee = String.format("%.2f", processingFee);
        SalesContract salesContract = new SalesContract(contractOfDate, customerName, customerEmail, vehicle, Double.parseDouble(formattedSalesTaxAmount), Double.parseDouble(formattedRecordingFee),
                Double.parseDouble(formattedProcessingFee), finance);
        ContractFileManager.saveContract(salesContract);

        dealership.removeVehicle(vehicle);
        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);

        System.out.println("Sales contract created and saved.");
    }


    public void createLeaseContract(Vehicle vehicle) {
        System.out.println("Creating Lease Contract");
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String contractOfDate = currentDate.format(dateFormatter);

        System.out.println("Enter Customer name: ");
        scanner.nextLine();
        String customerName = scanner.nextLine().trim();


        System.out.println("Enter Customer email: ");
        String customerEmail = scanner.nextLine().trim();

        double expectedEndingValue = vehicle.getPrice() * 0.5;
        double leaseFee = vehicle.getPrice() * 0.07;
        String formattedExpectedEndingValue = String.format("%.2f", expectedEndingValue);
        String formattedLeaseFee = String.format("%.2f", leaseFee);

        LeaseContract leaseContract = new LeaseContract(contractOfDate,customerName,customerEmail, vehicle,Double.parseDouble(formattedExpectedEndingValue),Double.parseDouble(formattedLeaseFee));
                ContractFileManager.saveContract(leaseContract);

        dealership.removeVehicle(vehicle);
        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);

        System.out.println("lease contract created and saved.");
    }


}


