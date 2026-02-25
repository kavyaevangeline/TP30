package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class Create_Table {

	
	public void create(String Name, int Age) throws SQLException {
		
		Driver driver = new Driver();
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/","root","root");
		Statement state = con.createStatement();
		state.execute("show databases");
		state.execute("use tp_30");
		
	state.execute("create table project(name varchar(25) not null,age int(3) not null);");
	state.execute("insert into project values('"+Name+"',"+Age+")");
	
	ResultSet result = state.executeQuery("select * from project");
		while(result.next()) {
			
			String name= result.getString("Name");
			int age = result.getInt("Age");
			
			if(name.equals("Name") && age == Age) {
				
				System.out.println(name +"data stored successfully"+ age +"data stored sucessfully");
				break;
			}
			
		}
		
	}
		@Test
		public void execute() throws SQLException
		{
			Scanner scan= new Scanner(System.in);
			System.out.print("Enter Name here :");
			String name=scan.next();
			System.out.print("Enter Age here :");
			int age=scan.nextInt();
			create(name, age);
		}
		
	}
	

