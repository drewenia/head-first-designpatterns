package AdapterAndFacadeDesignPattern.HeadFirstAdapterAndFacadeDesignPattern.DuckExample;

public class DuckTestDrive {
    public static void main(String[] args) {
        /* Bir Duck ve Turkey create edelim*/
        Duck mallardDuck = new MallardDuck();
        Turkey wildTurkey = new WildTurkey();

        /* Ve ardından Turkey'i bir TurkeyAdapter ile wrap edin, böylece onu bir Duck gibi görünmesini sağlar.*/
        Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);

        /* Ardından, Turkey'i test edelim: gooble ve fly'i deneyelim */
        System.out.println("The turkey says...");
        wildTurkey.gobble();
        wildTurkey.fly();

        /* Şimdi testDuck() methodunu çağırarak Duck'ı test edelim. Bu method bir Duck nesnesi bekler. */
        System.out.println("\nThe Duck says");
        testDuck(mallardDuck);

        /* Şimdi büyük bir test: Turkey kuşunu bir Duck gibi geçirmeye çalışıyoruz...*/
        System.out.println("\nThe, TurkeyAdapter says");
        testDuck(turkeyAdapter);
    }

    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
}
