package software.ulpgc.moneyCalculatorMGG.mocks;

import software.ulpgc.moneyCalculatorMGG.model.Currency;
import software.ulpgc.moneyCalculatorMGG.model.Money;
import software.ulpgc.moneyCalculatorMGG.interfaces.MoneyDialog;

import java.util.List;


public class MockMoneyDialog implements MoneyDialog {
    private List<Currency> currencies;

    @Override
    public MoneyDialog define(List<Currency> currencies) {
        this.currencies = currencies;
        return this;
    }

    @Override
    public Money get() {
        return new Money(200, currencies.get(0));
    }
}
