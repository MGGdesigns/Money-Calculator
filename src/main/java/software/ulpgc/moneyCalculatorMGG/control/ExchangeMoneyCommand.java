package software.ulpgc.moneyCalculatorMGG.control;

import software.ulpgc.moneyCalculatorMGG.interfaces.CurrencyDialog;
import software.ulpgc.moneyCalculatorMGG.interfaces.ExchangeRateLoader;
import software.ulpgc.moneyCalculatorMGG.interfaces.MoneyDialog;
import software.ulpgc.moneyCalculatorMGG.interfaces.MoneyDisplay;
import software.ulpgc.moneyCalculatorMGG.model.Currency;
import software.ulpgc.moneyCalculatorMGG.model.ExchangeRate;
import software.ulpgc.moneyCalculatorMGG.model.Money;

public class ExchangeMoneyCommand implements Command {
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    public ExchangeMoneyCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();

        ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currency);
        Money result = new Money((long) (money.amount()*exchangeRate.rate()), currency);

        moneyDisplay.show(result);
    }
}
