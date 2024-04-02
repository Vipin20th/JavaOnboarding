package designPatterns.fifthTask;

public class Bicycle {

    private final boolean hasGears;
    private final boolean hasDoubleStand;
    private final boolean hasDoubleSeats;
    private final boolean hasCarrier;

    private Bicycle(Builder builder) {
        this.hasGears = builder.hasGears;
        this.hasDoubleStand = builder.hasDoubleStand;
        this.hasDoubleSeats = builder.hasDoubleSeats;
        this.hasCarrier = builder.hasCarrier;
    }

    public static class Builder {
        private boolean hasGears = false;
        private boolean hasDoubleStand = false;
        private boolean hasDoubleSeats = false;
        private boolean hasCarrier = false;

        public Builder addGears() {
            this.hasGears = true;
            return this;
        }

        public Builder addDoubleStand() {
            this.hasDoubleStand = true;
            return this;
        }

        public Builder addDoubleSeats() {
            this.hasDoubleSeats = true;
            return this;
        }

        public Builder addCarrier() {
            this.hasCarrier = true;
            return this;
        }

        public Bicycle build() {
            return new Bicycle(this);
        }
    }

    // Getters for attributes
    public boolean hasGears() {
        return hasGears;
    }

    public boolean hasDoubleStand() {
        return hasDoubleStand;
    }

    public boolean hasDoubleSeats() {
        return hasDoubleSeats;
    }

    public boolean hasCarrier() {
        return hasCarrier;
    }
}
