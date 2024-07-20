/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dhara
 */
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.*;


public class C {

    public static void main(String[] args) {
        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Product", "root", "Dhara@29052002");
            System.out.print("Database Connection");

//            //String sql = "insert into Producttable(Product_id,ProductName,ProductPrice,ProductBrand) values(300,'Buiscuit',10,'Parle')";
//            String sqlupdate = "update Producttable set ProductPrice =30 where ProductName ='Pasta' ";

            Statement st = con.createStatement();
            Scanner sc = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Please Enter Your Choice ");
            System.out.println("Enter 1 : For Insert ");
            System.out.println("Enter 2 : For Update ");
            System.out.println("Enter 3 : For Delete ");
            System.out.println("Enter 4 : For Select ");

            int c = sc.nextInt();
            switch(c){
                case 1 : {System.out.println("Enter Prouct id :  ");
                int pid=sc.nextInt();
                System.out.println("Enter Prouct Name :  ");
                String pname=sc.next();
                System.out.println("Enter Price : ");
                int price = sc.nextInt();
                System.out.println("Enter Brand : ");
                String brand = sc.next();
                
                
               String sql = "insert into Producttable values('"+pid+"','"+pname+"','"+price+"','"+brand+"')";
               int x = st.executeUpdate(sql);
               break;
                }
                case 2 : {
                    
                    System.out.println("Please Enter 1 : To Update Product Price ");
                    System.out.println("Please Enter 2 : To Update Product Brand ");
                    int choice = sc.nextInt();
                    switch(choice){
                        case 1 : System.out.println("Please Enter the Product ID and Product Price: ");
                        int id = sc.nextInt();
                        float price = sc.nextFloat();
                        String update = "update Producttable set ProductPrice= '"+price+"'where Product_id ='"+id+"'";
                        int y= st.executeUpdate(update);
                        
                        case 2 : System.out.println("Please Enter the Product ID and Product Brand: ");
                        int idd = sc.nextInt();
                        String brand = sc.next();
                        String updatebrand = "update Producttable set ProductBrand= '"+brand+"'where Product_id ='"+idd+"'";
                        int z= st.executeUpdate(updatebrand);
                    }
                    break;
                }
                case 3 : {
                    System.out.println("Please Enter the Product ID for the deletion of that row : ");
                    int iddd= sc.nextInt();
                    String delete = "delete from Producttable where Product_id = '"+iddd+"'";
                     int d = st.executeUpdate(delete);
                }
                case 4 : {
                    String select = "select * from Producttable";
                    Statement str = con.createStatement();
                    ResultSet rs = str.executeQuery(select);
                    
                    while(rs.next()){
                    
                    System.out.println("Product ID : "+rs.getInt("Product_id"));
                    System.out.println("Product Name : "+rs.getString("ProductName"));
                    System.out.println("Product price : "+rs.getFloat("ProductPrice"));
                    System.out.println("Product Brand : "+rs.getString("ProductBrand"));
                    System.out.println("-------------------------------------------------------------------------");
                    }
                break;
                }
               
                

            }

            

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
