package edu.cs544.eafinal.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.cs544.eafinal.domain.Users;


public interface OrderService {
    public void publish(RabbitTemplate rabbitTemplate, Users user);
}
