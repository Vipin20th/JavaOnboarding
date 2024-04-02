package oopsTask.Question4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeAppliances {

    private List<Appliance> appliances;

    public HomeAppliances() {
        appliances = new ArrayList<>();
    }

    // Add an appliance to the home
    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    // Calculate the total power consumption
    public int calculatePowerConsumption() {
        int totalConsumption = 0;
        for (Appliance appliance : appliances) {
            totalConsumption += appliance.getPowerConsumption();
        }
        return totalConsumption;
    }

    // Sort appliances by a chosen parameter
    public void sortAppliances(Comparator<Appliance> comparator) {
        Collections.sort(appliances, comparator);
    }

    public static void main(String[] args) {
        HomeAppliances home = new HomeAppliances();

        // Add appliances to the home
        home.addAppliance(new Appliance(ApplianceType.TV));
        home.addAppliance(new Appliance(ApplianceType.LIGHT));
        home.addAppliance(new Appliance(ApplianceType.FAN));
        home.addAppliance(new Appliance(ApplianceType.LAPTOP));

        // Calculate and display the total power consumption
        System.out.println("Total power consumption: " + home.calculatePowerConsumption() + " units");

        // Sort appliances by power consumption
        home.sortAppliances(new PowerConsumptionComparator());

        // Display appliances after sorting
        System.out.println("Sorted appliances by power consumption:");
        for (Appliance appliance : home.appliances) {
            System.out.println(appliance.getType() + " - " + appliance.getPowerConsumption() + " units");
        }
    }
}
