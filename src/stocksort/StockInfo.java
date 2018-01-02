/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksort;

/**
 *
 * @author 348676487
 */
public class StockInfo implements Comparable {

    //Price
    Double price;
    //Date
    String date;
    //Dividend
    Double dividend;
    //Earnings
    Double earnings;
    //CPI
    Double CPI;
    //Interest Rate
    Double interestRate;
    //P/E Ratio
    Double peRatio;

    public StockInfo(Double price, String date, Double dividend, Double earnings, Double CPI, Double interestRate, Double peRatio) {
        this.price = price;
        this.date = date;
        this.dividend = dividend;
        this.earnings = earnings;
        this.CPI = CPI;
        this.interestRate = interestRate;
        this.peRatio = peRatio;
    }

    @Override
    public int compareTo(Object o) {
        //Cast the object to a stock
        StockInfo compare = (StockInfo) o;
        //Compare the date 
        return this.date.compareTo(compare.date);
    }

    @Override
    public String toString() {
        //Stock information delimited with commas
        return price + "," + date + "," + dividend + "," + earnings + "," + CPI + "," + interestRate + "," + peRatio;
    }
}
