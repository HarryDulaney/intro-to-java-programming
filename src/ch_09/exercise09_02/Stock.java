package ch_09.exercise09_02;

/**
 * 9.2 (The Stock class) Following the example of the Circle class in Section 9.2,
 * design a class named Stock that contains:
 * ■ A string data field named symbol for the stock’s symbol.
 * ■ A string data field named name for the stock’s name.
 * ■ A double data field named previousClosingPrice that stores the stock
 * price for the previous day.
 * ■ A double data field named currentPrice that stores the stock price for the
 * current time.
 * ■ A constructor that creates a stock with the specified symbol and name.
 * ■ A method named getChangePercent() that returns the percentage changed
 * from previousClosingPrice to currentPrice.
 * Draw the UML diagram for the class and then implement the class.
 * <p>
 * Write a test
 * program that creates a Stock object with the stock symbol ORCL, the name
 * Oracle Corporation, and the previous closing price of 34.5. Set a new current
 * price to 34.35 and display the price-change percentage.
 */
public class Stock {
    public String getSymbol() {
        return symbol;
    }

    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock() {
    }

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;

    }

    public double getChangePercent() {
        return (currentPrice - previousClosingPrice) / currentPrice;

    }

    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stock{}";
    }
}
