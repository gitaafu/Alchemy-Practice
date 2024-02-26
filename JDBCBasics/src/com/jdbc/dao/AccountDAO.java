package com.jdbc.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {

	public static void main(String args[])
	{
		try{
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","test@1234");
			System.out.println(connection);
			Statement statement=connection.createStatement();
			int result=statement.executeUpdate("insert into account values(2,'vimal','vanishree',22000)");
			System.out.println(result+" rows got updated");
			//int result=statement.executeUpdate("update account set bal=5000 where accno=1");
			//System.out.println(result+" rows got updated");
			//int result=statement.executeUpdate("delete from account where accno=1");
			//System.out.println(result+" rows got updated");
			
			
			ResultSet rs=statement.executeQuery("select * from account");
			while(rs.next())
			{
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		
	}
}
