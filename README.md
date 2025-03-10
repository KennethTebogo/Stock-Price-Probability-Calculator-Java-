# Stock Price Probability Calculator

This Java program calculates the probability that a stock price will be higher after **M** weeks, assuming a **lognormal price evolution**. The calculation is based on the mean growth rate (μ), volatility (σ), and the number of weeks (M).

## Features
- Computes the **Z-score** for stock price movement.
- Uses the **normal cumulative distribution function (CDF)** to calculate the probability manually (without external libraries).
- Accepts user input for **μ (mean growth rate)**, **σ (volatility)**, and **M (weeks).**
- Outputs the computed **Z-score** and probability.

## Requirements
- Java 8 or later
- Gradle (for building and running the project)

## Project Structure
```
stock-price-probability/
│
├── build.gradle
├── src/
│   └── main/
│       └── java/
│           └── StockPriceProbability.java
├── README.md
└── gradle/
    └── wrapper/
```

## Installation
Clone the repository and navigate to the project directory:

```
git clone https://github.com/KennethTebogo/stock-price-probability.git
cd stock-price-probability
```

## Build and Run
### Using Gradle
1. **Build the project:**
   ```
   ./gradlew build  # On macOS/Linux
   gradlew build    # On Windows
   ```
2. **Run the program:**
   ```
   ./gradlew run  # On macOS/Linux
   gradlew run    # On Windows
   ```

### Using Manual Compilation
Alternatively, you can compile and run the program manually:

```
javac src/main/java/StockPriceProbability.java
java -cp src/main/java StockPriceProbability
```

## Example Usage
```
Enter the value of Mu μ: 0.0165
Enter the value of Sigma σ: 0.073
Enter the number of Weeks: 2
Z-score: 0.238843
Probability P(F(M) > F(0)): 0.594428
```

## How It Works
- The program calculates the **Z-score** using:
  ```
  Z = sqrt(M) * (μ / σ)
  ```
- The **normal CDF** is computed manually using the error function approximation:
  ```
  Φ(x) = 0.5 * (1 + erf(x / sqrt(2)))
  ```

## License
This project is open-source and available under the [MIT License](LICENSE).

---

### Contributing
Feel free to fork the repository and submit pull requests with improvements or bug fixes!

### Author
[Kenneth Tebogo Khondowe](https://github.com/KennethTebogo)

