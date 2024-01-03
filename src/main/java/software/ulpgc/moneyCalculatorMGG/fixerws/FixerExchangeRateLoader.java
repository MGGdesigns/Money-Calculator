package software.ulpgc.moneyCalculatorMGG.fixerws;

import software.ulpgc.moneyCalculatorMGG.model.Currency;
import software.ulpgc.moneyCalculatorMGG.model.ExchangeRate;
import software.ulpgc.moneyCalculatorMGG.interfaces.ExchangeRateLoader;

public class FixerExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return null;
    }
}
