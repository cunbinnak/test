package pattern.structuralPattern.adapter;
/**
 *
 * @author Hung
 */
//This is the client class.  
public class AdapterDemo {  
 public static void main(String args[]){  
  CreditCard targetInterface=new BankCustomer();  
  targetInterface.giveBankDetails();  
  System.out.print(targetInterface.getCreditCard());  
 }   
}//End of the BankCustomer class.  