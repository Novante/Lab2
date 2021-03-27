package com.example;

import EmployeeMock.EmployeeRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeManagerTest {

    private List<Employee> employeeList;

    private void setupDatabase() {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", 200));
        employeeList.add(new Employee("2", 157));
        employeeList.add(new Employee("3", 1337));
    }

    @Test
    void findFirstEmployee() {

        setupDatabase();
        EmployeeRepositoryImpl mockRepo = new EmployeeRepositoryImpl(employeeList);

        var result = mockRepo.findAll().get(0);

        Assertions.assertEquals("1", result.getId());
        Assertions.assertEquals(200, result.getSalary());
    }

    @Test
    void saveNewEmployee() {
        setupDatabase();
        EmployeeRepositoryImpl mockRepo = new EmployeeRepositoryImpl(employeeList);

        mockRepo.save(new Employee("4", 288));

        Assertions.assertTrue(mockRepo.saveWasCalled);
    }

    @Test
    void saveInvalidEmployee() {
        setupDatabase();
        EmployeeRepositoryImpl mockRepo = new EmployeeRepositoryImpl(employeeList);

        mockRepo.save(new Employee(null, 0));

        Assertions.assertTrue(mockRepo.saveWasCalled);
        Assertions.assertTrue(mockRepo.invalidEmployee);
    }

    @Mock
    private BankService bankSrv;
    @Mock(name = "database")
    private EmployeeRepository dbMock;
    @InjectMocks
    private EmployeeManager empMgr;

    @Test
    void dbMockTest() {
        setupDatabase();
        when(dbMock.findAll()).thenReturn(employeeList);

        Assertions.assertEquals(employeeList, dbMock.findAll());
    }

    @Test
    void payEmployees() {
        setupDatabase();
        when(dbMock.findAll()).thenReturn(employeeList);

        empMgr.payEmployees();

        Assertions.assertEquals(employeeList.size(), empMgr.payEmployees());
    }

    @Test
    void throwEmployeeException() {
        setupDatabase();
        when(dbMock.findAll()).thenReturn(employeeList);
        doThrow(RuntimeException.class).when(bankSrv).pay(anyString(), anyDouble());
        empMgr.payEmployees();
        verify(bankSrv, times(employeeList.size())).pay(anyString(), anyDouble());

    }

}