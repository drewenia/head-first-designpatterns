package IteratorCompositePattern.HeadFirstIteratorCompositePattern;

import java.util.Iterator;

/* Iterator interface'ini implement ediyoruz */
public class DinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] menuItems;

    /*position array üzerindeki iteration'ın geçerli konumunu korur */
    int position = 0;

    /* Constructor, üzerinde iterate yapacağımız menü öğeleri Array'ini alır */
    public DinerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    /* hasNext() methodu, Array'in tüm öğelerini görüp görmediğimizi kontrol eder ve iterate edilecek daha fazla öğe
    varsa true değerini döndürür.*/
    @Override
    public boolean hasNext() {
        return position < menuItems.length && menuItems[position] != null;
    }

    /* next() methodu Array'de ki bir sonraki öğeyi döndürür ve position'ı artırır. Diner şefi maksimum boyutlu bir
    Array ayırdığı için, yalnızca Array'in sonunda olup olmadığımızı değil, aynı zamanda bir sonraki öğenin null olup
    olmadığını da kontrol etmemiz gerekir, bu da daha fazla öğe olmadığını gösterir. */
    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems[position];
        position += 1;
        return menuItem;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove an item until you've done at least one next()");
        }
        if (menuItems[position - 1] != null) {
            for (int i = position - 1; i < (menuItems.length - 1); i++) {
                menuItems[i] = menuItems[i + 1];
            }
            menuItems[menuItems.length - 1] = null;
        }
    }
}
