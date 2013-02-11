package literateProgramming;

public class PrimePrinter {
    private static final int numbersOfPrimes = 1000;
    private static final int linesPerPages = 50;
    private static final int columns = 4;

    public static void main(String[] args) {
        PrimeGenerator primePrinterHelper = new PrimeGenerator();
        NumberPrinter numberPrinter = new NumberPrinter(linesPerPages, columns);

        int primes[] = primePrinterHelper.generatePrimes(numbersOfPrimes);
        numberPrinter.print(primes, numbersOfPrimes);
    }
}