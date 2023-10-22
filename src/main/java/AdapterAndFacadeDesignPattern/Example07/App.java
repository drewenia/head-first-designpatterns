package AdapterAndFacadeDesignPattern.Example07;

public class App {
    public static void main(String[] args) {
        Ceo ceo = new Ceo();
        System.out.println(ceo.getFullTitleAndName());

        ExecutiveEmployee employee = new EmployeeAdapter(new Engineer());
        System.out.println(employee.getFullTitleAndName());
    }
}
