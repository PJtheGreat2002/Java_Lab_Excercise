package Lab_6;

public class Question1 {

    static int includeResult = 0; 
    static int excludeResult = 0; 

    
    static int countCombinations(int[] coins, int n, int sum) {
        // If sum is 0, there is one solution (no coins needed)
        if (sum == 0) return 1;

        // If sum is negative or no coins left, no solution
        if (sum < 0 || n <= 0) return 0;

        
        return countCombinations(coins, n, sum - coins[n - 1]) + 
               countCombinations(coins, n - 1, sum);
    }

    static class IncludeLastRunnable implements Runnable {
        private int[] coins;
        private int n;
        private int sum;

        public IncludeLastRunnable(int[] coins, int n, int sum) {
            this.coins = coins;
            this.n = n;
            this.sum = sum;
        }

        @Override
        public void run() {
            includeResult = countCombinations(coins, n, sum - coins[n - 1]);
        }
    }

    // Runnable for excluding the last coin
    static class ExcludeLastRunnable implements Runnable 
    {
        private int[] coins;
        private int n;
        private int sum;

        public ExcludeLastRunnable(int[] coins, int n, int sum) 
        {
            this.coins = coins;
            this.n = n;
            this.sum = sum;
        }

        @Override
        public void run() {
            excludeResult = countCombinations(coins, n - 1, sum);
        }
    }

    // Function to count combinations using threads
    static int count(int[] coins, int sum) throws InterruptedException 
    {
        int n = coins.length;

        Thread includeLast = new Thread(new IncludeLastRunnable(coins, n, sum));
        Thread excludeLast = new Thread(new ExcludeLastRunnable(coins, n, sum));
        
        includeLast.start();
        excludeLast.start();
        
        includeLast.join();
        excludeLast.join();

        return includeResult + excludeResult;
    }

    public static void main(String[] args) throws InterruptedException 
    {
        int[] coins = {2,5,3,6};
        int sum = 10;

        int totalCombinations = count(coins, sum);
        System.out.println("Number of combinations: " + totalCombinations);
    }
}