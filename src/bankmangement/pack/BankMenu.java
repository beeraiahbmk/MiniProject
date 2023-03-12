package bankmangement.pack;

import java.util.Scanner;

public class BankMenu {
		
		static void mainMenu() {
			int choice = -1;
			Scanner sc=new Scanner(System.in);
			Bank bank=new Bank();
	        do{
	        	
	            System.out.println("-------------------------------------------------------------------------------");
	            System.out.println("\t\t\tBank Management System");
	            System.out.println("-------------------------------------------------------------------------------\n\n");
	            System.out.println("\t0. Select Bank");
	            System.out.println("\t1. Add Account");
	            System.out.println("\t2. Deposit");
	            System.out.println("\t3. Withdraw");
	            System.out.println("\t4. Display All Accounts");
	            System.out.println("\t5. Remove Account");
	            System.out.println("\t6. Search Account");
	            System.out.println("\t7. Transfer Money");
	            System.out.println("\t8. Exit");
	            System.out.println("\n\n\tEnter Your Choice : ");
	            choice = sc.nextInt();
	            System.out.println("--------------------------------------------------------------------------------");
	            switch(choice)
	            {
	            case 0:
	            	bank.selectBank();
	            	break;
	                case 1 : 
	               	 bank.addAccount();
	                break;
	                case 2 : 
	               	 bank.diposit();
	                break;
	                case 3 :
	               	 bank.withdraw();
	                break;
	                case 4 : 
	               	 bank.displayAllAccounts();
	                break;
	                case 5 : 
	               	 bank.removeAccount();
	                break;
	                case 6 : 
	               	 bank.searchAccount();
	                break;
	                case 7 : 
	               	 bank.transfer();
	                break;
	                case 8 : System.out.println("Are You Sure (y/n) : ");
	                         if(sc.nextLine().equalsIgnoreCase("y"))
	                            choice = -1;
	                break;
	                default : System.out.println("INVALID CHOICE !!!");
	                break;
	            }
	        } while(choice != -1);
	}
			
			
}


