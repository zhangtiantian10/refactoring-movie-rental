package cn.xpbootcamp.refactor;

import java.util.Vector;

public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();
    private int frequentRenterPoints = 0;
    private double totalAmount = 0d;

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.addElement(rental);
        this.frequentRenterPoints += rental.getFrequentRenterPoints();
        this.totalAmount += rental.getAmount();
    }

    public String getName() {
        return name;
    }

    String statement() {
        StringBuilder initStringBuilder = new StringBuilder("Rental Record for " + getName() + "：\n");

        StringBuilder result = this.rentals
            .stream()
            .reduce(initStringBuilder, (partialResult, current) -> {
                Movie movie = current.getMovie();
                double thisAmount =  current.getAmount();;

                return  partialResult.append("\t")
                        .append(movie.getTitle())
                        .append("\t")
                        .append(thisAmount).append("\n");
            }, StringBuilder::append);

        result.append("Amount owed is ").append(this.totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

}
