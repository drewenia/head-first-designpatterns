Swiggy bir food delivery application'ı dır

Değişik restaurant'lardan Food service'i yapmaktadır

Item adında bir interface barındırır

```
public interface Item {
    String getItemName();
    String getPrice();
    String getRestaurantName();
}
```

FoodItem class'ı Item'i implemente eder

```
public class FoodItem implements Item{
    @Override
    public String getItemName() {
        return null;
    }

    @Override
    public String getPrice() {
        return null;
    }

    @Override
    public String getRestaurantName() {
        return null;
    }
}
```

SwiggyStore içerisinde List<Item> bulunur

```
public class SwiggyStore {
    List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }
}
```

SwiggyStore belli bir süre sonra Grocery (Bakkaliye) item'ları satmaya karar verir

GroceryItem adında bir interface create edilir ve Item interface'inden farkı getRestaurantName yerine getStoreName()'in
yer almasıdır

```
public interface GroceryItem {
    String getName();
    String getPrice();
    String getStoreName();
}
```

GroceryProduct GroceryItem'ı implemente eder

```
public class GroceryProduct implements GroceryItem{
    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPrice() {
        return null;
    }

    @Override
    public String getStoreName() {
        return null;
    }
}
```

GroceryItemAdapter oluşturulur ve Item'ı implemente eder

```
public class GroceryItemAdapter implements Item{

    GroceryItem groceryItem;

    public GroceryItemAdapter(GroceryItem groceryItem) {
        this.groceryItem = groceryItem;
    }

    @Override
    public String getItemName() {
        return groceryItem.getName();
    }

    @Override
    public String getPrice() {
        return groceryItem.getPrice();
    }

    @Override
    public String getRestaurantName() {
        return groceryItem.getStoreName();
    }
}
```





