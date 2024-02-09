package IteratorCompositePattern.Example01;

public class Main {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        for (Iterator iter = nameRepository.getIterator();iter.hasNext();){
            System.out.println("Name : " + iter.next());
        }
    }
}
