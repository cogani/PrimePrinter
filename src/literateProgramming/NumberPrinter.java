package literateProgramming;

/**
 * Created with IntelliJ IDEA.
 * User: nanopc
 * Date: 11/02/13
 * Time: 18:56
 * To change this template use File | Settings | File Templates.
 */
class NumberPrinter {
    private final int linesPerPages;
    private final int columns;
    private int[] numbers;
    private int numbersOfNumbers;

    public NumberPrinter(int linesPerPages, int columns, int[] numbers, int numbersOfNumbers) {
        this.linesPerPages = linesPerPages;
        this.columns = columns;
        this.numbers = numbers;
        this.numbersOfNumbers = numbersOfNumbers;
    }

    public void invoke() {
        int pagenumber = 1;
        int pageoffset = 1;
        while (pageoffset <= numbersOfNumbers) {
            System.out.println("The First " + numbersOfNumbers +
                    " Prime Numbers --- Page " + pagenumber);
            System.out.println("");
            for (int rowoffset = pageoffset; rowoffset < pageoffset + linesPerPages; rowoffset++) {
                for (int colum = 0; colum < columns; colum++)
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