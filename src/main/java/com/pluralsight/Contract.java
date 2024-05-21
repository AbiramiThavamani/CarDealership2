package com.pluralsight;

public abstract class Contract {

    protected String contractOFDate;
    protected String customerName;
    protected String customerEmail;
    protected double vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;

    public Contract(String contractDate, String customerName, String customerEmail, double vehicleSold, double totalPrice, double monthlyPayment) {
        this.contractOFDate = contractDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public String getContractDate() {
        return contractOFDate;
    }

    public void setContractDate(String contractDate) {
        this.contractOFDate = contractDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public double getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(double vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();



    public abstract double getMonthlyPayment();


}
