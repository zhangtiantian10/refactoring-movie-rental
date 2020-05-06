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

    double getAmount() {
        return amount;
    }

    int getFrequentRenterPoints() {
        int additional = movie.getPriceCode() == Movie.NEW_RELEASE
                && this.daysRented > 1 ? 1 : 0;
        return 1 + additional;
    }
}
