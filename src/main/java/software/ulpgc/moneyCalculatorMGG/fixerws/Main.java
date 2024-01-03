package software.ulpgc.moneyCalculatorMGG.fixerws;

import software.ulpgc.moneyCalculatorMGG.model.Currency;
import software.ulpgc.moneyCalculatorMGG.interfaces.CurrencyLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CurrencyLoader currencyLoader = new FixerCurrencyLoader();
        List<Currency> currencies = currencyLoader.load();
        for (Currency currency : currencies) {
            System.out.println(currency);
        }
    }
}
