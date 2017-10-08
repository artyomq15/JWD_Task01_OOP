package by.tc.task01.entity;

public class Speakers extends Appliance{
    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private int cordLength;

    public Speakers(){

    }

    public Speakers(int powerConsumption, int numberOfSpeakers, String frequencyRange, int cordLength) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Speakers)) return false;

        Speakers speakers = (Speakers) o;

        if (powerConsumption != speakers.powerConsumption) return false;
        if (numberOfSpeakers != speakers.numberOfSpeakers) return false;
        if (cordLength != speakers.cordLength) return false;
        return frequencyRange != null ? frequencyRange.equals(speakers.frequencyRange) : speakers.frequencyRange == null;

    }

    @Override
    public int hashCode() {
        int result = powerConsumption;
        result = 31 * result + numberOfSpeakers;
        result = 31 * result + (frequencyRange != null ? frequencyRange.hashCode() : 0);
        result = 31 * result + cordLength;
        return result;
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRange='" + frequencyRange + '\'' +
                ", cordLength=" + cordLength +
                '}';
    }
}
