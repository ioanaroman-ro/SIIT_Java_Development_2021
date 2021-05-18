package model;

import java.util.Objects;

public class PowerSource implements NameIdentifiable {

	private int maxPowerWatt;
	private int chargeInWh;
	private String name;

	public PowerSource(int maxPowerWatt, String name) {
		this(maxPowerWatt, 0, name);
	}

	public PowerSource(int maxPowerWatt, int chargeInWh, String name) {
		this.maxPowerWatt = maxPowerWatt;
		this.chargeInWh = chargeInWh;
		this.name = name;
	}

	private void consume(int wh) {
		chargeInWh -= wh;
	}

	public int getMaxPowerWatt() {
		return maxPowerWatt;
	}

	public void setMaxPowerWatt(int maxPowerWatt) {
		this.maxPowerWatt = maxPowerWatt;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PowerSource)) return false;
		PowerSource that = (PowerSource) o;
		return maxPowerWatt == that.maxPowerWatt && chargeInWh == that.chargeInWh && Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(maxPowerWatt, chargeInWh, name);
	}

	@Override
	public String toString() {
		return "PowerSource{" +
				"maxPowerWatt=" + maxPowerWatt +
				", chargeInWh=" + chargeInWh +
				", name='" + name + '\'' +
				'}';
	}
}
