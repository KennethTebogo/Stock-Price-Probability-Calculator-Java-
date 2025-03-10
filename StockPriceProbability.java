public class StockPriceProbability {

    // Function to compute the cumulative distribution function (CDF) for the standard normal distribution manually
    public static double normalCumulativeDistributionFunction(double x) {
        // Use the error function (erf) to compute the CDF
        return 0.5 * (1 + erf(x / Math.sqrt(2)));
    }

    // Function to calculate the error function (erf) manually
    public static double erf(double x) {
        // Approximation of the error function
        final double PI = Math.PI;
        double t = 1.0 / (1.0 + 0.5 * Math.abs(x));
        // Use a series expansion to calculate the error function
        double result = 1 - t * Math.exp(-x * x - 1.26551223 + 
                    t * (1.00002368 + t * (0.37409196 + t * (0.09678418 + 
                    t * (-0.18628806 + t * (0.27886807 + t * (-1.13520398 + 
                    t * (1.48851587 + t * (-0.82215223 + t * 0.17087277)))))))));
        return (x >= 0) ? result : -result;
    }

    // Function to calculate P(F(M) > F(0)) for lognormal stock price evolution
    public static double[] probabilityStockPriceIncrease(double mu, double sigma, double M) {
        if (M < 1) {
            throw new IllegalArgumentException("M must be at least 1 (weeks must be positive).");
        }

        // Compute the Z-score
        double zScore = Math.sqrt(M) * (mu / sigma);

        // Compute probability using the normal CDF
        double probability = normalCumulativeDistributionFunction(zScore);

        return new double[]{zScore, probability};
    }

    public static void main(String[] args) {
        // Example input values for μ (mean growth rate), σ (volatility), and M (number of weeks)
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.print("Enter the value of Mu μ: ");
        double mu = scanner.nextDouble();  // Mean growth rate

        System.out.print("Enter the value of Sigma σ: ");
        double sigma = scanner.nextDouble();  // Volatility

        System.out.print("Enter the number of Weeks: ");
        double M = scanner.nextDouble();  // Number of weeks
        
        // Calculate probability
        double[] result = probabilityStockPriceIncrease(mu, sigma, M);
        double zScore = result[0];
        double probability = result[1];

        // Display results
        System.out.printf("Z-score: %.6f%n", zScore);
        System.out.printf("Probability P(F(M) > F(0)): %.6f%n", probability);
    }
}

