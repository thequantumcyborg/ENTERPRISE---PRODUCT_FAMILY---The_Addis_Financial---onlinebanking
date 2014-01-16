/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


/**
 *
 * @author seifu001
 */
public class Account_Type {
   public int accountNO;
   public String accountType;
   public String accountBalance;
   
   public Account_Type(){}
   public Account_Type(int accountNo,String accountType, String accountBalance){
       this.accountNO=accountNo;
       this.accountType=accountType;
       this.accountBalance=accountBalance;
   }
   public void setAccountNO(int accountNO){
       this.accountNO=accountNO;
   }
   public void setAccountType(String accountType){
       this.accountType=accountType;
   }
   public void setAccountBalance(String accountBalance){
       this.accountBalance=accountBalance;
   }
   
   public int getAccountNO(){
        return this.accountNO;
   }
   public String getAccountType(){
        return this.accountType;
   }
   public String getAccountBalance(){
        return this.accountBalance;
   }
   
   
   
  }


