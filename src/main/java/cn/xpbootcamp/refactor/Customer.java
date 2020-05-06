package cn.xpbootcamp.refactor;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    String statement() {
        double totalAmount = 0d;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "：\n");

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            //show figures for this rental
            //determine amounts for each line
            int daysRented = each.getDaysRented();
            double thisAmount = each.getMovie().getTotalPrice(daysRented);
            //add frequent renter points
            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
                frequentRenterPoints++;

            //show figures for this rental
            result.append("\t")
                  .append(each.getMovie().getTitle())
                  .append("\t")
                  .append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

}
