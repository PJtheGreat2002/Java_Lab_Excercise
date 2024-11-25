import java.util.Scanner;
interface WaterConservationSystem
{
    public int calculateTrappedWater(int[] blockHeights);
}

abstract class RainySeasonConservation implements WaterConservationSystem
{
    // comment
}

class CityBlockConservation extends RainySeasonConservation
{
    public int calculateTrappedWater(int[] blockHeights)
    {
        if (blockHeights == null || blockHeights.length < 3) {
            System.out.println("Insufficient blocks to trap water.");
            return 0;
        }

        int n = blockHeights.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) 
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
            

        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) 
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
            

        int trappedWater = 0;
        for (int i = 0; i < n; i++) 
            trappedWater += Math.min(leftMax[i], rightMax[i]) - blockHeights[i];
            
        return trappedWater;
    }
}

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of array : ");
        int n = sc.nextInt();

        System.out.print("\nEnter array : ");
        int blockHeights[] = new int[n];

        for(int i = 0; i < blockHeights.length; i++)
        {
           // System.out.print("")
            blockHeights[i] = sc.nextInt();
        }

        CityBlockConservation A = new CityBlockConservation();
        int trappedWater = A.calculateTrappedWater(blockHeights);
        System.out.println("Total volume of trapped water: " + trappedWater + " units");
    }
}
