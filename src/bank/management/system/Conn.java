
package bank.management.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn()
    {
        try
        {
           c=DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","Dhara@29052002");
           s= c.createStatement();
        
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}