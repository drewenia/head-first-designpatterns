package IteratorCompositePattern.Example03;

import java.util.Iterator;

public interface SongIterator {
    Iterator<SongInfo> createIterator();
}
