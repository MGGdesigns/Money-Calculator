package software.ulpgc.moneyCalculatorMGG.mocks;

import software.ulpgc.moneyCalculatorMGG.control.Command;
import software.ulpgc.moneyCalculatorMGG.control.ExchangeMoneyCommand;
import software.ulpgc.moneyCalculatorMGG.interfaces.CurrencyDialog;
import software.ulpgc.moneyCalculatorMGG.interfaces.ExchangeRateLoader;
import software.ulpgc.moneyCalculatorMGG.interfaces.MoneyDialog;
import software.ulpgc.moneyCalculatorMGG.interfaces.MoneyDisplay;
import software.ulpgc.moneyCalculatorMGG.model.Currency;

import java.util.List;

public class MockMain {
    public static void main(String[] args) {
        List<Currency> currencies = new MockCurrencyLoader().load();
        MoneyDialog moneyDialog = new MockMoneyDialog().define(currencies);
        CurrencyDialog currencyDialog = new MockCurrencyDialog().define(currencies);
        MoneyDisplay moneyDisplay = new MockMoneyDisplay();
        ExchangeRateLoader exchangeRateLoader = new MockExchangeRateLoader();
        Command command = new ExchangeMoneyCommand(moneyDialog, currencyDialog, exchangeRateLoader, moneyDisplay);
        command.execute();
    }
}
