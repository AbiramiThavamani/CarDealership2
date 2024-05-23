package com.pluralsight;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

public class ContractFileManager {

    private String filename;

    public ContractFileManager(String filename){
        this.filename = filename;
    }


    public static void saveContract(Contract contract) {

        try
            (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contracts.csv",true))) {

            bufferedWriter.write(contract.getPersistence() + "\n");
            bufferedWriter.newLine();
            System.out.println("Contract saved successfully.");

        } catch (IOException e){
            e.printStackTrace();
            System.err.println("Error saving contract: ");
        }
    }


}

