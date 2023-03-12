package bankmangement.pack;

import java.util.HashMap;
import java.util.Scanner;

public class Login 
{
	Scanner sc=new Scanner(System.in);
	String username="Admin";
	String password="1234";
	String user;
	String pass;
//	HashMap<String,String> map=new HashMap<>();
	void accept() {
		try {
			System.out.println("Welcome to Bank Management System");
			System.out.println("enter the user name:");
			user=sc.next();
			System.out.println("enter the password:");
			pass=sc.next();
		}catch(Exception e) 
		{
			
		}
	}
	void check() 
	{
		for(int i=2;i>=0;i--) 
		{
		accept();
		if((username.compareTo(user))==0 && (password.compareToIgnoreCase(pass))==0) 
		{
			System.out.println("Login succesfully");
			BankMenu bankmenu=new BankMenu();
			bankmenu.mainMenu();
			
			
		}
		else 
		{
			System.out.println("Login unsuccessful");
			System.out.println("the enetred username or password is incoreect");
			if(i>0) 
			{
				System.out.println(" You Have "+i+" Chance(s) Remaining....\n Please Enter Valid Credentials & Try Logging In Again....\n");
			}
			else 
			{
				 System.out.println(" You Have Exhausted All Your Chances To Successfully Login Into The System !!!\n Please Restart The Program....");
			}
			
		}
	}
}

}
