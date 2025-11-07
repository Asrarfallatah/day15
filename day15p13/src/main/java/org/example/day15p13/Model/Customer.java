package org.example.day15p13.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private String customerID;
    private String customerUserName;
    private double customerBalance;

}
