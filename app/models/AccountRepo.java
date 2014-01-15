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
                     String url = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_98dc3582d5c864d?reconnect=true";
                  String user= "b196540d943a8f";
                  String pwd="fbd4ea41";

                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(url,user,pwd);
                    stmt=conn.createStatement();
                    
                    String sql;
                    
                    sql="SELECT * from heroku_98dc3582d5c864d.account_type";
                     stmt.executeQuery(sql);
                     rs = stmt.getResultSet();
                     
                    //read each resultset 
                    while(rs.next()){
                         accounts.add(new Account_Type(rs.getInt("accID"),
                                                rs.getString("accName"),
                                                rs.getString("accBalance")));
                        
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
}
