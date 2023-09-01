# Nesnelerinizi haberdar etmek

Bir şey ilginç olduğunda bunu kaçırmayın! Nesnelerinizi, ilgilenebilecekleri bir şey olursa bilgilendiren bir desene
sahibiz. Nesneler, hatta çalışma zamanında bilgilendirilmek isteyip istemediklerine karar verebilirler. Observer Deseni,
JDK'da en sık kullanılan desenlerden biridir ve son derece faydalıdır. Bitirince, birçok ilişkiyi ve loose coupling (
evet, doğru duydunuz, bağlama dedik) inceleyeceğiz. Observer ile Desen Partisi'nin en hareketlisi siz olacaksınız.

# The Weather Monitoring application overview

Sistemde üç oyuncu bulunmaktadır: Weather Station (hava istasyonu) (gerçek hava verilerini elde eden fiziksel cihaz),
WeatherData nesnesi (Hava İstasyonundan gelen verileri takip eder ve görüntüleri günceller) ve kullanıcılara mevcut hava
koşullarını gösteren görüntüleme öğesi.

![img.png](../Images/ObserverPattern/img.png)

WeatherData nesnesi, güncel verileri almak için fiziksel Weather Station ile iletişim kurmayı bilir. WeatherData nesnesi
daha sonra üç farklı görüntüleme öğesi için görüntülerini günceller: Mevcut Koşullar (sıcaklık, nem ve basınç gösterir),
Hava İstatistikleri ve basit bir tahmin.

Görevimiz, WeatherData nesnesini kullanarak mevcut koşullar, hava istatistikleri ve tahmin için üç görüntülemeyi
güncelleyen bir uygulama oluşturmaktır.

# Unpacking the WeatherData class

Vaat edildiği gibi, ertesi sabah WeatherData kaynak dosyaları gelir. Kodun içine bakarsanız, şeyler oldukça açık
görünüyor:

![img_1.png](../Images/ObserverPattern/img_1.png)

Bu üç method, sırasıyla sıcaklık, nem ve barometrik basınç için en son hava ölçümlerini döndürür. Bu değişkenlerin NASIL
ayarlandığı bizi ilgilendirmez; WeatherData nesnesi, Weather Station'dan güncellenmiş bilgi almayı nasıl yapacağını
bilir.

```measurementChanged()``` Bu method, hava ölçümleri güncellendiğinde çağrılır.

Unutmayın, Bu Mevcut Koşullar sadece üç farklı görüntüleme ekranından BİRİDİR.

![img_2.png](../Images/ObserverPattern/img_2.png)

Görevimiz, measurementsChanged() methodunu implement etmek, böylece mevcut koşullar, hava istatistikleri ve tahmin için
üç görüntüyü güncellemesini sağlamaktır.

# What do we know so far?

Weather-O-Rama'nın belirtimi çok açık değil, ancak ne yapmamız gerektiğini anlamamız gerekiyor. Peki, şu ana kadar ne
biliyoruz?

* WeatherData sınıfı, üç ölçüm değeri için getter methodlara sahiptir: sıcaklık, nem ve barometrik basınç.
* measurementsChanged() methodu, yeni hava ölçüm verileri mevcut olduğunda çağrılır. (Bu methodun nasıl çağrıldığını
  bilmiyoruz veya umursamıyoruz; sadece bu kadarını biliyoruz.)
* Weather data kullanan üç görüntüleme öğesi implement etmememiz gerekiyor: mevcut koşullar görüntüsü, istatistikler
  görüntüsü ve tahmin görüntüsü. Bu görüntüler, WeatherData'nın yeni ölçümlere sahip olduğu her seferinde
  güncellenmelidir.

![img_3.png](../Images/ObserverPattern/img_3.png)

* Sistem genişletilebilir olmalıdır - diğer geliştiriciler yeni özel görüntüleme öğeleri oluşturabilir ve kullanıcılar
  istedikleri kadar fazla görüntüleme öğesini uygulamaya ekleyebilir veya kaldırabilir. Şu anda sadece başlangıçtaki üç
  görüntüleme türünü biliyoruz (mevcut koşullar, istatistikler ve tahmin).

# İlk, yanıltıcı tahminimizi Weather Station'a uygulayarak başlayalım.

İşte ilk bir implementasyon olasılığı - Weather-O-Rama geliştiricilerinin ipucunu alarak kodumuzu measurementsChanged()
methoduna ekleyeceğiz:

```
public class WeatherData {
   
   // instance variable declarations
   
   public void measurementsChanged() {
   
      /* WeatherData'nın getter methodlarını (zaten implement edildi) çağırarak en son ölçümleri alın. */ 
      
      float temp = getTemperature();
      float humidity = getHumidity();
      float pressure = getPressure();
      
      /* Her bir görüntüleme öğesini çağırın ve en son ölçümleri iletmek için görüntüsünü güncellemesini sağlayın. */
      
      currentConditionsDisplay.update(temp, humidity, pressure);
      statisticsDisplay.update(temp, humidity, pressure);
      forecastDisplay.update(temp, humidity, pressure);
 }
 // other WeatherData methods here
}
```

# What’s wrong with our implementation?

Bölüm 1'deki tüm o concepts ve principles'ları tekrar düşünün...

```
currentConditionsDisplay.update(temp, humidity, pressure);
statisticsDisplay.update(temp, humidity, pressure);
forecastDisplay.update(temp, humidity, pressure);
```

Yukarıda ki değişim alanını encapsulate etmemiz gerekiyor.

```
update(temp, humidity, pressure)
```

En azından görünüşe göre ekran elemanlarıyla konuşmak için ortak bir interface kullanıyoruz... hepsinin temp, nem ve
basınç değerlerini alan bir update() methodu bulunuyor.

```
currentConditionsDisplay
statisticsDisplay
forecastDisplay
```

Concrete implementasyonlara kod yazarak, programda değişiklik yapmadan diğer ekran elemanlarını eklemek veya kaldırmak
için herhangi bir yolumuz bulunmuyor.

Observer'i inceleyeceğiz, ardından geri dönüp onu weather monitoring app'e nasıl uygulayacağımızı anlamaya çalışacağız.

# Meet the Observer Pattern

Gazete veya dergi aboneliklerinin nasıl çalıştığını biliyorsunuzdur:

* Bir gazete publisher'i işe başlar ve gazete publishing etmeye başlar.
* Belirli bir publisher'a subscribe olursunuz ve her yeni sayı çıktığında size teslim edilir. Subscribe olduğunuz sürece
  yeni gazeteler alırsınız.
* Artık gazete almak istemediğinizde unsubscribe olursunuz ve gazeteler teslim edilmeyi durdurur.
* Publisher iş yapmaya devam ettiği sürece, insanlar, oteller, havayolları ve diğer işletmeler sürekli olarak gazeteye
  Subscribe olur ve Unsubscribe olabilir

# Publishers + Subscribers = Observer Pattern

Eğer gazete subscriptions'larını anlıyorsanız, neredeyse Observer Tasarımını da anlamış olursunuz, sadece biz
publisher'a ÖZNE (SUBJECT) ve subscriber'lara GÖZLEMCİLER (OBSERVERS) olarak adlandırıyoruz. Biraz daha yakından
inceleyelim:

![img_4.png](../Images/ObserverPattern/img_4.png)

* Subject (ÖZNE) nesnesi belirli bir veriyi yönetir.
* Subject (Özne) içindeki veri değiştiğinde, observer'lar bildirim alır.
* Yeni veri değerleri, değiştiklerinde observer'lara bir şekilde iletilir.
* Observer'lar, Subject (Özne'nin) verisi değiştiğinde güncellemeler almak için Subject'e (Özne'ye) subscribed olmuş (
  register olmuş) durumdalar.
* Duck nesnesi bir observer değil, bu nedenle Subject (Özne'nin) verisi değiştiğinde bildirim almaz.

# A day in the life of the Observer Pattern

Bir Duck nesnesi gelir ve Subject'e observer olmak istediğini söyler. Duck gerçekten bu olaya katılmak istiyor;
Subject'in durumu değiştiğinde gönderdiği tamsayılar oldukça ilginç görünüyor...

![img_5.png](../Images/ObserverPattern/img_5.png)

Duck nesnesi artık resmi bir observer haline geldi. Listede ve bir sonraki bildirimi büyük bir heyecanla bekliyor,
böylece bir tamsayı alabilir.

![img_6.png](../Images/ObserverPattern/img_6.png)

Subject yeni bir veri değeri alır! Şimdi Duck ve diğer tüm observer'lar, Subject'in değiştiği konusunda bir bildirim
alır.

![img_7.png](../Images/ObserverPattern/img_7.png)

Mouse nesnesi observer olarak çıkartılmak istediğini belirtir. Mouse nesnesi uzun bir süredir tamsayılar alıyor ve bunun
sıkıcı olduğuna karar verir, bu nedenle observer olmayı bırakmanın zamanının geldiğine karar verir.

![img_8.png](../Images/ObserverPattern/img_8.png)

Mouse artık burada değil! Subject, Mouse'un isteğini kabul eder ve onu observerler kümesinden çıkarır.

![img_9.png](../Images/ObserverPattern/img_9.png)

Subject başka bir yeni tamsayı alır.Tüm observerlar başka bir bildirim alır, ancak artık içlerinde olmayan Mouse hariç.
Belki bir gün tekrar observer olmayı isteyebilir.

![img_10.png](../Images/ObserverPattern/img_10.png)

# The Observer Pattern defined

Observer Tasarımını anlamaya çalışırken, bir gazete subscription hizmetiyle publisher ve subscriber'ların bulunduğu bir
yapıyı düşünmek, deseni görselleştirmek için iyi bir yoldur. Ancak gerçek dünyada Observer Tasarımı genellikle şu
şekilde tanımlanır:

Observer Pattern, nesneler arasında one-to-many ilişkisi tanımlar. Böylece bir nesnenin durumu değiştiğinde, tüm
bağımlıları otomatik olarak bilgilendirilir ve güncellenir.

Bu tanımı, deseni nasıl konuştuğumuzla ilişkilendirelim:

![img_11.png](../Images/ObserverPattern/img_11.png)

Subject ve observerlar, one-to-many ilişkiyi tanımlar. Observer'lar, subject'e bağımlıdır, böylece subject'in durumu
değiştiğinde observerlar bilgilendirilir. Bildirim stiline bağlı olarak, observer aynı zamanda yeni değerlerle
güncellenebilir.

Keşfedeceğiniz gibi, Observer Tasarımını uygulamanın birkaç farklı yolu vardır, ancak çoğu, Subject ve Observer
interface'lerini içeren bir sınıf tasarımı etrafında döner.

# The Observer Pattern defined: the class diagram

![img_12.png](../Images/ObserverPattern/img_12.png)

**Subject Interface** : Nesneler, bu interface'i observerlar olarak register olmak ve observer olmaktan çıkmak için
kullanır.

**observers** -> Her Subject, birçok observer'a sahip olabilir.

**Observer Interface** : Tüm potansiyel observerlar, Observer interface'ini implement etmelidir. Bu interface'de
yalnızca
bir tane update() methodu bulunur ve bu method, Subject'in durumu değiştiğinde çağrılır.

**ConcreteSubject** : Concrete bir subject her zaman Subject interface'ini implement eder. Register ve Remove
methodlarının
yanı sıra concrete subject, state değiştiğinde tüm mevcut observerları güncellemek için kullanılan bir notifyObservers()
methodu uygular. Concrete subject, state'ini set etme ve get etmek için methodlara sahip olabilir (bununla ilgili daha
fazla bilgi daha sonra verilecektir).

**Concrete Observer** : Observer implemente eden herhangi bir sınıf olabilir. Her observer, güncellemeleri almak için
concrete bir Subject'e kaydolur.

--**DIALOGS**--

Q : Bunun one-to-many ilişkilerle ne ilgisi var?

A : Observer deseniyle Subject, state'i içeren ve kontrol eden nesnedir. Yani, BİR STATE'i olan bir Subject vardır. Öte
yandan, observerlar state'i kullanırlar, hatta ona sahip olmasalar bile. Birçok observer vardır ve durumu ne zaman
değiştiğini söylemesi için Subject'e güvenirler. Bu nedenle BİR SUBJECT ile MANY OBSERVER arasında bir ilişki vardır.

Q : Bağımlılık bu işin içine nasıl giriyor?

A : Çünkü Subject verilerin tek sahibidir, observerlar veriler değiştiğinde onları güncellemesi için Subject'e
bağımlıdır. Bu, aynı veriyi birçok nesnenin kontrol etmesine izin vermekten daha temiz bir nesne yönelimli tasarım
sağlar.

# The power of Loose Coupling

İki nesne Loosely Coupled bağlı olduğunda, etkileşimde bulunabilirler, ancak birbirlerinin hakkında çok az bilgiye
sahiptirler. Observer Deseni, Subject ve observerların loosely coupled bağlı olduğu bir nesne tasarımı sağlar.

Subject'in bir observer hakkında bildiği tek şey, belirli bir interface'i (Observer interface) implement ettiğidir.
Observer'in concrete sınıfının, ne yaptığını veya onun hakkında başka herhangi bir bilgiyi bilmeye ihtiyacı yoktur.

Yeni observerları istediğimiz zaman ekleyebiliriz. Subject'in ihtiyacı olan tek şey, Observer interface'ini implement
eden nesnelerin bir listesi olduğundan, istediğimiz zaman yeni observerlar ekleyebiliriz. Aslında, herhangi bir
observer'i çalışma zamanında başka bir observer ile değiştirebiliriz ve Subject sorunsuz bir şekilde devam eder. Aynı
şekilde, observerları istediğimiz zaman kaldırabiliriz.

Yeni türde observerlar eklemek için Subject'i değiştirmemiz gerekmez. Diyelim ki yeni bir Concrete sınıf, bir observer
olması gerekiyor. Yeni sınıf tipine uyum sağlamak için Subject'i değiştirmemize gerek yoktur, sadece yeni sınıfta
Observer interface'ini implement etmemiz ve observer olarak kaydolmamız yeterlidir. Subject önemsemez; Observer
interface'ini implement eden herhangi bir nesneye bildirimleri iletecektir.

Subject veya observerları birbirinden bağımsız olarak yeniden kullanabiliriz. Başka bir subject veya observer için başka
bir kullanımımız varsa, iki öğeyi de tightly coupled bağlamadıkları için kolayca yeniden kullanabiliriz.

Subject veya bir observerda yapılan değişiklik diğerini etkilemez. İki nesnenin loosely coupled bağlı olduğu için,
Subject veya observer'da değişiklik yapmakta özgürüz, yeter ki nesneler hala Subject veya observer interface'leri
implement etme yükümlülüklerini yerine getirsinler.

![img_13.png](../Images/ObserverPattern/img_13.png)

Nesneler arasında etkileşimde loosely coupled tasarımlar hedefleyin.

# Designing the Weather Station

![img_14.png](../Images/ObserverPattern/img_14.png)

**Subject Interface** : İşte Subject interface'imiz

**Observer Interface** : Tüm weather component'leri Observer interface'ini implement ederler. Bu, Subject'in
observerları güncelleme zamanı geldiğinde konuşmak için ortak bir interface'e sahip olmasını sağlar.

**DisplayElement Interface** : Ayrıca tüm display elemanlarının implement etmesi için bir interface oluşturalım. Display
elemanları sadece bir display() methodunu implements etmek zorunda.

**WeatherData** : WeatherData şimdi Subject interface'ini implements eder

**CurrentConditionDisplay** : Bu Display elemanı, WeatherData nesnesinden gelen güncel ölçümleri gösterir.

**StaticDisplay** : Bu, en düşük/ortalama/en yüksek ölçümleri takip eder ve gösterir.

**ForecastDisplay** : Bu display, barometreye dayalı hava tahminini gösterir.

**ThirdPartyDisplay** : Geliştiriciler, kendi display elemanlarını oluşturmak için Observer ve Display interface'lerini
implement edebilirler

Bu üç display elemanının da bir "Subject" olarak adlandırılan WeatherData'ya bir pointer'i olmalı, ancak eğer bunu
yaparlarsa, bu diyagram bir spagetti gibi görünmeye başlar.

# Implementing the Weather Station

Bu bölümün ilerleyen kısımlarında, Java'nın Observer deseni için bazı yerleşik destekler sağladığını göreceksiniz, ancak
şimdilik kendimiz implementasyona başlayacağız. Bazı durumlarda Java'nın yerleşik desteklerini kullanabilirsiniz, ancak
çoğu durumda kendi methodlarınızı oluşturmak daha esnek olabilir (ve zor değildir). Öyleyse, interface'ler ile
başlayalım:

```
public interface Subject {

    /* Her iki method da bir Observer'i argüman olarak alır; yani, register edilecek veya remove edilecek olan
    Observer'i temsil eder.*/
    
    void registerObserver(Observer o);
    void removeObserver(Observer o);

    /* Bu method, Subject'in state'i değiştiğinde tüm observer'lara bildirimde bulunmak için çağrılır.*/
    
    void notifyObservers();
}
```

```
public interface Observer {

    /* Bunlar, bir hava ölçümü değiştiğinde Observer'ların Subject'e ait aldığı state değerleridir. */
    
    void update(float temperature, float humidity, float pressure);
}
```

Observer interface'i, tüm observerlar tarafından implements edilir, bu nedenle hepsi update() methodunu implement etmek
zorundadır.

```
public interface DisplayElement {
    void display();
}
```

DisplayElement interface'i, sadece bir tane display() methodunu içerir ve display elemanı görüntülenmesi gerektiğinde bu
methodu çağıracağız.

# Implementing the Subject interface in WeatherData

```
public class WeatherData implements Subject { // Subject interface'ini implements ettik
    private final ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    
        /* Observer'ları tutmak için bir ArrayList ekledik ve bunu constructor'da oluşturuyoruz.*/
        
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        
        /* Bir observer register edildiğinde, onu sadece listenin sonuna ekleriz. */
        
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        
        /* Benzer şekilde, bir observer remove edilmek istediğinizde, onu sadece listeden çıkarırız. */
        
        int i = observers.indexOf(o);
        if (i >= 0)
            observers.remove(i);
    }

    @Override
    public void notifyObservers() {
        
        /* Burada tüm observer'lara state hakkında bilgi veriyoruz. Hepsi Observer olduğu için, hepsinin update()
        methodunu implements ettiğini biliyoruz, bu nedenle onlara nasıl bildirim yapacağımızı biliyoruz.*/
        
        observers.forEach(observer -> observer.update(temperature, humidity, pressure));
    }

    public void measurementChanged() {
        
        /* Weather Station'dan güncellenmiş ölçümleri aldığımızda Observer'ları bilgilendiriyoruz.*/
        
        notifyObservers();
    }

    public void setMeasurement(float temperature, float humidity, float pressure) {
        
        /* Tamam, her kitapla güzel bir Weather Statin göndermek istedik, ancak yayıncı buna sıcak bakmadı. Bu nedenle,
        cihazdan gerçek hava verileri okumak yerine, bu methodu kullanarak display elemanlarımızı test etmeye karar
        verdik */
        
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}
```

# Now, let’s build those display elements

Artık WeatherData sınıfımızı düzgün bir şekilde düzenlediğimize göre, Display Elemanlarını inşa etme zamanı geldi.
Weather-O-Rama üç tane sipariş verdi: current condition display, statistics display ve forecast display. Şimdi current
condition display'ine bir göz atalım; bu display elemanını iyi anladıktan sonra statistics ve forecast display'lerine
head first code dizininde göz atabilirsiniz. Benzer olduklarını göreceksiniz.

```
/* Bu display elemanı Observer interface'ini implement eder, böylece WeatherData nesnesinden değişiklikleri alabilir.
Aynı zamanda DisplayElement interface'ini de implement eder, çünkü API'miz tüm display elemanlarının bu implemente
etmesini gerektirecek şekildedir.*/

public class CurrentConditionDisplay implements Observer, DisplayElement{

    private float temperature;
    private float humiditiy;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {

        /* constructor'a weatherData nesnesi (Subject) geçilir ve bunu display'i bir observer olarak register için
        kullanırız.*/
        
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        
        /* display() methodu sadece en son sıcaklık ve nem değerlerini yazdırır. */
        
        System.out.println("Current conditions: " + temperature + "F degrees and " + humiditiy + "% humidity");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        
        /* update() çağrıldığında sıcaklığı ve nemini kaydediyoruz ve display() methodunu çağırıyoruz.*/
        
        this.temperature = temperature;
        this.humiditiy = humidity;
        display();
    }
}
```

--**DIALOGS**--

Q : update() display çağrısı için en iyi yer midir?

A : Bu basit örnekte, değerler değiştiğinde display() çağırmak mantıklıydı. Ancak haklısınız, verilerin nasıl
görüntülendiği şeklini tasarlamak için çok daha iyi yöntemler var. Model-View-Controller desenine geldiğimizde bunu
göreceğiz.

Q : Neden Subject'e bir referans sakladınız? Constructor'dan sonra tekrar kullanılmıyormuş gibi görünüyor?

A : Doğru, ancak gelecekte kendimizi bir observer olarak unregister ettikten sonra Subject'e zaten bir referansımız
olması işe yarar olabilir.

# Power up the Weather Station

1 - Öncelikle bir test düzeneği oluşturalım. Weather Station hazır, tek ihtiyacımız her şeyi bir araya getiren bazı kod
parçacıkları. İşte ilk denememiz. Kitabın ilerleyen bölümlerinde tüm bileşenlerin bir yapılandırma dosyası aracılığıyla
kolayca takılabilir olduğundan emin olacağız. Şimdilik işleyiş şu şekildedir:

```
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurement(80,65,30.4f);
    }
}
```

**Dialogs**

Subject : Nihayet birebir sohbet etme fırsatı bulduğumuza sevindim

Observer : Gerçekten mi? Sanki siz observer'lar ile fazla ilgilenmiyorsunuz gibi düşünmüştüm

Subject : Eh, işimi yapıyorum, değil mi? Her zaman ne olduğunu size söylerim... Sadece kim olduğunuzu pek bilmiyorum
diye ilgilenmediğim anlamına gelmez. Üstelik, sizinle ilgili en önemli şeyi biliyorum - Observer interface'ini implement
ediyorsunuz

Observer : Evet, ama bu sadece benim kim olduğumun küçük bir kısmı. Neyse, sizin hakkınızda daha çok şey biliyorum..

Subject : Öyle mi? ne gibi?

Observer : Eh, sürekli olarak state'inizi bize observer'lara iletiyorsunuz, böylece içeride neler olduğunu görebiliriz.
Bu bazen biraz rahatsız edici olabiliyor.

Subject : Peki, beni affedin. Bildirimlerimle state'imi göndermek zorundayım, böylece tüm tembel observer'lar ne
olduğunu bilecek

Observer : Tamam, bir dakika burada bekle; ilk olarak, tembel değiliz, sadece sizin o kadar önemli bildirimleriniz
arasında başka işlerimiz var, Sayın Subject, ve ikinci olarak, neden sadece herkese iletmek yerine istediğimiz state'i
almak için bizim gelmemize izin vermiyorsunuz

Subject : Eh... sanırım işe yarayabilir. Ancak hepiniz observer'ların gelip ihtiyacınız olan state'i almanıza izin
vermek için kendimi daha da açmam gerekecek. Bu biraz tehlikeli olabilir. Sadece etrafımda dolaşıp sahip olduğum her
şeyi observe etmenize izin veremem.

Observer : Neden sadece bize ihtiyacımız olan state'i çekebilmemiz için bazı genel getter methodları yazmıyorsunuz?

Subject : Evet, state'i çekebilmenize izin verebilirim. Ama bu sizin için daha az kullanışlı olmaz mı? Her seferinde bir
şey istemek için bana gelmek zorunda kalırsanız, istediğiniz tüm state'i almak için birden fazla method çağrısı yapmanız
gerekebilir. Bu nedenle ben push yöntemini daha çok seviyorum... böylece ihtiyacınız olan her şey tek bir bildirimde
bulunuyor.

Observer : Öyle baskıcı olma! Biz observer'ların birçok farklı türü olduğundan, ihtiyacımız olan her şeyi tahmin
edemezsiniz. Sadece size gelip ihtiyacımız olan state'i alalım. Böylece bazılarımız sadece biraz state'i ihtiyaç
duyarsa, hepsini almak zorunda kalmayız. Ayrıca daha sonra değiştirmeyi kolaylaştırır. Örneğin, kendinizi genişletip
daha fazla state eklerseniz, eğer pull yöntemini kullanıyorsanız, her observer üzerindeki update çağrılarını
değiştirmeniz gerekmez, sadece ek state'inize erişim sağlamak için daha fazla getter methoduna izin vermek için
kendinizi değiştirmeniz yeterlidir.

Subject : Evet, her iki yolun da avantajlarını görebilirim. Java'da bulunan bir observer deseni olduğunu fark ettim, bu
da hem pull hem de push yaklaşımlarını kullanmanıza izin veriyor

Observer : Oh, gerçekten mi? Sanırım bunu bir sonraki adımda inceleyeceğiz..

Subject : Harika... belki de pull örneğini görmek ve fikrimi değiştirmek istiyorum.

Observer : Neyse, bir konuda anlaşmak mı? Her zaman umut vardır, değil mi?

# Using Java’s built-in Observer Pattern

Java'nın yerleşik desteğiyle, yapmanız gereken tek şey Observable sınıfını extend etmek ve observer'lara ne zaman
bildirim yapılacağını belirtmek. API gerisini sizin için yapar.

Şimdiye kadar Observer Deseni için kendi kodumuzu oluşturduk, ancak Java'nın birkaç API'sinde yerleşik desteği
bulunuyor. En geneli, java.util paketindeki Observer interface'i ve Observable sınıfıdır. Bunlar, Subject ve Observer
interface'lerimize oldukça benzer, ancak size birçok işlevi otomatik olarak sunar. Bbserver'larınıza pull veya push
stilinde güncelleme yapmayı da uygulayabilirsiniz, göreceksiniz. java.util.Observer ve java.util.Observable için yüksek
seviyede bir fikir edinmek için, WeatherStation için bu yeniden tasarlanmış OO tasarımına göz atın:

![img_15.png](../Images/ObserverPattern/img_15.png)

Observable sınıfı tüm Observer'larınızı takip eder ve sizin için onları bildirir.

Observable bir INTERFACE değil, bir CLASS'tır, bu nedenle WeatherData, Observable sınıfını extend eder.

Observable class'ında ki ```setChanged()``` Bu size tanıdık gelmiyor gibi görünüyor! Bekleyin, bu konuya biraz sonra
geçeceğiz...

WeatherData : İşte Subject'imiz, şimdi aynı zamanda Observer olarak da adlandırabileceğimiz. Artık register(), remove()
ve notifyObservers() methodlarına ihtiyacımız yok; bu behavior'u üst sınıftan miras alıyoruz.

ObserverInterface : Bu tanıdık gelmelidir. Aslında, bu tamamen önceki sınıf diyagramımızla aynıdır!

DisplayElement interface'ini atladık, ancak tüm Display'ler hala onu implement ederler.

Display'ler : Somut observer'ların update() methodunda yapılacak bazı değişiklikler olacak, ancak temelde aynı fikir...
Ortak bir Observer interface'imiz var, bu interface üzerinden Subject tarafından çağrılan bir update() methodu
bulunuyor.

# How Java’s built-in Observer Pattern works

Yerleşik Observer Deseni, Weather Station üzerinde kullandığımız uygulamadan biraz farklı çalışır. En bariz farklılık,
WeatherData (Subject) artık Observable sınıfını extend eder ve add, delete ve notify Observer gibi methodları miras
alır (diğer birkaç tane de dahil). İşte Java sürümünü nasıl kullandığımız:

Bir nesnenin bir observer olabilmesi için, yine Observer interface'ini (bu kez java.util.Observer interface'ini)
implement etmeniz ve herhangi bir Observable nesnesi üzerinde addObserver() methodunu çağırmanız gereklidir. Benzer
şekilde, kendinizi bir Observer olarak kaldırmak için deleteObserver() methodunu çağırabilirsiniz.

Bildirimler göndermek için Observable olmanız gerekir. İlk olarak, java.util.Observable super sınıfını extend ederek
Observable olmalısınız. Ardından, iki adımlık bir süreç izlenir:

1 - İlk olarak, nesnenizin state'inin değiştiğini belirtmek için setChanged() methodunu çağırmanız gerekir.

2 - Ardından, iki farklı notifyObservers() methodundan birini çağırmanız gerekmektedir:

```notifyObservers()``` ya da ```notifyObservers(Object arg)```

```notifyObservers(Object arg)``` Bu sürüm, her bir Observer'a bildirildiğinde iletilen herhangi bir veri nesnesini
alır.

Bir Observer'in bildirimleri alabilmesi için; Yine update methodunu uygular, ancak methodun imzası biraz farklıdır:

![img_16.png](../Images/ObserverPattern/img_16.png)

Bildirimi gönderen Subject, bu argüman olarak iletilir. ```Òbservable o```

``Òbject arg``` Bu, notifyObservers() methoduna iletilen veri nesnesi olacaktır veya bir veri nesnesi belirtilmemişse
null olacaktır.

Eğer Observer'lara veriyi "push" etmek isterseniz, veriyi notifyObserver(arg) methoduna bir veri nesnesi olarak
iletebilirsiniz. Aksi takdirde, Observer'in veriyi alması gerekecektir ve bu veri, kendisine iletilen Observable
nesnesinden alınır. Nasıl yapılacağını görmek için Weather Station örneğini yeniden düzenleyelim.

Neden bu setChanged() methoduna ihtiyacımız var? Daha önce buna ihtiyacımız yoktu.

setChanged() methodu, state'in değiştiğini ve bildirimlerin güncellenmesi gerektiğini belirtmek için kullanılır. Eğer
setChanged() çağrılmadan önce notifyObservers() çağrılırsa, Observer'lar bilgilendirilmez. Observable'ın arkasındaki
mekanizmaya bir göz atarak bu nasıl çalışırı inceleyelim:

![img_17.png](../Images/ObserverPattern/img_17.png)

setChanged() methodu, bir değişiklik flag'ini (changed flag) true olarak ayarlar.

notifyObservers() yalnızca changed flag TRUE ise Observer'ları bilgilendirir.

Ve Observer'ları bilgilendirdikten sonra,changed flag'i tekrar FALSE olarak ayarlar.

Bu neden gerekli? setChanged() methodu, bildirimleri optimize etmenizi sağlayarak observer'ları nasıl güncellediğiniz
konusunda daha fazla esneklik sağlamak amacıyla kullanılır. Örneğin, hava istasyonumuzda ölçümlerimiz o kadar hassas
olsun ki sıcaklık okumaları sürekli olarak ondalık bir derecenin birkaç kesirle dalgalanıyor olsun. Bu, WeatherData
nesnesinin sürekli bildirimler göndermesine neden olabilir. Bunun yerine, sıcaklık yarım dereceden daha fazla değişirse
bildirim göndermek isteyebiliriz ve bu durum gerçekleştikten sonra setChanged() çağırabiliriz.

Bu işlevselliği çok sık kullanmayabilirsiniz, ancak ihtiyacınız olduğunda kullanılabilir. Her iki durumda da
bildirimlerin çalışması için setChanged() çağırmanız gereklidir. Bu işlevselliği kullanışlı buluyorsanız, değişiklik
durumunu false olarak ayarlayan clearChanged() methodunu ve changed flag'in geçerli durumunu size bildiren
hasChanged() methodunu kullanmayı da düşünebilirsiniz.

# Reworking the Weather Station with the built-in support

Artık Observer'larımızı takip etmemize, kayıt ve kaldırma işlemlerini yönetmemize gerek yok (üst sınıf bununla
ilgilenecek), bu nedenle register, add ve notify için olan kodu kaldırdık.

```
public class WeatherDataBuiltIn extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataBuiltIn() {
    }

    public void measurementChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
```

Artık constructor, Observer'ları tutmak için bir veri yapısı oluşturmak zorunda değil.

Dikkat ederseniz, notifyObservers() çağrısı ile bir veri nesnesi göndermiyoruz. Bu, PULL modelini kullandığımız anlamına
gelir.

Şimdi, bildirimleri çağırmadan önce state'in değiştiğini belirtmek için önce setChanged() methodunu çağırıyoruz.

Getter methodları yeni değil, ancak "pull" kullanacağımız için burada olduğunu hatırlatmak istedik. Observer'lar,
WeatherData nesnesinin durumuna erişmek için bunları kullanacaktır.

```
public class CurrentConditionDisplayBuiltIn implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplayBuiltIn(Observable observable) {

        /* Constructor method artık bir Observable alır ve bu Observable'ı kullanarak CurrentConditionDisplayBuiltIn
        nesnesini bir Observer olarak ekleriz.*/

        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions : " + temperature + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {

        /* update() methodunu, hem bir Observable hem de isteğe bağlı veri argümanını kabul edecek şekilde
        değiştirdik.*/

        /* update() methodunda önce observable'ın WeatherData türünde olduğundan emin oluruz ve ardından sıcaklık ve
        nem ölçümlerini almak için getter methodlarını kullanırız. Bundan sonra display() methodunu çağırırız.*/

        if (o instanceof WeatherDataBuiltIn weatherData){
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
```

**Önemli Not : java.util.Observable, programlama yaparken interface'lere değil implementasyonlara dayalı olma ilkesine
uymayabilir. DEPRECATE edilmiştir**

# The dark side of java.util.Observable

Evet, doğru bir tespit. Observable bir sınıf, bir interface değil, hatta bir interface'i implement etmez. Ne yazık ki,
java.util.Observable uygulamasının kullanışlılığını ve yeniden kullanımını sınırlayan bir dizi sorunu vardır. Bu, bazı
faydalar sağlamadığı anlamına gelmez, ancak dikkat etmeniz gereken bazı büyük sorunlar vardır. İlkelerimizden zaten bu
fikrin kötü bir fikir olduğunu biliyorsunuz, ancak gerçekte ne tür zararlar verebilir?

İlk olarak, Observable bir sınıf olduğundan, ondan alt sınıf türetmek zorundasınız. Bu, zaten başka bir üst sınıfı
extend eden mevcut bir sınıfa Observable behavior'unu ekleyemeyeceğiniz anlamına gelir. Bu, yeniden kullanım
potansiyelinizi sınırlar.

İkincisi, Observable interface'i olmadığı için, Java'nın yerleşik Observer API'si ile iyi çalışan kendi uygulamanızı
bile oluşturamazsınız. Ayrıca, java.util uygulamasını başka bir uygulama ile değiştirme seçeneğiniz de yoktur (örneğin,
yeni bir multi-threading uygulama ile değiştirme).

Observable, önemli methodları korur. Observable API'ye baktığınızda, setChanged() methodunun korumalı olduğunu
göreceksiniz. Peki bu ne anlama geliyor? İşte, Observable'ı alt sınıflandırmadıkça setChanged() methodunu çağıramazsınız
demektir. Bu, Observable sınıfının bir instance'ini oluşturamayacağınız anlamına gelir ve kendi nesnelerinizle bile
composition yapamazsınız, bunun yerine alt sınıflandırmak zorundasınız. Bu tasarım, burada bir başka tasarım ilkesini
ihlal ediyor... kalıtım yerine composition'ı tercih etme ilkesini ihlal ediyor.

--**BULLET POINTS**--

* Observer Deseni, nesneler arasında one-to-many ilişki tanımlar.
* Subject'ler veya aynı zamanda Observable olarak bildiğimiz nesneler, Observer'ları ortak bir interface kullanarak
  günceller.
* Observer'lar, Observable'ların dışında kendi hakkında hiçbir şey bilmeyen, sadece Observer Interface'ini implement
  ettiklerini bilen bir şekilde loosely coupled bağlıdır.
* Deseni kullanırken Observable'dan veriyi pull veya push edebilirsiniz (pull daha "doğru" olarak kabul edilir).
* Observer'larınız için belirli bir bildirim sırasına güvenmeyin.
* Java'nın java.util.Observable gibi Observer Deseni'nin çeşitli implementasyonları bulunmaktadır.
* java.util.Observable implementasyonunda ki sorunlara dikkat edin.
* İhtiyaç duyulması durumunda kendi Observable implementasyonunuzu oluşturmaktan çekinmeyin.
* Swing, Observer Deseni'ni yoğun bir şekilde kullanır, aynı şekilde birçok GUI framework'u de kullanır.
* Ayrıca, Observer Deseni'ni JavaBeans ve RMI gibi birçok farklı yerde bulabilirsiniz.
