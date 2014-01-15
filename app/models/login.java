/*
 * Construct and accesor methods for log in object.
 * Also, used for clearDB cloud database connection
 * note: import play.db.DB isnt used but spared for future jpa test (which provides less mysql legging)
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
 * @author kirubel s.
 */
public class login {
    // validator
    @Required public String onlineID;
    @Required public String passcode;
    
    //constructor, though java automatically creates one
    public login(){}
    
    /**constructor of each login attempt, helpful for multiple user access
        @param String
        @param String
        @return none
        */
    public login(String onlineID,String passcode){
        this.onlineID=onlineID;
        this.passcode=passcode;
    }
    
    /** setter
        @param String
        @return none
        */
    public void setOnlineID(String onlineID){
        this.onlineID=onlineID;
    }
    
    /** getter
        @param String
        @return String
        */
    public String getOnlineID(){
        return this.onlineID;
    }
    
    /** setter
        @param String
        @return none
        */
    public void setPassCode(String passcode){
        this.passcode=passcode;
    }
    
    /** getter
        @param String
        @return String
        */
    public String getPassCode(){
        return this.passcode;
    }
   /** recieves constructed login object from controller
    * returns true/false if designated user object exists or not
        @param String
        @param String
        @return boolean
        */
    public boolean check(String onlineID,String passcode){
     
                boolean verify=false;
                Connection conn=null;
                Statement stmt=null;
                ResultSet rs=null;
                try{
                    //fpr postgres url
                   //  String url = "jdbc:postgresql://ec2-54-221-206-165.compute-1.amazonaws.com:5432/d7uvtdoem30m6m?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory"; 
                  
                  String url = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_98dc3582d5c864d?reconnect=true";
                  String user= "b196540d943a8f";
                  String pwd="fbd4ea41";

                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(url,user,pwd);
                    stmt=conn.createStatement();
                    
                    String sql;
                    
                    //a postgres database query
                    //sql="SELECT Cust_ID,password from corebanking.customer";
                     sql="SELECT userID,password from heroku_98dc3582d5c864d.employee";
                     stmt.executeQuery(sql);
                     rs = stmt.getResultSet();
                     
                    //read each resultset 
                    while(rs.next()){
                         int uID=rs.getInt("userID");                       
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
