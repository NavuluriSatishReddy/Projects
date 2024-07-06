package com.j2ee.app02.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserAction {
    Connection connection;
    public UserAction()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","1234");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public String checkLogin(String uname,String upwd)
    {
        String status="";
        try{
            PreparedStatement pst=connection.prepareStatement("select * from user_reg where UNAME=? and UPWD=?");
            pst.setString(1,uname);
            pst.setString(2,upwd);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                status="User Login Successful";
            }
            else {
                status="User Login Failure";
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public String registration(String uname,String upwd,String uemail,String umobile)
    {
        String status="";
        try{
            PreparedStatement pst=connection.prepareStatement("insert into user_reg values(?,?,?,?)");
            pst.setString(1,uname);
            pst.setString(2,upwd);
            pst.setString(3,uemail);
            pst.setString(4,umobile);
            int rowCount=pst.executeUpdate();
            if(rowCount==1)
            {
                status="User Registration Successful";
            }
            else {
                status="User Registration Failure";
            }

        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
}
