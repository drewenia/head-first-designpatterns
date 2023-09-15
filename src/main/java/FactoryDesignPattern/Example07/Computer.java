package FactoryDesignPattern.Example07;

public abstract class Computer {
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    @Override
    public String toString() {
        return "Ram : " + this.getRAM() + ", HDD : " + this.getHDD() + ", CPU : " + this.getCPU();
    }
}
