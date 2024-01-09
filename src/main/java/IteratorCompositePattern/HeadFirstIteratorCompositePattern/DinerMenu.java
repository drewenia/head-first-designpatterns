package IteratorCompositePattern.HeadFirstIteratorCompositePattern;

import java.util.Iterator;

public class DinerMenu{
    private static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem(
                "Vegetarian BLT",
                "(Fakin’) Bacon with lettuce & tomato on whole wheat",
                true,
                2.99);
        addItem("BLT",
                "Bacon with lettuce & tomato on whole wheat",
                false,
                2.99);
        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad",
                false,
                3.29);
        addItem("Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false,
                3.05);
    }
    private void addItem(String name, String description, boolean vegeterian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegeterian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can’t add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems += 1;
        }
    }

    /* getMenuItems() methoduna artık ihtiyacımız olmayacak ve aslında bunu istemiyoruz çünkü dahili implementasyonumuzu
    açığa çıkarıyor! İşte createIterator() methodu. menuItems Array'inden bir DinerMenuIterator oluşturur ve bunu
    client'a döndürür */
    public Iterator<MenuItem> createIterator(){
        /* Iterator interface'ini döndürüyoruz. Client'in menü öğelerinin DinerMenu'de nasıl tutulduğunu ya da
        DinerMenuIterator'ın nasıl implement edildiğini bilmesi gerekmez. Sadece menüdeki öğeler arasında adım adım
        ilerlemek için iterator'ları kullanması gerekir.*/
        return new DinerMenuIterator(menuItems);
    }
}
