/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Senarath
 */
public class signUpController {
    
    public void sign(String name, String userName, String email, String password){
        new Model.signUp().signData(name, userName, email, password);
    }
}
