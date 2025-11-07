package org.example.day15p13.Controller;


import org.example.day15p13.Api.ApiResonse;
import org.example.day15p13.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {


    //creating a database
    ArrayList <Customer> customers = new ArrayList<>();

    // print data base
    @GetMapping("/get")
    public ArrayList<Customer>  getCustomers(){
       return customers;
    }

    // adding customer to dataBase
    @PostMapping("/add")
    public ApiResonse addCustomer(@RequestBody Customer customer){
        customers.add(customer);
        return new ApiResonse("Costumer has been added Successfully");
    }

    //update customer info
    @PutMapping("/update/{index}")
    public ApiResonse updateCustomer(@PathVariable int index , @RequestBody Customer customer){
        customers.set(index, customer);
        return new ApiResonse( "Costumer information has been updated Successfully");
    }

    //delete customer info
    @DeleteMapping("/delete/{index}")
    public ApiResonse deleteCustomer(@PathVariable int index){
        customers.remove(index);
        return new ApiResonse("Costumer information has been deleted Successfully");
    }

    // withdraw from customer Balance
    @PutMapping("/withdraw/{index}/{balnceWithDrawed}")
    public ApiResonse withdrawCustomer(@PathVariable int index, @PathVariable double balnceWithDrawed){

        Customer customer = customers.get(index);

        if(customer.getCustomerBalance() < balnceWithDrawed){

            return new ApiResonse("Error the Customer does not have enough balance to wither draw from");
        }

        customer.setCustomerBalance(   customer.getCustomerBalance() - balnceWithDrawed  );

        return new ApiResonse("Costumer wither draw has been done Successfully ");
    }

    // deposit to customer Balance
    @PutMapping("/deposit/{index}/{balnceDeposit}")
    public ApiResonse depositCustomer(@PathVariable int index ,@PathVariable double  balnceDeposit){
        Customer customer = customers.get(index);
        customer.setCustomerBalance(   customer.getCustomerBalance() + balnceDeposit  );
        return new ApiResonse("Costumer deposit has been done Successfully");
    }

}
