package software.ulpgc.moneyCalculatorMGG.interfaces;

import software.ulpgc.moneyCalculatorMGG.model.Currency;
import software.ulpgc.moneyCalculatorMGG.model.Money;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencies);
    Money get();
}
