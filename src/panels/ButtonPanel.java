package panels;

import javax.swing.*;

public class ButtonPanel extends JPanel {

    private JButton addButton;
    private JButton clearButton;
    private JButton checkoutButton;

    public ButtonPanel() {

        addButton = new JButton("Add to Cart");
        clearButton = new JButton("Clear");
        checkoutButton = new JButton("Checkout");

        add(addButton);
        add(clearButton);
        add(checkoutButton);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getCheckoutButton() {
        return checkoutButton;
    }
}