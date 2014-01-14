/* 
 *  Online banking cloud app
 */

package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

/**
 *
 * @author kirubel s.
 */

public class Application extends Controller {
  
    /**
        render initial login page
        @param none
        @return void
     */
public static void index() {
        render();
    }
    
     /**
        create login object; pass and verify(in model) the object connecting 
        * to clearDB (heroku add on). if log in fails call index() method
        @param String
        @param String
        @return void
     */
public static void signIn(String onlineID, String passcode) {
        boolean verify=true;
        //creaat a login object sent to a constructor in model 
        login existing = new login(onlineID,passcode);
        
        //send to model(login.java) and connect to database
        verify=existing.check(existing.getOnlineID(),existing.getPassCode());
            
            //This boolean check allows/disallows routing to next page 
            if(verify)
               render("@Application.account");
             else{
               flash.error("Invalid onlineID/passcode. Try Again!");
                index();
             }
             
        }
        
   
   
}