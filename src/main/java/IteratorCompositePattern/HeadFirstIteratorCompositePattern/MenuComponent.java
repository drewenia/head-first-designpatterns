package IteratorCompositePattern.HeadFirstIteratorCompositePattern;

import java.util.Iterator;

public abstract class MenuComponent {

    /* "Composite" methodları, yani MenuComponents ekleme, kaldırma ve alma methodlarını bir araya getirdik */
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i){
        throw new UnsupportedOperationException();
    }

    /* İşte "operation" methodları; bunlar MenuItems tarafından kullanılır. Birkaç sayfa sonra Menu kodunu
    gösterdiğimizde göreceğiniz gibi, bunlardan birkaçını Menu'de de kullanabiliriz. print(), hem Menu'lerimizin hem de
    MenuItems'in implemente edeceği bir "operation" methodudur, ancak burada varsayılan bir operation sağlıyoruz.*/
    public String getName(){
        throw new UnsupportedOperationException();
    }

    public String getDescription(){
        throw new UnsupportedOperationException();
    }

    public double getPrice(){
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian(){
        throw new UnsupportedOperationException();
    }

    public void print(){
        throw new UnsupportedOperationException();
    }

    public abstract Iterator<MenuComponent> createIterator();
}
