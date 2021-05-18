package model;

public class SimpleRefrigerator extends AbstractRefrigerator{

    public SimpleRefrigerator (String name) {
        super(name);
    }

    public float targetTemperature;

    public SimpleRefrigerator(String name, float targetTemperature) {
        super(name, targetTemperature);
    }

    public SimpleRefrigerator(String name, float targetTemperature, PowerSource powerSource) {
        super(name, targetTemperature, powerSource);
    }

    public String toString() {
        return "SimpleRefrigerator{ " + super.toString() + " }";
    }

    @Override
    public int getMaxWatts() {
        return (15*20);
    }
}
