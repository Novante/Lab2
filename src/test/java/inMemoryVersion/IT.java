package inMemoryVersion;

import com.example.BankService;
import com.example.Employee;
import com.example.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.example.EmployeeManager;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class IT {
    private List<Employee> employeeList;

    private void setupDatabase() {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", 200));
        employeeList.add(new Employee("2", 157));
        employeeList.add(new Employee("3", 1337));
    }

    @Mock(name = "database")
    private EmployeeRepositoryImpl dbMock;
    @Mock
    private BankService bankSrv;
    @InjectMocks
    private EmployeeManager empMgr;

    @Test
    void payEmployees() {

        setupDatabase();
        when(dbMock.findAll()).thenReturn(employeeList);
        List<Employee> empList = dbMock.findAll();

        Assertions.assertFalse(empList.get(0).isPaid());
        Assertions.assertFalse(empList.get(1).isPaid());

        empMgr.payEmployees();

        Assertions.assertTrue(empList.get(0).isPaid());
        Assertions.assertTrue(empList.get(1).isPaid());


        Assertions.assertEquals(employeeList.size(), empMgr.payEmployees());
    }



}
