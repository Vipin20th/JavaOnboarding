package oopsTask.Question4;

import java.util.Comparator;

public class PowerConsumptionComparator implements Comparator<Appliance> {

    @Override
    public int compare(Appliance a1, Appliance a2) {
        return Integer.compare(a1.getPowerConsumption(), a2.getPowerConsumption());
    }
}
