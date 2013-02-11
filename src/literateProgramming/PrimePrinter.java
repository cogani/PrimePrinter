package literateProgramming;

public class PrimePrinter {
    private static final int numbersOfPrimes = 1000;
    private static final int linesPerPages = 50;
    private static final int columns = 4;

    public static void main(String[] args) {
        PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();
        int primes[] = primePrinterHelper.generatePrimes();
        new NumberPrinter(linesPerPages, columns).print(primes, numbersOfPrimes);
    }
}