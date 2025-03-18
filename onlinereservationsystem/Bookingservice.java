package reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Bookingservice {

	
	public static String generatenumber() {
		
		String number="";
		
		for(int i=1;i<=6;i++) {
			number+=(int)(Math.random()*10);
		}
		
		return number;
	}
	
		public void bookticket() throws Exception{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Train no");
			int trainno=sc.nextInt();
			
			
           Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinereservation", "root", "root");
            PreparedStatement statement=conn.prepareStatement("select trainname from traindetails where trainno=?");
            statement.setInt(1, trainno);
            ResultSet set=statement.executeQuery();
            if(set.next()) {
            	String trainname=set.getString("trainname");
            	System.out.println(trainname);
            	System.out.println("Enter Train class");
    			String trainclass=sc.next();
    			System.out.println("date of journey yyyy/MM/dd");
    			String date=sc.next();
    			System.out.println("from(source)");
    			String from=sc.next();
    			System.out.println("destination");
    			String destination=sc.next();
    			System.out.println("Passenger name");
    			String passengername=sc.next();
    			System.out.println("are you sure to book ticket y/n");
    			String bookticket=sc.next();
    			String Pnr =this.generatenumber();
    			System.out.println("Ticket Booked Sucessfully PNR is "+this.generatenumber());
    			
    			if(bookticket.equals("y")) {
    				PreparedStatement prepare=conn.prepareStatement("insert into bookticket(trainno,pnr,passengername,trainname,trainclass,date,froms,traindestination) values (?,?,?,?,?,?,?,?) ");
    				prepare.setInt(1, trainno);
    				prepare.setString(2, Pnr);
    				prepare.setString(3, passengername);
    				prepare.setString(4, trainname);
    				prepare.setString(5, trainclass);
    				prepare.setString(6, date);
    				prepare.setString(7, from);
    				prepare.setString(8, destination);
    				prepare.execute();
    				
    			}
    			else {
    				System.out.println("Thank you");
    			}
            }
            else {
            	System.out.println("please enter correct train number");
            }
            
           
            
		}
		
		 public void deleteticket() throws Exception {
         	
         	Scanner scanner =new Scanner(System.in);
         	System.out.println("Enter Pnr Number");
         	int pnr=scanner.nextInt();
         	 Class.forName("com.mysql.cj.jdbc.Driver");
              
              Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinereservation", "root", "root");
              PreparedStatement stmt= connection.prepareStatement("Select * from bookticket where pnr=?");
              stmt.setInt(1, pnr);
              ResultSet s=stmt.executeQuery();
             if(s.next()) {
            	 System.out.println(s.getInt(1)+" "+s.getString(2)+" "+s.getString(3)+" "+s.getString(4));
            	 System.out.println("are you sure cancel ticket y/n");
            	 String result=scanner.next();
            	 if(result.equals("y")) {
            		 PreparedStatement tmt= connection.prepareStatement("Delete from bookticket where pnr=?");
            		 tmt.setInt(1, pnr);
            		 tmt.execute();
            	   System.out.println("ticket cancel sucessfully");
            		 
            		 
            	 }
             }
             else {
            	 System.out.println("please enter correct pnr number");
             }
         	
         

}
		 public void getallticket() throws Exception{
				Class.forName("com.mysql.cj.jdbc.Driver");
		        
		        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinereservation", "root", "root");
		       Statement statement= connection.createStatement();
		       ResultSet s=statement.executeQuery("Select * from bookticket");
		       while(s.next()) {
		    	   System.out.println(s.getInt(1)+" "+s.getString(2)+" "+s.getString(3)+" "+s.getString(4));
		       }
			}
		 }
