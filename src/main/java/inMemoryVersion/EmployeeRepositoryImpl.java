package inMemoryVersion;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private List<Employee> empList = new ArrayList<>();
    public boolean replaceExistingEmployee = false;

    public EmployeeRepositoryImpl() {

        empList.add(new Employee("1", 200));
        empList.add(new Employee("2", 157));
        empList.add(new Employee("3", 1337));

    }

    public EmployeeRepositoryImpl(List<Employee> x){
        this.empList = x;
    }


    public List<Employee> findAll() {
        return empList;

    }

    public Employee save(Employee e) {
        replaceExistingEmployee = false;
        if (e == null) {
            return null;
        }

        if (e.getId() != null) {
            for (int i = 0; i < empList.size(); i++) {
                if (empList.get(i).getId().equals(e.getId())) {
                    replaceExistingEmployee = true;
                    empList.set(i, e);
                    return e;
                }
            }
            empList.add(e);
            return e;
        }

        return null;
    }
}


