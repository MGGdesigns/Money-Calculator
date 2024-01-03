package software.ulpgc.moneyCalculatorMGG.mocks;

import software.ulpgc.moneyCalculatorMGG.model.Currency;
import software.ulpgc.moneyCalculatorMGG.interfaces.CurrencyDialog;

import java.util.List;

public class MockCurrencyDialog implements CurrencyDialog {
    private List<Currency> currencies;

    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        this.currencies = currencies;
        return this;
    }

    @Override
    public Currency get() {
        return currencies.get(1);
    }
}
