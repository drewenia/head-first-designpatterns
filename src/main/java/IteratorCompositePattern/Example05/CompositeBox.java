package IteratorCompositePattern.Example05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeBox implements Box{
    private final List<Box> childrens = new ArrayList<>();

    public CompositeBox(Box... boxes){
        childrens.addAll(Arrays.asList(boxes));
    }
    @Override
    public double calculatePrice() {
        return childrens.stream()
                .mapToDouble(Box::calculatePrice)
                .sum();
    }
}
