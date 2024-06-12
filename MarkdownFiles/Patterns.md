# Patterns

Bir Pattern, bir context'de bir soruna yönelik bir çözümdür. Bu çok da açıklayıcı bir tanım değil, değil mi? Ancak
endişelenmeyin, bu parçaların her birini, context'i, sorunu ve çözümü adım adım inceleyeceğiz:

Örnek: Bir nesne koleksiyonunuz var.

**Context**, Pattern'in geçerli olduğu durumdur. Bu tekrar eden bir durum olmalıdır.

Collection'ın implementasyonunu açığa çıkarmadan nesneler arasında adım atmanız gerekir.

**Problem**, bu Context'de ulaşmaya çalıştığınız hedefi ifade eder, ancak aynı zamanda context'de ortaya çıkan herhangi
bir kısıtlamayı da ifade eder.

Iteration'i ayrı bir sınıfta encapsulate edin

**Solution**, peşinde olduğunuz şeydir: herkesin uygulayabileceği, hedefi ve bir dizi kısıtlamayı çözen genel bir
tasarım.

----

Problem: İşe zamanında nasıl gidebilirim?

Context: Anahtarlarımı arabada kilitledim.

Solution : Camı kır, arabaya bin, motoru çalıştır ve işe git.

Tanımdaki tüm component'lere sahibiz: işe gitme hedefini ve zaman, mesafe ve muhtemelen diğer bazı faktörlerin
kısıtlamalarını içeren bir sorunumuz var. Ayrıca arabanın anahtarlarına erişilemeyen bir context'imiz var. Ve bizi
anahtarlara ulaştıran ve hem zaman hem de mesafe kısıtlamalarını çözen bir çözümümüz var. Artık bir modelimiz olmalı!
Değil mi?

# Design Pattern tanımına daha yakından bakmak

Örneğimiz Design Pattern tanımına uyuyor gibi görünse de gerçek bir desen değildir. Neden? Yeni başlayanlar için, bir
kalıbın tekrar eden bir soruna uygulanması gerektiğini biliyoruz. Dalgın bir kişi anahtarlarını sık sık arabaya
kilitleyebilse de, arabanın camını kırmak tekrar tekrar uygulanabilecek bir çözüm olarak nitelendirilemez (ya da en
azından hedefi başka bir kısıtlamayla dengelersek: maliyet).

Ayrıca birkaç yönden daha başarısızdır: Birincisi, bu tanımı alıp birine vermek ve onun bunu kendi benzersiz sorununa
uygulamasını sağlamak kolay değildir. İkinci olarak, bir Modelin önemli ama basit bir özelliğini ihlal ettik: ona bir
isim bile vermedik! Bir isim olmadan, kalıp diğer geliştiricilerle paylaşılabilecek bir kelime dağarcığının parçası
haline gelmez. Neyse ki patternler basit bir problem, context ve solution olarak tanımlanmıyor ve belgelenmiyor;
patternleri tanımlamak ve onları pattern kataloglarında bir araya getirmek için çok daha iyi yollarımız var.

--**DIALOGS**--

Q : Bir Problem, bir Context ve bir Solution olarak ifade edilen Model tanımları mı göreceğim?

A : Genellikle pattern kataloglarında bulabileceğiniz pattern açıklamaları, genellikle bundan biraz daha açıklayıcıdır.
Kalıp kataloglarına birazdan ayrıntılı olarak bakacağız; bir kalıbın amacı ve motivasyonu ve nerede uygulanabileceği
hakkında çok daha fazla bilgi verirler, solution design ve onu kullanmanın sonuçları (iyi ve kötü) ile birlikte.

Q : Tasarımıma uyması için bir kalıbın yapısını biraz değiştirmem doğru olur mu? Yoksa katı tanımına göre mi hareket
etmek zorundayım?

A : Elbette değiştirebilirsiniz. Design Principles'lar gibi, pattern'ler de da yasa veya kurallar değildir;
ihtiyaçlarınıza uyacak şekilde değiştirebileceğiniz kılavuzlardır. Gördüğünüz gibi, gerçek dünyadaki pek çok örnek
klasik desen tasarımlarına uymuyor.