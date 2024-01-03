package software.ulpgc.moneyCalculatorMGG.interfaces;

import software.ulpgc.moneyCalculatorMGG.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}
