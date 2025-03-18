package reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Reservationsystemtest {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		System.out.println("welcome to online reservation system");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		String username=sc.nextLine();
		System.out.println("Enter password");
		String password=sc.nextLine();
		
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinereservation", "root", "root");
            PreparedStatement statement=conn.prepareStatement("select password from users where username=?");
           statement.setString(1, username);
           ResultSet set=statement.executeQuery();
           
           if(set.next()) {
        	   String finalpassword=set.getString("password");
        	   if(finalpassword.equals(password)) {
        		   
        		   System.out.println("Press 1 for book ticket");
        		   System.out.println("Press 2 for cancel ticket");
        		   System.out.println("Press 3 for check ticket");
        		   int choice=sc.nextInt();
        		   switch(choice) {
        		   case 1:{
        			   Bookingservice b1=new Bookingservice();
        			   b1.bookticket(); 
        			   Scanners scm=new Scanners();
        			   scm.getinput();
        			   break;
        		   }
        		   case 2:{
        			   Bookingservice b1=new Bookingservice();
        			   b1.deleteticket();
        			   Scanners scm=new Scanners();
        			   scm.getinput();
        			   break;
        			  
        			   
        		   }
        		   case 3:{
        			   Bookingservice b1=new Bookingservice();
        			   b1.getallticket();
        			   Scanners scm=new Scanners();
        			   scm.getinput();
        			   break;
        			   
        		   }
        			   
        		   
        		   }
        	   }
        	   
        	   else {
        		   System.out.println("please enter valid creadentials");
        	   }
           }
           else {
        	   System.out.println("please enter valid creadentials");
           }
           set.close();
           statement.close();
           conn.close();
            
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver Not Found!");
            e.printStackTrace();
        }

	}

}
