/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Senarath
 */
public class addData {
    Connection con = null;
    PreparedStatement pst = null;
    
    public void printData(String name,String brand,String price){
        con = DBconnect.connect();
        
         try {
            String sql = "INSERT INTO instruments(IName,IBrand,IPrice) VALUES('"+name+"','"+brand+"','"+price+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Inserted!");
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
