package model;

public class Medicine {

    private String category;
    private String name;
    private String dosage;
    private int quantity;
    private double price;

    public Medicine(String category, String name,
                    String dosage, int quantity, double price) {

        this.category = category;
        this.name = name;
        this.dosage = dosage;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDosage() {
        return dosage;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }
}