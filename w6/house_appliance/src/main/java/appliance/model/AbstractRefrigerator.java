package appliance.model;

public abstract class AbstractRefrigerator extends AbstractPowerConsumer implements Refrigerator {

    protected float targetTemperature = 8;
    private String name;


    public AbstractRefrigerator(String name, float initialTemperature) {
        this(name, initialTemperature, null);
    }

    public AbstractRefrigerator(String name, float targetTemperature, PowerSource powerSource) {
        this.name = name;
        this.targetTemperature = targetTemperature;
        this.powerSource = powerSource;
    }

    public AbstractRefrigerator(String name) {
        this.name = name;
    }

    public void colder() {
        if (targetTemperature > 0){
            targetTemperature -= 0.5;
        } else {
            System.err.println("Temperature too low");
        }

    }

    public void warmer() {
        if (targetTemperature < 20){
            targetTemperature += 0.5;
        } else {
            System.err.println("Temperature too high");
        }
    }

    public int getCurrentWatts() {
        return (15 * (int) (20 - targetTemperature));
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "targetTemperature=" + targetTemperature +
                        ", name='" + name + '\'';
    }
}
