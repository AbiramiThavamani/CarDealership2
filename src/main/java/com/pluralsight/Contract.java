package com.pluralsight;

public abstract class Contract {

    protected String contractOFDate;
    protected String customerName;
    protected String customerEmail;
    protected Vehicle vehicleSold;


    public Contract(String contractOFDate, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.contractOFDate = contractOFDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;


    }


    public String getContractOFDate() {
        return contractOFDate;
    }

    public void setContractOFDate(String contractOFDate) {
        this.contractOFDate = contractOFDate;
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

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();


    public abstract double getMonthlyPayment();

    public abstract String getPersistence();

}

