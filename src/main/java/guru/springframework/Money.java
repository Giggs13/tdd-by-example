package guru.springframework;

import lombok.ToString;

@ToString
public class Money implements Expression {

    protected final int amount;
    protected final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    String currency() {
        return currency;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(amount / bank.rate(currency, to), to);

    }

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Money money = (Money) object;

        return amount == money.amount
                && currency.equals(money.currency);
    }
}
