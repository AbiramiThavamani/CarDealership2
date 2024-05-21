package com.pluralsight;

public class SalesContract extends Contract{

    private double salesTaxAmount;
    private double recordingFees;
    private double processingFees;
    private boolean finance;


    public SalesContract(String contractOFDate, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment, double salesTaxAmount, double recordingFees, double processingFees, boolean finance) {
        super(contractOFDate, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFees = recordingFees;
        this.processingFees = processingFees;
        this.finance = finance;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFees() {
        return recordingFees;
    }

    public void setRecordingFees(double recordingFees) {
        this.recordingFees = recordingFees;
    }

    public double getProcessingFees() {
        return processingFees;
    }

    public void setProcessingFees(double processingFees) {
        this.processingFees = processingFees;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    @Override
    public double getTotalPrice() {
       double vehiclePrice = getVehicleSold().getPrice();
       double totalPrice = vehiclePrice + getSalesTaxAmount() + recordingFees + processingFees;
       return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (finance) {
            if (getVehicleSold().getPrice() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }

    @Override
    public String getPersistence() {
        StringBuilder builder = new StringBuilder();
        builder.append("SALE").append("|");
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
        builder.append(getSalesTaxAmount()).append("|");
        builder.append(getRecordingFees()).append("|");
        builder.append(getProcessingFees()).append("|");
        builder.append(getTotalPrice()).append("|");
        builder.append(isFinance() ? "Yes" : "No").append("|");
        builder.append(getMonthlyPayment()).append("|");


        return builder.toString();
    }


}
