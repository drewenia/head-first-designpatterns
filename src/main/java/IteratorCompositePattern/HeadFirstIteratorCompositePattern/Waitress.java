package IteratorCompositePattern.HeadFirstIteratorCompositePattern;

import java.util.Iterator;

public class Waitress {
    MenuComponent menuComponents;

    public Waitress(MenuComponent menuComponents) {
        this.menuComponents = menuComponents;
    }

    public void printMenu() {
        menuComponents.print();
    }

    /* printVegetarianMenu() methodu menuComponents'in composite'ını alır ve iterator'ını elde eder. Bu bizim
    CompositeIterator'ımız olacaktır. */
    public void printVegetarianMenu() {
        Iterator<MenuComponent> iterator = menuComponents.createIterator();
        System.out.println("\nVEGETARIAN MENU\n---");
        /* Composite'in her öğesini yineleyin */
        while (iterator.hasNext()) {
            MenuComponent next = iterator.next();
            try {
                /* Her bir öğenin isVegetarian() methodunu çağırıyoruz ve eğer doğruysa print() methodunu çağırıyoruz */
                if (next.isVegetarian()) {
                    /* print() sadece MenuItems üzerinde çağrılır, asla Composite'ler üzerinde çağrılmaz. Nedenini
                    anlayabiliyor musunuz? */
                    next.print();
                }
                /* Menülerde isVegetarian() operation'ını her zaman bir exception fırlatacak şekilde implement ettik.
                Böyle bir durumda exception'ı yakalarız ancak iteration'a devam ederiz */
            } catch (UnsupportedOperationException ignored) {
            }
        }
    }
}
