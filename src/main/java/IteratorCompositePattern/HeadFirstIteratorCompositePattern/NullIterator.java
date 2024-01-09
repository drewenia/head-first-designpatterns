package IteratorCompositePattern.HeadFirstIteratorCompositePattern;

import java.util.Iterator;

/* Bu şimdiye kadar gördüğünüz en tembel iterator'dır, yolun her adımında pes eder */
public class NullIterator implements Iterator<MenuComponent> {

    /* En önemlisi hasNext() çağrıldığında her zaman false döndürüyoruz */
    @Override
    public boolean hasNext() {
        return false;
    }

    /* next() çağrıldığında null döndürüyoruz. */
    @Override
    public MenuComponent next() {
        return null;
    }
}
