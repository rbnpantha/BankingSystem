package edu.mum.amqp;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.mail.MessagingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.Customer;
import edu.mum.emailservice.EmailService;

//import edu.cs544.eafinal.domain.Customer;

public class DirectListener {

	public void listen(Customer customer) {
	
		
		String name = customer.getFirstName() + customer.getLastName();
		System.out.println("---------- New user Created and email sent to : " + name);
		
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml");
		   // String documentName = "AlarmClock.docx";
		    EmailService emailService = (EmailService) context.getBean("emailService");
		    try {
				emailService.sendMailToCustomer(name, customer.getEmail(), new Locale("en"));
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    System.out.println("                      The Email is on the WAY!!!");

		  }
		
		
		
		
		
	}

