/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author seifu001
 */
public class AccountRepo {
    public static ArrayList getAccountTypes(){
    
              ArrayList accounts = new ArrayList();
              
                Connection conn=null;
                Statement stmt=null;
                ResultSet rs=null;
                try{
                     String url = "jdbc:mysql:...";
                  String user= "...;
                  String pwd="...";

                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(url,user,pwd);
                    stmt=conn.createStatement();
                    
                    String sql;
                    
                    sql="SELECT * from heroku_98dc3582d5c864d.account_type";
                     stmt.executeQuery(sql);
                     rs = stmt.getResultSet();
            
                 
                 
                    //read each resultset 
                    while(rs.next()){
                         
                        int id=rs.getInt("accID");
                        String type=rs.getString("accName");
                        String bal=rs.getString("accBalance");
                        
                        String loginID=Integer.toString(id);
                        String subID=loginID.substring(5,9);
                        int encryptID=Integer.parseInt(subID);
                      
                      accounts.add(new Account_Type(encryptID,type, bal));  
                      }
               
                   
                    
                    rs.close();
                    stmt.close();
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();

                }catch(Exception e){
                    e.printStackTrace();
                }finally{
              //finally block used to close resources
              try{
                 if(stmt!=null)
                    stmt.close();
              }catch(SQLException se2){
              }// nothing we can do
              try{
                 if(conn!=null)
                    conn.close();
              }catch(SQLException se){
                 se.printStackTrace();
              }//end finally try
           }//end try 
              
             
      return accounts; 
      }
    public static ArrayList getAccountActivity(){
    
              ArrayList activity = new ArrayList();
              
                Connection conn=null;
                Statement stmt=null;
                ResultSet rs=null;
                try{
                     String url = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_98dc3582d5c864d?reconnect=true";
                  String user= "b196540d943a8f";
                  String pwd="fbd4ea41";

                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(url,user,pwd);
                    stmt=conn.createStatement();
                    
                    String sql;
                    
                    sql="SELECT * from heroku_98dc3582d5c864d.activity";
                     stmt.executeQuery(sql);
                     rs = stmt.getResultSet();
            
                 
                 
                    //read each resultset 
                    while(rs.next()){
                         
                        String date=rs.getString("date");
                        String desc=rs.getString("description");
                        String type=rs.getString("type");
                        String status=rs.getString("status");
                        String amount=rs.getString("amount");
                        String balance=rs.getString("balance");
                       
                      activity.add(new Account_Activity(date,desc,type,status,amount,balance));  
                      }
               
                   
                    
                    rs.close();
                    stmt.close();
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();

                }catch(Exception e){
                    e.printStackTrace();
                }finally{
              //finally block used to close resources
              try{
                 if(stmt!=null)
                    stmt.close();
              }catch(SQLException se2){
              }// nothing we can do
              try{
                 if(conn!=null)
                    conn.close();
              }catch(SQLException se){
                 se.printStackTrace();
              }//end finally try
           }//end try 
              
             
      return activity; 
      }
}
