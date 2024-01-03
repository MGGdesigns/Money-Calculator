package software.ulpgc.moneyCalculatorMGG.mocks;

import software.ulpgc.moneyCalculatorMGG.model.Currency;
import software.ulpgc.moneyCalculatorMGG.model.ExchangeRate;
import software.ulpgc.moneyCalculatorMGG.interfaces.ExchangeRateLoader;

import java.time.LocalDate;

public class MockExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return new ExchangeRate(from, to, LocalDate.now(), 1.218);
    }
}
