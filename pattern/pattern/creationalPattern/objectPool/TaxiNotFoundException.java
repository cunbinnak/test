/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.creationalPattern.objectPool;

/**
 *
 * @author Hung
 */
public class TaxiNotFoundException extends RuntimeException {
 
    private static final long serialVersionUID = -6670953536653728443L;
 
    public TaxiNotFoundException(String message) {
        System.out.println(message);
    }
}
