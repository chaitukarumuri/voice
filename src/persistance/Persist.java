package persistance;

import java.io.InputStream;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import business.User;
import business.UserData;

public class Persist {
	
	public User getUserDetails(int id)
	{
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			System.out.println("fds1");
			con = DataConnection.getConnection();
			
			ps = con.prepareStatement("SELECT * FROM USERDETAILS WHERE ID=?");
		ps.setInt(1, id);
		System.out.println("after prepared");

			ResultSet rs = ps.executeQuery();
			User user=new User();
			if(rs.next())
			{
				user.setId(rs.getInt("ID"));
				user.setUserName(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setFirstName(rs.getString("FIRSTNAME"));
				user.setLastName(rs.getString("LASTNAME"));
				user.setEmailId(rs.getString("EMAILID"));
				user.setMobile(rs.getString("MOBILENUM"));
				user.setAddress(rs.getString("ADDRESS"));
				user.setCity(rs.getString("CITY"));
				user.setState(rs.getString("STATE"));
				user.setCountry(rs.getString("COUNTRY"));
				user.setPIN(rs.getInt("PIN"));
				user.setAlternateEmail(rs.getString("ALTERNATEEMAIL"));
				user.setSecurityQue(rs.getString("SECURITYQUES"));
				user.setSecuirtyAns(rs.getString("SECURITYANS"));
				return user;
			}else return null;
			
		} catch (SQLException ex) {
			System.out.println("isIdPresent error -->" + ex.getMessage());
			
		} finally {
			DataConnection.close(con);
		}
	
		return null;
		
	}
	
	
	
	public boolean isIdPresent(int id)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			System.out.println("fds1");
			con = DataConnection.getConnection();
			
			ps = con.prepareStatement("SELECT * FROM USERDETAILS WHERE ID=?");
		ps.setInt(1, id);
		System.out.println("after prepared");

			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return true;
				
			}
			
		} catch (SQLException ex) {
			System.out.println("isIdPresent error -->" + ex.getMessage());
			
		} finally {
			DataConnection.close(con);
		}
		return false;
		
	}
	
	public void changepass(int id,String pass)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataConnection.getConnection();
			ps = con.prepareStatement("UPDATE USERDETAILS SET PASSWORD=? WHERE ID=?");
			ps.setString(1, pass);
			ps.setInt(2, id);
			ps.executeUpdate();
			
			
			
		} catch (SQLException ex) {
			System.out.println("update pass -->" + ex.getMessage());
			System.out.println("error");
			ex.printStackTrace();
			
		} finally {
			DataConnection.close(con);
			
		}
		
	}
	
	
	
	public void sign(User user)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataConnection.getConnection();
			ps = con.prepareStatement("INSERT INTO USERDETAILS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAILID, MOBILENUM, ADDRESS, CITY, STATE, COUNTRY, PIN, ALTERNATEEMAIL, SECURITYQUES, SECURITYANS)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?)");
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setString(6, user.getEmailId());
			ps.setString(7, user.getMobile());
			ps.setString(8, user.getAddress());
			ps.setString(9, user.getCity());
			ps.setString(10, user.getState());
			ps.setString(11, user.getCountry());
			ps.setInt(12, user.getPIN());
			ps.setString(13, user.getAlternateEmail());
			ps.setString(14, user.getSecurityQue());
			ps.setString(15, user.getSecuirtyAns());
			ps.executeUpdate();
			
			
			
		} catch (SQLException ex) {
			System.out.println("sign error -->" + ex.getMessage());
			System.out.println("error");
			ex.printStackTrace();
			
		} finally {
			DataConnection.close(con);
			
		}
		
	}

	
	public List<UserData> getdata(int id)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataConnection.getConnection();
			ps = con.prepareStatement("Select * from userdata where ID=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			List<UserData> list = new ArrayList<UserData>();
			while(rs.next())
			{
				UserData userData=new UserData();
				userData.setId(rs.getInt("ID"));
				userData.setFilename(rs.getString("FILENAME"));
				Blob blob = rs.getBlob("FILE");
			    InputStream inputStream=blob.getBinaryStream();
			    
			    userData.setFile(new DefaultStreamedContent(inputStream, "image/jpg", userData.getFilename()));
				list.add(userData);
			}
			return list;
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			
		} finally {
			DataConnection.close(con);
		}
		
	
		
		
		
		return null;
		
	}
	
	public boolean uploadFile(int id,InputStream inputStream,String filename,long length)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataConnection.getConnection();
			ps = con.prepareStatement("INSERT INTO USERDETAILS (ID, FILENAME, IMG)VALUES (?, ?, ?)");
			
			ps.setInt(1, id);
			ps.setString(2, filename);
			ps.setBinaryStream(3, inputStream, (int) length);
			ps.executeUpdate();
			
			return true;
			
		} catch (SQLException ex) {
			System.out.println("sign error -->" + ex.getMessage());
			System.out.println("error");
			ex.printStackTrace();
			
		} finally {
			DataConnection.close(con);
			
		}
		
		return false;
		
	}
	
	
	
	
	public List<User> getusers()
	{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataConnection.getConnection();
			ps = con.prepareStatement("Select * from userdetails");
			

			ResultSet rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next())
			{
				User user=new User();
				user.setUserName(rs.getString("UserName"));
				list.add(user);
			}
			return list;
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			
		} finally {
			DataConnection.close(con);
		}
		
	
		return null;
		
	}
}
