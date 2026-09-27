package panels;

import javax.swing.*;
import java.awt.*;

public class BillPanel extends JPanel {

    private JTextArea billArea;

    public BillPanel() {

        setLayout(new BorderLayout());

        billArea = new JTextArea();

        billArea.setEditable(false);
        billArea.setFont(
                new Font("Monospaced", Font.PLAIN, 14)
        );

        billArea.setText(
                "----------- BILL -----------\n" +
                        "Medicine        Qty    Price\n" +
                        "----------------------------\n"
        );

        JScrollPane scrollPane =
                new JScrollPane(billArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void addMedicine(
            String medicine,
            String dosage,
            int quantity,
            double price) {

        double total = quantity * price;

        billArea.append(
                medicine + " " +
                        dosage + "    " +
                        quantity + "      " +
                        total + " BDT\n"
        );
    }

    public void clearBill() {

        billArea.setText(
                "----------- BILL -----------\n" +
                        "Medicine        Qty    Price\n" +
                        "----------------------------\n"
        );
    }
}