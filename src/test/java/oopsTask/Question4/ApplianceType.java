package oopsTask.Question4;

public enum ApplianceType {

    FAN(1),
    LIGHT(2),
    TV(3),
    LAPTOP(4);

    private final int powerConsumption;

    ApplianceType(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }
}
