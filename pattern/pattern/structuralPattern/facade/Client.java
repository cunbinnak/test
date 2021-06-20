/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.structuralPattern.facade;

/**
 *
 * @author Hung
 */
public class Client {
 
    public static void main(String[] args) {
        ShopFacade.getInstance().buyProductByCashWithFreeShipping("contact@gmail.com");
        ShopFacade.getInstance().buyProductByPaypalWithStandardShipping("contact@gmail.com", "0988999999");
    }
}
