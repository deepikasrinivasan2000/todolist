package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.*;

import com.mysql.cj.jdbc.Blob;

import dto.Task;
import dto.User;
@webServlet("")
public class Dao{
	
	public static Connection getConnection() throws  ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/database?user=root&password=root");
	}
	public static int saveUser(User user) throws ClassNotFoundException,SQLException{
		
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("?,?,?,?,?,?");
		pst.setInt(1,user());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getUseremail());
		pst.setLong(4,user.getUserContact());
		pst.setString(5,user.getUserpassword());
		
		Blob imageblob= new SerialBlob(user.getUserImage());
		pst.setBlob(6,imageBlob);
		int res=pst.executeUpdate();
		return pst.executeUpdate();		
	}
	public User findByEmail(String email) throws ClassNotFoundException,SQLException
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("select * from user where useremail=?");
		pst.setString(1, email);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			User u=new User();
			u.setUserid(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setUseremail(rs.getString(3));
			u.setUsercontact(rs.getLong(4));
			u.setUserpassword(rs.getString(5));
			//convert blob image to byte[]
			Blob imageBlob=rs.getBlob(6);
			byte[] image=imageBlob.getBytes(1,(int)imageBlob,length());
			
			u.setUserimage(image);
			return u;
			
		}
		else {
			return null;
		}
		public int createtetask(Task task) throws ClassNotFoundException,SQLException)
		{
			
		}
	}
	
	
	
	
	
	
	
	
	
	
}