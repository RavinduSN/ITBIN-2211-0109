/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.loginDetails;

/**
 *
 * @author Senarath
 */
public class loginController {
    
    public boolean validateLogin(String userName, String password) {
        loginDetails details = new loginDetails();
        return details.check(userName, password);
    }
}
