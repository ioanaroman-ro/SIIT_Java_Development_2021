package appliance.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SimpleHouse implements House {

    private List<Appliance> appliances = new ArrayList<>();

    private final List<PowerSource> powerSources;

    public SimpleHouse(List<PowerSource> powerSources) {
        this.powerSources = Collections.unmodifiableList(powerSources);
    }

    public List<Appliance> getAppliances() {
        return Collections.unmodifiableList(appliances);
    }

    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    public Collection<PowerSource> getPowerSources() {
        return powerSources;
    }

    public int getLoadInWatts(PowerSource powerSource) {
        int sumOfConsumers = 0;
        for (Appliance appliance : appliances) {
            if (appliance instanceof PowerConsumer) {
                PowerConsumer powerConsumer1 = (PowerConsumer) appliance;
                if (powerSource.equals(powerConsumer1.getPowerSource())) {
                    sumOfConsumers += powerConsumer1.getCurrentWatts();
                }
            }
        }
        return sumOfConsumers;
    }


    public void switchOnAllLights() {
        for (Appliance appliance : appliances) {
            if (appliance instanceof Light) {
                Light light = (Light) appliance;
                if (!light.isOn()) {
                    light.on();
                }
            }
        }

    }

    public void switchOffAllLights() {
        for (Appliance appliance : appliances) {
            if (appliance instanceof Light) {
                Light light = (Light) appliance;
                if (light.isOn()) {
                    light.off();
                }
            }
        }
    }

    public void switchAllToGrid() {
        for (Appliance appliance : appliances) {
            if (appliance instanceof PowerConsumer) {
                PowerConsumer powerConsumer1 = (PowerConsumer) appliance;
                PowerSource grid = findPowerSourceByName("Grid");
                if (!powerConsumer1.getPowerSource().equals(grid)) {
                    powerConsumer1.setPowerSource(grid);
                }
            }
        }
    }

    public PowerSource findPowerSourceByName(String name) {
        PowerSource p = null;
        for (PowerSource powerSource : powerSources) {
            if (powerSource.getName().equals(name)) {
                p = powerSource;
            }
        }
        return p;
    }

    public void switchOffGrid() {
        for (Appliance appliance : appliances) {
            if (appliance instanceof PowerConsumer) {
                PowerConsumer powerConsumer1 = (PowerConsumer) appliance;
                PowerSource grid = findPowerSourceByName("Grid");
                PowerSource solar = findPowerSourceByName("Solar");
                PowerSource battery = findPowerSourceByName("Battery");
                if (powerConsumer1.getPowerSource().equals(grid)) {
                    powerConsumer1.setPowerSource(solar);
                    if (getLoadInWatts(solar) > solar.getMaxPowerWatt()) {
                        powerConsumer1.setPowerSource(battery);
                        if (getLoadInWatts(battery) > battery.getMaxPowerWatt()) {
                            powerConsumer1.setPowerSource(grid);
                            if(powerConsumer1 instanceof Switchable){
                                ((Switchable) powerConsumer1).off();
                            }
                        }
                    }
                }
            }
        }
    }
}


