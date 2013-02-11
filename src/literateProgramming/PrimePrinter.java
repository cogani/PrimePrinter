package literateProgramming;

public class PrimePrinter {
    private static final int numbersOfPrimes = 1000;

    public static void main(String[] args) {
        PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();
        int primes[] = primePrinterHelper.generatePrimes();
        primePrinterHelper.printNumbers(primes, numbersOfPrimes);
    }
}