package com.Register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class First
 */

@WebServlet("/fs")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String add = request.getParameter("add");
        String branch = request.getParameter("branch");
        int sem = Integer.parseInt(request.getParameter("sem"));
        
        Connection con = DbService.getConnection();
            PreparedStatement ps;
            try {
                ps = con.prepareStatement("insert into student values(?,?,?,?,?)");
            
            ps.setInt(1, id);
            ps.setString(2,name);
            ps.setString(3, add);
            ps.setString(4,branch);
            ps.setInt(5, sem);
            
            int i = ps.executeUpdate();
            
            if(i > 0) {
            
            	RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Success.html");
            	view.forward(request, response);
            
            } else {
            	response.getWriter().println("Failed");
            }
            
//            if(i>0) response.getWriter().println("Succesfull");
//            else response.getWriter().println("Failed");
            
            }catch(Exception e) {
            	System.out.println(e);
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
