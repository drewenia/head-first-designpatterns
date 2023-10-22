package AdapterAndFacadeDesignPattern.Example07;

public class EmployeeAdapter implements ExecutiveEmployee{
    Employee employee;

    public EmployeeAdapter(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getFullTitleAndName() {
        return employee.getName() + ", " + employee.getJobTitle();
    }
}
