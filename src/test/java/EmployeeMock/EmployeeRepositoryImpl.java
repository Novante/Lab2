package EmployeeMock;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    public EmployeeRepositoryImpl(List<Employee> employees) {
        this.employees = employees;
    }

    private List<Employee> employees;

    public boolean saveWasCalled = false;
    public boolean invalidEmployee = false;

    public List<Employee> findAll() {
        return employees;
    }

    public Employee save(Employee e) {

        saveWasCalled = true;
        if (e == null) {
            invalidEmployee = true;
            return null;
        }

        if (e.getId() == null) {
            invalidEmployee = true;
            return null;
        }

        employees.add(e);
        return e;
    }
}
