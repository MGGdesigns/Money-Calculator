package software.ulpgc.moneyCalculatorMGG.model;

public record Money(long amount, Currency currency) {
    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
