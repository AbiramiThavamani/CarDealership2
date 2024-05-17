package com.pluralsight;

public class SalesContract extends Contract{


    public SalesContract(String contractDate, String customerName, String customerEmail, double vehicleSold, double totalPrice, double monthlyPayment) {
        super(contractDate, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
