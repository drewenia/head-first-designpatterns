# Decorating Objects

Bu bölümü "Desing Eye for the Inheritance Guy" olarak adlandırın. Tipik inheritance'in overuse (aşırı) kullanımını
yeniden gözden geçireceğiz ve sınıflarınızı çalışma zamanında nesne composition'ı türünde kullanarak süslemenin nasıl
yapılacağını öğreneceksiniz. Neden mi? Süslemenin tekniklerini bildiğinizde, temel sınıflara herhangi bir kod
değişikliği yapmadan kendi (veya başkasının) nesnelerine yeni sorumluluklar ekleyebileceksiniz.

# Welcome to Starbuzz Coffee

Starbuzz Coffee, en hızlı büyüyen kahve dükkanlarından biri olarak kendine bir isim yapmıştır. Yerel köşenizde bir tane
gördüyseniz, karşıya bakın; başka bir tane daha göreceksiniz.

Hızlı büyüdükleri için, içecek seçeneklerine uyacak şekilde sipariş sistemlerini güncellemeye çalışıyorlar.
İlk işe başladıklarında sınıflarını şu şekilde tasarladılar...

![img.png](../Images/DecoratorPattern/img.png)

Beverage, kahve dükkanında sunulan tüm içecekler tarafından alt sınıflandırılan abstract bir sınıftır.

cost() methodu abstract bir methoddur; alt sınıflar kendi implementasyonlarını tanımlamalıdır.

Description instance variable'i her alt sınıfta ayarlanır ve içeceğin bir açıklamasını tutar, örneğin "Most excellent
dark roast". getDescription() methodu açıklamayı döndürür.

Her alt sınıf, içeceğin maliyetini döndürmek için cost() methodunu implement eder.

Kahvenizin yanı sıra, buharlı süt, soya ve moka (diğer adıyla çikolata) gibi birkaç katkı maddesi isteyebilir ve hepsini
köpüklü süt ile tamamlayabilirsiniz. Starbuzz, bunların her biri için bir miktar ücret alır, bu yüzden bunları sipariş
sistemlerine dahil etmeleri gerçekten önemlidir. İşte ilk girişimleri...

![img_1.png](../Images/DecoratorPattern/img_1.png)

Her cost() methodu, kahve maliyetini siparişteki diğer katkı maddeleriyle birlikte hesaplar.

Starbuzz'un kendileri için bir bakım kabusu yarattığı oldukça açık. Sütün fiyatı yükseldiğinde ne yaparlar? Yeni bir
karamel üstü eklediklerinde ne yaparlar?

Bu saçma; neden tüm bu sınıflara ihtiyacımız var? Sadece üst sınıfta instance varibles'ları ve miras kullanamaz mıyız
baharatları takip etmek için?

Peki, deneyelim. İlk olarak Beverage temel sınıfını oluşturalım ve her içeceğin süt, soya, mocha ve şeker kreması gibi
instance variables'ları temsil etmesi için ekleyelim...

![img_2.png](../Images/DecoratorPattern/img_2.png)

Her baharat için yeni boolean değerleri ekleyelim.

Şimdi Beverage içinde cost() methodunu (abstract tutmak yerine) implement edelim, böylece belirli bir içeceğin
baharatlarla ilişkilendirilen maliyetlerini hesaplayabilsin. Alt sınıflar hala cost() metodunu override edecektir, ancak
temel içecek maliyetinin yanı sıra eklenen baharatların maliyetini hesaplayabilmeleri için super sürümünü de
çağıracaklar.

getter-setter'lar baharatlar için boolean değerlerini get etmek ve set etmek için kullanılır.

Şimdi alt sınıfları ekleyelim, menüdeki her içeceğin bir alt sınıfı olsun:

Üst sınıfın cost() methodu tüm baharatların maliyetini hesaplayacak, alt sınıflardaki override edilmiş cost() methodu
ise bu işlevselliği o belirli içeceğe özgü maliyetleri içerecek şekilde extend edecektir.

Her cost() methodunun içeceğin maliyetini hesaplaması ve ardından baharatları eklemesi gerekiyor, bunu yapmak için
cost() methodu içinde üst sınıfın cost() methodunu çağırmalıdır.

Bu yaklaşımla ilgili gelecekteki değişikliklerle ilgili bazı potansiyel sorunları düşünerek bazı endişeleriniz olduğunu
anlıyorum. Tasarımın gelecekte nasıl değişebileceğini düşünüyorsunuz? Belirli endişelerinizi paylaşırsanız, bu konuda
daha fazla yardımcı olabilirim.

--**DIALOGS**--

Usta: Çekirge, son görüşmemizden bu yana biraz zaman geçti. Miras konusunda derin düşüncelere mi daldın?

Öğrenci: Evet, Usta. Miras güçlü bir kavram olsa da, her zaman en esnek veya sürdürülebilir tasarımlara yol açmadığını
öğrendim.

Usta: Ah, evet, ilerleme kaydetmişsin. Peki, öyleyse miras yoluyla değilse nasıl yeniden kullanım elde edeceksin,
öğrencim?

Öğrenci: Usta, zamanında "miras alma" yollarının, composition ve delegation yoluyla behavior'a çalışma zamanında aktarma
yollarının olduğunu öğrendim.

Usta: Devam et?

Öğrenci: Behavior'ı alt sınıflandırma yoluyla miras aldığımda, bu Behavior derleme zamanında statik olarak ayarlanır.
Ayrıca, tüm alt sınıfların aynı Behavior'ı miras alması gerekir. Ancak, bir nesnenin Behavior'ını composition yoluyla
extend edebiliyorsam, bunu çalışma zamanında dinamik olarak yapabilirim.

Usta: Çok iyi, Çekirge, Composition'ın gücünü görmeye başlıyorsun.

Öğrenci: Evet, bu teknikle nesnelere birden fazla yeni sorumluluk eklemek mümkün, hatta üst sınıfın tasarımcısı
tarafından dahi düşünülmemiş sorumlulukları bile ekleyebilirim. Ve en önemlisi, onların koduna dokunmam gerekmiyor!

Usta: Composition'ın kodunuzu nasıl sürdürülebilir kıldığı hakkında ne öğrendin?

Öğrenci: İşte bunu anlatmaya çalışıyordum. Nesneleri dinamik olarak composing (birleştirerek) ederek, yeni işlevselliği
mevcut kodu değiştirmek yerine yeni kod yazarak ekleyebilirim. Mevcut kodu değiştirmiyorum, bu nedenle mevcut kodda
hataların ortaya çıkma olasılığı veya istenmeyen side-effect'lere neden olma riski çok daha azdır.

Usta: Çok iyi. Bugün için yeterli, Çekirge. Bu konu hakkında daha fazla düşünmeni isterim... Unutma, kod akşamleyin
kapalı (değişikliğe kapalı) olmalıdır, ancak sabahleyin açık (genişletmeye açık) olmalıdır, sanki lotus çiçeği gibi.

# The Open-Closed Principle

Çekirge, en önemli tasarım prensiplerinden birini anlamaya başlıyor gibi görünüyor:

![img_3.png](../Images/DecoratorPattern/img_3.png)

**Sınıflar, genişletmeye açık ancak değişikliğe kapalı olmalıdır.**

Gelin, içeriye buyurun; biz açığız. Sınıflarımızı istediğiniz yeni Behavior'lara genişletmekten çekinmeyin.
İhtiyaçlarınız veya gereksinimleriniz değişirse (ki değişeceğini biliyoruz), sadece kendi uzantılarınızı yapabilirsiniz.

Evet, bu kodu doğru ve hatasız bir şekilde hazırlamak için çok zaman harcadık, bu yüzden mevcut kodu değiştirmenize izin
veremeyiz. Değişikliğe kapalı olarak kalmalıdır. Eğer beğenmezseniz, yöneticiyle konuşabilirsiniz.

Amacımız, mevcut kodu değiştirmeden yeni Behavior'ları kolayca eklemek için sınıfları genişletmeyi mümkün kılmaktır.
Bunu başarırsak ne elde ederiz? Değişikliklere dayanıklı tasarımlar ve değişen gereksinimlere uygun yeni işlevleri
kolayca entegre edebilen esnek tasarımlar elde ederiz.

--**DIALOGS**--

Q : Genişletmeye açık ve değişikliğe kapalı mı? Bu kulağa çok çelişkili geliyor. Bir tasarım nasıl her ikisi birden
olabilir?

A : Bu çok iyi bir soru. İlk başta kesinlikle çelişkili gibi görünüyor. Sonuçta, değiştirilebilirliği daha az olan bir
şeyi genişletmek daha zor, değil mi? Ama aslında, altta yatan kodu değiştiremesek bile sistemlerin genişletilmesine izin
veren bazı zekice nesne yönelimli teknikler bulunmaktadır. Observer Deseni'ni (2. Bölümde) düşünün... yeni Observer'lar
ekleyerek, Subject'i herhangi bir zamanda genişletebiliriz, Subject'e kod eklememiz gerekmez. Diğer nesne yönelimli
tasarım teknikleriyle Behavior'ı genişletmenin birkaç başka yolunu da göreceksiniz

Q : Observable'ı anladım, ama genellikle bir şeyi genişletilebilir ancak değiştirilemez olarak nasıl tasarlarım

A : Çoğu desen, kodunuzu değiştirilmeden genişletme olanağı sağlayarak sizi zaman içinde test edilmiş tasarımlarla
donatır. Bu bölümde, OpenClosed ilkesini takip etmek için Decorator desenini kullanmanın iyi bir örneğini göreceksiniz

Q : Tasarımımın her parçasının Open-Close kuralına uymasını nasıl sağlayabilirim? Principle mi?

A : Genellikle yapamazsınız. Varolan kodu değiştirmeden nesne yönelimli tasarımı esnek ve genişletilebilir hale getirmek
zaman ve çaba gerektirir. Genel olarak, tasarımlarımızın her parçasını sıkı bir şekilde belirleme lüksümüz yoktur (ve
muhtemelen israftır). Open-Closed Prensibini takip etmek genellikle yeni seviyelerde soyutlamaları beraberinde getirir,
bu da kodumuzu karmaşıklaştırır. Tasarımlarınızda en olası değişecek alanlara odaklanmak ve ilgili prensipleri uygulamak
istersiniz.

Q : Hangi değişim alanlarının daha önemli olduğunu nasıl bilebilirim?

A : Bu kısmen nesne yönelimli sistemler tasarlama deneyimine ve çalıştığınız alanı bilme konusuna bağlıdır. Diğer
örnekleri incelemek, kendi tasarımlarınızda değişim alanlarını tanımak için size yardımcı olacaktır.

Not : Bir çelişki gibi görünebilirken, kodun doğrudan değiştirilmeden genişletilmesine izin veren teknikler vardır.
Kodun genişletilmesi gereken alanlarını seçerken dikkatli olun; HER YERDE Open-Closed Prensibi uygulamak israf, gereksiz
ve karmaşık, anlaşılması zor kodlara yol açabilir.

# Meet the Decorator Pattern

Tamam, içeceklerimizi ve eklerin fiyatlandırma düzenini kalıtım ile temsil etmenin iyi çalışmadığını gördük - sınıf
patlamaları, katı tasarımlar veya baz sınıfa bazı alt sınıflar için uygun olmayan işlevler ekliyoruz.

Bu nedenle, bunun yerine şunu yapacağız: içeceğimizi başlangıçta alacak ve çalışma zamanında eklemelerle "süsleyeceğiz".
Örneğin, müşteri bir Dark Roast kahve isterse ve ona Mocha ve Whip eklemek isterse, o zaman şunu yapacağız:

1 - Bir DarkRoast object'i alın

2 - Bir Mocha object'i ile decorate edin

3 - Bir Whip object'i ile decorate edin

4 - cost() methodunu çağırıp, eklerin maliyetini eklemek için delege etmeye güveneceğiz.

Peki, bir nesneyi nasıl "decorate ederiz" ve bu sürecin içinde nasıl delege kullanılır? İpucu: decorator nesnelerini "
wrapper" olarak düşünün. Nasıl çalıştığını görelim...

# Constructing a drink order with Decorators

1 - Başlangıcı DarkRoast nesnesi ile yaparız.

![img_4.png](../Images/DecoratorPattern/img_4.png)

1 - DarkRoast'ın Beverage'dan miras aldığını ve içeceğin maliyetini hesaplayan bir cost() methodu olduğunu unutmayın.

2 - Müşteri Mocha istiyor, bu nedenle bir Mocha nesnesi oluştururuz ve onunla DarkRoast'ın etrafına sararız. Bu,
DarkRoast nesnesini decorate eder ve Mocha'nın ek işlevselliğini içerir.

![img_5.png](../Images/DecoratorPattern/img_5.png)

Mocha nesnesi bir decorator'dır. Türü, decorate ettiği nesnenin türünü yansıtır, bu durumda Beverage türünü yansıtır. ("
Mirror"le, aynı tür olduğunu kastediyoruz.) Evet, Mocha'nın da bir cost() methodu vardır ve polymorphism sayesinde
Mocha ile wrap edilmiş herhangi bir Beverage'ı (çünkü Mocha, Beverage'ın bir alt türüdür) bir Beverage gibi
işleyebiliriz. Bu, tasarımın esnekliğini ve yeniden kullanılabilirliğini artırır ve Mocha'nın içeceği decorate etmesi
sonucunda bile Beverage olarak işlem görmesini sağlar.

3 - Müşteri aynı zamanda Whip de istiyor, bu nedenle bir Whip decorator'ı oluştururuz ve Mocha'yı bu decorator ile wrap
ederiz. Bu şekilde, Mocha içeceği artık hem Mocha hem de Whip tarafından decorate edilir.

![img_6.png](../Images/DecoratorPattern/img_6.png)

Whip de bir decorator'dır, bu yüzden DarkRoast'ın türünü yansıtır ve bir cost() methodu içerir. Evet, bir DarkRoast
içeceği Mocha ve Whip ile decorate edildiğinde bile hala bir Beverage'dır ve bu içecekle bir DarkRoast ile
yapabileceğiniz her şeyi yapabilirsiniz, bu içeceğin cost() methodunu çağırma dahil

4 - Şimdi müşteri için maliyeti hesaplamanın zamanı geldi. Bunu yapmak için dıştaki decorator olan Whip üzerinde cost()
methodunu çağırıyoruz ve Whip, decorate ettiği nesnelerin maliyetini hesaplamak için delege edecektir. Bir maliyet
alındığında, Whip'in kendi maliyetini ekleyecektir. Bu sayede içeceğin tam maliyetini hesaplamış oluruz.

![img_7.png](../Images/DecoratorPattern/img_7.png)

# Okay, here’s what we know so far...

* Decorators, decorate ettikleri nesnelerle aynı üst türe sahiptir.
* Bir nesneyi wrap etmek için bir veya daha fazla decorator kullanabiliriz.
* Decorator, decorate ettiği nesne ile aynı üst türe sahip olduğu için, wrap edilmiş nesnenin yerine decorated edilmiş
  bir nesneyi geçebiliriz.
* Decorator, kendi Behavior'ını ekler ve geri kalan işi decorate ettiği nesneye delege eder.
* Nesneler herhangi bir zamanda decorate edilebilir, bu nedenle çalışma zamanında istediğimiz kadar çok decorator ile
  nesneleri dinamik olarak decorate edebiliriz.

Şimdi bu konunun gerçekten nasıl çalıştığını anlamak için Decorator Deseni tanımına bakarak ve biraz kod yazarak devam
edelim.

# The Decorator Pattern defined

Decorator Deseni, bir nesneye dinamik olarak ek sorumluluklar ekler. Decorator'lar, işlevselliği genişletmek için alt
sınıf oluşturmanın yerine kullanılabilen esnek bir alternatif sunar. Bu tasarım deseni, nesneleri wrap ederek ve daha
sonra bu wrapper'ları kullanarak bir nesnenin Behavior'ını dinamik olarak genişletmeye olanak tanır. Bu, yazılımın
open-closed ilkesine uyar ve nesne yönelimli tasarımın esnekliğini artırır.

Bu, Decorator Deseni'nin rolünü tanımlarken, deseni kendi implemente etmemiza nasıl uygulayacağımız hakkında çok fazla
bilgi
vermez. Şimdi biraz daha açıklayıcı olan sınıf diyagramına bir göz atalım (bir sonraki sayfada aynı yapının Beverage'a
uygulandığını göstereceğiz).

![img_8.png](../Images/DecoratorPattern/img_8.png)

* ConcreteComponent, dinamik olarak yeni Behavior ekleyeceğimiz nesnedir. Bu, Component'i extend eder
* Her component tek başına kullanılabilir veya bir decorator tarafından wrap edilebilir.
* Her decorator, bir component'e HAS-A ilişkisine sahip olur (wrap eder), yani decorator'ın bir component'e referansı
  tutan bir instance variable'i vardır.
* Decorator, decorate edecekleri Component ile aynı interface veya abstract sınıfı implement eder
* Decorators, Component'in state'ini extend edebilir
* ConcreteDecorator, decorate ettiği şey için bir instance variable bulundurur (Decorator'ın wrap ettiği Component)
* Decorators yeni methodlar ekleyebilir; ancak genellikle yeni Behavior, component'in mevcut bir methodunun öncesinde
  veya sonrasında hesaplama yaparak eklenir

# Decorating our Beverages

Şimdi Starbuzz Beverages'larını bu framework'e dahil edelim..

![img_9.png](../Images/DecoratorPattern/img_9.png)

* Beverage, abstract component sınıfımız olarak hareket eder.

* Dört adet concrete component, her biri bir kahve türü için.

1 - HouseBlend

2 - DarkRoast

3 - Espresso

4 - Decaf

* İşte condiment decorator'larımız; fark edeceksiniz ki, sadece cost() değil, aynı zamanda getDescription() metodunu da
  implement etmeleri gerekiyor. Bunun nedenini birazdan göreceğiz..."

1 - Milk

2 - Mocha

3 - Soy

4 - Whip

# Cubicle Conversation

Inheritance ile Composition Arasındaki Karışıklık

Tamam, biraz kafam karıştı... Sanıyordum ki bu desende inheritance kullanmayacağız, bunun yerine composition kullanmayı
düşünüyorduk

--**DIALOGS**--

S :  Ne demek istiyorsun?

M : Sınıf diyagramına bakın. CondimentDecorator, Beverage sınıfını extend ediyor. Bu inheritance, değil mi?

S : Doğru. Sanırım buradaki önemli nokta, decorator'lerin decorate edecekleri nesnelerle aynı tipe sahip olmalarının
önemli olmasıdır. Burada tür eşleşmesini sağlamak için mirası kullanıyoruz, ancak Behavior elde etmek için miras
kullanmıyoruz.

M : Anladım, decorator'ların componentleri wrap ettiği ve component'in yerine geçmesi gerektiği için aynı "interface" e
sahip olmaları gerektiğini görebiliyorsunuz. Ancak Behavior nerede devreye giriyor?

S : Decorator'i bir component'le compose ettiğimiz de, yeni Behavior ekliyoruz. Yeni Behavior'ı bir üst sınıftan miras
almak yerine nesneleri composition ile elde ediyoruz.

M : Anladım, abstract sınıf olan Beverage'i alt sınıflamak, doğru tipe sahip olmak için yapılıyor, Behavior'ını miras
almak için değil. Davranış, decorator'ların temel componentler'i ve diğer decorator'lar ile composition yoluyla geliyor.

S : Bu doğru

M : Anladım. Nesne composition'ı kullandığınız için, hangi condiments'ler ile beverage'ları nasıl karıştıracağınız
konusunda çok daha fazla esneklik elde edersiniz. Çok akıllıca!

S : Evet, mirasa dayandığımızda behavior'ımız yalnızca derleme zamanında statik olarak belirlenebilir. Başka bir
deyişle, yalnızca üst sınıfın bize verdiği behavior'u veya üzerine yazdığımız behavior'u elde ederiz. Composition
kullanarak ise decorators'ları dilediğimiz gibi karıştırabiliriz... çalışma zamanında

M : Anladığım kadarıyla, yeni behavior eklemek için herhangi bir zaman yeni decorator'lar implement edebiliriz. Eğer
mirasa dayanıyorsak, yeni behavior istediğimizde mevcut kodu her zaman değiştirmemiz gerekebilirdi. Bu nedenle
composition kullanarak, yeni behaviorları eklemek daha esnek ve sürdürülebilir bir yaklaşım sağlar.

S : Kesinlikle

M : Neden sadece component'in türünü miras almak için abstract bir sınıf yerine Beverage sınıfı için bir interface
kullanmadık

S : Elbette, kodu aldığınızda Starbuzz zaten bir abstract Beverage sınıfına sahipti. Geleneksel olarak, Decorator Deseni
bir abstract component belirtir, ancak Java'da açıkça bir interface kullanabilirdik. Ancak mevcut kodu değiştirmekten
kaçınmaya her zaman çalışırız, bu yüzden abstract sınıf işe yarıyorsa onu "fix etmeye" gerek yoktur.

# Writing the Starbuzz code

Şimdi bu tasarımı gerçek bir kod haline getirme zamanı geldi. İlk olarak, Starbuzz'ın orijinal tasarımından Beverage
sınıfıyla başlayalım. Bir göz atalım:

```
public abstract class Beverage {
    String description = "unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
```

Beverage, iki method içeren abstract bir sınıftır: getDescription() ve cost(). getDescription() methodu zaten Beverage
sınıfında implement edilmiş görünüyor. Ancak alt sınıflarda cost() methodunu implement etmemiz gerekecek.

Beverage sınıfı zaten yeterince basit görünüyor. Şimdi Condiments (Decorator) abstract sınıfını da implemente edelim

```
public abstract class CondimentDecorator extends Beverage{

    public abstract String getDescription();
    
    @Override
    public double cost() {
        return 0;
    }
    
}
```

İlk olarak, Beverage ile yer değiştirilebilir (interchangeable) olmamız gerekiyor, bu nedenle Beverage sınıfını extends
ediyoruz.

Ayrıca, tüm condiment (decorator) sınıflarının getDescription() methodunu reimplement etmelerini gerektireceğiz. Bir
saniye sonra nedenini göreceğiz.

# Coding beverages

Temel sınıflarımızı hallettikten sonra, bazı içecekleri implement etmeye başlayalım. Espresso ile başlayacağız.
Unutmayın, belirli bir içeceğin description'ini ayarlamamız ve ayrıca cost() methodunu implemente etmemiz gerekiyor.

```
public class Espresso extends Beverage{
    
    public Espresso(){
        description = "Espresso";
    }
    
    @Override
    public double cost() {
        return 1.99;
    }
    
}
```

İlk olarak, Beverage sınıfını extends ediyoruz.

Description'i halletmek için, bunu sınıfın constructor'ında ayarlarız. Description instance variable'inin Beverage
sınıfından miras aldığını unutmayın.

Son olarak, Espresso'nun maliyetini hesaplamamız gerekiyor. Bu sınıfta içeceklere katkı maddeleri eklememize gerek yok,
sadece bir Espresso'nun fiyatını döndürmemiz gerekiyor: 1.9 dolar.

Şimdi HouseBlend içeceğini ekliyoruz;

```
public class HouseBlend extends Beverage{

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
```

Şimdi DarkRoast içeceğini ekliyoruz;

```
public class DarkRoast extends Beverage{

    public DarkRoast() {
        description = "Dark Roast";
    }

    @Override
    public double cost() {
        return .99;
    }
}
```

Şimdi Decaf içeceğini ekliyoruz;

```
public class Decaf extends Beverage{

    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
```

# Coding condiments

Eğer Decorator Deseni sınıf diyagramına geri dönüyorsanız, şimdi abstract Component'i (Beverage) yazdık, concrete
component'lerimizi (HouseBlend, Decaf, DarkRoast, Espresso) yazdık ve abstract Decorator'ımızı (CondimentDecorator)
oluşturduk. Şimdi concrete decoratorları implemente etmenin zamanı geldi. İşte Mocha örneği:

```
public class Mocha extends CondimentDecorator{
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + .20;
    }
}
```

Mocha bir decorator olduğundan, CondimentDecorator sınıfını extends ediyoruz. Hatırlatmak gerekirse, CondimentDecorator
sınıfı Beverage sınıfını extends ediyor.

Mocha'yı bir Beverage referansı ile instantiate edeceğiz:

1 - Bir Beverage'i wrap etmek için bir instance variable tutmak.

2 - Bu instance variable'ini wrap ettiğimiz nesneye ayarlamak için bir yol. Burada, wrap ettiğimiz Beverage'i Decorator'
in constructor'ına ileteceğiz.

Description'ın sadece Beverage'i değil, Beverage'i decorate eden her öğeyi - örneğin, "Dark Roast" - içermesini
istiyoruz, yani "Dark Roast, Mocha" gibi. İlk olarak, decorate ettiğimiz nesneye kendi description'ınını almak için
başvuruyoruz, ardından bu description sonuna ", Mocha" ekliyoruz.

Şimdi Mocha Beverage'inin maliyetini hesaplamamız gerekiyor. İlk olarak, çağrıyı decorate ettiğimiz nesneye iletiyoruz,
böylece maliyeti hesaplayabilir; sonra, Mocha'nın maliyetini sonuca ekliyoruz.

Soy içinde class'ımızı yazalım;

```
public class Soy extends CondimentDecorator{

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + .15;
    }
}
```

Whip içinde class'ımızı yaratalım;

```
public class Whip extends CondimentDecorator{

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + .10;
    }
}
```

# Serving some coffees

Tebrikler! Şimdi geriye yaslanma, birkaç kahve sipariş etme ve Decorator Deseni ile oluşturduğunuz esnek tasarımı
hayranlıkla izleme zamanı.

```
public class StarbuzzCafe {
    public static void main(String[] args) {
        
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " " + espresso.cost());

        Beverage darkRoast = new DarkRoast();
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);
        System.out.println(darkRoast.getDescription() + " " + darkRoast.cost());

        Beverage houseBlend = new HouseBlend();
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Whip(houseBlend);
        houseBlend = new Soy(houseBlend);
        System.out.println(houseBlend.getDescription() + " " + houseBlend.cost());
        
    }
}
```

Espresso siparişi veriyoruz, condiment olmadan description ve cost'u yazdırıyoruz

DarkRoast siparişi veriyoruz, 2 defa Mocha, 1 defa da Whip ile wrap ediyoruz. Description ve cost yazdırıyoruz

Son olarak HouseBlend sipariş ediyoruz, Mocha, Whip ve Soy ile wrap edip description ve cost yazdırıyoruz

![img_10.png](../Images/DecoratorPattern/img_10.png)

--**DIALOGS**--

Q : Biraz endişeliyim, belirli bir concrete component - mesela, HouseBlend - için test yapabilen bir kod hakkında. Ve
belirli bir şey yapabilen, mesela bir indirim uygulayabilen bir kod. HouseBlend'i decorator'lar ile wrap ettikten sonra,
artık bu işe yaramayacak

A : Tamamen doğru. Eğer concrete component'in türüne dayalı kodlara sahipseniz, decorator'ler bu kodları bozabilir.
Sadece abstract component türüne karşı kod yazarsanız, decorator'ların kullanımı kodunuz için şeffaf kalır. Ancak
concrete componentlere karşı kod yazmaya başladığınızda, uygulama tasarımınızı ve decorator'ların kullanımını gözden
geçirmeniz gerekebilir.

Q : Bir Beverage'in client'inin, en dış decorator olmayan bir decorator'a sahip olması kolay olmaz mı? Mesela, bir
DarkRoast üzerine Mocha, Soy ve Whip eklediysem, Mocha yerine Soy referansına sahip olan bir kod yazmak kolay olabilir,
bu da siparişte Whip'i içermez anlamına gelir.

A : Kesinlikle, Decorator Tasarım Deseni ile daha fazla nesneyi yönetmeniz gerektiğini savunabilirsiniz ve bu nedenle
kod hatalarının, önerdiğiniz türde sorunları ortaya çıkarma olasılığının arttığını söyleyebilirsiniz. Ancak,
decorator'lar genellikle Factory ve Builder gibi diğer tasarım desenleri kullanılarak oluşturulur. Bu desenleri
kapsadıktan sonra, concrete component'in decorator'ı ile birlikte oluşturulmasının "well encapsulated" olduğunu ve bu
tür sorunlara yol açmadığını göreceksiniz.

Q : Decorator'lar, chain halinde uygulandığında genellikle birbirlerini tanımazlar. Ancak, getDecription() gibi bir
methodu özelleştirmek ve decoration'ların sırasını değiştirmek istiyorsanız, bu durumda en dış decorator'in diğer
decorator'leri bilmesi gerekebilir. Bu, belirli bir işlevselliği elde etmek için gerekebilecek özel bir tasarım
gereksinimidir.

A : Decorators, wrap ettikleri nesneye behavior eklemek için tasarlanmışlardır. Decorator chain içinde birden fazla
katmana bakmanız gerektiğinde, decorator'ın asıl amacının ötesine gitmeye başlıyorsunuz demektir. Bununla birlikte,
böyle şeyler mümkündür. Düşünün ki son description'i işleyebilen ve "Mocha, Whip, Mocha" yerine "Whip, Double Mocha"
olarak yazdırabilen bir CondimentPrettyPrint decoratorü olsun. Bu tür bir işlevselliği elde etmek için, getDecription()
bu işi kolaylaştırmak için bir description listesi (ArrayList) döndürebilir.

# Real World Decorators: Java I/O

Java.io paketindeki çok sayıda sınıf... sizi sıkabilir. İlk (ve ikinci ve üçüncü) kez bu API'ye baktığınızda "vay"
dediyseniz, yalnız hissetmeyin. Ancak Artık Decorator Tasarım Deseni'ni bildiğinize göre, java.io paketinin büyük ölçüde
Decorator üzerine kurulu olduğunu anlamalısınız. İşte bir dosyadan veri okuma işlevselliği eklemek için decorator'ları
kullanan tipik bir nesne kümesi:

![img_11.png](../Images/DecoratorPattern/img_11.png)

FileInputStream, decorate edilen component'in kendisidir. Java I/O kütüphanesi, FileInputStream,
StringBufferInputStream, ByteArrayInputStream gibi birkaç component'i içeren bir dizi component sağlar. Tüm bunlar,
baytları okumak için temel bir component sunar.

BufferedInputStream, concrete bir decorator'dır. BufferedInputStream, iki şekilde behavior ekler: performansı artırmak
için input'u buffer'a alır ve character-based input'u satır satır okumak için yeni bir method olan readLine() ile
interface'i extend eder

LineNumberInputStream, aynı zamanda concrete bir decorator'dır. Bu sınıf, verileri okurken satır numaralarını sayabilme
yeteneği ekler.

BufferedInputStream ve LineNumberInputStream her ikisi de FilterInputStream sınıfından extends edilir.
FilterInputStream, abstract decorator sınıf olarak işlev görür

# Decorating the java.io classes

![img_12.png](../Images/DecoratorPattern/img_12.png)

FilterInputStream abstract decorator'dır

Bu InputStream sınıfları, decorator'lar ile wrap edeceğimiz concrete component'ler olarak hareket ederler.
Göstermediğimiz birkaç tane daha var, örneğin ObjectInputStream gibi.

![img_13.png](../Images/DecoratorPattern/img_13.png)

Concrete decorator'larımız:

![img_14.png](../Images/DecoratorPattern/img_14.png)

Görünüşe göre bu, Starbuzz tasarımından çok farklı değil. Şimdi, java.io API belgelerini inceleyebilir ve çeşitli input
stream'ler üzerine decorator'lar oluşturabilirsiniz.

Aynı tasarımın output stream'leri için de geçerli olduğunu göreceksiniz. Ve muhtemelen reader/writer stream'leri (
character-based veriler için) stream sınıflarının tasarımını yakından takip ediyor (bazı farklılıklar ve tutarsızlıklar
olabilir, ancak ne olduğunu anlamak için yeterince yakın).

Ancak, Java I/O aynı zamanda Decorator Deseni'nin dezavantajlarından birini de gösteriyor: bu deseni kullanan tasarımlar
genellikle geliştiriciyi bunaltabilecek birçok küçük sınıfa yol açar. Ancak şimdi Decorator'ın nasıl çalıştığını
bildiğiniz için, perspektifi koruyabilir ve başkasının Decorator ağırlıklı API'sini kullanırken, sınıflarının nasıl
düzenlendiğini anlayarak istediğiniz behavior'u elde etmek için wrapping kullanabilirsiniz.

# Writing your own Java I/O Decorator

Şuna ne dersiniz: input stream'de ki tüm büyük harfleri küçük harfe dönüştüren bir decorator yazın.

```
public class LowerCaseInputStream extends FilterInputStream {
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    public int read(byte[] b, int offset, int len) throws IOException {
        int result = super.read(b, offset, len);
        for (int i = offset; i < offset+result; i++) {
            b[i] = (byte)Character.toLowerCase((char)b[i]);
        }
        return result;
    }
}
```

Şimdi iki read methodu implement etmemiz gerekiyor. Bunlar bir byte (veya byte array'ini) alır ve her byte'ı (bir
karakteri temsil ediyorsa) büyük harfse küçük harfe dönüştürür.

# Test out your new Java I/O Decorator

```
public class InputTest {
    public static void main(String[] args) {
        int c;
        try{
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
            while ((c = in.read())>=0){
                System.out.print((char) c);
            }
            in.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
```

FileInputStream'ı kurun ve önce onu BufferedInputStream ile decorate edin, ardından kendi yeni LowerCaseInputStream
filtresiyle decorate edin.

--**DIALOGS**--

Q : Hoş geldiniz, Decorator Tasarım Deseni. Son zamanlarda biraz moralinizin bozuk olduğunu duymuştuk.

A : Evet, dünya beni büyüleyici bir tasarım deseni olarak görüyor gibi görünebilir, ama herkes gibi benim de payıma
düşen sorunlarım var, bilirsiniz.

Q : Yaşadığınız bazı sıkıntıları bizimle paylaşabilir misiniz?

A : Evet, Decorator Tasarım Deseni, tasarımlara esneklik eklemekte kesinlikle güçlü bir araçtır. Ancak, bu esneklik
getirirken tasarıma çok sayıda küçük sınıf ekleyebilme gücü, kodun karmaşıklığını artırabilir ve diğer geliştiriciler
için anlaması zor hale getirebilir. Bu nedenle, Decorator Deseni'ni kullanırken iyi tasarım prensiplerine dikkat etmek
ve gereksiz karmaşıklığı önlemek önemlidir.

Q : Bir örnek verebilir misiniz?

A : Java Input/Output kütüphanelerini ele alalım. Bu, başta insanlar için anlaması ünlü zor bir konudur. Ancak eğer
sınıfları sadece bir InputStream etrafında wrap eder olarak görselerdi, işler çok daha kolay olurdu.

Q : Kulağa o kadar da kötü gelmiyor. Sen hala harika bir modelsin ve bunu geliştirmek sadece bir halk eğitimi meselesi,
değil mi?

A : Sorunlarım var, görüyorsunuz ki bazen insanlar belirli türleri kullanan bir client kodu parçasını alır ve her şeyi
düşünmeden Decorator'ları ekler. Şimdi, benimle ilgili harika bir şey, genellikle Decorator'ları şeffaf bir şekilde
ekleyebilmenizdir ve client'in bir decorator'la uğraştığını bilmesi gerekmez. Ancak dediğim gibi, bazı kodlar belirli
türlere bağlıdır ve Decorator'ları eklemeye başladığınızda, pat! Kötü şeyler olur

Q : Sanırım herkes Decorator'ları eklerken dikkatli olmanız gerektiğini anlar, kendinize fazla sıkıntı yapmanız
gerektiğini düşünmüyorum

A : Biliyorum, olabildiğince sıkıntı yapmamaya çalışıyorum. Ayrıca Decorator'ları eklemenin, component'i başlatmak için
gereken kodun karmaşıklığını artırma sorunum var. Bir kez decorator'lar eklediğinizde, sadece component'i başlatmakla
kalmaz, aynı zamanda kaç tane decorator ile wrap etmeniz gerektiğini de düşünmelisiniz

Q : Gelecek hafta Factory ve Builder tasarımlarını görüşeceğim - duyduğuma göre bu konuda çok yardımları olabilir?"

A : Doğru, bu konuda daha sık onlarla konuşmalıyım

Q : Herkes senin esnek tasarımlar oluşturmak ve Open-Closed Prensibe sadık kalmak için harika bir örnek olduğunu
düşünüyor, bu yüzden başını dik tutmaya ve olumlu düşünmeye devam et!"

--**BULLET POINTS**--

* Inheritance, extension'ın bir türüdür, ancak tasarımlarımızda esnekliği elde etmenin her zaman en iyi yolu değildir.
* Tasarımlarımızda, mevcut kodu değiştirmeye gerek olmadan behaviour'un genişletilmesine izin vermelisiniz.
* Composition ve delegation, genellikle çalışma zamanında yeni behavior'lar eklemek için kullanılabilir.
* Decorator Deseni, behavior'u genişletmek için alt sınıflandırmanın bir alternatifini sunar.
* Decorator Deseni, concrete componentleri wrap etmek için kullanılan bir dizi decorator sınıfını içerir.
* Decorator sınıfları, decorate ettikleri componentlerin türünü yansıtır. (Aslında, bunlar, componentleri kalıtım veya
  interface implementasyonu yoluyla decorate ettikleri componentlerle aynı türdedir.)
* Decorator'lar, component'lerine yönelik method çağrılarına yeni işlevselliği ekleyerek component'lerinin behavior'unu
  değiştirirler (method çağrılarından önce ve/veya sonra hatta yerine).
* Bir component'i istediğiniz sayıda decorator ile wrap edebilirsiniz.
* Decorator'lar, genellikle component'in client'ina şeffaf olur; yani, client componentin concrete türüne dayanmıyorsa.
* Decorator'lar, tasarımımızda birçok küçük nesneye neden olabilir ve aşırı kullanım karmaşıklığa yol açabilir.