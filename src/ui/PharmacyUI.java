package ui;

import javax.swing.*;
import java.awt.*;

import panels.MedicinePanel;
import panels.BillPanel;
import panels.ButtonPanel;

import model.Medicine;
import service.PharmacyService;

public class PharmacyUI extends JFrame {

    private MedicinePanel medicinePanel;
    private BillPanel billPanel;
    private ButtonPanel buttonPanel;

    private PharmacyService pharmacyService;

    private double price = 20;

    public PharmacyUI() {

        setTitle("Pharmacy Management System");

        setSize(750, 500);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        // Create objects
        medicinePanel = new MedicinePanel();
        billPanel = new BillPanel();
        buttonPanel = new ButtonPanel();

        pharmacyService =
                new PharmacyService();

        // Title
        JLabel title =
                new JLabel(
                        "PHARMACY MANAGEMENT SYSTEM",
                        JLabel.CENTER
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        // Top
        add(title, BorderLayout.NORTH);

        // Center
        JPanel centerPanel = new JPanel(
                new GridLayout(1, 2, 10, 10)
        );

        centerPanel.add(medicinePanel);
        centerPanel.add(billPanel);

        add(centerPanel, BorderLayout.CENTER);

        // Bottom
        add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        buttonActions();

        setVisible(true);
    }

    private void buttonActions() {

        // Add button
        buttonPanel.getAddButton()
                .addActionListener(e -> {

                    String category =
                            medicinePanel.getCategory();

                    String name =
                            medicinePanel.getMedicine();

                    String dosage =
                            medicinePanel.getDosage();

                    int quantity =
                            medicinePanel.getQuantity();

                    Medicine medicine =
                            new Medicine(
                                    category,
                                    name,
                                    dosage,
                                    quantity,
                                    price
                            );

                    pharmacyService
                            .addMedicine(medicine);

                    billPanel.addMedicine(
                            name,
                            dosage,
                            quantity,
                            price
                    );
                });

        // Clear button
        buttonPanel.getClearButton()
                .addActionListener(e -> {

                    pharmacyService.clear();

                    billPanel.clearBill();
                });

        // Checkout button
        buttonPanel.getCheckoutButton()
                .addActionListener(e -> {

                    if (pharmacyService.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Cart is empty!"
                        );

                    } else {

                        double total =
                                pharmacyService
                                        .calculateTotal();

                        JOptionPane.showMessageDialog(
                                this,
                                "Checkout Successful!\n\n"
                                        + "Total: "
                                        + total
                                        + " BDT"
                        );

                        pharmacyService.clear();

                        billPanel.clearBill();
                    }
                });
    }
}