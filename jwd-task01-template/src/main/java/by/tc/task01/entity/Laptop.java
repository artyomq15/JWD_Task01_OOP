package by.tc.task01.entity;

public class Laptop extends Appliance{
	private double batteryCapacity;
    private String operatingSystem;
    private int memoryRom;
    private int systemMemory;
    private double centralProcessorUnit;
    private int displayInches;

    public Laptop(){

    }

    public Laptop(double batteryCapacity, String operatingSystem, int memoryRom, int systemMemory, double centralProcessorUnit, int displayInches) {
        this.batteryCapacity = batteryCapacity;
        this.operatingSystem = operatingSystem;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.centralProcessorUnit = centralProcessorUnit;
        this.displayInches = displayInches;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCentralProcessorUnit() {
        return centralProcessorUnit;
    }

    public void setCentralProcessorUnit(double centralProcessorUnit) {
        this.centralProcessorUnit = centralProcessorUnit;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;

        Laptop laptop = (Laptop) o;

        if (Double.compare(laptop.batteryCapacity, batteryCapacity) != 0) return false;
        if (memoryRom != laptop.memoryRom) return false;
        if (systemMemory != laptop.systemMemory) return false;
        if (Double.compare(laptop.centralProcessorUnit, centralProcessorUnit) != 0) return false;
        if (displayInches != laptop.displayInches) return false;
        return operatingSystem != null ? operatingSystem.equals(laptop.operatingSystem) : laptop.operatingSystem == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(batteryCapacity);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (operatingSystem != null ? operatingSystem.hashCode() : 0);
        result = 31 * result + memoryRom;
        result = 31 * result + systemMemory;
        temp = Double.doubleToLongBits(centralProcessorUnit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + displayInches;
        return result;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", memoryRom=" + memoryRom +
                ", systemMemory=" + systemMemory +
                ", centralProcessorUnit=" + centralProcessorUnit +
                ", displayInches=" + displayInches +
                '}';
    }
}
