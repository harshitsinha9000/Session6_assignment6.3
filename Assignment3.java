package java_session6;

import java.util.Scanner;


class bank_task 
{

	synchronized void perform_task()
	{
		
		int choice,balance=0,amount=0,withdraw;
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Perform Withdraw 2.Perform Deposit");
		choice = sc.nextInt();
		
		switch(choice)
		{
		   
		  case 1:
			  if(balance<=0)
			  	{
				  	System.out.println("You can not withdraw the amount");
			  	}
			  else
			  	{
				  	System.out.println("Enter the amount to be withdrawn");
				  	sc.reset();
				  	withdraw = sc.nextInt();
				  	if(balance>=withdraw)
				  	{
					  balance-=withdraw;
					  System.out.println("Balance left = "+balance);
				  	}
			  	}
			  	break;
		  case 2:
			  		System.out.println("Enter the amount to be deposited");
			  		sc.reset();
			  		amount = sc.nextInt();
			  		
			  		balance+=amount;
			  		System.out.println("Balance amount = "+balance);
			  
		}
		
	}
}

class Thread_demo extends Thread
{
	bank_task obj;
	Thread_demo(bank_task obj)
	{
		this.obj=obj;
		
	}
	
	public void run()
	{
		obj.perform_task();
	}
	
}


public class Assignment3 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		bank_task b1 = new bank_task();      //single instance 
		
		
		Thread_demo th1 = new Thread_demo(b1);  
		Thread_demo th2 = new Thread_demo(b1);
		
		th1.start();
		th2.start();
		
		
	}

}
