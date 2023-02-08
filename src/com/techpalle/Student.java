package com.techpalle;

import java.sql.*;
import java.util.ArrayList;

public class Student 
{
	private static Connection con=null;
	private static Statement s=null;
	private static PreparedStatement ps=null;
	
	private static final String driverPath="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/palle";
	private static final String userName="root";
	private static final String password="aryan";
	private static ResultSet rs=null;
	
	public static void creating() 
	{
		try 
		{
			Class.forName(driverPath);
			
			con=DriverManager.getConnection(url,userName,password);
			
			s=con.createStatement();
			
			s.executeUpdate("create table student(sno int primary key auto_increment, "
					+ "sname varchar(80) not null,sub varchar(80),email varchar(80) unique)");
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if (s!=null) 
				{
					s.close();
				}
				if (con!=null) 
				{
					con.close();
				} 
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static void inserting (String name,String sub,String mail)
	{
		try
		{
			Class.forName(driverPath);
			
			con=DriverManager.getConnection(url,userName,password);
			
			ps=con.prepareStatement("insert into student(sname,sub,email) values(?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, sub);
			ps.setString(3, mail);
			
			int row= ps.executeUpdate();
			System.out.println(row);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if (ps!=null) 
				{
					ps.close();
				}
				if (con!=null) 
				{
					con.close();
				} 
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static void update (int no, String sub,String mail) 
	{
		try 
		{
			Class.forName(driverPath);
			
			con=DriverManager.getConnection(url,userName,password);
			
			ps=con.prepareStatement("update student set sub=?,email=? where sno=?");
			ps.setString(1, sub);
			ps.setString(2, mail);
			ps.setInt(3, no);
			
			int row= ps.executeUpdate();
			System.out.println(row);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(ps!=null)
				{
					ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static void delete (int no)
	{
		try
		{
			Class.forName(driverPath);
			
			con=DriverManager.getConnection(url,userName,password);
			
			ps=con.prepareStatement("delete from student where sno=?");
			ps.setInt(1, no);
			
			int row= ps.executeUpdate();
			System.out.println(row);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if (ps!=null) 
				{
					ps.close();
				}
				if (con!=null) 
				{
					con.close();
				} 
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static void read() 
	{
		try 
		{
			Class.forName(driverPath);
			
			con=DriverManager.getConnection(url,userName,password);
			
			s= con.createStatement();
			
			String qry="select sname from student";
			rs= s.executeQuery(qry);
			ResultSetMetaData md= rs.getMetaData();
			
			System.out.println(md.getColumnName(1).toUpperCase()+":-");
			
			while (rs.next()) 
			{
				System.out.println(rs.getString("sname"));
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(s!=null)
				{
					s.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static ArrayList<Object> reading() 
	{
		ArrayList<Object> al=new ArrayList<Object>();
		
		try 
		{
			Class.forName(driverPath);
			
			con=DriverManager.getConnection(url,userName,password);
			
			s= con.createStatement();
			
			String qry="select * from student";
			rs= s.executeQuery(qry);
			
			while (rs.next()) 
			{
				al.add(rs.getInt("sno"));
				al.add(rs.getString("sname"));
				al.add(rs.getString("sub"));
				al.add(rs.getString("email"));
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(s!=null)
				{
					s.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return al;
	}
}
