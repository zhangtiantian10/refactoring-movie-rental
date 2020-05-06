package cn.xpbootcamp.refactor;

import java.util.HashMap;
import java.util.Map;

public class Movie {

    static final int CAMPUS = 2;
    static final int HISTORY = 0;
    static final int NEW_RELEASE = 1;
    static Map<Integer, MovieFees> movieFeesMap =
       new HashMap<Integer, MovieFees>() {{
           put(CAMPUS, MovieFees.campus);
           put(HISTORY, MovieFees.history);
           put(NEW_RELEASE, MovieFees.newRelease);
       }};

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
        return movieFeesMap
                .get(this.priceCode)
                .getTotalPrice(days);
    }
}
