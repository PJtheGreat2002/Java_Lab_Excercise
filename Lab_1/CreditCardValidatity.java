import java.util.*;
public class CreditCardValidatity {

    int valid;
    public int ccNumber;
    CreditCardValidatity(int credit)
    {
        ccNumber = credit;
    }

    public void validation(int CreditCardNo){
        int len = String.valueOf(CreditCardNo).length();
        if(len >= 8 && len <=9)
        {
            System.out.println("Valid Number");
            int lastdigit = CreditCardNo % 10;
            int remianingno = CreditCardNo / 10;
            int reversed = rev(remianingno); 

            System.out.println("Reversed Number"+reversed);

            //System.out.println("1st ok");

            int processno = stepc(reversed);

            System.out.println("Doubling odd digits: "+ processno);

            int len1 = String.valueOf(processno).length();
            int digitsum = 0;
            String numStr = Integer.toString(processno);
            for(int i = 0; i < len1; i++)
            {
                int digit = Character.getNumericValue(numStr.charAt(i));
                digitsum += digit;
            }
            System.out.println("digitsum"+digitsum);
            //System.out.println("2nd ok");

            String last = Integer.toString(digitsum);
            int len3 = last.length();
            int digit = Character.getNumericValue(last.charAt(len3 - 1));

            System.out.println("Digit"+ digit);
            int stepe = 10 - digit;


            //System.out.println("3rd ok");

            if(stepe == lastdigit)
                System.out.println("Credit Card is Valid");
            else
                System.out.println("Credit Card is not Valid");
        }
        else
            System.out.println("Invalid Credit Card Number");
        
    }
    public static int rev(int cno)
    {
        int reverse = 0;
        while(cno !=0)
        {
            int rem = cno % 10;
            reverse = reverse * 10 + rem;
            cno = cno/10;
        }
        return reverse;
    }
    public static int doubleAndSumDigits(int digit) {
        int doubled = digit * 2;
        if (doubled >= 10)
            return doubled / 10 + doubled % 10; 
        return doubled;
    }
    public static int stepc(int number) {
        String numStr = Integer.toString(number);
        int length = numStr.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
                    
            if ((i + 1) % 2 != 0)
            result.append(doubleAndSumDigits(digit));
            else
            result.append(digit);
        }
        Integer re = Integer.valueOf(result.toString());
        return re;
    }
    public static void main(String[] args) {
        System.out.println("Enter your credit card number: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        CreditCardValidatity obj = new CreditCardValidatity(input);
        obj.validation(input);
        sc.close();
    }
}
