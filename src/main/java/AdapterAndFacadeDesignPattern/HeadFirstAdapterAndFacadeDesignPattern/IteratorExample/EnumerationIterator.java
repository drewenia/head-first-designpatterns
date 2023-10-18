package AdapterAndFacadeDesignPattern.HeadFirstAdapterAndFacadeDesignPattern.IteratorExample;

import java.util.Enumeration;
import java.util.Iterator;

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
