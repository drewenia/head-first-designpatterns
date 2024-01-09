package IteratorCompositePattern.HeadFirstIteratorCompositePattern;

import java.util.Iterator;
import java.util.Stack;

/* Tüm iterator'lar gibi biz de java.util.Iterator interface'ini implement ediyoruz */
public class CompositeIterator implements Iterator<MenuComponent> {
    Stack<Iterator<MenuComponent>> stack = new Stack<>();

    /* Üzerinde iterate yapacağımız en üst düzey Composite'in iterator'i içeri aktarılır. Bunu bir Stack veri yapısına
    atıyoruz.*/
    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public MenuComponent next() {
        /* Tamam, Client bir sonraki öğeyi almak istediğinde, önce hasNext() methodunu çağırarak bir tane olduğundan
        emin oluruz... */
        if (hasNext()){
            /* Bir sonraki eleman varsa, mevcut iterator'i Stack'den çıkarır ve bir sonraki elemanını alırız */
            Iterator<MenuComponent> iterator = stack.peek();
            MenuComponent menuComponent = iterator.next();
            if (menuComponent instanceof Menu){
                /* Bu öğe bir menüyse, iterate'e dahil edilmesi gereken başka bir composite'e sahibiz, bu yüzden onu 
                Stack'e atarız. Her iki durumda da Component'i döndürürüz */
                stack.push(menuComponent.createIterator());
            }
            return menuComponent;
        } else return null;
    }

    @Override
    public boolean hasNext() {
        /* Bir sonraki elemanın olup olmadığını görmek için, Stack'in boş olup olmadığını kontrol ederiz; eğer öyleyse,
        yoktur. Aksi takdirde, iterator'i Stack'in tepesinden alır ve bir sonraki öğeye sahip olup olmadığına bakarız.
        Eğer yoksa Stack'den çıkarırız ve hasNext() fonksiyonunu recursive olarak çağırırız. */
        if (stack.isEmpty()) return false;
        else {
            Iterator<MenuComponent> iterator = stack.peek();
            if (!iterator.hasNext()){
                stack.pop();
                return hasNext();
            } else {
                /* Aksi takdirde bir sonraki eleman vardır ve true değerini döndürürüz */
                return true;
            }
        }
    }
}
