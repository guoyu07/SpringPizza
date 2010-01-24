package com.springinaction.pizza.flow;

import static com.springinaction.pizza.domain.Topping.*;
import static java.util.Arrays.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springinaction.pizza.domain.Customer;
import com.springinaction.pizza.domain.Order;
import com.springinaction.pizza.domain.Pizza;
import com.springinaction.pizza.domain.Topping;
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
   
   public String addPizza(Order order) {
     System.out.println("!!!!!!H E Y !!!!!!");
     Pizza pizza = new Pizza();
     Topping[] toppings = new Topping[] {
             EXTRA_CHEESE,
             GREEN_PEPPER,
             PEPPERONI
     };
     pizza.setToppings(asList(toppings));
     order.addPizza(pizza);
     LOGGER.error("!!!!!!!!   :  " + order.getPizzas().size());
     
     return "successerino";
   }

   @Autowired
   CustomerService customerService;
}
