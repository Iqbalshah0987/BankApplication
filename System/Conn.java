package System;
import java.sql.*;
public class Conn {
    Connection con;
    Statement s;
    String url="jdbc:mysql:///asm",     //'asm' is the database name...
           user="root",
           password="";
    public Conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");     //for driver loading...
            con=DriverManager.getConnection(url,user,password);   //for connection of driver with database...
            s=con.createStatement();  //for access to our database...
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}