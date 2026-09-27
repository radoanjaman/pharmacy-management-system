package service;

import model.Medicine;
import java.util.ArrayList;

public class PharmacyService {

    private ArrayList<Medicine> medicines;

    public PharmacyService() {
        medicines = new ArrayList<>();
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public double calculateTotal() {

        double total = 0;

        for (Medicine medicine : medicines) {
            total = total + medicine.getTotalPrice();
        }

        return total;
    }

    public void clear() {
        medicines.clear();
    }

    public boolean isEmpty() {
        return medicines.isEmpty();
    }
}