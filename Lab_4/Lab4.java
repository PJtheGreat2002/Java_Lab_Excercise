import java.util.*;
abstract class Robber
{
    public void RobbingClass()
    {
        System.out.println("MSc AI & ML");
    }
    public void MachineLearning()
    {
        System.out.println("I love Machine Learning"); 
    }
    abstract int RowHouses(int n,int money[]);
    abstract int RoundHouses(int n,int money[]);
    abstract int SquareHouse(int n,int money[]);
    abstract int MultiHouseBuilding(int money[][]);
}
class JavaProfessionalRobber extends Robber
{
    public int RowHouses(int n,int money[])
    {
        
        if (money == null || money.length == 0) 
            return 0; // No houses to rob

        if (money.length == 1) 
            return money[0]; // Only one house to rob
            
        int prev1 = 0; // Max money robbed up to the previous house
        int prev2 = 0; // Max money robbed up to the house before the previous house

        for(int i = 0; i < money.length; i++)
        {
            int current = Math.max(prev1, prev2 + money[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;

    }
    public int RoundHouses(int n,int money[])
    {
        if (money == null || money.length == 0) {
            return 0; // No houses to rob
        }
        if (money.length == 1) {
            return money[0]; // Only one house to rob
        }
        // Calculate the maximum money in two scenarios
        int robFirstToSecondLast = rob(money, 0, money.length - 2);
        int robSecondToLast = rob(money, 1, money.length - 1);

        // Return the maximum of the two scenarios
        return Math.max(robFirstToSecondLast, robSecondToLast);
    }

    private int rob(int[] money, int start, int end) {
        int prev1 = 0; // Max money robbed up to the previous house
        int prev2 = 0; // Max money robbed up to the house before the previous house

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + money[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1; // The maximum money robbed in this range
    }

    
    public int SquareHouse(int n,int money[])
    {
        if (money == null || money.length == 0) 
            return 0; // No houses to rob

        if (money.length == 1) 
            return money[0]; // Only one house to rob
            
        int prev1 = 0; // Max money robbed up to the previous house
        int prev2 = 0; // Max money robbed up to the house before the previous house

        for(int i = 0; i < money.length; i++)
        {
            int current = Math.max(prev1, prev2 + money[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;

    }
    public int MultiHouseBuilding(int money[][])
    {
    
        int odd = 0;
        int even = 0;

        for (int i = 0; i < money.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < money[i].length; j++) {
                    even += money[i][j];
                }
            } else {
                for (int j = 0; j < money[i].length; j++) {
                    odd += money[i][j];
                }
            }
        }
        return Math.max(odd,even);
    }

}
public class Lab4 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        JavaProfessionalRobber obj  = new JavaProfessionalRobber();

        obj.RobbingClass();
        obj.MachineLearning();
        
        // Row House
        System.out.println("\nRow House"); 
        System.out.println("Enter the no. of elements for row house : ");
        int n1 = sc.nextInt();
        
        int houses[] = new int[n1];
        System.out.println("Enter the elements for row house : ");
        for(int i = 0; i < n1; i++)
            houses[i] = sc.nextInt();
        
        System.out.println("Maximum money robbed: " + obj.RowHouses(n1, houses));

        // Round House
        System.out.println("\nRound House"); 
        System.out.println("Enter the no. of elements for round house : ");
        int n2 = sc.nextInt();
        int roundhouses[] = new int[n2];
        System.out.println("Enter the elements for round house : ");
        for(int i = 0; i < n2; i++)
            roundhouses[i] = sc.nextInt();
        
        System.out.println("Maximum money robbed: " + obj.RoundHouses(n2, roundhouses));

        // Square House
        System.out.println("\nSquare House");  
        System.out.println("Enter the no. of elements for Square house : ");
        int n3 = sc.nextInt();
        
        int sqhouse[] = new int[n3];
        System.out.println("Enter the elements for Square house : ");
        for(int i = 0; i < n3; i++)
            sqhouse[i] = sc.nextInt();
        
        System.out.println("Maximum money robbed: " + obj.SquareHouse(n3, sqhouse));
        
        // MultiHouse Building
        System.out.println("\nMultiHouse Building"); 
        System.out.println("Enter the no. of houses : ");
        int n4 = sc.nextInt();
        System.out.println("Enter the no. of elements in each houses : ");
        int n5 = sc.nextInt();
        
        int multihouses[][] = new int[n4][n5];
        
        for(int i = 0; i < n4; i++)
        {
            System.out.println("Enter the elements for house " + (i+1) + " : ");
            for(int j = 0; j < n5; j++)
                multihouses[i][j] = sc.nextInt();
            
        }
        
        System.out.println("Maximum money robbed: " + obj.MultiHouseBuilding(multihouses));

        sc.close();
    }
}
