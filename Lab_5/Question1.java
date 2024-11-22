interface BankInterface 
{
    public void getBalance();
    public void getInterestRate();
}
class BankA implements BankInterface
{
    float deposit = 10000;
    float totalBalance = 0;
    public void getBalance()
    {
        System.out.println("Bank A Balance = "+ totalBalance);
    }
    public void getInterestRate()
    {
        float interestRate = 7.0f;
        System.out.println("\nBank A Amount Deposited = " + deposit);
        System.out.println("Bank A Interest rate = "+ interestRate + "%");
        totalBalance = deposit + ((deposit * interestRate)/100);
    }
}
class BankB implements BankInterface
{
    float deposit = 150000;
    float totalBalance = 0;
public void getBalance()
    {
        System.out.println("Bank B Balance = "+ totalBalance);
    }
    public void getInterestRate()
    {
        float interestRate = 7.4f;
        System.out.println("\nBank B Amount Deposited = " + deposit);
        System.out.println("Bank B Interest rate = "+ interestRate + "%");
        totalBalance = deposit + ((deposit * interestRate)/100);
    }
}
class BankC implements BankInterface
{
    float deposit = 200000;
    float totalBalance = 0;
    public void getBalance()
    {
        System.out.println("Bank C Balance = "+ totalBalance);
    }
    public void getInterestRate()
    {
        float interestRate = 7.9f;
        System.out.println("\nBank C Amount Deposited = " + deposit);
        System.out.println("Bank C Interest rate = "+ interestRate + "%");
        totalBalance = deposit + ((deposit * interestRate)/100);
    }
}
public class Question1 {
    public static void main(String[] args) {
        BankA A = new BankA();
        A.getInterestRate();
        A.getBalance();

        BankB B = new BankB();
        B.getInterestRate();
        B.getBalance();

        BankC C = new BankC();
        C.getInterestRate();
        C.getBalance();

    }
}
