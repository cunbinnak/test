/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.creationalPattern.builder; 
 //Builder
public interface OrderBuilder { 
    OrderBuilder orderType(OrderType orderType); 
    OrderBuilder orderBread(BreadType breadType); 
    OrderBuilder orderSauce(SauceType sauceType); 
    OrderBuilder orderVegetable(VegetableType vegetableType); 
    Order build();
 
}
