package edu.cs544.eafinal.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;

import edu.cs544.eafinal.domain.Transaction;
import edu.cs544.eafinal.domain.Users;
import edu.cs544.eafinal.service.OrderService;
import edu.cs544.eafinal.service.TransactionService;
import edu.cs544.eafinal.service.UserService;
import edu.cs544.eafinal.serviceImpl.DirectServiceImpl;
import edu.cs544.eafinal.serviceImpl.TransactionServiceImpl;
import edu.mum.security.AuthenticateUser;

public class Main {
	private static AuthenticateUser authenticateUser = new AuthenticateUser();
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");

		AuthenticationManager authenticationManager = (AuthenticationManager) ctx.getBean("authenticationManager");

		UserService userService = (UserService) ctx.getBean("userServiceImpl");

		System.out.println("Welcome to the Bank of Fairfield!!");

				
		try {
			authenticateUser.authenticate(authenticationManager);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		displayMainMenu(userService);
	}

	private static void displayMainMenu(UserService userService) throws IOException {
		TransactionService transactionService = new TransactionServiceImpl();
		int index = 1;
		System.out.println("Enter Menu \n 1. User Menu \n 2. Transaction Menu \n 3. LogOut");
		System.out.println();
		System.out.print("Enter your choice :   ");

		try {
			index = Integer.parseInt(br.readLine());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		try {
			switch (index) {

			case 1: {
				displayUserMenu(userService);
				break;
			}
			case 2: {
				displayTransactionMenu(userService, transactionService);
				break;
			}
			case 3: {
				authenticateUser.logout();
				System.out.println("Successfully logged out !!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				main(null);
				
				break;
			}
			default:
				System.out.println("Your entered a wrong choice !!");
				System.out.println("Please enter the appropiate choice !!");
			}
		} catch (AuthenticationCredentialsNotFoundException e) {
			System.out.println( );
			System.out.println( " ******** ANONYMOUS USER Attempted to access a secure resource *********"  );
			System.out.println( );
		}
	}

	private static void displayTransactionMenu(UserService userService, TransactionService transactionService) throws IOException {
		int index = 3;

		System.out.println("Please select the appropiate number" + "\n" + "1 \t To Add New Transaction" + "\n"
				+ "2 \t To View Transactions By AccountNumber" + "\n" + "3 \t To View All Transactions" + "\n"
				+ "4 \t To Update Transaction" + "\n" + "5 \t To Delete Transaction" + "\n6 \t Go Back");

		System.out.println();
		System.out.print("Enter your choice :   ");

		try {
			index = Integer.parseInt(br.readLine());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		try {
			switch (index) {

			case 1: {
				createNewTransaction(transactionService);
				displayTransactionMenu(userService, transactionService);
				break;
			}
			case 2: {
				viewTransaction(transactionService);
				displayTransactionMenu(userService, transactionService);

				break;
			}
			case 3: {
				viewAllTransactions(transactionService);
				displayTransactionMenu(userService, transactionService);

				break;
			}
			case 4: {
				System.out.println("You have selected to update Transaction !!");
				displayTransactionMenu(userService, transactionService);

				break;
			}
			case 5: {
				System.out.println("You have selected to delete Transaction!!");
				displayTransactionMenu(userService, transactionService);


				// This is to delete a user
//				Users deleteUser = new Users();
//				userService.deleteUser(3L);
				break;
			}
			case 6: {
				displayMainMenu(userService);
			}
			default:
				System.out.println("Your entered a wrong choice !!");
				System.out.println("Please enter the appropiate choice !!");
			}
		} catch (AuthenticationCredentialsNotFoundException e) {
			System.out.println( );
			System.out.println( " ******** ANONYMOUS USER Attempted to access a secure resource *********"  );
			System.out.println( );
		}
	}

	private static void displayUserMenu(UserService userService) throws IOException {
		int index = 3;
		System.out.println("Please select the appropiate number" + "\n" + "1 \t To Create New User" + "\n"
				+ "2 \t To View User By AccountNumber" + "\n" + "3 \t To View All Users" + "\n" + "4 \t To Update User"
				+ "\n" + "5 \t To Delete User" + "\n6 \t Go Back");

		System.out.println();
		System.out.print("Enter your choice :   ");

		try {
			index = Integer.parseInt(br.readLine());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		try {
			switch (index) {

			case 1: {
				createNewUser(br, userService);
				break;
			}
			case 2: {
				viewUser(userService);
				break;
			}
			case 3: {
				viewAllUsers(userService);
				break;
			}
			case 4: {
				System.out.println("You have selected to update User !!");
				break;
			}
			case 5: {
				deleteUser(userService);
				break;
			}
			case 6: {
				displayMainMenu(userService);
				break;
			}
			default:
				System.out.println("Your entered a wrong choice !!");
				System.out.println("Please enter the appropiate choice !!");
			}

		}
		catch (AuthenticationCredentialsNotFoundException e) {
			System.out.println( );
			System.out.println( " ******** ANONYMOUS USER Attempted to access a secure resource *********"  );
			System.out.println( );
		}

	}

	private static void deleteUser(UserService userService) throws IOException {
		try {
			System.out.println("You have selected to delete user!!");
			// This is to delete a user
//			Users deleteUser = new Users();
//			userService.deleteUser(3L);
			System.out.println( " ******** You have successfully deleted user *********"  );
		} catch (AccessDeniedException e) {
			System.out.println( " ******** You don't have permission to delete user *********"  );
		}
		displayUserMenu(userService);
	}

	private static void viewAllUsers(UserService userService) throws IOException {
		try {
			System.out.println("You have selected To View all Users!!");
			// Get all users:
			List<Users> users = userService.getAll();
			for (Users newUser : users) {
				System.out.println("User name : " + newUser.getFirstName());
			}
		} catch(AccessDeniedException e) {
			System.out.println( " ******** You don't have permission to view all users *********"  );
		}
		displayUserMenu(userService);

	}

	private static void viewAllTransactions(TransactionService transactionService) {
		System.out.println("You have selected To View all Users!!");
		// Get all users:
		List<Transaction> transactions = transactionService.getAll();
		for (Transaction newTransction : transactions) {
			System.out.println(
					"Transaction is : " + newTransction.getTransactionAmount() + "\t" + newTransction.getDate());
		}

	}

	private static void viewTransaction(TransactionService transactionService)  {
		System.out.println("You have selected To View Transaction By AccountNumber!!");
		Transaction transaction = transactionService.getTransaction(1L);
		System.out.println("Transaction is : " + transaction.getTransactionAmount() + "\t" + transaction.getDate());
	}

	private static void createNewTransaction(TransactionService transactionService) throws IOException {
		System.out.println("You have selected to create new Transaction!!");

		Transaction addTransaction = new Transaction();
		System.out.println("Enter Account Number : ");
		addTransaction.setAccountNumber(br.readLine());
		System.out.println("Enter Transaction Amount : ");
		addTransaction.setTransactionAmount(Integer.parseInt(br.readLine()));
		java.util.Date date = new java.util.Date();
		System.out.println("Date in date1 is : "+ date);
		addTransaction.setDate(date);
		Transaction addedTransaction = transactionService.addTransaction(addTransaction);
		System.out.println("New Transaction Added  : " + "Transaction Amount :" + addedTransaction.getTransactionAmount() + "\t"
				+ "Transaction ID : "+
				addedTransaction.getId());
		
	}

	private static void viewUser(UserService userService) throws IOException {
		System.out.println("You have selected To View User By AccountNumber!!");
		Users user = userService.getUser(1L);
		System.out.println("User name : " + user.getFirstName());
		
		displayUserMenu(userService);

	}

	private static void createNewUser(BufferedReader br, UserService userService) throws IOException  {

		try {
			System.out.println("You have selected to create new User!!");

			Users addUser = new Users();
			System.out.println("Enter First Name : ");
			addUser.setFirstName(br.readLine());
			System.out.println("Enter Last Name : ");
			addUser.setLastName(br.readLine());
			System.out.println("Enter Age : ");
			addUser.setAge(Integer.parseInt(br.readLine()));
			System.out.println("Enter Email  : ");
			addUser.setEmail(br.readLine());
			System.out.println("Enter Member Number : ");
			addUser.setMemberNumber(Integer.parseInt(br.readLine()));
			Users addedUser = userService.addUser(addUser);
			System.out
			.println("New User Added with name : " + addedUser.getFirstName() + " " + addedUser.getLastName());
			

			
			//this is for sending message as amqp
			ApplicationContext context = new GenericXmlApplicationContext(
					"classpath:META-INF/spring/order-app-context.xml");

			RabbitTemplate directTemplate = context.getBean("directTemplate", RabbitTemplate.class);
			OrderService directService = new DirectServiceImpl();
			directService.publish(directTemplate,addUser);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			
		
			/*//this is for sending message as amqp
			ApplicationContext context = new GenericXmlApplicationContext(
					"classpath:META-INF/spring/order-app-context.xml");

			RabbitTemplate directTemplate = context.getBean("directTemplate", RabbitTemplate.class);
			OrderService directService = new DirectServiceImpl();
			directService.publish(directTemplate);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

		
		
		} catch (AccessDeniedException e) {
			System.out.println( " ******** You don't have permission to create user *********"  );
		}

		displayUserMenu(userService);

	}

}
