package guru.springframework;

public class Sum implements Expression {

    final Expression augmend;
    final Expression addmend;

    Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augmend.reduce(bank, to).amount + addmend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augmend.times(multiplier), addmend.times(multiplier));
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addmend);
    }
}
