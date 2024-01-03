package software.ulpgc.moneyCalculatorMGG.swing;

import software.ulpgc.moneyCalculatorMGG.control.Command;
import software.ulpgc.moneyCalculatorMGG.control.ExchangeMoneyCommand;
import software.ulpgc.moneyCalculatorMGG.fixerws.FixerCurrencyLoader;
import software.ulpgc.moneyCalculatorMGG.interfaces.CurrencyDialog;
import software.ulpgc.moneyCalculatorMGG.interfaces.MoneyDialog;
import software.ulpgc.moneyCalculatorMGG.interfaces.MoneyDisplay;
import software.ulpgc.moneyCalculatorMGG.mocks.MockExchangeRateLoader;
import software.ulpgc.moneyCalculatorMGG.model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwingMain extends JFrame {
    private final Map<String, Command> commands = new HashMap<>();
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;

    public static void main(String[] args) {
        SwingMain main = new SwingMain();
        List<Currency> currencies = new FixerCurrencyLoader().load();
        Command command = new ExchangeMoneyCommand(
                main.moneyDialog().define(currencies),
                main.currencyDialog().define(currencies),
                new MockExchangeRateLoader(),
                main.moneyDisplay());
        main.add("exchange money", command);
        main.setVisible(true);
    }

    public SwingMain() throws HeadlessException {
        this.setTitle("Money Calculator MGG");
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(240, 240, 240));

        mainPanel.add(createMoneyDialog(), BorderLayout.NORTH);
        mainPanel.add(createCurrencyDialog(), BorderLayout.WEST);
        mainPanel.add(createMoneyDisplay(), BorderLayout.CENTER);
        mainPanel.add(createResizedImageLabel(), BorderLayout.SOUTH);

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(toolbar(), BorderLayout.SOUTH);
    }

    private Component toolbar() {
        JButton button = new JButton("Calcular");
        button.setFont(new Font("Verdana", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(41, 128, 185));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.addActionListener(e -> commands.get("exchange money").execute());

        return button;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        display.setBorder(BorderFactory.createTitledBorder("Resultado de la conversión:"));
        display.setBackground(new Color(189, 195, 199));
        return display;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        dialog.setBorder(BorderFactory.createTitledBorder("Seleccione una moneda:"));
        dialog.setBackground(new Color(189, 195, 199));
        return dialog;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        dialog.setBorder(BorderFactory.createTitledBorder("Introduzca una cantidad:"));
        dialog.setBackground(new Color(189, 195, 199));
        return dialog;
    }

    private Component createResizedImageLabel() {
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/coin-banner-MGG.png"));
        Image originalImage = originalIcon.getImage();

        int width = 700;
        int height = 175;
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        return new JLabel(resizedIcon);
    }

    private void add(String name, Command command) {
        commands.put(name, command);
    }

    private MoneyDisplay moneyDisplay() {
        return moneyDisplay;
    }

    private CurrencyDialog currencyDialog() {
        return currencyDialog;
    }

    private MoneyDialog moneyDialog() {
        return moneyDialog;
    }
}
