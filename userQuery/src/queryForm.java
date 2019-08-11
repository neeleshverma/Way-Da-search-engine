import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userQuery.queryParser;

/**
 * Servlet implementation class queryForm
 */
@WebServlet("/queryForm")
public class queryForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
	     String userQuery = request.getParameter("search-query").toLowerCase();
	     
	     queryParser qp = new queryParser();
	     String parsedQuery_and_title = qp.parse(userQuery, 3);
	     String parsedQuery_and_heading = qp.parse(userQuery, 4);
	     String parsedQuery_and_imp_words = qp.parse(userQuery, 5);
	     String parsedQuery_or_title = qp.parse(userQuery, 0);
	     String parsedQuery_or_heading = qp.parse(userQuery, 1);
	     String parsedQuery_or_imp_words = qp.parse(userQuery, 2);
	     
//	     System.out.println(parsedQuery_and_title);
//	     System.out.println(parsedQuery_and_heading);
//	     System.out.println(parsedQuery_and_imp_words);

	     out.println("<html><body bgcolor='#ABEBC6'>"); 
	     //out.println("Here it is");
	     out.println("<div align = 'right'> <a href = 'http://localhost:8080/userQuery/searchBox.html'>Go to Home </a> </div>");
//	     String userQuery = request.getParameter("search-query");
	     
//	     String databaseQuery = "select url, title from search_engine where title like '% ?' or title like '? %' or title like '% ? %' "  
//	    		 + "or heading like '% ?' or heading like '? %' or heading like '% ? %'"  ;
	     //out.println(databaseQuery);
	     try 
	     (
	    	Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5620/postgres", "neelesh", "");
	    	Statement stmt = conn.createStatement();
////	        PreparedStatement pStmt = conn.prepareStatement("select url, title from search_engine where title like '% ?' or title like '? %' or title like '% ? %' "  
//		    		 + "or heading like '% ?' or heading like '? %' or heading like '% ? %'");
	     )
	     {
//	    	 pStmt.setString(1, userQuery);
//	    	 pStmt.setString(2, userQuery);
//	    	 pStmt.setString(3, userQuery);
//	    	 pStmt.setString(4, userQuery);
//	    	 pStmt.setString(5, userQuery);
//	    	 pStmt.setString(6, userQuery);
//	    	 String query = "select url, title from search_engine where title like '% "+ userQuery + "' or title like '" + userQuery + " %' or title like '% "+ userQuery +  " %' "  
//		    		 + "or heading like '% " + userQuery + "' or heading like '" + userQuery + " %' or heading like '% "+ userQuery +" %'";
	    	 //out.println(query);
//	    	 ResultSet rset = pStmt.executeQuery();
	    	 List<Integer> list = new ArrayList<Integer>();
	    	 out.println("<ul style = 'list-style-type:disc'>");
	    	 
	    	 ResultSet rSet1 = stmt.executeQuery(parsedQuery_and_title);
	    	 
	    	 boolean resultFound = false;
	    	 while(rSet1.next())
	    	 {
//	    		 System.out.println("Executed 1");
	    		 resultFound = true;
	    		 int num = rSet1.getInt("id");
	    		 list.add(num);
	    		 String url = rSet1.getString("url");
	    		 String title = rSet1.getString("title");
	    		 out.println("<li> <a href = '" + url + "'>" +title + " </a> </li>");
	    		 out.println(url);
	    		 out.println("</br>");
	    		 out.println("</br>");
	    	 }
	    	 
	    	 ResultSet rSet2 = stmt.executeQuery(parsedQuery_and_heading);
	    	 while(rSet2.next())
	    	 {
//	    		 System.out.println("Executed 2");
	    		 resultFound = true;
	    		 int num = rSet2.getInt("id");
	    		 if(!list.contains(num))
	    		 {
		    		 list.add(num);
		    		 String url = rSet2.getString("url");
		    		 String title = rSet2.getString("title");
		    		 out.println("<li> <a href = '" + url + "'>" +title + " </a> </li>");
		    		 out.println(url);
		    		 out.println("</br>");
		    		 out.println("</br>");
	    		 }
	    	 }
	    	 
	    	 ResultSet rSet3 = stmt.executeQuery(parsedQuery_and_imp_words);
	    	 while(rSet3.next())
	    	 {
//	    		 System.out.println("Executed 3");
	    		 resultFound = true;
	    		 int num = rSet3.getInt("id");
	    		 if(!list.contains(num))
	    		 {
		    		 list.add(num);
		    		 String url = rSet3.getString("url");
		    		 String title = rSet3.getString("title");
		    		 out.println("<li> <a href = '" + url + "'>" +title + " </a> </li>");
		    		 out.println(url);
		    		 out.println("</br>");
		    		 out.println("</br>");
	    		 }
	    	 }
	    	 
	    	 ResultSet rSet4 = stmt.executeQuery(parsedQuery_or_title);
	    	 while(rSet4.next())
	    	 {
//	    		 System.out.println("Executed 4");
	    		 resultFound = true;
	    		 int num = rSet4.getInt("id");
	    		 if(!list.contains(num))
	    		 {
		    		 list.add(num);
		    		 String url = rSet4.getString("url");
		    		 String title = rSet4.getString("title");
		    		 out.println("<li> <a href = '" + url + "'>" +title + " </a> </li>");
		    		 out.println(url);
		    		 out.println("</br>");
		    		 out.println("</br>");
	    		 }
	    	 }
	    	 
	    	 ResultSet rSet5 = stmt.executeQuery(parsedQuery_or_heading);
	    	 while(rSet5.next())
	    	 {
//	    		 System.out.println("Executed 5");
	    		 resultFound = true;
	    		 int num = rSet5.getInt("id");
	    		 
	    		 if(!list.contains(num))
	    		 {
	    			 list.add(num);
	    			 String url = rSet5.getString("url");
		    		 String title = rSet5.getString("title");
	    			 out.println("<li> <a href = '" + url + "'>" +title + " </a> </li>");
		    		 out.println(url);
		    		 out.println("</br>");
		    		 out.println("</br>");
	    		 }
	    	 }
	    	 
	    	 ResultSet rSet6 = stmt.executeQuery(parsedQuery_or_imp_words);
	    	 while(rSet6.next())
	    	 {
//	    		 System.out.println("Executed 6");
	    		 resultFound = true;
	    		 int num = rSet6.getInt("id");
	    		 String url = rSet6.getString("url");
	    		 String title = rSet6.getString("title");
	    		 if(!list.contains(num))
	    		 {
	    			 out.println("<li> <a href = '" + url + "'>" +title + " </a> </li>");
		    		 out.println(url);
		    		 out.println("</br>");
		    		 out.println("</br>");
	    		 }
	    	 }
	    	 
	    	 out.println("</ul>");
	    	 
	    	 if(!resultFound)
	    	 {
	    		 out.println("Sorry! no results found. Please check for spelling errors and enter a valid query.");
	    	 }
	    	 out.println("</body></html>");
	     }
	     catch(Exception e)
	     {
             e.printStackTrace();
	     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
