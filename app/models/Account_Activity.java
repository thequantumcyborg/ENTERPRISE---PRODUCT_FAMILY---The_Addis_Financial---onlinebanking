/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author seifu001
 */
public class Account_Activity {
    public String date;
    public String desc;
    public String type;
    public String status;
    public String amount;
    public String balance;
    
    public Account_Activity(String date, String desc, String type, String status, String amount, String balance){
        this.date=date;
        this.desc=desc;
        this.type=type;
        this.status=status;
        this.amount=amount;
        this.balance=balance;
    }
    public void setDate(String date){
        this.date=date;
    }
     public void setDesc(String desc){
        this.desc=desc;
    }
     public void setType(String type){
        this.type=type;
    }
     public void setStatus(String status){
        this.status=status;
    }
     public void setAmount(String amount){
        this.amount=amount;
    }
    public void setBalance(String balance){
        this.balance=balance;
    }
    
    public String getDate(){
        return this.date;
    }
    public String getDesc(){
        return this.desc;
    }
    public String getType(){
        return this.type;
    }
    public String getStatus(){
        return this.status;
    }
    public String getAmount(){
        return this.amount;
    }
    public String getBalance(){
        return this.balance;
    }
        
    
    
}
