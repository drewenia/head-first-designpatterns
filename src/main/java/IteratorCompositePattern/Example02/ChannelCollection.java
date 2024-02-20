package IteratorCompositePattern.Example02;

public interface ChannelCollection {
    void addChannel (Channel channel);

    void removeChannel(Channel channel);

    ChannelIterator iterator(ChannelTypeEnum type);
}
