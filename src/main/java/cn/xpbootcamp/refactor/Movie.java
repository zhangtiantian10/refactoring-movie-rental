package cn.xpbootcamp.refactor;

public class Movie {

    static final int CAMPUS = 2;
    static final int HISTORY = 0;
    static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    int getPriceCode() {
        return priceCode;
    }

    String getTitle() {
        return title;
    }

    double getTotalPrice(int days) {
        double amount = 0d;
        switch (this.priceCode) {
            case HISTORY:
                amount += 2;
                if (days > 2)
                    amount += (days - 2) * 1.5;
                break;
            case NEW_RELEASE:
                amount += days * 3;
                break;
            case CAMPUS:
                amount += 1.5;
                if (days > 3)
                    amount += (days - 3) * 1.5;
                break;
        }

        return amount;
    }
}
