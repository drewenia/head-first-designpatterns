# Being Adaptive

Bu bölümde, bir kare pimi yuvarlak bir deliğe koyma gibi imkansız görünen görevleri denemeye çalışacağız. İmkansız gibi
mi geliyor? Design Patterns (Tasarım Şablonları) olduğunda değil. Decorator Pattern'i hatırlıyor musunuz? Nesneleri yeni
sorumluluklar vermek için wrap ettik. Şimdi bazı nesneleri farklı bir amaçla wrap etmeye gidiyoruz: interface'lerini
oldukları gibi göstermek yerine başka bir şey gibi göstermek için. Neden böyle yaparız? Böylece bir interface'i bekleyen
bir tasarımı, farklı bir interface'i implemente eden bir sınıfa uyarlayabiliriz. İşte bu kadar değil; bu süreçte,
nesneleri interface'lerini basitleştirmek için wrap eden başka bir şablonu da inceleyeceğiz.

# Adapters all around us

OO adapter nedir konusunu anlamanızda hiçbir zorluk yaşamayacaksınız, çünkü gerçek dünya onlarla doludur. İşte bir
örnek: Avrupa ülkesinde bir Amerikan yapımı dizüstü bilgisayar kullanmanız gerekti mi? O zaman muhtemelen bir AC güç
adapterüne ihtiyacınız olmuştur...

![img.png](../Images/AdapterFacade/img.png)

European prizleri, bir şeyi takmak için bir interface sağlarlar.

AC Power Adapter, bir interface'i başka bir interface'e dönüştürür.

ABD yapımı dizüstü bilgisayar, başka bir interface'i bekler.

Adapterün ne yaptığını biliyorsunuz: Dizüstü bilgisayarınızın fişi ile Avrupa AC prizi arasına yerleşir; görevi Avrupa
prizini, dizüstü bilgisayarınızı takabileceğiniz ve güç alabileceğiniz bir hale getirmektir. Veya şöyle
düşünebilirsiniz: adapter, prizin interface'ini dizüstü bilgisayarınızın beklediği bir interface'e dönüştürür.

Bazı AC adapterleri basittir - sadece prizin şeklini değiştirirler, böylece fişinizle uyumlu hale gelirler ve AC akımını
doğrudan geçirirler - ancak diğer adapterler daha karmaşıktır ve içeriden gücü yükseltmek veya düşürmek gerekebilir,
böylece cihazlarınızın ihtiyaçlarına uygun hale getirirler.

Peki, gerçek dünya adapterleri neyse, nesne tabanlı adapterler (OO adapterleri) nasıl işler? İşte, OO adapterlerimiz
gerçek dünya benzerlerinin aynı rolünü oynarlar: Bir interface alır ve bir client'in beklediği bir interface'e
uyarlarlar.

# Object oriented adapters

Varsayalım ki mevcut bir yazılım sisteminiz var ve yeni bir vendor sınıf kütüphanesini bu sisteme entegre etmeniz
gerekiyor, ancak yeni vendor önceki vendordan farklı bir şekilde interface'leri tasarladı:

![img_1.png](../Images/AdapterFacade/img_1.png)

Vendor class'ının interface'i, kodunuzu yazdığınız interface ile eşleşmiyor. Bu şekilde çalışmayacak!

Peki, mevcut kodunuzu değiştirme şansınız yoksa (ve vendor'un kodunu da değiştiremiyorsanız) sorunu çözmek için ne
yapabilirsiniz? İşte, yeni vendor interface'ini beklediğiniz interface'e dönüştüren bir sınıf yazabilirsiniz.

![img_2.png](../Images/AdapterFacade/img_2.png)

Adapter, sınıflarınızın beklediği interface'i uygular, Ve Vendor interface'ine erişerek request'leri işler.

Adapter, client'dan gelen request'leri alır ve bunları Vendor sınıflarında anlamlı hale getiren request'lere
dönüştürerek aracılık eder.

![img_3.png](../Images/AdapterFacade/img_3.png)

Yeni Vendor sınıflarını entegre etmek için HERHANGİ bir ek kod yazmanızı gerektirmeyen bir çözüm düşünebiliyor musunuz?
Vendor'un adapter sınıfını arz etmesine ne dersiniz?

# If it walks like a duck and quacks like a duck,then it must might be a duck turkey wrapped with a duck adapter...

Şimdi bir adapter'in işlevini görmenin zamanı geldi. İlk bölümdeki Duck'ları hatırlıyor musunuz? Duck interface'leri
ve sınıflarının hafifçe basitleştirilmiş bir versiyonunu gözden geçirelim:

```
public interface Duck {
    void quack();
    void fly();
}
```

Bu sefer duck'larımız, duck'ların quack ve fly'ına izin veren Duck interface'ini uyguluyorlar.

İşte Duck sınıfının bir alt sınıfı olan MallardDuck

```
public class MallardDuck implements Duck{
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
```

Şimdi bloktaki en yeni kümes hayvanıyla tanışma zamanı:

```
public interface Turkey {

    // glu glu sesi
    void gobble();

    //Hindi kuşları uçabilirler, ancak sadece kısa mesafeler için uçabilirler.
    void fly();
}
```

WildTurkey class;

```
public class WildTurkey implements Turkey{
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
```

Şimdi, Duck nesnelerinizden eksik olduğunuz bir durumda ve onların yerine bazı Turkey nesnelerini kullanmak
istiyorsunuz. Açıkçası, Turkey nesnelerini doğrudan kullanamayız çünkü farklı bir interface'e sahipler. Bu nedenle, bir
Adapter yazalım:

```
public class TurkeyAdapter implements Duck{

    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
```

İlk olarak, uyum sağladığınız türün interface'ini implemente etmeniz gerekmektedir. Bu, client'in beklediği interface'
dir.

Sonraki adım olarak, uyarladığımız nesneye bir başvuru almalıyız; bu işlemi genellikle constructor üzerinden
gerçekleştiririz.

Şimdi interface'deki tüm methodları implemente etmemiz gerekiyor; sınıflar arasındaki quack() çevirisi kolaydır: sadece
gobble() methodunu çağırın.

Her iki interface'in de bir fly() methodu olsa da, Turkey kuşları kısa süreli uçabilirler - Duck'lar gibi uzun mesafe
uçamazlar. Bir Duck'ın fly() methodu ile bir Turkey'in fly() methodu arasında bağlantı kurmak için, Turkey fly()
methodunun bu eksikliği telafi etmek için beş kez çağırmamız gerekmektedir.

# Test drive the adapter

```
public class DuckTestDrive {
    public static void main(String[] args) {
        
        /* Bir Duck ve Turkey create edelim*/
        Duck mallardDuck = new MallardDuck();
        Turkey wildTurkey = new WildTurkey();

        /* Ve ardından Turkey'i bir TurkeyAdapter ile wrap edin, böylece onu bir Duck gibi görünmesini sağlar.*/
        Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);

        /* Ardından, Turkey'i test edelim: gooble ve fly'i deneyelim */
        System.out.println("The turkey says...");
        wildTurkey.gobble();
        wildTurkey.fly();

        /* Şimdi testDuck() methodunu çağırarak Duck'ı test edelim. Bu method bir Duck nesnesi bekler. */
        System.out.println("\nThe Duck says");
        testDuck(mallardDuck);

        /* Şimdi büyük bir test: Turkey kuşunu bir Duck gibi geçirmeye çalışıyoruz...*/
        System.out.println("\nThe, TurkeyAdapter says");
        testDuck(turkeyAdapter);
    }

    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
}
```

![img_4.png](../Images/AdapterFacade/img_4.png)

# The Adapter Pattern explained

Şimdi bir Adapter'in ne olduğu hakkında bir fikir edindik, şimdi geri çekilip tüm parçalara tekrar bir göz atalım.

![img_5.png](../Images/AdapterFacade/img_5.png)

Client, target interface'e karşı implemente edilmektedir

Adapter, target interface'i implemente eder ve Adaptee'nin bir instance'ini tutar.

TurkeyAdapter, target interface'i (Duck) implemente etmiştir

Turkey, adapte edilen interface'dir (Adaptee)

### Here’s how the Client uses the Adapter

* Client, target interface'i kullanarak adapter'a bir request'de bulunur ve bunu çağırarak adapter üzerinde bir method
  çağırır.

* Adapter, request'i adapte edilen interface (Adaptee) üzerinde bir veya daha fazla çağrıya çevirir.

* Client, çağrının sonuçlarını alır ve çeviri yapan bir adapter olduğunu asla bilmez.

Not : Dikkat edilmesi gereken bir diğer nokta, Client ve Adaptee'nin (uyarlanan) birbirinden bağımsız olduğudur - ikisi
de diğerinden habersizdir.

--**DIALOGS**--

Q : Bir adapter ne kadar "adapting" olmalıdır? Büyük bir target interface'i implemente etmem gerekiyorsa, oldukça
fazla işim olabilir gibi görünüyor.

A : Kesinlikle öyle olabilir. Bir adapter'i implemente etmenin gerçekten de target interface'imizi desteklemek
istediğiniz interface boyutuyla orantılı olduğunu söyleyebiliriz. Ancak seçeneklerinizi düşünün. Tüm client tarafı
çağrılarınızı interface'de yeniden şekillendirebilirsiniz, bu da oldukça fazla inceleme işi ve kod değişiklikleri
gerektirir. Veya, tüm değişiklikleri tek bir sınıfta encapsulate eden temiz bir şekilde bir sınıf sağlayabilirsiniz

Q : Bir adapter her zaman bir ve yalnızca bir sınıfı mı wrap eder?

A : Adapter Deseni'nin rolü bir interface'i başka bir interface'e dönüştürmektir. Adapter deseninin çoğu örneği bir
adapter'in bir adaptee'yi wrap ettiğini gösterse de, dünya genellikle biraz daha karışık olabilir. Bu nedenle, target
interface'i implement etmek için gereken iki veya daha fazla adaptee'ye sahip olan durumlarla karşılaşabilirsiniz. Bu,
başka bir modele olan bir ilgiyi çağrıştırır, Facade Deseni olarak adlandırılan; insanlar genellikle ikisini karıştırır.
Bu konuya bu bölümün sonraki kısımlarında facadeler hakkında konuştuğumuzda tekrar döneceğiz.

Q : Eğer sistemimde eski ve yeni parçalarım varsa, eski parçalar eski Vendor interface'ini bekliyor ancak yeni
parçaları yeni Vendor interface'ini kullanacak şekilde yazmışsak, burada bir adapter kullanmak ve orada unwrapped
interface'i kullanmak kafa karıştırıcı olabilir. Adapter'i kullanmak yerine eski kodumu yazıp adapter'ı unutmazsam daha
iyi bir seçenekte olmaz mı?

A : Bu her zaman gerekli değil. Yapabileceğiniz şeylerden biri, her iki interface'i de destekleyen bir Two Way Adapter
oluşturmaktır. Bir Two Way Adapter oluşturmak için sadece ilgili her iki interface'i de implemente etmeniz yeterlidir,
böylece adapter eski bir interface veya yeni bir interface olarak hareket edebilir.

# Adapter Pattern defined

Adapter Deseni, bir sınıfın interface'ini Client'ların beklediği başka bir interface'e dönüştürür. Adapter, uyumsuz
interface'ler nedeniyle aksi takdirde çalışamayan sınıfların birlikte çalışmasını sağlar

Bu desenin, dönüşümü gerçekleştiren bir Adapter oluşturarak Client'i uyumsuz bir interface'le kullanmamıza izin
verdiğini biliyoruz. Bu, Client'i implemente edilen interface'den ayırır ve interface'in zamanla değişmesini
bekliyorsak, adapter değişikliği encapsulate eder, böylece Client'in farklı bir interface'e karşı çalışması gerektiğinde
her seferinde değiştirilmesi gerekmez. Desenin çalışma zamanı davranışına bir göz attık; şimdi sınıf diyagramına da bir
göz atalım;

![img_6.png](../Images/AdapterFacade/img_6.png)

Client yalnızca Target interface'i görür.

Adapter Target Interface'i implemente eder

Adapter, Adaptee ile composed edilir

Tüm request'ler, Adaptee'ye delege edilir

Adapter Deseni, iyi nesne yönelimli tasarım prensipleriyle doludur: adaptee'yi değiştirilmiş bir interface'le wrap etmek
için object composition kullanımına bakın. Bu yaklaşım, adaptee'nin herhangi bir alt sınıfını bir adapter'la
kullanabilme avantajına sahiptir. Ayrıca desenin Client'i bir implementasyon ile değil bir interface ile bağladığına
dikkat edin; farklı backend sınıflarını dönüştüren her bir adapter'i kullanabiliriz. Ya da, yeni implementasyonları
sonradan ekleyebiliriz, yeter ki Target interface'e uyulsun.

# Object and class adapters

Şu anda tanımış olduğumuz desene rağmen, size hala tam hikayeyi anlatmadık. Aslında iki tür adapter bulunmaktadır:
object adapters ve class adapters. Bu bölüm object adapters'larını ele almıştır ve önceki sayfadaki sınıf diyagramı bir
object adapters'in diyagramıdır. Peki, class adapters nedir ve neden hakkında size bilgi vermedik? Çünkü onu implemente
etmek için için birden fazla inheritance gerekmektedir ve bu, Java'da mümkün değildir. Ancak bu, en sevdiğiniz birden
fazla kalıtım dilini kullanırken ileride class adapters'a ihtiyaç duyabileceğiniz anlamına gelmez! Birden fazla
inheritance için sınıf diyagramına bir göz atalım.

![img_7.png](../Images/AdapterFacade/img_7.png)

Tek fark, class adapter ile Target ve Adaptee'yi alt sınıf yaparken, object adapter ile request'leri bir Adaptee'ye
iletmek için composition'ı kullanmamızdır.

--**Class Adapter Example**--

![img_8.png](../Images/AdapterFacade/img_8.png)

Not: Class adapter, multi inheritance kullanır, bu nedenle Java'da yapamazsınız...

Client, bir Duck ile konuştuğunu düşünüyor.

Target, Duck sınıfıdır. Bu, client tarafından methodların çağrıldığı nesnedir

Adapter, her iki sınıfı da (Duck ve Turkey) extends ederek Turkey'in bir Duck üzerindeki request'lere yanıt vermesini
sağlar.

Turkey sınıfı, Duck ile aynı methodlara sahip değil, ancak Adapter, Duck methodu çağrılarını alabilir ve ardından Turkey
üzerinde method çağrıları yapabilir.

--**Object Adapter Example**--

![img_9.png](../Images/AdapterFacade/img_9.png)

Client, bir Duck ile konuştuğunu sanıyor.

<<interface>> Target : Class Adapter ile olduğu gibi, Target Duck sınıfıdır. İşte client'in methodlarını çağırdığı nesne
budur.

Adapter, Duck interface'ini implement eder, ancak bir method çağrısı aldığında bu çağrıları bir Turkey nesnesine
delege eder.

Turkey sınıfı, Duck ile aynı interface'e sahip değildir. Başka bir deyişle, Turkey'lerde quack() gibi methodlar
bulunmaz.

Adapter sayesinde, Turkey (Adaptee), client'in Duck interface'inde yaptığı çağrıları alacaktır.

--**DIALOGS**--

Object Adapter : Composition kullandığım için avantajım var. Bir adaptee edilen sınıfı değil, aynı zamanda alt
sınıflarını da adapt edebilirim.

Class Adapter : Bu doğru, ben belirli bir adaptee edilen sınıfa bağlı olduğum için bazı sıkıntılar yaşayabilirim. Ancak
adaptee etmem gereken sınıfın tamamını yeniden implemente etmem gerekmediği için büyük bir avantajım var. Ayrıca,
ihtiyaç duyarsam adaptee edilen nesnenin davranışını override edebilirim çünkü sadece alt sınıfı oluşturuyorum.

Object Adapter : Benim bulunduğum dünyada, inheritance yerine composition'ı tercih etmeyi seviyoruz; belki birkaç satır
kodu kurtarıyorsunuz, ama ben sadece adaptee edene delege etmek için biraz kod yazıyorum. Esnekliği korumayı tercih
ediyoruz.

Class Adapter : Esnek olabilir, ancak verimli mi? Hayır. Class Adapter kullanarak sadece ben varım, bir adapter ve bir
adaptee edilen yok.

Object Adapter : Sadece küçük nesneye mi endişeleniyorsunuz? Belki bir methodu hızlıca override edebilirsiniz, ancak
benim adapter koduma eklediğim herhangi bir behavior, adaptee edilen sınıfım ve tüm alt sınıfları ile çalışır.

Class Adapter : Evet, fakat adaptee edilen sınıfın bir alt sınıfı yeni bir behavior eklerse, o zaman ne olur?

Object Adapter : Hey, anlayış göster, sadece alt sınıf ile compose etmem gerekiyor, böylece o işe yarar hale gelir.

# Real world adapters

### Old world Enumerators

Eğer bir süredir Java ile ilgileniyorsanız, muhtemelen early koleksiyon tiplerinin (Vector, Stack, Hashtable ve birkaç
diğeri) elements() adında bir methodu implement ettiğini hatırlarsınız. Enumeration interface'i, koleksiyonun içindeki
öğeleri nasıl yönetildiğinin ayrıntılarına dair bilgi sahibi olmadan koleksiyonun öğeleri üzerinde adım adım
ilerlemenize olanak tanır.

![img_10.png](../Images/AdapterFacade/img_10.png)

Enumeration basit bir interface'e sahiptir. Collection'da daha fazla öğe olup olmadığını size söyler. Collection
içerisinde ki bir sonraki elemanı size verir

### New World Iterators

Sun, daha yeni Collection sınıflarını piyasaya sürdüğünde, Enumeration gibi koleksiyondaki bir dizi öğeyi döngülemeye
olanak tanıyan Iterator interface'ini kullanmaya başladı, aynı zamanda öğeleri kaldırma yeteneği ekledi.

![img_11.png](../Images/AdapterFacade/img_11.png)

hasNext() : Enumeration interface'indeki hasMoreElements() metoduna benzer. Bu metod sadece koleksiyondaki tüm öğeleri
inceleyip incelemediğinizi size söyler.

next() : Collection'da ki bir sonraki öğeyi verir

remove() : Collection'dan bir item'i remove eder

### And today...

Çoğu zaman, yalnızca Iterator'ları kullanmak istediğimiz yeni kodumuz için Enumerator interface'ini sunan eski kodlarla
karşı karşıya kalırız gibi görünüyor. Adapter oluşturmamız gerekiyor gibi gözüküyor.

# Adapting an Enumeration to an Iterator

Öncelikle iki interface'i inceleyeceğiz ve birinden diğerine methodların nasıl eşlendiğini anlamaya çalışacağız. Başka
bir deyişle, client target üzerinde bir method çağırdığında adaptee edilen üzerinde neyi çağıracağımızı belirlemeye
çalışacağız.

![img_12.png](../Images/AdapterFacade/img_12.png)

Bu iki method kolay görünüyor, doğrudan hasNext() ve next() methodlarına eşleniyor gibi görünüyor.

hasNext() -> hasMoreElements()
next() -> nextElement()

Ancak Iterator'daki remove() methodu nedir? Enumeration'da böyle bir şey yok.

# Designing the Adapter

İşte sınıfların nasıl görünmesi gerektiği: Target interface'i implement eden ve bir adaptee ile composed edilen bir
adapter'a ihtiyacımız var. hasNext() ve next() methodlarını target'dan adapte etmek kolay olacak: bunları doğrudan
geçiririz. Ancak remove() hakkında ne yapmanız gerektiğini düşünün. Şu an için şu sınıf diyagramını göz önünde
bulundurun:

![img_13.png](../Images/AdapterFacade/img_13.png)

Yeni kodunuz, altında gerçekte bir Enumeration bulunsa bile hala Iterator'ları kullanmaya devam edebilir.

Eski kodunuzdaki Enumeration'ları, yeni kodunuz için Iterator gibi görünmesini sağlıyoruz.

EnumerationIterator adapter'dir

Enumeration interface'ini implement eden bir sınıf adaptee'dir

# Dealing with the remove() method

Evet, Enumeration'ın remove işlemini desteklemediğini biliyoruz. Bu bir "read-only" interface'dir. Adapter üzerinde
tam işlevsel bir remove() methodu uygulamanın bir yolu yok. En iyi yapabileceğimiz şey bir runtime exception
fırlatmaktır. Neyse ki, Iterator interface'inin tasarımcıları bu ihtiyacı önceden gördüler ve remove() methodunu
UnsupportedOperationException'ı destekleyecek şekilde tanımladılar. Bu gibi bir durumda adapter mükemmel olmayabilir;
client'lar potansiyel exception'lara dikkat etmelidir, ancak client dikkatli ve adapter iyi belgelenmişse bu mükemmel
bir çözümdür.

# Writing the EnumerationIterator adapter

```
/* Enumeration'ı Iterator'a uyarladığımız için, Adapter'ımız Iterator interface'ini implement eder...
bu bir Iterator gibi görünmelidir.*/

public class EnumerationIterator implements Iterator {
    Enumeration enumeration;

    /* Uyarlama yaptığımız Enumeration. Composition kullanıyoruz, bu yüzden onu bir instance variable'da saklıyoruz.*/
    public EnumerationIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    /* Iterator'ın hasNext() methodu Enumeration'ın hasMoreElements() methoduna delege edilir...*/
    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    /* Iterator'ın next() methodu Enumeration'ın nextElement() methoduna delege edilir...*/
    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    /* Iterator'ın remove() methodunu destekleyemiyoruz. Burada sadece bir exception fırlatıyoruz.*/
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
```

--**DIALOGS**--

Decorator : Görevim tamamen responsibility ilgilidir - bir Decorator devreye girdiğinde, tasarımınıza eklenen
bazı yeni responsibilities veya behavior'lar olacağını bilirsiniz.

Adapter : Kirli işi yapan siperlerdeyiz: interface'leri dönüştürüyoruz. İşlerimiz cazip olmayabilir, ancak
client'larımız kesinlikle hayatlarını daha basit hale getirmemizi takdir ediyorlar.

Decorator : Bu doğru olabilir, ama çalışmadığımızı düşünmeyin. Büyük bir interface'i decorate etmemiz gerektiğinde, vay
canına, bu oldukça fazla kod gerektirebilir.

Adapter : Client'in beklediği interface'i sunmak için bir araya getirmeniz gereken birkaç sınıf olduğunda bir adapter
olmayı deneyin. İşte o zaman zorlu bir durum olabilir. Ancak bizim bir deyişimiz vardır: "an uncoupled client is a happy
client"

Decorator : bazen sadece bir decorator'ım ve kim bilir kaç tane başka decorator tarafından wrap edilmiş olabilirim. Bir
method çağrısı size delegate edildiğinde, o methodun kaç tane başka decorator tarafından daha önce ele alındığını
bilemezsiniz ve çabanızın talebi karşılamak için fark edilip edilmeyeceğini bilemezsiniz.

Adapter : Evet, eğer adapter'ler görevlerini iyi yapıyorlarsa, client'larımız bizi asla fark etmez. Ama adapter'ler
hakkındaki harika şey, client'lara herhangi bir kod değişikliği yapmadan yeni kütüphaneleri ve alt kümeleri kullanma
imkanı tanıyor olmamız.

Decorator : Decorator'ler olarak biz de aynısını yapıyoruz, yalnızca mevcut kodu değiştirmeden sınıflara yeni
behavior'lar eklemenize izin veriyoruz. Hala adapter'lerin sadece şık decorator'lar olduğunu söylüyorum - yani, bizim
gibi, bir nesneyi wrap ediyorlar.

Adapter : Hayır, hayır, hayır, hiç de öyle değil. Biz her zaman wrap ettiğimiz şeyin interface'ini dönüştürürüz, siz
asla yapmazsınız. Bir decorator'ın bir adapter gibi olduğunu söyleyebilirim; sadece siz interface'i değiştirmezsiniz!

Decorator : Hayattaki görevimiz sadece bilgi geçişi yapmak değil, wrap ettiğimiz nesnelerin behavior'larını veya
responsibility'lerini extend etmektir.

Adapter : Hey, kimi sadece bilgi geçişi yapan biri olarak adlandırıyorsun? Gelin ve birkaç interface dönüştürme işlemini
ne kadar süreyle yapabildiğinizi görelim!

# And now for something different...

### There’s another pattern in this chapter.

Sizler Adapter Tasarım Deseni'nin, bir sınıfın interface'ini bir client'in beklediği interface'e dönüştürdüğünü
gördünüz.

Ayrıca, bu işlemi Java'da gerçekleştirdiğimizi, uyumsuz bir interface'e sahip bir nesneyi, doğru interface'i implement
eden bir nesneyle wrap ederek başardığımızı biliyorsunuz.

Şimdi, farklı bir nedenle bir interface'i değiştiren bir deseni inceleyeceğiz: interface'i basitleştirmek. Bu desen, bir
veya daha fazla sınıfın karmaşıklığını temiz, aydınlık bir cephenin arkasında gizleyen bir model olarak adlandırılan
"Facade Pattern" olarak adlandırılır.

# Home Sweet Home Theater

Araştırmanızı yaptınız ve bir DVD oynatıcı, bir projektör video sistemi, otomatik bir perde, çevresel ses ve hatta bir
patlamış mısır patlatıcısı dahil, etkileyici bir sistem oluşturdunuz. Bir araya getirdiğiniz tüm component'lere bir göz
atalım:

![img_14.png](../Images/AdapterFacade/img_14.png)

Evet, bu birçok sınıf, birçok etkileşim ve öğrenilip kullanılması gereken büyük bir interface kümesidir. Bu tür karmaşık
sistemlerde yönetim ve kullanım zor olabilir.

Haftalarca kablo döşemek, projektörü monte etmek, tüm bağlantıları yapmak ve ince ayar yapmak için harcadınız. Şimdi her
şeyi harekete geçirme zamanı geldi ve bir filmi keyifle izlemek için hazırsınız...

# Watching a movie (the hard way)

1 - Patlamış mısır makinesini açın.

2 - Makineyi patlamaya başlatın.

3 - Işıkları kısın

4 - Perdeyi aşağı indirin

5 - Projector'u açın

6 - Projector'un input'unu DVD olarak ayarlayın

7 - Projector'u wide screen moduna getirin.

8 - Sound Amplifier'i açın

9 - Amplifier'in input'unu DVD olarak ayarlayın

10 - Amplifier'i surround sound'a set edin

11 - Amplifier'in volume'unu medium(5)'e set edin

12 - DVD Player'i açın

13 - DVD Player'da oynatmayı başlatın

### Aynı görevlere sınıflar ve bu görevleri yerine getirmek için gereken method çağrıları açısından bakalım

```
Popper popper = new Popper();

// Patlamış mısır makinesini aç ve patlatmayı başlat...
popper.on();
popper.pop();

Lights lights = new Lights();
// Işıkları %10 seviyesine indir
lights.dim(10);

Screen screen = new Screen();
// perdeyi indir
screen.down();

Dvd dvd = new Dvd();

Projector projector = new Projector();
// projector'u ac ve wide screen mode'a gec
projector.on();
projector.setInput(dvd);
projector.wideScreenMode();

Amp amp = new Amp();
// Amplifier'i ac, dvd'yi set et, sesi surround sound'a set et ve volume 5 olarak ayarla
amp.on();
amp.setDvd(dvd);
amp.setSurroundSound();
amp.setVolume(5);

// dvd player'i aç, movie'yi oynat
dvd.on();
dvd.play(movie);
```

### Ama daha fazlası var...

* Film bittiğinde, her şeyi nasıl kapatırsınız? Her şeyi tersine çevirerek tekrar yapmanız gerekebilir, değil mi?

* CD veya radyo dinlemek de aynı derecede karmaşık olmaz mı?

* Sisteminizi yükseltmeye karar verirseniz, muhtemelen biraz farklı bir işlem öğrenmeniz gerekecektir.

Peki, ne yapmalı? Ev sinema sisteminizin kullanım karmaşıklığı ortaya çıkıyor gibi görünüyor! Facade Pattern'ın bizi bu
karmaşıklıktan nasıl kurtarabileceğini görelim

# Lights, Camera, Facade!

Bir Facade, ihtiyacınız olan şey tam olarak budur: Facade Deseni ile complex bir subsystem alabilir ve bir
veya daha fazla mantıklı interface sağlayan bir Facade sınıfı implemente ederek kullanımını kolaylaştırabilirsiniz.
Endişelenmeyin; complex subsystem gücüne ihtiyacınız varsa hala kullanılabilir durumda, ancak ihtiyacınız olan tek şey
doğrudan bir interface ise, Facade sizin için buradadır. Facade'nin nasıl çalıştığına bir göz atalım:

1 - Tamam, şimdi ev sinema sistemi için bir Facade oluşturma zamanı geldi. Bunu yapmak için, watchMovie() gibi basit
birkaç method sunan yeni bir HomeTheaterFacade sınıfı oluşturuyoruz.

2 - Facade sınıfı, ev sinema componentlerini bir subsystem olarak ele alır ve watchMovie() methodunu implemente etmek
için subsystem'i çağırır.

![img_15.png](../Images/AdapterFacade/img_15.png)

3 - Artık client kodunuz, subsystem üzerinde method çağırmak yerine HomeTheaterFacade üzerinde method çağırır. Bu
sayede bir film izlemek için sadece watchMovie() gibi bir methodu çağırmanız yeterli olur ve bu method aracılığıyla
ışıklar, DVD oynatıcı, projektör, amplifikatör, perde ve patlamış mısır constructor'ı ile iletişim kurar.

![img_16.png](../Images/AdapterFacade/img_16.png)

4 - Facade hala subsystem'in doğrudan kullanılabilir olmasını sağlar. Sub system sınıflarının gelişmiş işlevselliğine
ihtiyacınız varsa, bunları kullanabilirsiniz.

Bir facade sadece bir interface'i basitleştirmekle kalmaz, aynı zamanda bir client'i bir component subsystem'indan
ayırır.

Facades ve adapter'ler birden fazla sınıfı wrap etmiş olabilir, ancak bir Facade'ın amacı basitleştirmekken, bir
adapter'in amacı interface'i farklı bir şeye dönüştürmektir.

--**DIALOGS**--

Q : Eğer Facade, subsystem sınıflarını kapsıyorsa, low-level işlevselliğe ihtiyaç duyan bir client bu işlevselliğe
nasıl erişir?

A : Facade'lar, subsystem sınıflarını "encapsule etmezler" ya da gizlemezler; yalnızca işlevselliğine basitleştirilmiş
bir interface sağlarlar. Subsystem sınıfları, daha belirli interface'lere ihtiyaç duyan client'lar tarafından doğrudan
kullanılmaya devam eder. Bu, Facade Deseni'nin güzel bir özelliğidir: basitleştirilmiş bir interface sunarken, ihtiyaç
duyanlara sistemdeki tam işlevselliği açıkça sunar.

Q : Facade, işlev ekler mi yoksa her request'i sadece subsystem'lara ileterek mi çalışır?

A : Facade, subsystem'ları kullanmanın yanı sıra kendi 'smarts' veya özelliklerini eklemekte özgürdür. Örneğin,
HomeTheaterFacade, yeni bir behavior implemente etmez, ancak patlamış mısır yapıcısının önce açılması gerektiğini (ve
bir film gösterimini nasıl başlatılacağı gibi ayrıntıları) bilecek kadar zekidir.

Q : Her subsystem'in yalnızca bir facade'i mi olur?

A : Her zaman gerekli değil. Desen kesinlikle belirli bir subsystem için oluşturulacak birçok facade'nin oluşturulmasına
izin verir

Q : Facade sadece daha basit bir interface'e sahip olmamın dışında hangi faydaları sağlar?

A : Facade Deseni ayrıca client implementasyonunu herhangi bir subsystem'den bağımsız hale getirmenize de olanak tanır.
Diyelim ki büyük bir maaş artışı aldınız ve ev sinemanızı farklı interface'lere sahip tamamen yeni componentlere
yükseltmeye karar verdiniz. Eğer client'inizi subsystem yerine facade'a kodladıysanız, client kodunuzun değişmesi
gerekmez, sadece facade (ve umarım üretici bunu sağlıyordur!) yeterli olur

Q : Adapter Pattern ile Facade Pattern arasındaki farkı anlamanın yolu, adapter'in bir sınıfı wrap ettiği ve
facade'ların birçok sınıfı temsil edebileceğidir, öyle mi?

A : Hayır! Adapter Deseni, bir veya daha fazla sınıfın interface'ini, bir client'in beklediği bir interface'e dönüştüren
desendir. Çoğu teorik örnekte adapter, bir sınıfı dönüştürüyor gibi görünse de, client'in kodlandığı bir interface
sağlamak için birçok sınıfı dönüştürmeniz gerekebilir. Benzer şekilde, bir Facade, çok karmaşık bir interface'e
sahip bir tek sınıfa basitleştirilmiş bir interface sağlayabilir. İkisi arasındaki fark, ne kadar çok sınıfı "
wrap ettikleri" ile ilgili değil, ama niyetleriyle ilgilidir. Adapter Deseni'nin niyeti, bir interface'i değiştirerek
client2in beklediği bir interface ile eşleştirmektir. Facade Deseni'nin niyeti ise bir subsystem'e basitleştirilmiş bir
interface sağlamaktır.

# Constructing your home theater facade

"HomeTheaterFacade" oluşturulmasını adım adım inceleyelim: İlk adım, facade'da subsystem'in tüm componentlere erişimin
olabilmesi için composition'ı kullanmaktır.

```
public class HomeTheaterFacade {
    /* İşte composition; bunlar kullanacağımız subsystem component'lerin tamamıdır.*/
    Ampilifier ampilifier;
    Tuner tuner;
    DvdPlayer dvdPlayer;
    CdPlayer cd;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;

    /* Facade, constructor'ında subsystem component'lerinin her birine bir referans alır. Ardından, facade her birini
    karşılık gelen instance variable'a atar.*/
    public HomeTheaterFacade(Ampilifier ampilifier,
                             Tuner tuner,
                             DvdPlayer dvdPlayer,
                             CdPlayer cd,
                             Projector projector,
                             TheaterLights lights,
                             Screen screen,
                             PopcornPopper popper)
    {
        this.ampilifier = ampilifier;
        this.tuner = tuner;
        this.dvdPlayer = dvdPlayer;
        this.cd = cd;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }

    /* Şimdi subsystem'in component'lerini birleştirip birleşik bir interface'e getirme zamanı geldi.
    "watchMovie()" ve "endMovie()" methodlarını uygulayalım.*/
    public void watchMovie(String movie){
        /* "watchMovie()" methodu, daha önce manuel olarak yapmak zorunda kaldığımız işlem sırasını takip eder,
        ancak tüm işi yapacak kullanışlı bir methoda sarar. Her görev için subsystem'da ki ilgili componente
        sorumluluğu devrettiğimize dikkat edin.*/

        System.out.println("Get ready to watch a movie");

        popper.on();
        popper.pop();

        lights.dim(10);

        screen.down();

        projector.on();
        projector.wideScreenMode();

        ampilifier.on();
        ampilifier.setDvd(dvdPlayer);
        ampilifier.setSurroundSound();
        ampilifier.setVolume(5);

        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie(){
        /* "endMovie()" methodu ise her şeyi kapatmakla ilgilenir. Yine, her görev subsystem'da ki uygun componente
        devredilir.*/

        System.out.println("shutting movie theater down");

        popper.off();

        lights.on();

        screen.up();

        projector.off();

        ampilifier.off();

        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.stop();
    }
}
```

# Time to watch a movie (the easy way)

```
public class App {
    public static void main(String[] args) {
        PopcornPopper popper = new PopcornPopper();
        TheaterLights lights = new TheaterLights();
        Screen screen = new Screen();
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        Ampilifier amp = new Ampilifier();
        Tuner tuner = new Tuner();
        CdPlayer cd = new CdPlayer();

        HomeTheaterFacade facade = new HomeTheaterFacade(
          amp,tuner,dvd,cd,projector,lights,screen,popper
        );

        facade.watchMovie("Raiders of the Lost Ark");
        facade.endMovie();
    }
}
```

# Facade Pattern defined

Facade Deseni'ni kullanmak için, bir subsystem'de bulunan daha complex sınıfları basitleştiren ve birleştiren bir sınıf
oluştururuz. Birçok desenin aksine, Facade oldukça açıktır; kafanızı karıştıracak karmaşık abstraction'ları yoktur.
Ancak bu, onun ne kadar güçlü olduğunu azaltmaz: Facade Deseni, client'lar ve subsystem'ler arasındaki tight coupling'i
önlememize ve yeni bir nesne yönelimli prensibe uymamıza yardımcı olur.

Bu yeni prensibi tanıtmadan önce, desenin resmi tanımına bir göz atalım:

Facade Pattern, bir subsystem'deki bir dizi interface'e tek bir interface sağlar. Facade, subsystem'in kullanımını
kolaylaştıran daha üst düzey bir interface tanımlar.

Burada zaten bilmediğiniz çok şey yok, ancak bir desenin en önemli özelliklerinden biri niyetidir. Bu tanım, bize Facade
Deseni'nin amacının, bir subsystem'i basitleştirilmiş bir interface aracılığıyla daha kolay kullanılabilir hale getirmek
olduğunu açıkça belirtir. Bu, desenin sınıf diyagramında da gözlemlenebilir:

![img_17.png](../Images/AdapterFacade/img_17.png)

Facade : Daha kolay kullanılabilen birleşik Interface.

# The Principle of Least Knowledge

En Az Bilgi İlkesi (The Principle of Least Knowledge), nesneler arasındaki etkileşimleri yalnızca birkaç yakın "friends"
arasında sınırlamamızı önerir. Bu principle genellikle şöyle ifade edilir:

En Az Bilgi İlkesi (The Principle of Least Knowledge) - Sadece doğrudan friends'ler ile konuşun.

Ancak bu gerçek anlamda ne ifade ediyor? Bu, bir sistem tasarlarken, herhangi bir nesnenin etkileşimde bulunduğu sınıf
sayısına ve bu sınıflarla nasıl etkileşimde bulunduğuna dikkat etmeniz gerektiği anlamına gelir. Bu principle,
sistemdeki bir
bölümde yapılan değişikliklerin diğer bölümlere yayılmasını engeller. Birçok sınıf arasında çok sayıda bağımlılık
oluşturduğunuzda, bakımı maliyetli ve diğer insanlar için anlaşılması karmaşık bir sistem oluşturuyorsunuz.

# How NOT to Win Friends and Influence Objects

Peki, bunu nasıl önlersiniz? Principle bazı yönergeler sunar: herhangi bir nesneyi alalım; şimdi bu nesnenin herhangi
bir methodundan, principle bize sadece aşağıdaki sınıflara ait methodları çağırmamız gerektiğini söyler:

* Object'in kendisi

* Methoda parametre olarak geçirilen object'ler

* Methodun oluşturduğu veya instantiate ettiği herhangi bir object

* Object için herhangi bir component

Bu yönergelerin bize başka methodların çağrılmasıyla döndürülen nesneler üzerindeki methodları çağırmamamızı söylediğine
dikkat edin!

Bir "component'i", bir instance variable tarafından referans verilen herhangi bir nesne olarak düşünün. Başka bir
deyişle bunu bir HAS-A ilişkisi olarak düşünün.

Bu kulağa biraz katı geliyor, değil mi? Başka bir çağrıdan geri aldığımız bir nesnenin metodunu çağırmanın ne zararı
var? Eğer bunu yaparsak, başka bir nesnenin alt parçasından istekte bulunmuş oluruz (ve doğrudan bildiğimiz nesnelerin
sayısını artırmış oluruz). Bu gibi durumlarda, priciple bizi nesneden bizim için istekte bulunmasını istemeye zorlar; bu
şekilde onun component nesneleri hakkında bilgi sahibi olmak zorunda kalmayız(ve friends çevremizi küçük tutuyoruz).
Örneğin:

### Without the principle

```
public float getTemp() {
    Thermometer thermometer = station.getThermometer();
    return thermometer.getTemperature();
}
```

Burada station'dan Thermometer nesnesini alıyoruz ve ardından getTemperature() methodunu kendimiz çağırıyoruz.

### With the principle

```
public float getTemp() {
    return station.getTemperature();
}
```

Prensibi uyguladığımızda, Station sınıfına bizim için termometreye request'de bulunan bir method ekleriz. Bu, bağımlı
olduğumuz sınıf sayısını azaltır.

# Keeping your method calls in bounds...

Burada, methodları çağırabileceğiniz ve yine de Principle of Least Knowledge principlesine bağlı kalabileceğiniz tüm
yolları
gösteren bir Car sınıfı var:

```
public class Car {

    /* İşte bu sınıfın bir componenti. Methodlarını çağırabiliriz.*/
    Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    /* Parametre olarak geçirilen bir nesne üzerinde bir method çağırabilirsiniz. */
    public void start(Key key){
        /* Burada yeni bir object oluşturuyoruz, methodları legal. */
        Doors doors = new Doors();

        /* Parametre olarak geçirilen bir nesne üzerinde bir method çağırabilirsiniz. */
        boolean authorized = key.turns();

        if (authorized){
            /* Object'nin bir component'i üzerinde bir method çağırabilirsiniz */
            engine.start();
            /* Object içinde local bir method çağırabilirsiniz */
            updateDashboardDisplay();
            /* Oluşturduğunuz veya instantiate ettiğiniz bir nesne üzerinde bir method çağırabilirsiniz.*/
            doors.lock();
        }
    }

    public void updateDashboardDisplay(){
        // update display
    }
}
```

--**DIALOGS**--

Q : Başka bir Principle'a da "Law Of Demeter" denir; bunlar nasıl ilişkilidir?

A : İkisi de aynıdır ve bu terimler sık sık birbirine karışır. Priciple of Least Knowledge kullanmayı tercih ediyoruz ve
bunun birkaç nedeni vardır:

1 - isim daha sezgiseldir

2 - "Law" kelimesinin kullanımı, bu priciple'i her zaman uygulamamız gerektiğini ima eder. Aslında hiçbir principle
kanun değildir, tüm principle'lar yararlı oldukları zaman ve yerde kullanılmalıdır. Tüm tasarımlar denge içerir (
abstraction vs speed, space vs time vb.) ve principle'lar rehberlik sağlarken, bunları uygulamadan önce tüm faktörler
dikkate alınmalıdır.

Q : Principle of Least Knowledge uygulamanın herhangi bir dezavantajı var mı?

A : Evet; bu principle nesneler arasındaki bağımlılıkları azaltırken ve çalışmalar bunun yazılım bakımını azalttığını
gösterirken, bu principle'in uygulanmasının diğer component'lere yapılan method çağrılarını işlemek için daha fazla "
wrapper" sınıf yazılmasına neden olduğu da bir gerçektir. Bu da karmaşıklığın ve geliştirme süresinin artmasının
yanı sıra çalışma zamanı performansının düşmesine neden olabilir.

--**Sharpen your pencil**--

Bu sınıflardan herhangi biri Principle of Least Knowledge ihlal ediyor mu? Neden ya da neden değil?

```
public House {
    WeatherStation station;
    // other methods and constructor
    public float getTemp() {
        return station.getThermometer().getTemperature();
    }
}
```

Principle of Least Knowledge İhlal Ediyor! Başka bir çağrıdan dönen bir nesnenin methodunu çağırıyorsunuz.

```
public class House {
    WeatherStation station;

    // other methods and constructor
    
    public float getTemp() {
        Thermometer thermometer = station.getThermometer();
        return getTempHelper(thermometer);
    }

    public float getTempHelper(Thermometer thermometer) {
        return thermometer.getTemperature();
    }
}
```

Aykırı değil! Bu, principle'i çevreleyerek bir yol bulma gibi görünüyor. Gerçekten de sadece çağrıyı başka bir methoda
taşıdığımızdan beri ne değişti?

# The Facade and the Principle of Least Knowledge

![img_18.png](../Images/AdapterFacade/img_18.png)

Bu client'in sadece bir friend'i vardır; HomeTheaterFacade. Nesne tabanlı programlamada, sadece bir friend'in olması
İYİ bir şeydir!

HomeTheaterFacade, client için tüm bu subsystem component'lerini yönetir. Client'i basit ve esnek tutar.

Client'i etkilemeden HomeTheater component'lerini yükseltebiliriz.

Subsystem'ları da Principle of Least Knowledge'a bağlı tutmaya çalışıyoruz. Bu çok karmaşık hale gelirse ve çok fazla
friend birbirine karışırsa, subsystem katmanları oluşturmak için ek facade'lar ekleyebiliriz.

### Adapter

Bir sınıfın interface'ini client'ların beklediği başka bir interface'e dönüştürür. Uyumsuz interface'ler nedeniyle
birlikte çalışamayan sınıfların birlikte çalışmasını sağlar.

### Facade

Bir subsystem'da ki bir dizi interface'e birleşik bir interface sağlar. Facade, subsystem'in kullanımını kolaylaştıran
daha üst düzey bir interface tanımlar.

--**BULLET POINTS**--

* Bir mevcut sınıfı kullanmanız gerektiğinde ve interface'i ihtiyacınız olanla uyuşmuyorsa, bir adapter kullanın.

* Büyük bir interface'i veya complex bir interface kümesini basitleştirmeniz ve birleştirmeniz gerektiğinde, bir facade
  kullanın.

* Bir adapter, bir interface'i bir client'in beklediği bir interface'e dönüştürür.

* Bir facade, bir client'i complex bir subsystem'dan ayırır.

* Bir adapter'in implement edilmesi, target interface'in boyutu ve karmaşıklığına bağlı olarak az veya çok çalışma
  gerektirebilir.

* Bir facade implement etmek, facade'i subsystem ile birleştirmemizi ve facade'nin işini yapmak için delegation
  kullanmamızı gerektirir.

* Adapter Deseni'nin iki türü vardır: object ve class adapters. Class adapter'lar multi inheritance gerektirir.

* Bir subsystem için birden fazla facade implement edebilirsiniz.

* Bir adapter, bir nesneyi interface'ini değiştirmek için wrap eder, bir decorator yeni behavior'lar ve responsibility'
  ler eklemek için bir nesneyi wrap eder ve bir facade bir küme nesneyi basitleştirmek için "wrap eder".