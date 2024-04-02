package oopsTask.Question4;

public class Appliance {

    private ApplianceType type;

    public Appliance(ApplianceType type) {
        this.type = type;
    }

    public int getPowerConsumption() {
        return type.getPowerConsumption();
    }

    public ApplianceType getType() {
        return type;
    }
}
