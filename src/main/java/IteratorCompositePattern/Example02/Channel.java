package IteratorCompositePattern.Example02;

public class Channel {
    private final double frequency;
    private final ChannelTypeEnum TYPE;

    public Channel(double frequency, ChannelTypeEnum TYPE) {
        this.frequency = frequency;
        this.TYPE = TYPE;
    }

    public double getFrequency() {
        return frequency;
    }

    public ChannelTypeEnum getTYPE() {
        return TYPE;
    }

    @Override
    public String toString(){
        return "Frequency="+this.frequency+", Type="+this.TYPE;
    }
}
