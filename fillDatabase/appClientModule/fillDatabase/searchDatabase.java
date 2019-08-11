package fillDatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.Scanner;

public class searchDatabase {
	public static void main(String[] args) throws Exception{
		 
		File file = new File("/home/neelesh/Desktop/crawlOutput.txt"); 
	
		Scanner sc = new Scanner(file);
//		while(sc.hasNextLine())
//		{
//			String data[] = sc.nextLine().split("----", 3);
//			System.out.println(data[1]);
//		}
		String query = "INSERT into search_engine(url, title, heading, imp_words) VALUES(?, ?, ?, ?)";
		try 
		(
		    Connection conn = DriverManager.getConnection(
		    		"jdbc:postgresql://localhost:5620/postgres", "neelesh", "");
		    PreparedStatement pstmt = conn.prepareStatement(query);
		)
		{
		
		    while(sc.hasNextLine())
		    {
		    	String data[] = sc.nextLine().split("----", 4);
		    	pstmt.setString(1, data[0]);
		    	pstmt.setString(2, data[1]);
		    	pstmt.setString(3, data[2]);
		    	pstmt.setString(4, data[3]);
		    	pstmt.executeUpdate();
		    }
		}
		catch (Exception sqle)
		{
			System.out.println("Exception : " + sqle);
		}
	}
}