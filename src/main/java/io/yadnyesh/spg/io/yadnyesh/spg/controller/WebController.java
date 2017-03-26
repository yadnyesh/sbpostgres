package io.yadnyesh.spg.io.yadnyesh.spg.controller;

import io.yadnyesh.spg.CustomerRepository;
import io.yadnyesh.spg.io.yadnyesh.spg.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z063407 on 3/26/17.
 */
@RestController
public class WebController {
    @Autowired
    CustomerRepository repository;

    @RequestMapping("/save")
    public String process(){
        repository.save(new Customer("Jack", "Smith"));
        repository.save(new Customer("Adam", "Johnson"));
        repository.save(new Customer("Kim", "Smith"));
        repository.save(new Customer("David", "Williams"));
        repository.save(new Customer("Peter", "Davis"));
        return "Done";
    }


    @RequestMapping("/findall")
    public @ResponseBody List<Customer> findAll(){
        List<Customer> customers = new ArrayList<>();

        for(Customer customer : repository.findAll()){
            customers.add(customer);
            customers.toArray();
        }
        return customers;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "<html>";

        for(Customer cust: repository.findByLastName(lastName)){
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }
}