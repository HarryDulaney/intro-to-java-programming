package ch_09.exercise09_02;

public class Exercise09_02 {
    public static void main(String[] args) {
        Stock testStock = new Stock("ORCL", "Oracle Corporation");
        testStock.setPreviousClosingPrice(34.5);
        testStock.setCurrentPrice(34.35);

        System.out.println("The price change for " + testStock.getSymbol() + " " +
                testStock.getName() + " is " + Math.round(testStock.getChangePercent() * 10000.00) / 100.00 + "%");


    }

}
