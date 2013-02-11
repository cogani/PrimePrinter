package literateProgramming;

class PrimePrinterHelper {
    private final int numbersOfPrimes = 1000;
    private final int linesPerPages = 50;
    private final int columns = 4;
    private final int ordmax = 30;
    private final int[] primes = new int[numbersOfPrimes + 1];
    private int pagenumber;
    private int pageoffset;
    private int rowoffset;
    private int colum;
    private int candidate;
    private int primeIndex;
    private boolean possiblyPrime;
    private int ord;
    private int square;
    private int n;
    private final int[] multiples = new int[ordmax + 1];

    int[] generatePrimes() {
        n = 0;
        candidate = 1;
        primeIndex = 1;
        primes[1] = 2;
        ord = 2;
        square = 9;


        while (primeIndex < numbersOfPrimes) {
            do {
                candidate = candidate + 2;
                if (candidate == square) {
                    ord = ord + 1;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candidate;
                }
                n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candidate)
                        multiples[n] = multiples[n] + primes[n] + primes[n];
                    if (multiples[n] == candidate)
                        possiblyPrime = false;
                    n = n + 1;
                }
            } while (!possiblyPrime);
            primeIndex = primeIndex + 1;
            primes[primeIndex] = candidate;
        }
        return primes;
    }

    public void printNumbers(int[] numbers, int numbersOfNumbers) {
        new NumberPrinter(numbers, numbersOfNumbers).invoke();
    }

    private class NumberPrinter {
        private int[] numbers;
        private int numbersOfNumbers;

        public NumberPrinter(int[] numbers, int numbersOfNumbers) {
            this.numbers = numbers;
            this.numbersOfNumbers = numbersOfNumbers;
        }

        public void invoke() {
            pagenumber = 1;
            pageoffset = 1;
            while (pageoffset <= numbersOfNumbers) {
                System.out.println("The First " + numbersOfNumbers +
                        " Prime Numbers --- Page " + pagenumber);
                System.out.println("");
                for (rowoffset = pageoffset; rowoffset < pageoffset + linesPerPages; rowoffset++) {
                    for (colum = 0; colum < columns; colum++)
                        if (rowoffset + colum * linesPerPages <= numbersOfNumbers)
                            System.out.format("%10d", numbers[rowoffset + colum * linesPerPages]);
                    System.out.println("");
                }
                System.out.println("\f");
                pagenumber = pagenumber + 1;
                pageoffset = pageoffset + linesPerPages * columns;
            }
        }
    }
}