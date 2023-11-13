package TemplateDesignPatter.HeadFirstTemplateDesignPattern;

/* Unutmayın, gerçekten subclass olmadığımız için Comparable interface'ini implement etmemiz gerekiyor*/
public class Duck implements Comparable<Object>{

    String name;
    int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Duck otherDuck = (Duck) o;

        return Integer.compare(this.weight, otherDuck.weight);
    }
}
