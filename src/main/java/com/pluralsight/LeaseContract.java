package com.pluralsight;

public class LeaseContract extends Contract{

    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String contractOFDate, String customerName, String customerEmail, Vehicle vehicleSold, double expectedEndingValue, double leaseFee) {
        super(contractOFDate, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return (getVehicleSold().getPrice() - expectedEndingValue) + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 36;
        double interestRate = 0.04 / 1200;
        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;
        return monthlyPayment;
    }

    @Override
    public String getPersistence() {
        StringBuilder builder = new StringBuilder();
        builder.append("Lease").append("|");
        builder.append(getContractOFDate()).append("|");
        builder.append(getCustomerName()).append("|");
        builder.append(getCustomerEmail()).append("|");
        builder.append(getVehicleSold().getVin()).append("|");
        builder.append(getVehicleSold().getYear()).append("|");
        builder.append(getVehicleSold().getMake()).append("|");
        builder.append(getVehicleSold().getModel()).append("|");
        builder.append(getVehicleSold().getColor()).append("|");
        builder.append(getVehicleSold().getVehicleType()).append("|");
        builder.append(getVehicleSold().getOdometer()).append("|");
        builder.append(getVehicleSold().getPrice()).append("|");
        builder.append(getExpectedEndingValue()).append("|");
        builder.append(getLeaseFee()).append("|");
        builder.append(getTotalPrice()).append("|");
        builder.append(getMonthlyPayment()).append("|");

        return builder.toString();
    }
}
