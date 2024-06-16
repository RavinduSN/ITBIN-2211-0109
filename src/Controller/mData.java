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
public class mData {
    
    public void getData(String name,String brand,String price){
        
      new Model.addData().printData(name,brand,price);
    }
}
