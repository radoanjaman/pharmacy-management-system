package panels;

import javax.swing.*;
import java.awt.*;

public class MedicinePanel extends JPanel {

    private JComboBox<String> categoryBox;
    private JComboBox<String> medicineBox;
    private JComboBox<String> dosageBox;
    private JSpinner quantitySpinner;

    public MedicinePanel() {

        setLayout(new GridLayout(4, 2, 10, 10));

        // Category
        JLabel categoryLabel = new JLabel("Category:");

        String[] categories = {
                "Heart",
                "Lung",
                "Orthopedic",
                "General"
        };

        categoryBox = new JComboBox<>(categories);

        // Medicine
        JLabel medicineLabel = new JLabel("Medicine:");

        String[] medicines = {
                "Aspirin",
                "Paracetamol",
                "Amoxicillin",
                "Ibuprofen"
        };

        medicineBox = new JComboBox<>(medicines);

        // Dosage
        JLabel dosageLabel = new JLabel("Dosage:");

        String[] dosages = {
                "5 mg",
                "10 mg",
                "20 mg"
        };

        dosageBox = new JComboBox<>(dosages);

        // Quantity
        JLabel quantityLabel = new JLabel("Quantity:");

        quantitySpinner =
                new JSpinner(
                        new SpinnerNumberModel(
                                1, 1, 100, 1
                        )
                );

        // Add components
        add(categoryLabel);
        add(categoryBox);

        add(medicineLabel);
        add(medicineBox);

        add(dosageLabel);
        add(dosageBox);

        add(quantityLabel);
        add(quantitySpinner);
    }

    public String getCategory() {
        return categoryBox.getSelectedItem().toString();
    }

    public String getMedicine() {
        return medicineBox.getSelectedItem().toString();
    }

    public String getDosage() {
        return dosageBox.getSelectedItem().toString();
    }

    public int getQuantity() {
        return (Integer) quantitySpinner.getValue();
    }
}