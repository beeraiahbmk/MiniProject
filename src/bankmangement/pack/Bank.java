package bankmangement.pack;
import java.util.*;
import java.io.*;

public class Bank {
	Scanner sc=new Scanner(System.in);
	static Vector<Integer> v_Account = new Vector<Integer>();
    static Vector<String> v_Name = new Vector<String>();
    static Vector<Float> v_Balance = new Vector<Float>();
    static Vector<String> v_Bankname=new Vector<>();
    String bank;
    Random random=new Random();
    void selectBank() {
    	System.out.println("which bank u wnat a account");
		System.out.println("\t1 State bank of india");
		System.out.println("\t2 Bank of india");
		System.out.println("\t3 HDFC bak");
		System.out.println("Enter the option");
		int option=sc.nextInt();
		switch(option) {
		case 1:
			System.out.println("Cretaing account in State bank of india");
			bank="SBI";
			addAccount();
			break;
		case 2:
			System.out.println("Creating a bank accoutn in Bank of india");
			bank="BOI";
			addAccount();
			break;
		case 3:
			System.out.println("Creating account in HDFC bank");
			bank="HDFC";
			addAccount();
			break;
		}
    }
    
	void addAccount() {
		try {

//		System.out.println("Enter the account number");
//		int account_number=sc.nextInt();
		System.out.println("The account number is:");
		int account_number=random.nextInt(100000)+10000;
		System.out.println(account_number);
		if(v_Account.contains(account_number)) 
		{
			System.out.println("account already exists!");
		}
		else 
		{
			
			System.out.println("Enter the account holder name");
			String accountholder_name=sc.next();
			v_Account.add(account_number);
			v_Name.addElement(accountholder_name);
			v_Balance.add(0.0f);
			v_Bankname.add(bank);
			System.out.println("Account added successfully");
			display(v_Account.indexOf(account_number));
			
		}
		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
			
		}
		
	}
	static void display(int index) {
		System.out.println("Account Number : "+v_Account.elementAt(index));
        System.out.println("Account Holder Name : "+v_Name.elementAt(index));
        System.out.println("Available Balance : "+v_Balance.elementAt(index));
        System.out.println("Bank Name : "+v_Bankname.elementAt(index));
	}
	void diposit() {
		 int index=searchAccount();
	        if(index>=0)
	        {
	            try{
	                Float balance =v_Balance.elementAt(index);
	                System.out.println("\nEnter The Amount To Deposit : ");
	                int amount=sc.nextInt();
	                balance += amount;
	                v_Balance.set(index,new Float(balance));
	                System.out.println("\n\n Amount Deposited Successfully....");
	                System.out.println("\n\n Current Balance Is : Rs."+balance);
	            }catch(Exception e) {
	            	System.out.println(e.getMessage());
	            }
	        }
		 
	 }
	void withdraw() {
		int index=searchAccount();
        if(index>=0)
        {
            try{
                float balance = (float)(Float)v_Balance.elementAt(index);
                if(balance <= 0)
                {
                    System.out.println("Account Does Not Have Sufficient Balance !!!\nPlease Deposit Some Amount First...");
                }
                else
                {
                    System.out.println("\nEnter The Amount To Withdraw : ");
                    float amount=sc.nextFloat();
                    if(balance <= amount)
                    {
                        System.out.println("Insufficient Balance !!!");
                    }
                    else
                    {
                        balance -= amount;
                        v_Balance.set(index,new Float(balance));
                        System.out.println("\n\n Amount Withdrawn Successfully....");
                        System.out.println("\n\n Current Balance Is : Rs."+balance);
                    }
                }
            }
            catch(Exception e)
            {}
        }
		
		
	}
	void displayAllAccounts() {
		System.out.println("      Account No.       |       Account Holder Name       |       Balance");
        System.out.println("-------------------------------------------------------------------------------");
        if(v_Account.size()>0)
        {
            for(int i=0;i<v_Account.size();i++)
            {
                System.out.printf("      %-17d |       %-25s |       %.2f",v_Account.elementAt(i),v_Name.elementAt(i),v_Balance.elementAt(i));
                System.out.println();
            }
        }
        else
        {
            System.out.println("\n\n  No Accounts To Display !!!\n\n");
        }
		
		
	}
	void removeAccount() {
		int index=searchAccount();
        if(index > 0)
        {
            v_Account.removeElementAt(index);
            v_Name.removeElementAt(index);
            v_Balance.removeElementAt(index);
            System.out.println("\n\n Account Deleted Successfully....");
        }
        else if(v_Account.size() == 0)
        {
            System.out.println("Account Cannot Be Deleted As Only One Account Is Present In System...");
        }
		
		
	}
	int searchAccount() {
		 int account_number;
	        System.out.println("Enter The Account Number To Search : ");
	        try{
	            account_number=sc.nextInt();
	            if (v_Account.contains(account_number))
	            {
	                int index = v_Account.indexOf(account_number);
	                display(index);
	                return index;
	            }
	            else
	                System.out.println("Account Does Not Exists !!!");
	        }catch(Exception e)
	        {}
	        return -1;
		
	}
	void transfer() {
		try{
            System.out.println("Enter The Account Number Of Sender : ");
            int sno = sc.nextInt();
            if (v_Account.contains(new Integer(sno)))
            {
                float sbal = (float)(Float)v_Balance.elementAt(v_Account.indexOf(new Integer(sno)));
                if(sbal > 0)
                { 
                    System.out.println("Enter The Account Number Of Reciever : ");
                    int dno = sc.nextInt();
                    if (v_Account.contains(new Integer(dno)))
                    {
                        System.out.println("Enter The Amount To Be Transferred : ");
                        float amount = sc.nextFloat();
                        if(sbal <= amount)
                        {
                            System.out.println("Insufficient Balance !!!");
                        }
                        else
                        {
                            float dbal = (float)(Float)v_Balance.elementAt(v_Account.indexOf(new Integer(dno)));
                            sbal -= amount;
                            dbal += amount;
                            v_Balance.set(v_Account.indexOf(new Integer(sno)),new Float(sbal));
                            v_Balance.set(v_Account.indexOf(new Integer(dno)),new Float(dbal));
                            System.out.println("\n\n Amount Has Been Transferred From A/c No. : "+sno+" To A/c No. : "+dno+" Successfully....");
                        }
                    }
                    else
                    {
                        System.out.println("Account Does Not Exist !!!");
                    }
                }
                else
                {
                    System.out.println("Insufficient Balance !!!");
                }
            }
            else
            {
                System.out.println("Account Does not Exist !!!");
            }
        }
        catch(Exception e)
        {}
    }


}
