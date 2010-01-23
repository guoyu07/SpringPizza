package com.springinaction.pizza.flow;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springinaction.pizza.domain.Customer;
import com.springinaction.pizza.service.CustomerNotFoundException;
import com.springinaction.pizza.service.CustomerService;

@Component
public class PizzaFlowActions {
  private static final Logger LOGGER = Logger.getLogger(PizzaFlowActions.class);
  
   public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException {     
      Customer customer = customerService.lookupCustomer(phoneNumber);
      if(customer != null) {        
        return customer;
      } else {
        throw new CustomerNotFoundException();
      }
   }
   
   public void addCustomer(Customer customer) {
      LOGGER.error("-----!!!--------->  " + customer.getName());
   }

   @Autowired
   CustomerService customerService;
}
