package cn.xpbootcamp.refactor;

public class Rental {

    private Movie movie;
    private int daysRented;
    private double amount;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.amount = movie.getTotalPrice(daysRented);
    }

    Movie getMovie() {
        return movie;
    }

    int getDaysRented() {
        return daysRented;
    }

    double getAmount() {
        return amount;
    }
}
