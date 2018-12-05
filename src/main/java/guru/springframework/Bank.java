package guru.springframework;

import java.util.HashMap;

class Bank {

    private final HashMap<Pair, Integer> rateMap = new HashMap<>();

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }

    int rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }
        return rateMap.get(new Pair(from, to));
    }

    void addRate(String from, String to, int rate) {
        rateMap.put(new Pair(from, to), rate);
    }
}
