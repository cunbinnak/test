package pattern.creationalPattern.abstractFactory;

// calculate the loan payment for different banks
// like MB, ICICI, SBI etc. a real world example. 
import java.io.*; 
// Step 1: We are going to create 
//                       a Bank interface.
interface Bank { 
    String getBankName(); 
} 
// Step 2: Create concrete classes that will 
// implement the  Bank interface. 
class MB implements Bank { 
    private final String BNAME;

    public MB() {
        BNAME = "MB BANK";
    } 
    //  @override
    public String getBankName() {
        return BNAME; 
    } 
}

class ICICI implements Bank {

    private final String BNAME;

    public ICICI() {
        BNAME = "ICICI BANK";
    }

    //  @override
    public String getBankName() {
        return BNAME;

    }

} 
class SBI implements Bank {

    private final String BNAME;

    public SBI() {
        BNAME = "SBI BANK";
    }

    //  @override
    public String getBankName() {
        return BNAME;  
    }

}

// Step 3: Create a loan abstract class. 
abstract class Loan { 
    protected double rate; // ví dụ: 4 ==> tức là 4% 1 năm  
    abstract void getInterestRate(double rate);  
    public void calculateLoanPayment(double loanamount, int years) {
      /* Khoản trả hàng tháng (Equated Monthly Installment - EMI):  
         n=number of monthly installments;  
     */ 
        double EMI;  int n;   n = years * 12;
        rate = rate / 1200;
       EMI = ( (rate * Math.pow( (1 + rate), n) )  
               / ((Math.pow((1 + rate), n)) - 1)) * loanamount;
       System.out.println("your's monthly EMI is " + EMI 
             + " for the amount " + loanamount + " you have borrowed "); 
    } 
}// end of the Loan abstract class. 
// Step 4:Create concrete classes that will extends the  Loan abstract class. 
class HomeLoan extends Loan { 
    public void getInterestRate(double r) { 
        rate = r;   } 
}//End of the HomeLoan class. 
class BussinessLoan extends Loan { 
    public void getInterestRate(double r) { 
        rate = r; 
    }

}//End of the BusssinessLoan class.

class EducationLoan extends Loan { 
    public void getInterestRate(double r) { 
        rate = r; 
    }

}//End of the EducationLoan class.

// Step 5 
 //Create an abstract class (i.e AbstractFactory) 
// to get the factories for Bank and Loan Objects.
abstract class AbstractFactory { 
    public abstract Bank getBank(String bank); 
    public abstract Loan getLoan(String loan);

}//End of the AbstractFactory.

// Step 6 
 //Create Factory classes extending AbstractFactory 
// to generate object of concrete class based on given information.
class BankFactory extends AbstractFactory {
    @Override
    public Bank getBank(String bank) {
        if (bank == null) { return null;
        } 
        if (bank.equalsIgnoreCase("MB")) {
            return new MB();
        } else if (bank.equalsIgnoreCase("ICICI")) {
            return new ICICI();
        } else if (bank.equalsIgnoreCase("SBI")) {
            return new SBI();
        }
        return null;
    } 
   @Override
    public Loan getLoan(String loan) {
        return null;
    } 
}//End of the BankFactory class. 
class LoanFactory extends AbstractFactory {  
    public Bank getBank(String bank) {
        return null;
    } 
   //@Override
    public Loan getLoan(String loan) {
        if (loan == null) {  return null;
        } 
        if (loan.equalsIgnoreCase("Home")) {
            return new HomeLoan();
        } else if (loan.equalsIgnoreCase("Business")) {
            return new BussinessLoan();
        } else if (loan.equalsIgnoreCase("Education")) {
            return new EducationLoan();
        }
        return null;
    } 
}//End of the LoanFactory class.

// Step 7:Create a FactoryCreator class to get 
// the factories by passing an information such as Bank or Loan.
class FactoryCreator { 
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("Bank")) {
            return new BankFactory();
        } else if (choice.equalsIgnoreCase("Loan")) {
            return new LoanFactory();
        }
        return null;
    }
}//End of the FactoryCreator.

// Step 8; Use the FactoryCreator to get AbstractFactory 
// in order to get factories of concrete classes by passing an information such as type.
class AbstractFactoryPatternExample { 
    public static void main(String args[]) throws IOException {  
   
        String bankName = "MB";  
        String loanName = "Home";// Vay mua nhà
        double rate = 7; // 7% 1 năm
        double loanAmount = 10000000;//10 triệu
         int years =2;

        AbstractFactory bankFactory = FactoryCreator.getFactory("Bank"); 
        Bank b = bankFactory.getBank(bankName); //MB
   
        AbstractFactory loanFactory = FactoryCreator.getFactory("Loan"); 
        Loan l = loanFactory.getLoan(loanName);//Home 

        l.getInterestRate(rate);
        l.calculateLoanPayment(loanAmount, years); 
    } 
}//End of the  AbstractFactoryPatternExample 

