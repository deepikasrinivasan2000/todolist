package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Dao;
import dto.User;


@WebServlet("/saveuser")
@MultipartConfig(maxFileSize = 10*1024*1024)
public class Saveuser extends  HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	// TODO Auto-generated method stub
		int userid=Integer.parseInt(req.getParameter("id"));
		String username=req.getParameter("name");
		String useremail=req.getParameter("email");
		long usercontact=Long.parseLong(req.getParameter("contact"));
		String userpassword=req.getParameter("password");
		
		Part imagePart=req.getPart("image");
		byte[] imagebytes=imagePart.getInputStream().readAllBytes();
		
		User user=new User(userid,username,useremail,usercontact,userpassword,imagebytes);
		Dao dao=new Dao();
		try {
			int res=dao.saveUser(user);
			if(res>0)
			{
				resp.sendRedirect("login.jsp");
			}
			else
			{
				resp.sendRedirect("signup.jsp");
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
}


