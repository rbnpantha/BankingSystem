package edu.cs544.eafinal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.cs544.eafinal.domain.Customer;
import edu.cs544.eafinal.domain.Users;
import edu.cs544.eafinal.service.OrderService;




public class DirectServiceImpl implements OrderService {
    public void publish(RabbitTemplate rabbitTemplate, Users user) {

    	System.out.println("Inside message publisher");
    	
        // Create customer...
        Customer customer = new Customer(user.getEmail(),user.getFirstName(),user.getLastName());
        rabbitTemplate.convertAndSend(customer);
         
    
 
 
    }
}
