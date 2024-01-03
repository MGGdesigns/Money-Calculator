package software.ulpgc.moneyCalculatorMGG;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}
