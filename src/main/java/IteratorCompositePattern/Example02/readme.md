Elimizde bir Radyo kanalları listesi olduğunu ve client programın bu kanalları tek tek veya kanal türüne göre dolaşmak
istediğini varsayalım. Örneğin bazı client programlar sadece İngilizce kanallarla ilgileniyor ve sadece onları işlemek
istiyor, diğer kanal türlerini işlemek istemiyorlar.

Bu nedenle, client'a bir kanal koleksiyonu sağlayabilir ve kanallar arasında geçiş yapmak ve bunları işleyip
işlemeyeceğine karar vermek için logic yazmalarına izin verebiliriz. Ancak bu çözümün, client'in çapraz geçiş
mantığını bulması gerektiği gibi birçok sorunu vardır. Client mantığının doğru olduğundan emin olamayız. Ayrıca,
Client sayısı artarsa, bakımı çok zor hale gelecektir. Burada Iterator modelini kullanabilir ve kanal türüne göre
iterasyon sağlayabiliriz. Client programın kanal listesine yalnızca yineleyici aracılığıyla erişebildiğinden emin
olmalıyız. Implementasyonun ilk kısmı, koleksiyon ve yineleyici arayüzlerimiz için sözleşme tanımlamaktır.

> ChannelTypeEnum.java

```
public enum ChannelTypeEnum {
    ENGLISH,
    HINDI,
    FRENCH,
    ALL
}
```

> Channel.java (Channel, frequency ve ChannelTypeEnum niteliklerine sahip basit bir POJO sınıfıdır.)

```
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
```

> ChannelIterator.java

```
public interface ChannelIterator {
    boolean hasNext();
    Channel next();
}
```

> ChannelCollection.java (ChannelCollection interface'i, koleksiyon sınıfı implementasyonumuz için contract'ı tanımlar.
> Bir channel eklemek ve kaldırmak için methodlar olduğuna ancak channel'ların listesini döndüren bir method olmadığına
> dikkat edin. ChannelCollection, iterator döndüren bir methoda sahiptir.)

```
public interface ChannelCollection {
    void addChannel (Channel channel);

    void removeChannel(Channel channel);

    ChannelIterator iterator(ChannelTypeEnum type);
}
```

> ChannelCollectionImpl.java

```
public class ChannelCollectionImpl implements ChannelCollection {

    private final List<Channel> channels;

    public ChannelCollectionImpl() {
        channels = new ArrayList<>();
    }

    @Override
    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    @Override
    public void removeChannel(Channel channel) {
        channels.remove(channel);
    }

    @Override
    public ChannelIterator iterator(ChannelTypeEnum type) {
        return new ChannelIteratorImpl(type, this.channels);
    }

    private class ChannelIteratorImpl implements ChannelIterator {

        private final ChannelTypeEnum type;
        private final List<Channel> channels;
        private int position;

        public ChannelIteratorImpl(ChannelTypeEnum type, List<Channel> channels) {
            this.type = type;
            this.channels = channels;
        }

        @Override
        public boolean hasNext() {
            while (position < channels.size()) {
                Channel channel = channels.get(position);
                if (channel.getTYPE().equals(type) || type.equals(ChannelTypeEnum.ALL)){
                    return true;
                } else {
                    position++;
                }
            }
            return false;
        }

        @Override
        public Channel next() {
            Channel channel = channels.get(position);
            position++;
            return channel;
        }
    }
}
```

> ChannelIteratorImpl.java class'ı inner class olarak tanıtılmış ve implemente edilmiştir

Iterator interface'inin inner class implementasyonuna dikkat edin, böylece implementasyon başka bir koleksiyon
tarafından kullanılamaz.

Aynı yaklaşım Collection sınıfları tarafından da takip edilir ve hepsinin Iterator interface'inin inner class
implementasyonu vardır.

```
public class ChannelCollectionImpl implements ChannelCollection {

    private final List<Channel> channels;

    public ChannelCollectionImpl() {
        channels = new ArrayList<>();
    }

    @Override
    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    @Override
    public void removeChannel(Channel channel) {
        channels.remove(channel);
    }

    @Override
    public ChannelIterator iterator(ChannelTypeEnum type) {
        return new ChannelIteratorImpl(type, this.channels);
    }

    private class ChannelIteratorImpl implements ChannelIterator {

        private final ChannelTypeEnum type;
        private final List<Channel> channels;
        private int position;

        public ChannelIteratorImpl(ChannelTypeEnum type, List<Channel> channels) {
            this.type = type;
            this.channels = channels;
        }

        @Override
        public boolean hasNext() {
            while (position < channels.size()) {
                Channel channel = channels.get(position);
                if (channel.getTYPE().equals(type) || type.equals(ChannelTypeEnum.ALL)){
                    return true;
                } else {
                    position++;
                }
            }
            return false;
        }

        @Override
        public Channel next() {
            Channel channel = channels.get(position);
            position++;
            return channel;
        }
    }
}
```

> Main.java

```
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
```

Iterator kalıbı, bir koleksiyon üzerinde iteration yapmak ve implementation logic'ini client programdan gizlemek için
standart bir yol sağlamak istediğinizde kullanışlıdır.

Iteration mantığı koleksiyonun içine gömülüdür ve client programın bunlar üzerinde kolayca yineleme yapmasına yardımcı
olur.