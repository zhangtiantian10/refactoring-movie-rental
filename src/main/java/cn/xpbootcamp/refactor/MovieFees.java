package cn.xpbootcamp.refactor;

public class MovieFees {
    static MovieFees campus = new MovieFees(1.5,3,1.5);
    static MovieFees history = new MovieFees(2,2,1.5);
    static MovieFees newRelease = new MovieFees(3,1,3);

    private double defaultPrice;
    private int limitDays;
    private double priceAfterLimitDay;


    public MovieFees(double defaultPrice, int limitDays, double priceAfterLimitDay) {
        this.defaultPrice = defaultPrice;
        this.limitDays = limitDays;
        this.priceAfterLimitDay = priceAfterLimitDay;
    }

    public double getTotalPrice(int daysRental) {
        double totalPrice = this.defaultPrice;
        if (daysRental > this.limitDays)
            totalPrice += (daysRental - this.limitDays) * this.priceAfterLimitDay;
        return totalPrice;
    }
}
