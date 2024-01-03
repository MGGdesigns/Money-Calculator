package software.ulpgc.moneyCalculatorMGG.swing;

import software.ulpgc.moneyCalculatorMGG.model.Money;
import software.ulpgc.moneyCalculatorMGG.interfaces.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    @Override
    public void show(Money money) {
        this.setText(money.toString());
    }
}
