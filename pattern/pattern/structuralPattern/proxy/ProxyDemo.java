/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.structuralPattern.proxy;

/**
 *
 * @author Hung
 */
public class ProxyDemo {  
    public static void main(String[] args)   
    {  
        OfficeInternetAccess access 
                = new ProxyInternetAccess("Ashwani Rajput");  
        access.grantInternetAccess();  
    }  
}  