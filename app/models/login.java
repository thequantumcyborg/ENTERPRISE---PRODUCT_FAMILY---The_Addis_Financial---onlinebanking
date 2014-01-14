/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import play.data.validation.*;
import java.util.*;
import play.db.DB;


/**
 *
 * @author seifu001
 */
public class login {
    @Required public String onlineID;
    @Required public String passcode;
    
    public login(){}
    public login(String onlineID,String passcode){
        this.onlineID=onlineID;
        this.passcode=passcode;
    }
    
    public void setOnlineID(String onlineID){
        this.onlineID=onlineID;
    }
    public String getOnlineID(){
        return this.onlineID;
    }
    
    public void setPassCode(String passcode){
        this.passcode=passcode;
    }
    public String getPassCode(){
        return this.passcode;
    }
   
    public boolean check(String onlineID,String passcode){
     
                boolean verify=false;
                Connection conn=null;
                Statement stmt=null;
                ResultSet rs=null;
                try{
                    //postgres url
                   //  String url = "jdbc:postgresql://ec2-54-221-206-165.compute-1.amazonaws.com:5432/d7uvtdoem30m6m?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory"; 
                  
                  String url = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_98dc3582d5c864d?reconnect=true";
                  String user= "b196540d943a8f";
                  String pwd="fbd4ea41";

                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(url,user,pwd);
                    stmt=conn.createStatement();
                    
                    String sql;
                    //sql="SELECT Cust_ID,password from corebanking.customer";
                     sql="SELECT userID,password from heroku_98dc3582d5c864d.employee";
                     stmt.executeQuery(sql);
                     rs = stmt.getResultSet();
                    while(rs.next()){
                         int uID=rs.getInt("userID");
                         //String ssn=rs.getString("SSN");
                         String pas=rs.getString("password");
                         String loginID=Integer.toString(uID);
                           
                         if (onlineID.equals(loginID) && passcode.equals(pas)){
                             verify=true; 
                         }
                        
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
       return verify;
    }
    
    
}
