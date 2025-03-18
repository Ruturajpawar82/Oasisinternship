package reservation;

import java.util.Scanner;

public class Scanners {
	
	public void getinput() throws Exception {
		Scanner sc=new Scanner(System.in);
		 System.out.println("Press 1 for book ticket");
		   System.out.println("Press 2 for cancel ticket");
		   System.out.println("Press 3 for check ticket");
		   int choice=sc.nextInt();
		   switch(choice) {
		   case 1:{
			   Bookingservice b1=new Bookingservice();
			   b1.bookticket();  
			   break;
		   }
		   case 2:{
			   Bookingservice b1=new Bookingservice();
			   b1.deleteticket();
			   break;
		   }
		   case 3:{
			   Bookingservice b1=new Bookingservice();
			   b1.getallticket();
			   break;
			   
		   }
			   
		   
		   }
	}

}
