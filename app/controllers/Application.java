package controllers;


import play.*;
import play.mvc.*;

import java.util.*;

import models.*;



public class Application extends Controller {
  
    public static void index() {
        render();
    }
     // ${params.passcode} for main.html
    
          public static void signIn(String onlineID, String passcode) {
             boolean verify=true;
             login existing = new login(onlineID,passcode);
              verify=existing.check(existing.getOnlineID(),existing.getPassCode());
             if(verify)
               render("@Application.account");
             else{
               flash.error("Invalid onlineID/passcode. Try Again!");
                index();
             }
             
        }
        
   
   
}