package IteratorCompositePattern.Example02;

public class Main {
    public static void main(String[] args) {
        ChannelCollection channels = populateChannels();
        ChannelIterator baseIterator = channels.iterator(ChannelTypeEnum.ALL);
        while(baseIterator.hasNext()){
            Channel channel = baseIterator.next();
            System.out.println(channel.toString());
        }

        System.out.println("*******");
        ChannelIterator englishIterator = channels.iterator(ChannelTypeEnum.ENGLISH);
        while(englishIterator.hasNext()){
            Channel englishChannel = englishIterator.next();
            System.out.println(englishChannel.toString());
        }
    }

    private static ChannelCollection populateChannels() {
        ChannelCollection collections = new ChannelCollectionImpl();
        collections.addChannel(new Channel(98.5,ChannelTypeEnum.ENGLISH));
        collections.addChannel(new Channel(99.5,ChannelTypeEnum.HINDI));
        collections.addChannel(new Channel(100.5,ChannelTypeEnum.FRENCH));
        collections.addChannel(new Channel(101.5,ChannelTypeEnum.HINDI));
        collections.addChannel(new Channel(102.5,ChannelTypeEnum.HINDI));
        collections.addChannel(new Channel(103.5,ChannelTypeEnum.FRENCH));
        collections.addChannel(new Channel(104.5,ChannelTypeEnum.HINDI));
        collections.addChannel(new Channel(105.0,ChannelTypeEnum.ENGLISH));
        return collections;
    }
}
